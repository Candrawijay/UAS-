package uappp;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AwalController {

    @FXML
    private Button btnStart;

    @FXML
    void btnStart(ActionEvent event) throws IOException {
FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUp.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage)btnStart.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

}
