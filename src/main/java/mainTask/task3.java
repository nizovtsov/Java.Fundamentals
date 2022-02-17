package mainTask;

import java.util.Random;
import java.util.Scanner;

//3.     Вывести заданное количество случайных чисел с переходом и без перехода на новую строку
public class task3 {
    private static void showLnArray(int [] array) {
        System.out.println("Output by newline: ");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    private static void showArray(int [] array) {
        System.out.print("Output without newline: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
    public static void main(String[] args) {
        int n;
        int[] array;

        System.out.println("Enter the number of random numbers to generate and press <Enter>: ");
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        n = scan.nextInt();
        scan.close();
        array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = rand.nextInt(10);
        }

        showLnArray(array);
        showArray(array);
    }
}
