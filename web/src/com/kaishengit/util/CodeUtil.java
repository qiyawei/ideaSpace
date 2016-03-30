package com.kaishengit.util;

import java.util.HashMap;
import java.util.Map;

public class CodeUtil {

    public static Map<String, Integer> map = new HashMap<String, Integer>();

    public static void put(String key,Integer value) {
        map.put(key, value);
    }

    public static Integer get(String key) {
        Integer num = map.get(key);
        if(num == null){
            return 0;
        }
        return num;
    }

    public static void remove(String key) {
        map.remove(key);
    }
}
