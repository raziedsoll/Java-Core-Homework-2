package HomeWork2.Task2;

/*
Задание 2
[3, 4, 2, 7], 10 -> [3, 7] - вывести пару менно в скобках, которые дают сумму - 10
*/


import java.util.*;


public class Task2 {

    static void twoNumbersWithSum(int[] array, int sum) {

        if (array == null) {
            System.out.println("The argument is a null reference!");
            return;
        }

        if (array.length < 2) {
            System.out.println("[]");
            return;
        }

        int indexOfSecNum;
        Arrays.sort(array);

        for (int i = 0; i < array.length; i++) {
            indexOfSecNum = Arrays.binarySearch(array, i + 1, array.length, sum - array[i]);
            if (indexOfSecNum > 0) {
                System.out.println("[" + array[i] + ", " + array[indexOfSecNum] + "]");
                return;
            }
        }

        System.out.println("[]"); // в случае если искомой пары нет
    }


    public static void main(String[] args) {
        int[] arr1 = {3, 4, 2, 7};
        twoNumbersWithSum(arr1, 10);
    }
}
