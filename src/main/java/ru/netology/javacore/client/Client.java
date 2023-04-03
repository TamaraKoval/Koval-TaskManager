package ru.netology.javacore.client;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    static final int PORT = 8989;

    public static void main(String[] args) {
        Gson gson = new Gson();

        //Message message = new Message(Message.MessageType.REMOVE, "Дерево");
        Message message = new Message(Message.MessageType.RESTORE);
        String jsonMessage = gson.toJson(message);

        try (Socket socket = new Socket("localhost", PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            out.println(jsonMessage);
            System.out.println(in.readLine());

        } catch (IOException e) {
            System.out.println("Не могу подключиться к серверу");
            e.printStackTrace();
        }
    }
}
