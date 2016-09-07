package controller;

/**
 * Created by m_al_ on 9/2/2016.
 */
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Userdatabase;
import sample.SignUpJavaFXView;
import sample.AccountJavaFXView;
import sample.LoginJavaFXView;
import model.User;
import java.io.IOException;


public class LoginController {
    @FXML
    TextField username;
    @FXML
    PasswordField password;
    boolean exist = false;
    public static User loggeduser = new User();

    public LoginController() {
        exist = false;
    }

    public void openSignUpView() throws IOException {
        new SignUpJavaFXView();
    }

    public void authenticate() {
        if (!exist) {
            for (int i = 0; i < Userdatabase.getUsers().size(); i++) {
                if (username.getText().equals(Userdatabase.getUsers().get(i).getUsername())) {
                    System.out.println("Welcome, " + username.getText() + "!");
                    loggeduser = (Userdatabase.getUsers().get(i));
                    exist = true;
                    try {
                        new AccountJavaFXView();
                    } catch (IOException e) {
                        System.err.println("Error opening username database list");
                        e.printStackTrace();
                    }
                }
                else {
                    System.out.println("No user found");
                }
            }
        }
    }
}



