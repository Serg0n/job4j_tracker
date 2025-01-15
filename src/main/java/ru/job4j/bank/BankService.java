package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу банковского сервиса по добавлению,
 * удалению, пользователей их аккаунтов и переводу средств между счетами.
 * @author Serg0n
 * @version 1.0
 **/
public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Добавляет пользователя в систему.
     * Если пользователь уже существует, он не будет добавлен.
     * @param user пользователь, которого необходимо добавить.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Удаляет пользователя из системы по номеру паспорта.
     * @param passport номер паспорта пользователя, которого необходимо удалить.
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Добавляет новый счет к пользователю по номеру паспорта.
     * Если пользователь не найден или у него уже есть такой счет, операция не выполняется.
     * @param passport номер паспорта пользователя.
     * @param account добавляемый счет.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Ищет пользователя по номеру паспорта.
     * @param passport номер паспорта пользователя.
     * @return пользователь с указанным паспортом или null, если пользователь не найден.
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Ищет счет пользователя по номеру паспорта и реквизитам.
     * @param passport номер паспорта пользователя.
     * @param requisite реквизиты счета.
     * @return счет с указанными реквизитами или null, если счет не найден.
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Выполняет перевод денег с одного счета на другой.
     * @param sourcePassport номер паспорта отправителя.
     * @param sourceRequisite реквизиты счета отправителя.
     * @param destinationPassport номер паспорта получателя.
     * @param destinationRequisite реквизиты счета получателя.
     * @param amount сумма перевода.
     * @return true, если перевод успешно выполнен, иначе false.
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        Account sourceAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account destinationAccount = findByRequisite(destinationPassport, destinationRequisite);
        if (sourceAccount != null && destinationAccount != null && sourceAccount.getBalance() >= amount) {
            sourceAccount.setBalance(sourceAccount.getBalance() - amount);
            destinationAccount.setBalance(destinationAccount.getBalance() + amount);
            return true;
        }
        return false;
    }

    /**
     * Получает список счетов пользователя.
     * @param user пользователь, чьи счета необходимо получить.
     * @return список счетов пользователя или null, если пользователь не найден.
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
