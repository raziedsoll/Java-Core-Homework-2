package HomeWork2.Task3;

import java.util.Arrays;

/*
Task3
Реализовать функцию нечеткого поиска

fuzzySearch("car", "ca6$$#_rtwheel"); // true
fuzzySearch("cwhl", "cartwheel"); // true
fuzzySearch("cwhee", "cartwheel"); // true
fuzzySearch("cartwheel", "cartwheel"); // true
fuzzySearch("cwheeel", "cartwheel"); // false
fuzzySearch("lw", "cartwheel"); // false
*/
public class Task3 {

    static boolean fuzzySearch(String subStr, String str) {
        if (subStr == null || str == null) {
            return false;
        }

        if(subStr.equals(str)){
            return true;
        }

        if(subStr.length() == 0){
            return false;
        }

        int index = 0;
        for (int i = 0; i < str.length(); i++) {

            if (subStr.charAt(index) == str.charAt(i)) {
                index++;
            }

            if (index == subStr.length()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(fuzzySearch("car", "ca6$$#_rtwheel")); //true
        System.out.println(fuzzySearch("cwhl", "cartwheel")); //true
        System.out.println(fuzzySearch("cwhee", "cartwheel")); //true
        System.out.println(fuzzySearch("cartwheel", "cartwheel")); //true
        System.out.println(fuzzySearch("cwheeel", "cartwheel")); //false
        System.out.println(fuzzySearch("lw", "cartwheel")); //false

        System.out.println(fuzzySearch(null, "ca6$$#_rtwheel")); //false
        System.out.println(fuzzySearch("car", null)); //false
        System.out.println(fuzzySearch(null, null)); //false

        System.out.println(fuzzySearch("", "")); //true
        System.out.println(fuzzySearch("car", "")); //false
        System.out.println(fuzzySearch("", "cartwheel")); //false
    }
}
