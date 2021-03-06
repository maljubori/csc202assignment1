package model;

/**
 * Created by m_al_ on 9/2/2016.
 */
import java.io.*;

public class UserIO {
    public static void writeUsers(Object data) throws IOException {
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("users.dat"));
        output.writeObject(data);
    }
    public static Object readUsers() throws IOException, ClassNotFoundException {
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("users.dat"));
        return input.readObject();
    }
}
