package controller;

/**
 * Created by m_al_ on 9/5/2016.
 */
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Userdatabase;
import sample.SignUpJavaFXView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class LoginController {
    @FXML
    TextField username;
    @FXML
    PasswordField password;
    @FXML
    Button button;

    boolean exist;

    public LoginController() {
            exist = false;
    }

    public void authenticate() {
        for (int i = 0; i < Userdatabase.getUsers().size(); i++) {
            if (username.getText().equals(Userdatabase.getUsers().get(i).getUsername())) {
                System.out.println("Welcome, " + username.getText() + "!");
//                try {
//                    new LoginJavaFXView();
//                } catch (IOException e) {
//                    System.err.println("Error Username database list");
//                    e.printStackTrace();
//                }
                exist = true;
            }
        }
    }

    public void openSignupView() throws IOException {
        System.out.println("Open sign up sample");
        new SignUpJavaFXView();
        // close here
    }
}


