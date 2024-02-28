

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Methods {
    //Conexión con el Servidor
    //"192.168.64.16"
    private String serverIP ;
    //6666
    private  int Port ;
    private Socket socket;
    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;

    //Constructor
    public Methods() {

    }

    public void initComponents()throws IOException {
        this.socket = new Socket(serverIP,Port);
        this.dataOutputStream = new DataOutputStream(socket.getOutputStream());
        this.dataInputStream = new DataInputStream(socket.getInputStream());
    }

    public void setServerIP(String ip){
        this.serverIP = ip;
    }
    public String getServerIP() {
        return serverIP;
    }

    public void setPort(int port){
        this.Port = port;
    }

    public int getPort() {
        return Port;
    }



    //Pedir datos consola
    public static Scanner sc = new Scanner(System.in);



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
        String recibido ="";
        do {
            System.out.println("nuevo mensaje:");
            msg = sc.nextLine();
            enviarMensaje(user,msg);

            recibido = recibirMensaje();


        }while (!recibido.equals(" /bye"));
        System.out.println("Lamentamos que te vayas :(  puedes volver cuando quieras :D");
        this.closeConnection();
    }

    private void enviarMensaje(User user,String msg) throws IOException {

        String mensajeTotal = user.getUsername() + ": " + msg;
        byte[] mensaje = mensajeTotal.getBytes();
        dataOutputStream.writeInt(mensaje.length);
        dataOutputStream.write(mensaje);

    }

    public String recibirMensaje()throws IOException{
        int longitudMensaje = dataInputStream.readInt();//Espera a que lelgue un mensage de tipo int
        byte[] mensajeBytes = new byte [longitudMensaje];
        dataInputStream.readFully(mensajeBytes);
        String operacion = new String(mensajeBytes);
        System.out.println("La operacion que nos han enviado es: " + operacion);
        return operacion;

    }

    public void closeConnection() throws IOException {
        dataOutputStream.close();
        dataInputStream.close();
        socket.close();
    }







}

