
import java.io.*;
import java.util.Scanner;

public class assignment_04 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter image name: ");
        String name = input.next();
        System.out.print("Image Width: ");
        int width = input.nextInt();
        System.out.print("Image Height: ");
        int height = input.nextInt();
        System.out.println("Output file name is convolution.raw");

        try {
            File file = new File(name);
            FileInputStream myInputFile = new FileInputStream(file);
            FileOutputStream myOutputFile = new FileOutputStream("convolution.raw");
            int value;
            int k = 0;
            int l = 0;
            int sum = 0;

            int[][] h = {{-1, 0, 1}, {-2, 0, 2}, {-1, 0, 1}};
            int[] arr0 = new int[myInputFile.available()];
            int[][] arr1 = new int[height][width];//store f(x,y)
            int[][] arr2 = new int[height][width];//store g(x,y)

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
            //convolution
            for (int i = 0; i < arr2.length; i++) {
                for (int j = 0; j < arr2[i].length; j++) {
                    sum = 0;
                    if (i + 1 >= 0 && i + 1 <= (height - 1) && j + 1 >= 0 && j + 1 <= (width - 1)) {
                        sum += h[0][0] * arr1[i + 1][j + 1];
                    }
                    if (i + 1 >= 0 && i + 1 <= (height - 1) && j + 0 >= 0 && j + 0 <= (width - 1)) {
                        sum += h[0][1] * arr1[i + 1][j + 0];
                    }
                    if (i + 1 >= 0 && i + 1 <= (height - 1) && j - 1 >= 0 && j - 1 <= (width - 1)) {
                        sum += h[0][2] * arr1[i + 1][j - 1];
                    }
                    if (i + 0 >= 0 && i + 0 <= (height - 1) && j + 1 >= 0 && j + 1 <= (width - 1)) {
                        sum += h[1][0] * arr1[i + 0][j + 1];
                    }
                    if (i + 0 >= 0 && i + 0 <= (height - 1) && j + 0 >= 0 && j + 0 <= (width - 1)) {
                        sum += h[1][1] * arr1[i + 0][j + 0];
                    }
                    if (i + 0 >= 0 && i + 0 <= (height - 1) && j - 1 >= 0 && j - 1 <= (width - 1)) {
                        sum += h[1][2] * arr1[i + 0][j - 1];
                    }
                    if (i - 1 >= 0 && i - 1 <= (height - 1) && j + 1 >= 0 && j + 1 <= (width - 1)) {
                        sum += h[2][0] * arr1[i - 1][j + 1];
                    }
                    if (i - 1 >= 0 && i - 1 <= (height - 1) && j + 0 >= 0 && j + 0 <= (width - 1)) {
                        sum += h[2][1] * arr1[i - 1][j + 0];
                    }
                    if (i - 1 >= 0 && i - 1 <= (height - 1) && j - 1 >= 0 && j - 1 <= (width - 1)) {
                        sum += h[2][2] * arr1[i - 1][j - 1];
                    }
                    if (sum < 0) {
                        sum = 0;
                    }
                    if (sum > 255) {
                        sum = 255;
                    }
                    arr2[i][j] = sum;
                }
            }

            //output
            for (int i = 0; i < arr1.length; i++) {
//                System.out.println("");
                for (int j = 0; j < arr1[i].length; j++) {
//                    System.out.printf("%4s", arr2[i][j]);
                    myOutputFile.write(arr2[i][j]);
                }
            }

            myOutputFile.close();
            myInputFile.close();
        } catch (IOException ex) {
            System.out.println("File error!");
        }
    }
}
