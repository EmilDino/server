import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1);

            DataInputStream in = new DataInputStream
                    (socket.getInputStream());
            DataOutputStream out = new DataOutputStream
                    (socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            double tal = 0.0;
            String text = "a";

            while (true) {
                System.out.println("Skriv et tal: ");
                tal = scanner.nextDouble();
                /**text = scanner.next(); */

                // Send tallet til serveren
                out.writeDouble(tal);
                System.out.println("Areal der kommer tilbage fra sereveren: " + in.readDouble());

                if(tal == 0.0) { break; }

                /** out.writeChars(text);
                System.out.println("text der kommer tilbage: ");

                if(text == "b") {break; } */
            }

        }catch (IOException e) {
            System.out.println("Clienten er fucked mate");
            e.printStackTrace();
        }
    }
}
