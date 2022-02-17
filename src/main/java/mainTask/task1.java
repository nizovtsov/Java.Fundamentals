package mainTask;

import java.util.Scanner;

//1.     Приветствовать любого пользователя при вводе его имени через командную строку.
public class task1 {
    public static void main(String[] args) {
        System.out.println("Please enter your name and press <Enter>: ");
        Scanner scan = new Scanner(System.in);
        String name = scan.next();
        System.out.println("Hello, " + name);
        scan.close();
    }
}
