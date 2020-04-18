
import java.io.*;
import java.text.DecimalFormat;
import java.util.Scanner;

public class assignment_03 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter image name: ");
        String name = input.next();
        System.out.print("Image Width: ");
        int width = input.nextInt();
        System.out.print("Image Height: ");
        int height = input.nextInt();
        System.out.println("Output file name is histogram.raw");

        try {
            File file = new File(name);
            FileInputStream myInputFile = new FileInputStream(file);
            FileOutputStream myOutputFile1 = new FileOutputStream("histogram.raw");
            int value;
            int k = 0;//count arr0
            int runSum1 = 0;//for increment use and get the last value of runSum(array)
            int[] arr0 = new int[myInputFile.available()];
            int[] noOfPixel = new int[256];//num of pixels of original image
            int[] noOfPixel1 = new int[256];//num of pixels of histogram image
            int[] runSum = new int[256];//run sum
            double[] normalized = new double[256];//normalized(run sum / 7626)
            double[] mul255 = new double[256];//multiply 255(double)
            int[] map = new int[256];//histogram-equalized value

            //store value into 1D array(int)
            while ((value = myInputFile.read()) != -1) {
                arr0[k++] = value;
                noOfPixel[value]++;//store total number of each value into array
            }

            //run sum
            for (int i = 0; i < noOfPixel.length; i++) {
                runSum[i] = runSum1 += noOfPixel[i];
            }

            //normalized
            DecimalFormat df = new DecimalFormat("0.00");
            for (int i = 0; i < runSum.length; i++) {
                normalized[i] = runSum[i] / 1.0 / runSum1;
            }

            //multiply255
            for (int i = 0; i < normalized.length; i++) {
                mul255[i] = Math.round(normalized[i] * 255);
            }

            //map no of pixels with multiply255
            for (int j = 0; j < mul255.length; j++) {
                map[(int) (mul255[j])] += noOfPixel[j];
            }

            //output
            String t = "\t\t";//space
            System.out.print("-------------------------------------");
            System.out.print("Histogram-equalized values");
            System.out.println("-------------------------------------");
            System.out.println("Gray-level\tNo of Pixel\tRun Sum\t\tNormalized\t"
                    + "Multiply255\tMap\tNew No of Pixel");
            System.out.println("----------------------------------------------"
                    + "------------------------------------------------------");

            for (int i = 0; i < arr0.length; i++) {
                myOutputFile1.write((int) mul255[arr0[i]]);
                noOfPixel1[(int) mul255[arr0[i]]]++;
            }

            for (int i = 0; i < noOfPixel.length; i++) {
                System.out.println(i + t + noOfPixel[i] + t + runSum[i] + t
                        + df.format(normalized[i]) + t + (int) (mul255[i])
                        + t + map[i] + "\t" + noOfPixel1[i]);
            }

            myOutputFile1.close();
            myInputFile.close();
        } catch (IOException ex) {
            System.out.println("File error!");
        }
    }
}
