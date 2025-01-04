package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.action.*;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StartUITest {

    @Test
    void whenExit() {
        Output output = new StubOutput();
        Input input = new MockInput(new String[]{"0"});
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(new ExitAction(output));
        new StartUI(output).init(input, tracker, actions);
        String expected = String.join(System.lineSeparator(),
                "Меню:",
                "0. Завершить программу",
                "=== Завершение программы ===",
                "");
        assertThat(output.toString()).isEqualTo(expected);
    }

    @Test
    void whenReplaceItemTestOutputIsSuccessfully() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input input = new MockInput(new String[]{"0", String.valueOf(one.getId()), replaceName, "1"});
        List<UserAction> actions = List.of(
                new ReplaceAction(output),
                new ExitAction(output)
        );
        new StartUI(output).init(input, tracker, actions);
        String expected = String.join(System.lineSeparator(),
                "Меню:",
                "0. Изменить заявку",
                "1. Завершить программу",
                "=== Редактирование заявки ===",
                "Заявка изменена успешно.",
                "Меню:",
                "0. Изменить заявку",
                "1. Завершить программу",
                "=== Завершение программы ===",
                "");
        assertThat(output.toString()).isEqualTo(expected);
    }

    @Test
    void whenFindAllActionTestOutputIsSuccessfully() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Input input = new MockInput(new String[]{"0", "1"});
        List<UserAction> actions = List.of(
                new FindAllAction(output),
                new ExitAction(output)
        );
        new StartUI(output).init(input, tracker, actions);
        String expected = String.join(System.lineSeparator(),
                "Меню:",
                "0. Показать все заявки",
                "1. Завершить программу",
                "=== Вывод всех заявок ===",
                one.toString(),
                "Меню:",
                "0. Показать все заявки",
                "1. Завершить программу",
                "=== Завершение программы ===",
                "");
        assertThat(output.toString()).isEqualTo(expected);
    }

    @Test
    void whenFindByNameActionTestOutputIsSuccessfully() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Input input = new MockInput(new String[]{"0", one.getName(), "1"});
        List<UserAction> actions = List.of(
                new FindByNameAction(output),
                new ExitAction(output)
        );
        new StartUI(output).init(input, tracker, actions);
        String expected = String.join(System.lineSeparator(),
                "Меню:",
                "0. Показать заявки по имени",
                "1. Завершить программу",
                "=== Вывод заявок по имени ===",
                one.toString(),
                "Меню:",
                "0. Показать заявки по имени",
                "1. Завершить программу",
                "=== Завершение программы ===",
                "");
        assertThat(output.toString()).isEqualTo(expected);
    }

    @Test
    void whenInvalidExit() {
        Output output = new StubOutput();
        Input input = new MockInput(new String[]{"8", "0"});
        Tracker tracker = new Tracker();
        List<UserAction> actions = List.of(new ExitAction(output));
        new StartUI(output).init(input, tracker, actions);
        String expected = String.join(System.lineSeparator(),
                "Меню:",
                "0. Завершить программу",
                "Неверный ввод, вы можете выбрать: 0 .. 0",
                "Меню:",
                "0. Завершить программу",
                "=== Завершение программы ===",
                "");
        assertThat(output.toString()).isEqualTo(expected);
    }
}
