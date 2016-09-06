package controller;



/**
 * Created by m_al_ on 9/5/2016.
 */
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import model.User;
import model.Userdatabase;
import model.UserIO;
import sample.SignUpJavaFXView;

import java.io.File;
import java.io.IOException;

/**
 * Created by tkanchanawanchai6403 on 6/29/2016.
 */
public class SignupController {
    @FXML
    TextField username;
    @FXML
    PasswordField password;
    @FXML
    PasswordField confirmpassword;
    @FXML
    Parent root;

    public void createAccount() {
        User u = new User();
        Userdatabase.getUsers().add(u);
        try {
            UserIO.writeUsers(Userdatabase.getUsers());
            System.out.println("New database succesfully created");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage st = (Stage) root.getScene().getWindow();
        st.close();
    }

    public void createFileChooser() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new ExtensionFilter("Text Files", "*.txt"),
                new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
                new ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
                new ExtensionFilter("All Files", "*.*"));
        File selectedFile = fileChooser.showOpenDialog(SignUpJavaFXView.getSignupStage());
        System.out.println(selectedFile.getPath());
        /*   if (selectedFile != null) {
            mainStage.display(selectedFile);
        }*/
    }
}

