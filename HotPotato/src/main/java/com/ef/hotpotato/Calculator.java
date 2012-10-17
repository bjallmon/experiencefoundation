package com.ef.hotpotato;

import java.util.Arrays;

public class Calculator {


    public static String calculate(String input) {
        Integer sum = Integer.valueOf(0);
        String[] splitNumbers = input.split("(?<=(\\+|\\*|\\-|\\/|\\d++))");
        System.out.println(Arrays.toString(splitNumbers));
        String operator = null;
        for (String item : splitNumbers) {
            Integer itemInteger;
            try {
                itemInteger = Integer.valueOf(item);
            } catch (NumberFormatException nfe) {
                operator = item;
                continue;
            }


            if ("-".equals(operator)) {
                sum = add(sum, (itemInteger * (-1)));
            } else if ("*".equals(operator)) {
                sum = multiply(sum, itemInteger);
            } else if ("/".equals(operator)) {
                sum = divide(sum, itemInteger);
            } else {
                sum = add(sum, itemInteger);
            }

        }

        return sum.toString();
    }

    private static Integer divide(Integer sum, Integer itemInteger) {
        return sum / itemInteger;
    }

    private static Integer multiply(Integer sum, Integer itemInteger) {
        return sum * itemInteger;

    }

    private static Integer add(Integer sum, Integer itemInteger) {
        return sum + itemInteger;
    }

}
