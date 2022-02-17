package optionalTask1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

//Optional Task 1
public class task {
    public static void main(String[] args) {
        int n;
        int[] array;
        int[] unsortedArray;
        int[] lengthArray;

        System.out.print("Введите количество элементов массива и нажмите <Enter>: ");
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        array = new int[n];
        unsortedArray = new int[n];
        //lengthArray = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Введите " + i + " элемент: ");
            array[i] = scan.nextInt();
            unsortedArray[i] = array[i];
        }
        scan.close();

        System.out.println("Введенный массив: " + Arrays.toString(array));
        bubbleSort(array);
        lengthArray = getLengthArray(array);

        System.out.println("-------");
        System.out.println("Пункт 1");
        System.out.println("Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.");
        printMinMaxValueAndLength(array, lengthArray);

        System.out.println("-------");
        System.out.println("Пункт 2");
        System.out.println("Вывести числа в порядке возрастания (убывания) значений их длины.");
        printSortedArray(array);

        System.out.println("-------");
        System.out.println("Пункт 3");
        System.out.println("Вывести на консоль те числа, длина которых меньше (больше) средней длины по всем числам, а также длину.");
        printValuesLesserBiggerThanAverageLength(array, lengthArray);

        System.out.println("-------");
        System.out.println("Пункт 4");
        System.out.println("Найти число, в котором количество различных цифр минимально. Если таких чисел несколько, найти первое из них.");
        printValueWithMinSameChars(unsortedArray); // TODO: 2/15/22 немного исправить функцию

        System.out.println("-------");
        System.out.println("Пункт 5");
        System.out.println("Найти количество чисел, содержащих только четные цифры, а среди оставшихся — количество чисел с равным числом четных и нечетных цифр.");
        printCountOddEvenNumbers(array);

        System.out.println("-------");
        System.out.println("Пункт 6");
        System.out.println("Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел несколько, найти первое из них.");
        printNumberWithAscendingDigits(array);

        System.out.println("-------");
        System.out.println("Пункт 7");
        System.out.println("Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них");
        printNumberWithOnlyDifferentDigits(array);
        //printNumberWithOnlyDifferentDigits(unsortedArray);

