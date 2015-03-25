package nl.vinyamar.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {

    public static void main(String[] args) {
        //        System.out.println(largestNumber(9, 2, 3, 310, 34, 5, 9, 11));
        System.out.println(largestNumber(1, 2, 90));

    }

    private static String largestNumber(int... num) {
        int total = 0;
        List<String> stringValues = new ArrayList<>();
        List<String> reversedStringValues = new ArrayList<>();
        for (int i = 0; i < num.length; i++) {
            String stringValue = new Integer(num[i]).toString();
            stringValues.add(stringValue);
            total = total + stringValue.length();
        }
        for (String value : stringValues) {
            StringBuilder reversedPaddedValue = new StringBuilder(value).reverse();
            for (int i = value.length(); i <= total; i++) {
                reversedPaddedValue.append("0");
            }
            reversedStringValues.add(reversedPaddedValue.toString());
        }
        sortIt(reversedStringValues);
        StringBuilder result = new StringBuilder();
        for (int i = reversedStringValues.size(); i > 0; i--) {
            String value = new StringBuilder(reversedStringValues.get(i - 1)).reverse().toString();
            result.append(Integer.valueOf(value).toString());
        }
        return result.toString();
    }

    private static void sortIt(List<String> reversedStringValues) {
        Comparator<String> beautifulComp = (str1, str2) -> {
            String s1 = str1 + str2;
            String s2 = str2 + str1;
            return s1.compareTo(s2);
        };
        Collections.sort(reversedStringValues);
    }

}
