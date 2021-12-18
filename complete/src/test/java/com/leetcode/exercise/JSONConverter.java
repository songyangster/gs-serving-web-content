package com.leetcode.exercise;

import org.json.JSONArray;
import org.json.JSONException;

public class JSONConverter {
    public static int[][] convertJSONtoInt2DArray(String jsonString) throws JSONException {
        JSONArray jsonArray = new JSONArray(jsonString);
//        System.out.println(jsonArray);
        int[][] arrayOfArrays = new int[jsonArray.length()][];
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONArray innerJsonArray = (JSONArray) jsonArray.get(i);
            int[] stringArray = new int[innerJsonArray.length()];
            for (int j = 0; j < innerJsonArray.length(); j++) {
                stringArray[j] = Integer.valueOf((String) innerJsonArray.get(j));
            }
            arrayOfArrays[i] = stringArray;
        }
        return arrayOfArrays;
    }

    public static char[][] convertJSONtoChar2DArray(String jsonString) throws JSONException {
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
    }

}
