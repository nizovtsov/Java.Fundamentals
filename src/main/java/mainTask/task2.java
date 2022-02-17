package mainTask;

import java.util.Arrays;

//2.     Отобразить в окне консоли аргументы командной строки в обратном порядке.
public class task2 {
    public static void main(String[] args) {
        System.out.println("Our array: " + Arrays.toString(args));
        for (int i = args.length-1; i >= 0; i--) {
            System.out.println("argument = " +i+ " = " + args[i]);
        }
    }
}
