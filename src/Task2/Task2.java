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

        HashSet<Integer> mySet = new HashSet<>();
        int secondNumber;

        for (int firstNumber : array) {
            secondNumber = sum - firstNumber;
            if (mySet.contains(secondNumber)) {
                System.out.println("[" + firstNumber + ", " + secondNumber + "]");
                return;
            }
            mySet.add(secondNumber);
        }

        System.out.println("[]"); // в случае если искомой пары нет


    }


    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 7};
        twoNumbersWithSum(arr, 10);
    }
}
