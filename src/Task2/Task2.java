package HomeWork2.Task2;

/*
Задание 2
[3, 4, 2, 7], 10 -> [3, 7] - вывести пару менно в скобках, которые дают сумму - 10
*/


import java.util.ArrayList;

public class Task2 {

    static ArrayList<Integer> twoNumbersWithSum(int[] array, int sum) {

        ArrayList<Integer> list = new ArrayList<>();
        if (array == null || array.length < 2) {
            return list;
        }

        int total;

        OUTER:
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                total = array[i];
                total += array[j];
                if (total == sum) {
                    list.add(array[i]);
                    list.add(array[j]);
                    break OUTER;
                }
            }
        }
        return list;
    }


    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 7};
        System.out.println(twoNumbersWithSum(arr, 10));
    }
}
