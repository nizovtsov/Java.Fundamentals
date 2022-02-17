package mainTask;

import java.util.Arrays;

//4.     Ввести целые числа как аргументы командной строки, подсчитать их сумму (произведение)
// и вывести результат на консоль.
public class task4 {
    public static void main(String[] args) {
        int sum = 0;
        int multiplication = 0;
        int x;
        System.out.println("Our array: " + Arrays.toString(args));
        for (int i = 0; i < args.length; i++) {
            x = Integer.parseInt(args[i]);

            if (i == 0) {
                sum = x;
                multiplication = x;
            } else {
                sum += x;
                multiplication *= x;
            }
        }
        System.out.println("Summation: " + sum);
        System.out.println("Multiplication: " + multiplication);
    }
}
