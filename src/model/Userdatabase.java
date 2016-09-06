package model;

/**
 * Created by m_al_ on 9/5/2016.
 */
import java.util.ArrayList;

public class Userdatabase {

    //
//    private static ArrayQueue<User> users = new ArrayQueue<User>();
    private static ArrayList<User> users = new ArrayList<User>();

    public static ArrayList<User> getUsers() {
        return users;
    }


    public static void setUsers(ArrayList<User> users) {
        Userdatabase.users = users;
    }
}
