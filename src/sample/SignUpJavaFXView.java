package sample;

/**
 * Created by m_al_ on 9/2/2016.
 */

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUpJavaFXView {

    public static Stage signupStage = new Stage();
    public SignUpJavaFXView() throws IOException {
        Parent signupView = FXMLLoader.load(getClass().getResource("SignUpJavaFx.fxml"));
        signupStage.setTitle("Signup Page");
        Scene signupScene = new Scene(signupView, 300, 400);
        signupStage.setScene(signupScene);
        signupStage.show();
    }

    public static Stage getSignupStage() {
        return signupStage;
    }
}