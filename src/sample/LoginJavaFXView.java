package sample;
/**
 * Created by m_al_ on 9/2/2016.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.User;
import model.Userdatabase;
import model.UserIO;
import java.io.IOException;
import java.util.ArrayList;

public class LoginJavaFXView extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        loaduserdatabase();
        Parent loginView = FXMLLoader.load(getClass().getResource("LoginJavaFX.fxml"));
        primaryStage.setTitle("Login Page");
        primaryStage.setScene(new Scene(loginView, 300, 275));
        primaryStage.show();
    }

    public void loaduserdatabase() {
        try {
            Userdatabase.setUsers((ArrayList<User>) UserIO.readUsers());
        }
        catch (IOException e) {
            System.err.print("Failed to read/open user databases");
        }
        catch (ClassNotFoundException e) {
            System.err.print(e.toString());
        }
    }


    public static void main(String[] args) { launch(args); }

}


