import java.io.*;
import java.net.*;

public class Server {
    int port = 8080;

    public static void main(String[] args) {
        Server server = new Server();
    }

    public Server(){
        try{
            ServerSocket serverSocket = new ServerSocket(this.port);

            System.out.println("Ожидание подключения...");

            Socket socket = serverSocket.accept();

            System.out.println("Клиент подключился...");

            InputStream inStream = socket.getInputStream();
            OutputStream outStream = socket.getOutputStream();

            DataInputStream in = new DataInputStream(inStream);
            DataOutputStream out = new DataOutputStream(outStream);

            String line = null;
            while(true){
                line = in.readUTF();
                System.out.println("Получена строка: " + line);
                out.writeUTF(line);
                out.flush();
                System.out.println("Ожидание следующий строки");
                if(line.equals("exit")) break;
            }

            in.close();
            out.close();
            socket.close();

        } catch (IOException ex){
            System.out.println(ex);
        }

    }

}
