package mainTask;

import java.util.InputMismatchException;
import java.util.Scanner;

//5.   Ввести число от 1 до 12. Вывести на консоль название месяца,
// соответствующего данному числу. Осуществить проверку корректности ввода чисел.
public class task5 {
    private static void switchMonth(int n) {
        System.out.println("Its a 'switchMonth'.");
        switch (n) {
            case 1:
                System.out.println("January");
                break;
            case 2:
                System.out.println("February");
                break;
            case 3:
                System.out.println("March");
                break;
            case 4:
                System.out.println("April");
                break;
            case 5:
                System.out.println("May");
                break;
            case 6:
                System.out.println("June");
                break;
            case 7:
                System.out.println("July");
                break;
            case 8:
                System.out.println("August");
                break;
            case 9:
                System.out.println("September");
                break;
            case 10:
                System.out.println("October");
                break;
            case 11:
                System.out.println("November");
                break;
            case 12:
                System.out.println("December");
                break;
            default:
                System.out.println("There are only 12 months in a year.");
        }
    }

    private static void arrayMonth(int n) {
        System.out.println("Its an 'arrayMonth'.");
        String str;
        String[] month = {"January", "February", "March", "April", "May", "June", "July", "August",
                "September", "October" ,"November", "December"};
        try {
            str = month[n -1];
            System.out.println("This month is " + str);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("There is no such month.");
        }
    }

    public static void main(String[] args) {
        int monthNumber;

        System.out.println("Enter month number and press <Enter>: ");
        Scanner scan = new Scanner(System.in);

        try {
            monthNumber = scan.nextInt();
            switchMonth(monthNumber);
            arrayMonth(monthNumber);
        } catch (InputMismatchException e) {
            System.out.println("There is no such month.");
        }

        scan.close();
    }
}
