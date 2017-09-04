import java.io.IOException;
import java.io.*;
import java.net.*;

public class Client {

    int port = 8080;
    String adress = "127.0.0.1";

    public static void main(String[] args) {
        Client client = new Client();
    }

    public Client(){
        try{
            Socket socket = new Socket(adress, port);
            System.out.println("Мы подключились!");

            InputStream inStream = socket.getInputStream();
            OutputStream outStream = socket.getOutputStream();

            DataInputStream in = new DataInputStream(inStream);
            DataOutputStream out = new DataOutputStream(outStream);

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Введите имя...");
            System.out.println();
            String line = null;

            while(true){
                line = reader.readLine();
                out.writeUTF(line);
                line = in.readUTF();
                System.out.println("Text"+line);
                System.out.println();
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
