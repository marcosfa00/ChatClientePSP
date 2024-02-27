import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Methods {
    //Conexión con el Servidor
    private final String serverIP = "192.168.64.16";
    private final int Port = 6666;
    private Socket socket;
    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;

    //Constructor
    public Methods() throws IOException {
        this.socket = new Socket(serverIP,Port);
        this.dataOutputStream = new DataOutputStream(socket.getOutputStream());
        this.dataInputStream = new DataInputStream(socket.getInputStream());
    }

    //Pedir datos consola
    Scanner sc = new Scanner(System.in);

    /**
     * Esta función le pide al usuario el nombre d eusuario para poder registrarse
     * @param user
     */
    public void createUser(User user) throws IOException {
        System.out.println("Bienvenido a Marcosfa's CHAT \npor favor introduzca su Username:");
        String username = sc.nextLine();
        user.setUsername(username);
        System.out.println("Bienvenido " + user.getUsername());
        System.out.println("A continuación puedes comenzar a escribir: ");
        String msg ="";
        do {
            msg = sc.nextLine();
            enviarMensaje(user,msg);


        }while (!msg.equals("0"));
    }

    private void enviarMensaje(User user,String msg) throws IOException {
        String mensajeTotal = user.getUsername() + ": " + msg;
        byte[] mensaje = mensajeTotal.getBytes();
        dataOutputStream.writeInt(mensaje.length);
        dataOutputStream.write(mensaje);
    }








}
