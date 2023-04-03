package ru.netology.javacore;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Todos {
    protected final static int MAX_SIZE = 7;
    protected List<String> taskList;

    public Todos() {
        taskList = new ArrayList<>();
    }

    public void addTask(String task) {
        if (taskList.size() < MAX_SIZE) {
            taskList.add(task);
        }
    }

    public void removeTask(String task) {
        taskList.remove(task);
    }

    public String getAllTasks() {
        return taskList.stream()
                .sorted()
                .collect(Collectors.joining(" "));
    }
}
