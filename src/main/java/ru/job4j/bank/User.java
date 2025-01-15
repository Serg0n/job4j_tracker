package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс представляет пользователя банка, включающий паспортные данные и имя.
 * @author Serg0n
 * @version 1.0
 */
public class User {
    /**
     * Паспорт пользователя.
     */
    private String passport;

    /**
     * Имя пользователя.
     */
    private String username;

    /**
     * Конструктор для создания нового пользователя.
     * @param passport номер паспорта пользователя.
     * @param username имя пользователя.
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Возвращает номер паспорта пользователя.
     * @return номер паспорта.
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Устанавливает новый номер паспорта пользователя.
     * @param passport новый номер паспорта.
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Возвращает имя пользователя.
     * @return имя пользователя.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Устанавливает новое имя пользователя.
     * @param username новое имя пользователя.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Сравнивает текущий объект с другим объектом.
     * Сравнение выполняется только по номеру паспорта.
     * @param o объект для сравнения.
     * @return true, если объекты равны, иначе false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Возвращает хеш-код объекта, основанный на номере паспорта.
     * @return хеш-код объекта.
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
