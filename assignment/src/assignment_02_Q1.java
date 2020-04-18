
import java.io.*;
import java.util.Scanner;

public class assignment_02_Q1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter image name: ");
        String name = input.next();
        System.out.print("Image Width: ");
        int width = input.nextInt();
        System.out.print("Image Height: ");
        int height = input.nextInt();
        System.out.println("Output file name is patterning.raw");

        try {
            File file = new File(name);
            FileInputStream myInputFile = new FileInputStream(file);
            FileOutputStream myOutputFile = new FileOutputStream("patterning.raw");
            int value;
            int k = 0;
            int l = 0;

            //width=123*3=369
            //height=62*3=186  
            int[] arr0 = new int[myInputFile.available()];
            int[][] arr = new int[height][width];
            int[][] arr1 = new int[height * 3][width * 3];

            //store value into 1D array(int)
            while ((value = myInputFile.read()) != -1) {
                arr0[k++] = value;
            }

            //store value into 2D array(int)
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    arr[i][j] = arr0[l++];
                }
            }

            //patterning
            for (int j = 0; j < arr.length; j++) {
                for (int i = 0; i < arr[j].length; i++) {
                    if (arr[j][i] >= 0 && arr[j][i] <= 25) {//pattern0
                        arr1[j * 3 + 0][i * 3 + 0] = 0;//1
                        arr1[j * 3 + 0][i * 3 + 1] = 0;//2
                        arr1[j * 3 + 0][i * 3 + 2] = 0;//3
                        arr1[j * 3 + 1][i * 3 + 0] = 0;//4
                        arr1[j * 3 + 1][i * 3 + 1] = 0;//5
                        arr1[j * 3 + 1][i * 3 + 2] = 0;//6
                        arr1[j * 3 + 2][i * 3 + 0] = 0;//7
                        arr1[j * 3 + 2][i * 3 + 1] = 0;//8
                        arr1[j * 3 + 2][i * 3 + 2] = 0;//9
                    }
                    if (arr[j][i] >= 26 && arr[j][i] <= 50) {//pattern1
                        arr1[j * 3 + 0][i * 3 + 0] = 0;//1
                        arr1[j * 3 + 0][i * 3 + 1] = 0;//2
                        arr1[j * 3 + 0][i * 3 + 2] = 0;//3
                        arr1[j * 3 + 1][i * 3 + 0] = 0;//4
                        arr1[j * 3 + 1][i * 3 + 1] = 0;//5
                        arr1[j * 3 + 1][i * 3 + 2] = 0;//6
                        arr1[j * 3 + 2][i * 3 + 0] = 0;//7
                        arr1[j * 3 + 2][i * 3 + 1] = 0;//8
                        arr1[j * 3 + 2][i * 3 + 2] = 255;//9
                    }
                    if (arr[j][i] >= 51 && arr[j][i] <= 75) {//pattern2
                        arr1[j * 3 + 0][i * 3 + 0] = 255;//1
                        arr1[j * 3 + 0][i * 3 + 1] = 0;//2
                        arr1[j * 3 + 0][i * 3 + 2] = 0;//3
                        arr1[j * 3 + 1][i * 3 + 0] = 0;//4
                        arr1[j * 3 + 1][i * 3 + 1] = 0;//5
                        arr1[j * 3 + 1][i * 3 + 2] = 0;//6
                        arr1[j * 3 + 2][i * 3 + 0] = 0;//7
                        arr1[j * 3 + 2][i * 3 + 1] = 0;//8
                        arr1[j * 3 + 2][i * 3 + 2] = 255;//9
                    }
                    if (arr[j][i] >= 76 && arr[j][i] <= 100) {//pattern3
                        arr1[j * 3 + 0][i * 3 + 0] = 255;//1
                        arr1[j * 3 + 0][i * 3 + 1] = 0;//2
                        arr1[j * 3 + 0][i * 3 + 2] = 255;//3
                        arr1[j * 3 + 1][i * 3 + 0] = 0;//4
                        arr1[j * 3 + 1][i * 3 + 1] = 0;//5
                        arr1[j * 3 + 1][i * 3 + 2] = 0;//6
                        arr1[j * 3 + 2][i * 3 + 0] = 0;//7
                        arr1[j * 3 + 2][i * 3 + 1] = 0;//8
                        arr1[j * 3 + 2][i * 3 + 2] = 255;//9
                    }
                    if (arr[j][i] >= 101 && arr[j][i] <= 125) {//pattern4
                        arr1[j * 3 + 0][i * 3 + 0] = 255;//1
                        arr1[j * 3 + 0][i * 3 + 1] = 0;//2
                        arr1[j * 3 + 0][i * 3 + 2] = 255;//3
                        arr1[j * 3 + 1][i * 3 + 0] = 0;//4
                        arr1[j * 3 + 1][i * 3 + 1] = 0;//5
                        arr1[j * 3 + 1][i * 3 + 2] = 0;//6
                        arr1[j * 3 + 2][i * 3 + 0] = 255;//7
                        arr1[j * 3 + 2][i * 3 + 1] = 0;//8
                        arr1[j * 3 + 2][i * 3 + 2] = 255;//9
                    }
                    if (arr[j][i] >= 126 && arr[j][i] <= 150) {//pattern5
                        arr1[j * 3 + 0][i * 3 + 0] = 255;//1
                        arr1[j * 3 + 0][i * 3 + 1] = 0;//2
                        arr1[j * 3 + 0][i * 3 + 2] = 255;//3
                        arr1[j * 3 + 1][i * 3 + 0] = 0;//4
                        arr1[j * 3 + 1][i * 3 + 1] = 0;//5
                        arr1[j * 3 + 1][i * 3 + 2] = 0;//6
                        arr1[j * 3 + 2][i * 3 + 0] = 255;//7
                        arr1[j * 3 + 2][i * 3 + 1] = 255;//8
                        arr1[j * 3 + 2][i * 3 + 2] = 255;//9
                    }
                    if (arr[j][i] >= 151 && arr[j][i] <= 175) {//pattern6
                        arr1[j * 3 + 0][i * 3 + 0] = 255;//1
                        arr1[j * 3 + 0][i * 3 + 1] = 0;//2
                        arr1[j * 3 + 0][i * 3 + 2] = 255;//3
                        arr1[j * 3 + 1][i * 3 + 0] = 255;//4
                        arr1[j * 3 + 1][i * 3 + 1] = 0;//5
                        arr1[j * 3 + 1][i * 3 + 2] = 0;//6
                        arr1[j * 3 + 2][i * 3 + 0] = 255;//7
                        arr1[j * 3 + 2][i * 3 + 1] = 255;//8
                        arr1[j * 3 + 2][i * 3 + 2] = 255;//9
                    }
                    if (arr[j][i] >= 176 && arr[j][i] <= 200) {//pattern7
                        arr1[j * 3 + 0][i * 3 + 0] = 255;//1
                        arr1[j * 3 + 0][i * 3 + 1] = 255;//2
                        arr1[j * 3 + 0][i * 3 + 2] = 255;//3
                        arr1[j * 3 + 1][i * 3 + 0] = 255;//4
                        arr1[j * 3 + 1][i * 3 + 1] = 0;//5
                        arr1[j * 3 + 1][i * 3 + 2] = 0;//6
                        arr1[j * 3 + 2][i * 3 + 0] = 255;//7
                        arr1[j * 3 + 2][i * 3 + 1] = 255;//8
                        arr1[j * 3 + 2][i * 3 + 2] = 255;//9
                    }
                    if (arr[j][i] >= 201 && arr[j][i] <= 225) {//pattern8
                        arr1[j * 3 + 0][i * 3 + 0] = 255;//1
                        arr1[j * 3 + 0][i * 3 + 1] = 255;//2
                        arr1[j * 3 + 0][i * 3 + 2] = 255;//3
                        arr1[j * 3 + 1][i * 3 + 0] = 255;//4
                        arr1[j * 3 + 1][i * 3 + 1] = 0;//5
                        arr1[j * 3 + 1][i * 3 + 2] = 255;//6
                        arr1[j * 3 + 2][i * 3 + 0] = 255;//7
                        arr1[j * 3 + 2][i * 3 + 1] = 255;//8
                        arr1[j * 3 + 2][i * 3 + 2] = 255;//9
                    }
                    if (arr[j][i] >= 226 && arr[j][i] <= 255) {//pattern9
                        arr1[j * 3 + 0][i * 3 + 0] = 255;//1
                        arr1[j * 3 + 0][i * 3 + 1] = 255;//2
                        arr1[j * 3 + 0][i * 3 + 2] = 255;//3
                        arr1[j * 3 + 1][i * 3 + 0] = 255;//4
                        arr1[j * 3 + 1][i * 3 + 1] = 255;//5
                        arr1[j * 3 + 1][i * 3 + 2] = 255;//6
                        arr1[j * 3 + 2][i * 3 + 0] = 255;//7
                        arr1[j * 3 + 2][i * 3 + 1] = 255;//8
                        arr1[j * 3 + 2][i * 3 + 2] = 255;//9
                    }
                }
            }
            //output(before patterning)
//            for (int j = 0; j < arr.length; j++) {
//                System.out.println("");
//                for (int i = 0; i < arr[j].length; i++) {
//                    System.out.printf("%4s", arr[j][i]);
//                }
//            }
//            System.out.println("\n\n");
            //output(after patterning)
            for (int j = 0; j < arr1.length; j++) {
//                System.out.println("");
                for (int i = 0; i < arr1[j].length; i++) {
//                    System.out.printf("%4s", arr1[j][i]);
                    myOutputFile.write(arr1[j][i]);
                }
            }
            myOutputFile.close();
            myInputFile.close();
        } catch (IOException ex) {
            System.out.println("File error!");
        }
    }
}
