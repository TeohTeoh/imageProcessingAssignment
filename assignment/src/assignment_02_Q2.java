
import java.io.*;
import java.util.Scanner;

public class assignment_02_Q2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter image name: ");
        String name = input.next();
        System.out.print("Image Width: ");
        int width = input.nextInt();
        System.out.print("Image Height: ");
        int height = input.nextInt();
        System.out.println("Output file name is d1.raw and d2.raw");

        try {
            File file = new File(name);
            FileInputStream myInputFile = new FileInputStream(file);
            FileOutputStream myOutputFile = new FileOutputStream("d1.raw");
            FileOutputStream myOutputFile1 = new FileOutputStream("d2.raw");
            int value;
            int k = 0;
            int l = 0;
            int m = 0;
            int[][] d1 = {{0, 128}, {192, 64}};
            int[][] d2 = {
                {0, 128, 32, 160},
                {192, 64, 224, 96},
                {48, 176, 16, 144},
                {240, 112, 208, 80}};
            int[] arr0 = new int[myInputFile.available()];
            int[][] arr1 = new int[height][width];
            int[][] arr2 = new int[height][width];

            //store value into 1D array(int)
            while ((value = myInputFile.read()) != -1) {
                arr0[k++] = value;
            }

            for (int i = 0; i < arr1.length; i++) {
                for (int j = 0; j < arr1[i].length; j++) {
                    //store value into 2D array(int)
                    arr1[i][j] = arr0[l++];
                    arr2[i][j] = arr0[m++];
                    //d1
                    if (arr1[i][j] > d1[i % 2][j % 2]) {
                        arr1[i][j] = 255;
                    } else {
                        arr1[i][j] = 0;
                    }
                    //d2
                    if (arr2[i][j] > d2[i % 4][j % 4]) {
                        arr2[i][j] = 255;
                    } else {
                        arr2[i][j] = 0;
                    }
                    myOutputFile.write(arr1[i][j]);
                    myOutputFile1.write(arr2[i][j]);
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
