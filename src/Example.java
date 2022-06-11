import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Example {
    public static void main(String[] args) {
        String path = "D:\\Code\\Java\\JavaCore\\11_FileIO\\input.txt";
        File file = new File(path);
        /**
         * Tạo file
         */
        try {
            if (file.createNewFile()) {
                System.out.println("Tạo file " + file.getName() + " thành công");
            } else {
                System.out.println("File đã tồn tại");
            }
        } catch (IOException e) {
            System.out.println("Không thể tạo file");
            e.printStackTrace();
        }

        double[] myArr = new double[20];
        for (int i = 0; i < myArr.length; i++) {
            if (i < 10) {
                myArr[i] = new Random().nextInt(100);
            } else {
                myArr[i] = new Random().nextDouble(100);
            }
        }

        /**
         * Ghi vào file
         */
        try {
            FileWriter myWriter = new FileWriter(path);
            for (double value :
                    myArr) {
                myWriter.write(String.valueOf(value) + "\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        /**
         * Đọc file
         */
        Double[] a = new Double[myArr.length];
        try {
            Scanner myReader = new Scanner(file);
            int countA = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                try {
                    Double.parseDouble(data);
                } catch (NumberFormatException ex) {
                    System.out.println("Failed data");
                }
                a[countA] = Double.parseDouble(data);
                countA++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        for (int i = 0; i < a.length -1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    double temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                }
            }
        }

        try {
            FileWriter myWriter = new FileWriter(path);
            myWriter.write("Chiều dai của mảng là " + a.length + "\n");
            for (double value :
                    a) {
                myWriter.write(String.valueOf(value) + "\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            Scanner myReader = new Scanner(file);
            int countA = 0;
            String data = "";
            while (myReader.hasNextLine()) {
                data += myReader.nextLine() + "\n";
            }
            System.out.println(data);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

