package com.ef.hotpotato;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HotPotato {

    public static String Hello() {
        return "Hello World!";
    }

    public static String echo(String input) {
        return input;
    }

    public static String echoList(List<String> listOfStrings) {
        StringBuilder result = new StringBuilder();
        int index = 0;
        for (String item : listOfStrings) {
            index++;
            result.append(item);
            if (index < listOfStrings.size()) {
                result.append("\n");
            }
        }
        return result.toString();
    }

    public static Map<String, Object> echoListAndSize(List<String> listOfStrings) {
        Map<String, Object> result = new HashMap<String, Object>();
        String text = echoList(listOfStrings);
        result.put("text", text);
        result.put("size", listOfStrings.size());
        return result;
    }
}
