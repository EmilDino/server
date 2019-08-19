import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(1);

            System.out.println("Serveren kører fint");

            Socket socket = server.accept();

            System.out.println("serveren har modtaget en forbindelse fra: " + socket.getRemoteSocketAddress().toString());

            while(true) {
                DataInputStream in = new DataInputStream
                        (socket.getInputStream());
                DataOutputStream out = new DataOutputStream
                        (socket.getOutputStream());

                double aNumber = in.readDouble();
                System.out.println(aNumber);
                double areal = aNumber * Math.PI * aNumber;
                out.writeDouble(areal);

                if(aNumber == 0.0) { break; }

                /**String aText = in.read();
                System.out.println(aText);
                out.writeChars(aText); */
            }
        } catch (IOException e) {
            System.out.println("Severen er fucked mate");

            e.printStackTrace();
        }
    }
}
