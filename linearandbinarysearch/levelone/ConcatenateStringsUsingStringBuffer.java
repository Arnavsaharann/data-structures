package com.bridgelabz.linearandbinarysearch.levelone;

public class ConcatenateStringsUsingStringBuffer {
    public static void main(String[] args) {
        String[] stringArray = {"Arnav", "is", "a", "good", "boy"};

        String result = ConcatenateStrings(stringArray);
        System.out.println(result);

    }

    public static String ConcatenateStrings(String[] arr){
        StringBuilder sb = new StringBuilder();

        for(String s : arr){
            sb.append(s);
        }

        return sb.toString();
    }
}
