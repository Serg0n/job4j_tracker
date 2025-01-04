package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder text = new StringBuilder();
        Character temp;
        int size = evenElements.size();
        for (int i = 0; i < size; i++) {
            temp = evenElements.pop();
            if (i % 2 == 0) {
            text.append(temp);
            }
        }
        return text.toString();
    }

    private String getDescendingElements() {
        StringBuilder text = new StringBuilder();
        Character temp;
        int size = descendingElements.size();
        for (int i = 0; i < size; i++) {
            temp = descendingElements.pollLast();
            text.append(temp);
        }
        return text.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}