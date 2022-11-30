import java.util.Arrays;
import java.util.logging.*;
import java.util.Scanner;
import java.io.*;

public class Pyzurek {
    public static void main(String[] args) throws SecurityException, IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите количество элементов массива: ");
        int size = input.nextInt();
        int array[] = new int[size];
        System.out.println("Введите через пробел элементы массива:");
        for (int i = 0; i < size; i++) {
            array[i] = input.nextInt();
        }
        input.close();
        System.out.println(Arrays.toString(array));

        Logger logger = Logger.getLogger(Pyzurek.class.getName());
        FileHandler fh = new FileHandler("Pyzurek_Log.txt");
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);

        boolean flag = false;
        int temp;
        while(!flag) {
            flag = true;
            logger.info(Arrays.toString(array));
            for (int i = 0; i < array.length-1; i++) {
                if (array[i] > array[i+1]) {
                    flag = false;
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}