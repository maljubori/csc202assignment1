package controller;

/**
 * Created by m_al_ on 9/2/2016.
 */

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.io.IOException;

import javafx.stage.Stage;
import model.User;
import sample.AccountJavaFXView;
import controller.LoginController;

public class AccountController {

    @FXML
    public Label usernamefill;
    public Label firstnamefill;
    public Label lastnamefill;
    public Label birthdatefill;
    public Label emailfill;
    public Label phonenumberfill;
    public Label ssnfill;
    public Label genderfill;

    public void initialize() {
        usernamefill.setText(LoginController.loggeduser.getUsername());
        firstnamefill.setText(LoginController.loggeduser.getFirstname());
        lastnamefill.setText(LoginController.loggeduser.getLastname());
        birthdatefill.setText(LoginController.loggeduser.getBirthdate());
        emailfill.setText(LoginController.loggeduser.getEmail());
        phonenumberfill.setText(LoginController.loggeduser.getPhonenumber());
        ssnfill.setText(LoginController.loggeduser.getSocial());
        genderfill.setText(LoginController.loggeduser.getGender());
    }




    public AccountController() throws IOException {
    }
}