        //System.out.println("Our sorted array: " + Arrays.toString(array));
        //System.out.println("Our sorted array: " + Arrays.toString(lengthArray));
        //System.out.println("Our array: " + Arrays.toString(array));
    }

    //1
    private static void printMinMaxValueAndLength(int[] array, int[] lengthArray) {
        System.out.println("Минимальное число: " + array[0] + " и количество цифр в нем: "+ lengthArray[0]);
        System.out.println("Максимальное число: " + array[array.length-1] + " и количество цифр в нем: "+ lengthArray[lengthArray.length-1]);
    }

    //2
    private static void printSortedArray(int[] array) {
        System.out.println("По возрастанию");
        for (int i = 0; i < array.length; i++) {
            System.out.println("Элемент " + i + " : " + array[i]);
        }

        System.out.println("По убыванию");
        for (int i = array.length-1; i >= 0; i--) {
            System.out.println("Элемент " + i + " : " + array[i]);
        }
    }

    //3
    private static void printValuesLesserBiggerThanAverageLength(int[] array, int[] lengthArray) {
        int sumOfLengthArr = 0;
        int numOfLengthArr = 0;
        double averageOfLengthArr;

        for (int i = 0; i < lengthArray.length; i++) {
            sumOfLengthArr += lengthArray[i];
            numOfLengthArr++;
        }

        averageOfLengthArr = (double)sumOfLengthArr/(double)numOfLengthArr;

        System.out.println("Значения меньше средней длины");
        for (int i = 0; i < lengthArray.length; i++) {
            if (lengthArray[i] < averageOfLengthArr) {
                System.out.println("Значение: " + array[i] + " и количество цифр в нем: "+ lengthArray[i]);
            }
        }

        System.out.println("Значения больше средней длины");
        for (int i = 0; i < lengthArray.length; i++) {
            if (lengthArray[i] > averageOfLengthArr) {
                System.out.println("Значение: " + array[i] + " и количество цифр в нем: " + lengthArray[i]);
            }
        }
    }

    //5
    private static void printCountOddEvenNumbers(int[] arr) {
        int evenDigit = 0; // количество четных цифр в числе
        int oddDigit = 0; // количество нечетных цифр в числе

        int evenCount = 0; // итоговое количество чисел состоящих из четных цифр
        int oddCount = 0; // итоговое количество чисел с равным числом четных и нечетных цифр

        int[] tempArr = arr.clone();

        System.out.println("array0: " + Arrays.toString(tempArr));
        for (int i = 0; i < tempArr.length; i++) {
            ArrayList<Integer> tempNumber = new ArrayList<>();
            System.out.println("обрабатываем: " + tempArr[i]);
            while (tempArr[i] != 0) {
                tempNumber.add(tempArr[i] % 10);
                tempArr[i] /= 10;
            }

            // проверить каждую цифру на четность и увеличить нужный счетчик
            for (int j = 0; j < tempNumber.size(); j++) {
                if (tempNumber.get(j) % 2 == 0) evenDigit++;
                else oddDigit++;
            }

            // если количество четных цифр = количеству цифр в чисел
            if (evenDigit == tempNumber.size()) {
                evenCount++; // первое условие
                //System.out.println("из четных чисел: " + tempNumber.toString());
            }
            else if (evenDigit == oddDigit) {
                oddCount++; // второе условие -> если четные = нечетным
                //System.out.println("четные и не четные%: " + tempNumber.toString());
            }

            // обнуление счетчиков
            evenDigit = 0;
            oddDigit = 0;
        }
        System.out.println("Количество цифр состоящих только из четных чисел : " + evenCount + "\nА чисел, где кол-во четных и нечетных чисел равны : " + oddCount);
    }

    //6.1
    private static void printNumberWithAscendingDigits(int[] array) {
        for (int number: array) {
            int[] digits = splitNumberIntoDigits(number);
                    if (isDigitsAsc(digits)) {
                        System.out.println(number);
                        break;
                    }
        }
    }
    //6.2
    public static int[] splitNumberIntoDigits(int number) {
        String numberStr = Integer.toString(number);
        int[] arr = new int[numberStr.length()];
        //for (int i = 0; i < numberStr.length() - 1; i++) {
        for (int i = numberStr.length() - 1; i >= 0; i--) {
            //arr[i]=Integer.valueOf(numberStr.charAt(i));
            arr[i] = number % 10;
            number /= 10;
        }
        return arr;
        //return String.valueOf(number).chars().map(Character::getNumericValue).toArray();
    }
    //6.3
    public static boolean isDigitsAsc(int[] digits) {
        for (int i = 0; i < digits.length; i++) {
            if (i+1< digits.length && (digits[i+1] < digits[i]))
                return false;
        }
        return true;
    }
    //7
    private static void printNumberWithOnlyDifferentDigits(int[] array) {
        for (int element : array) {
            boolean isDistinct = true;
            char[] chars = String.valueOf(Math.abs(element)).toCharArray();
            for (int i = 0; i < chars.length - 1; i++) {
                for (int j = i + 1; j < chars.length; j++) {
                    if (chars[i] == chars[j]) {
                        isDistinct = false;
                        break;
                    }
                }
                if (!isDistinct) {
                    break;
                } else if (i == chars.length - 2) {
                    System.out.println("Первое число в списке, состоящее только из различных цифр: " + element);
                    return;
                }
            }
        }
        System.out.println("========Таких чисел нет!!!========");
    }

    private static void printValueWithMinSameChars(int[] arr) {
        int min = diffNum(arr[0]);
        int minElem = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (diffNum(arr[i]) < min) {
                min = diffNum(arr[i]);
                minElem = arr[i];
            }
        }
        System.out.println("Минимальный элемент: " + minElem);
    }

    private static int diffNum(int x) {
        HashSet<Integer> nums = new HashSet<>();
        while (x > 0) {
            nums.add(x % 10);
            x /= 10;
        }
        return nums.size();
    }



    private static void bubbleSort(int[] array) {
        int b;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j+1]) {
                    b = array[j];
                    array[j] = array[j+1];
                    array[j+1] = b;
                }
            }
        }
    }

    private static int[] getLengthArray(int[] array) {
        int[] lengthArr = new int[array.length];
        int i = 0;

        for (Integer value : array) {
            //lengthArr[i] = (int)(Math.log10(value)+1);
            lengthArr[i] = String.valueOf(value).length();
            i++;
        }

        return lengthArr;
    }
}
