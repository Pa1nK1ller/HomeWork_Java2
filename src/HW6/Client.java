package HW6;

import com.google.gson.Gson;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.UUID;

public class Client {

    public static void main(String[] args) throws IOException {
        String id = UUID.randomUUID().toString();
        Socket socket = new Socket("localhost", 8081);
        Scanner scanner = new Scanner(System.in);
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        String inputString;
        new Thread(() -> {
            while (true) {
                DataInputStream dataInputStream;
                try {
                    dataInputStream = new DataInputStream(socket.getInputStream());
                    String messageFromServer = dataInputStream.readUTF();
                    System.out.println("Сообщенеи от сервера" + messageFromServer);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();
        do {
            inputString = scanner.nextLine();
            Message message = new Message();
            message.setMessage(inputString);
            message.setClientId(id);
            dataOutputStream.writeUTF(new Gson().toJson(message));
            dataOutputStream.flush();

        } while (!"\\finish".equals(inputString));
        socket.close();
    }

}