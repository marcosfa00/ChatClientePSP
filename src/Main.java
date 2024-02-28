import java.io.IOException;
import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) throws IOException {
        Methods m = new Methods();
        User user = new User();
        System.out.println("A que IP te vas a conectar ?");
        m.setServerIP( Methods.sc.nextLine());
        System.out.println();
        System.out.println("Indica el puerto al que te vas a conectar de la ip: " + m.getServerIP());
        m.setPort(Methods.sc.nextInt());
        m.initComponents();
        m.createUser(user);

    }
}