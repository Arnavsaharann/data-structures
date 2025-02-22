package com.bridgelabz.linearandbinarysearch.levelone;

public class SearchforWordInListOfSentences {
    public static void main(String[] args) {
        String[] sentences = {
                "My name is Arnav.",
                "My name is Mayank.",
                "My name is Vibhor.",
                "My name is Kanika."
        };

        String target = "Arnav";

        String ans = searchWordInSentences(sentences, target);
        if(ans.equals("")){
            System.out.println("The Word is not present");
        }else{
            System.out.println("The sentence where the word is present is: "+ans);
        }

    }
    public static String searchWordInSentences(String[] sentences, String target){
        for(String sentence : sentences){
            if(sentence.contains(target)){
                return sentence;
            }
        }

        return "";
    }
}
