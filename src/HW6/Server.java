package HW6;

import com.google.gson.Gson;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8081);

        try (serverSocket) {
            System.out.println("Создали серверный сокет");
            System.out.println("Ожидаем подключение клиента");
            Socket socket = serverSocket.accept();
            System.out.println("Клиент подключился");
            Scanner scanner = new Scanner(System.in);
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            String inputString;
            Message message;

            new Thread(() -> {
                while (true) {
                    String outputString = scanner.nextLine();
                    Message messageServer = new Message();
                    messageServer.setMessage(outputString);
                    try {
                        dataOutputStream.writeUTF(new Gson().toJson(messageServer));
                        dataOutputStream.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

            do {
                inputString = dataInputStream.readUTF();
                message = new Gson().fromJson(inputString, Message.class);
                System.out.println("Echo client Id =" + message.getClientId() + ": ");
                System.out.println(message.getMessage());

            } while (!"\\finish".equals(message.getMessage()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}