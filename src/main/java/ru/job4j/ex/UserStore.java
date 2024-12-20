package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (User user : users) {
            if (user.getUsername().equals(login)) {
                return user;
            }
        }
        throw new UserNotFoundException("Пользователь с логином " + login + " не найден");
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid()) {
            throw new UserInvalidException("Пользователь не валидный");
        }
        if (user.getUsername().length() < 3) {
            throw new UserInvalidException("Имя пользователя должно содержать не менее 3 символов.");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true),
        };

        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("У пользователя есть доступ");
            }
        } catch (UserInvalidException e) {
            System.out.println("Пользователь не валидный: " + e.getMessage());
        } catch (UserNotFoundException e) {
            System.out.println("Пользователь не найден: " + e.getMessage());
        }
    }
}