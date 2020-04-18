
import java.io.*;
import java.util.Scanner;

public class assignment_05 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter image name: ");
        String name = input.next();
        System.out.print("Image Width: ");
        int width = input.nextInt();
        System.out.print("Image Height: ");
        int height = input.nextInt();
        System.out.println("Output file name is lowPassFiltering.raw and "
                + "highPassFiltering.raw");

        try {
            File file = new File(name);
            FileInputStream myInputFile = new FileInputStream(file);
            FileOutputStream myOutputFile = new FileOutputStream("lowPassFiltering.raw");
            FileOutputStream myOutputFile1 = new FileOutputStream("highPassFiltering.raw");
            int value;
            int k = 0;
            int l = 0;
            int sum = 0;
            int sum1 = 0;

            int[][] kernel = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};//low pass
            int[][] kernel1 = {{-1, -1, -1}, {-1, 8, -1}, {-1, -1, -1}};//high pass
            int[] arr0 = new int[myInputFile.available()];
            int[][] arr1 = new int[height][width];//store f(y,x) 
            int[][] arr2 = new int[height][width];//store g(y,x) =>low pass filtering
            int[][] arr3 = new int[height][width];//store g1(y,x) =>high pass filtering

            //store value into 1D array(int)
            while ((value = myInputFile.read()) != -1) {
                arr0[k++] = value;
            }
            //store value into 2D array(int)
            for (int i = 0; i < arr1.length; i++) {
                for (int j = 0; j < arr1[i].length; j++) {
                    arr1[i][j] = arr0[l++];
                }
            }
            //low pass, high pass
            for (int i = 0; i < arr2.length; i++) {
                for (int j = 0; j < arr2[i].length; j++) {
                    sum = 0;
                    sum1 = 0;
                    if (i + 1 >= 0 && i + 1 <= (height - 1) && j + 1 >= 0 && j + 1 <= (width - 1)) {
                        sum += kernel[0][0] * arr1[i + 1][j + 1];
                        sum1 += kernel1[0][0] * arr1[i + 1][j + 1];
                    }
                    if (i + 1 >= 0 && i + 1 <= (height - 1) && j + 0 >= 0 && j + 0 <= (width - 1)) {
                        sum += kernel[0][1] * arr1[i + 1][j + 0];
                        sum1 += kernel1[0][1] * arr1[i + 1][j + 0];
                    }
                    if (i + 1 >= 0 && i + 1 <= (height - 1) && j - 1 >= 0 && j - 1 <= (width - 1)) {
                        sum += kernel[0][2] * arr1[i + 1][j - 1];
                        sum1 += kernel1[0][2] * arr1[i + 1][j - 1];
                    }
                    if (i + 0 >= 0 && i + 0 <= (height - 1) && j + 1 >= 0 && j + 1 <= (width - 1)) {
                        sum += kernel[1][0] * arr1[i + 0][j + 1];
                        sum1 += kernel1[1][0] * arr1[i + 0][j + 1];
                    }
                    if (i + 0 >= 0 && i + 0 <= (height - 1) && j + 0 >= 0 && j + 0 <= (width - 1)) {
                        sum += kernel[1][1] * arr1[i + 0][j + 0];
                        sum1 += kernel1[1][1] * arr1[i + 0][j + 0];
                    }
                    if (i + 0 >= 0 && i + 0 <= (height - 1) && j - 1 >= 0 && j - 1 <= (width - 1)) {
                        sum += kernel[1][2] * arr1[i + 0][j - 1];
                        sum1 += kernel1[1][2] * arr1[i + 0][j - 1];
                    }
                    if (i - 1 >= 0 && i - 1 <= (height - 1) && j + 1 >= 0 && j + 1 <= (width - 1)) {
                        sum += kernel[2][0] * arr1[i - 1][j + 1];
                        sum1 += kernel1[2][0] * arr1[i - 1][j + 1];
                    }
                    if (i - 1 >= 0 && i - 1 <= (height - 1) && j + 0 >= 0 && j + 0 <= (width - 1)) {
                        sum += kernel[2][1] * arr1[i - 1][j + 0];
                        sum1 += kernel1[2][1] * arr1[i - 1][j + 0];
                    }
                    if (i - 1 >= 0 && i - 1 <= (height - 1) && j - 1 >= 0 && j - 1 <= (width - 1)) {
                        sum += kernel[2][2] * arr1[i - 1][j - 1];
                        sum1 += kernel1[2][2] * arr1[i - 1][j - 1];
                    }
                    sum /= 9;
                    if (sum < 0) {
                        sum = 0;
                    }
                    if (sum > 255) {
                        sum = 255;
                    }
                    if (sum1 < 0) {
                        sum1 = 0;
                    }
                    if (sum1 > 255) {
                        sum1 = 255;
                    }
                    arr2[i][j] = sum;//low pass
                    arr3[i][j] = sum1;//high pass
                }
            }

            for (int i = 0; i < arr1.length; i++) {
//                System.out.println("");
                for (int j = 0; j < arr1[i].length; j++) {
//                    System.out.printf("%4s",arr2[i][j]);
                    myOutputFile.write(arr2[i][j]);
                    myOutputFile1.write(arr3[i][j]);
                }
            }

            myOutputFile.close();
            myOutputFile1.close();
            myInputFile.close();
        } catch (IOException ex) {
            System.out.println("File error!");
        }
    }
}
