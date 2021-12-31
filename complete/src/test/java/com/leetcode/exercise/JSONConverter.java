package com.leetcode.exercise;

import org.json.JSONArray;
import org.json.JSONException;

public class JSONConverter {
    public static int[] convertJSONtoIntArray(String jsonString) {
        try {
        JSONArray jsonArray = new JSONArray(jsonString);
        System.out.println(jsonArray);
        int[] array = new int[jsonArray.length()];
        for (int i = 0; i < jsonArray.length(); i++) {
             array[i] = (Integer) jsonArray.get(i);
        }
        return array;
        } catch (Exception e) {
            System.out.println("Invalid Json String:" + jsonString);
        }
        return null;
    }

    public static String[] convertJSONtoStringArray(String jsonString) {
        try {
        JSONArray jsonArray = new JSONArray(jsonString);
        System.out.println(jsonArray);
        String[] array = new String[jsonArray.length()];
        for (int i = 0; i < jsonArray.length(); i++) {
            array[i] = (String) jsonArray.get(i);
        }
        return array;
        } catch (Exception e) {
            System.out.println("Invalid Json String:" + jsonString);
        }
        return null;
    }

    public static int[][] convertJSONtoInt2DArray(String jsonString) {
        try {
            JSONArray jsonArray = new JSONArray(jsonString);
//        System.out.println(jsonArray);
            int[][] arrayOfArrays = new int[jsonArray.length()][];
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONArray innerJsonArray = (JSONArray) jsonArray.get(i);
                int[] intArray = new int[innerJsonArray.length()];
                for (int j = 0; j < innerJsonArray.length(); j++) {
                    intArray[j] = (int) innerJsonArray.get(j);
                }
                arrayOfArrays[i] = intArray;
            }
            return arrayOfArrays;
        } catch (Exception e) {
            System.out.println("Invalid Json String:" + jsonString);
        }
        return null;
    }

    public static char[][] convertJSONtoChar2DArray(String jsonString) {
        try {
        JSONArray jsonArray = new JSONArray(jsonString);
//        System.out.println(jsonArray);
        char[][] arrayOfArrays = new char[jsonArray.length()][];
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONArray innerJsonArray = (JSONArray) jsonArray.get(i);
            char[] stringArray = new char[innerJsonArray.length()];
            for (int j = 0; j < innerJsonArray.length(); j++) {
                stringArray[j] = ((String) innerJsonArray.get(j)).charAt(0);
            }
            arrayOfArrays[i] = stringArray;
        }
        return arrayOfArrays;
        } catch (Exception e) {
            System.out.println("Invalid Json String:" + jsonString);
        }
        return null;
    }

}
