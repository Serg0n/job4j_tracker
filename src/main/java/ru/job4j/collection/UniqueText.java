package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {
    public boolean isEquals(String originText, String duplicateText) {
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
         for (String wordOrigin : origin) {
             check.add(wordOrigin);
         }
        for (String wordText : text) {
            if (!check.contains(wordText)) {
                return false;
            }
        }
        return true;
    }
}