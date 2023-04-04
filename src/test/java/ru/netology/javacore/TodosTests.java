package ru.netology.javacore;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TodosTests {

    Todos todos;

    @BeforeEach
    void beforeEach() {
        todos = new Todos();
    }

    @Test
    void test_addTaskInTheBeginning() {
        boolean empty = todos.taskList.isEmpty();

        Assertions.assertTrue(empty);
    }

    @Test
    void test_addTaskAfterFilling() {
        int expectedSize = 1;

        todos.addTask("Какой-то текст");
        int realSize = todos.taskList.size();

        Assertions.assertEquals(expectedSize, realSize);
    }

    @Test
    void test_addTaskMaxSize() {
        int expectedSize = 7;

        int testingCount = 10;

        for (int i = 0; i < testingCount; i++) {
            todos.addTask("Какой-то текст");
        }
        int realSize = todos.taskList.size();

        Assertions.assertEquals(expectedSize, realSize);
    }

    @Test
    void test_removeTaskIfContains() {
        String testStr = "Гулять";
        todos.addTask(testStr);

        todos.removeTask(testStr);

        Assertions.assertFalse(todos.taskList.contains(testStr));
    }

    @Test
    void test_removeTaskIfNotContains() {
        int expectedSize = 1;

        String testStr = "Гулять";
        todos.addTask(testStr);
        String falseStr = "Играть";
        todos.removeTask(falseStr);

        int realSize = todos.taskList.size();

        Assertions.assertEquals(expectedSize, realSize);
    }

    @Test
    void test_getAllTasks() {
        String expectedStr = "Гулять Играть Смеяться";

        todos.addTask("Гулять");
        todos.addTask("Смеяться");
        todos.addTask("Играть");

        String realStr = todos.getAllTasks();

        Assertions.assertEquals(expectedStr, realStr);
    }
}
