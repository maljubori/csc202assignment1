package controller;

/**
 * Created by m_al_ on 9/2/2016.
 */

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.MalformedURLException;


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
    public ImageView imageviewaccount;

    public void initialize() throws MalformedURLException {
        usernamefill.setText(LoginController.loggeduser.getUsername());
        firstnamefill.setText(LoginController.loggeduser.getFirstname());
        lastnamefill.setText(LoginController.loggeduser.getLastname());
        birthdatefill.setText(LoginController.loggeduser.getBirthdate());
        emailfill.setText(LoginController.loggeduser.getEmail());
        phonenumberfill.setText(LoginController.loggeduser.getPhonenumber());
        ssnfill.setText(LoginController.loggeduser.getSocial());
        genderfill.setText(LoginController.loggeduser.getGender());

        // Save profile picture to a value that can be used here, but what?

        //String imagepath = SignupController.picture.toURI().toURL().toString();
        //Image image = new Image(imagepath);
        //imageviewaccount.setImage(image);
    }
}
