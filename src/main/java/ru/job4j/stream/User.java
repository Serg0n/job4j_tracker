package ru.job4j.stream;

public record User(String passport, String username) {
    public String getPassport() {
        return passport;
    }
}