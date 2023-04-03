package ru.netology.javacore.client;

public class Message {

    public enum MessageType {
        ADD, REMOVE, RESTORE;
    }

    protected String type;
    protected String task;

    public Message(MessageType typeOfTask, String textOfTask) {
        if (typeOfTask == MessageType.ADD) {
            this.type = "ADD";
        } else if (typeOfTask == MessageType.REMOVE) {
            this.type = "REMOVE";
        } else {
            throw new RuntimeException("Ошибка введения данных");
        }
        this.task = textOfTask;
    }

    public Message(MessageType typeOfTask) {
        if (typeOfTask == MessageType.RESTORE) {
            this.type = "RESTORE";
        } else {
            throw new RuntimeException("Ошибка введения данных");
        }
    }

    public String getType() {
        return type;
    }

    public String getTask() {
        return task;
    }
}
