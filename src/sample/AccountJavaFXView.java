package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


/**
 * Created by m_al_ on 9/2/2016.
 */
public class AccountJavaFXView {


    public static Stage loggedStage = new Stage();

    public AccountJavaFXView() throws IOException {
        Parent loggedView = FXMLLoader.load(getClass().getResource("AccountJavaFx.fxml"));
        loggedStage.setTitle("My Account");
        Scene loggedScene = new Scene(loggedView, 300, 275);
        loggedStage.setScene(loggedScene);
        loggedStage.show();

    }

    public Stage getLoggedStage() {
        return loggedStage;
    }
}
