package model;

/**
 * Created by m_al_ on 9/2/2016.
 */
import java.util.ArrayList;

public class Userdatabase {
    public static ArrayList<User> users = new ArrayList<User>();
    public static ArrayList<User> getUsers() {
        return users;
    }
    public static void setUsers(ArrayList<User> users) {
        Userdatabase.users = users;
    }
}
