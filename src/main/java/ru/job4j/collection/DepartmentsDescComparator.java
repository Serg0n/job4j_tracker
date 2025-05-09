package ru.job4j.collection;

import java.util.Comparator;

public class DepartmentsDescComparator implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] leftParts = left.split("/");
        String[] rightParts = right.split("/");

        int len = Math.min(leftParts.length, rightParts.length);
        for (int i = 0; i < len; i++) {
            int result;
            if (i == 0) {
                result = rightParts[i].compareTo(leftParts[i]);
            } else {
                result = leftParts[i].compareTo(rightParts[i]);
            }
            if (result != 0) {
                return result;
            }
        }
        return Integer.compare(leftParts.length, rightParts.length);
    }
}
