package ru.netology.javacore;

import com.google.gson.Gson;
import ru.netology.javacore.client.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class TodoServer {
    protected final int PORT;
    protected Todos todos;

    public TodoServer(int port, Todos todos) {
        this.PORT = port;
        this.todos = todos;
    }

    public void start() throws IOException {
        System.out.println("Starting server at " + PORT + "...");
        Gson gson = new Gson();

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                    String taskJson = in.readLine();
                    Message taskMessage = gson.fromJson(taskJson, Message.class);
                    switch (taskMessage.getType()) {
                        case "ADD":
                            todos.addTask(taskMessage.getTask());
                            break;
                        case "REMOVE":
                            todos.removeTask(taskMessage.getTask());
                            break;
                        case "RESTORE":
                            continue;
                    }

                    out.println(todos.getAllTasks());

                } catch (IOException e) {
                    System.out.println("Can`t start server");
                    e.printStackTrace();
                }
            }
        }
    }
}
