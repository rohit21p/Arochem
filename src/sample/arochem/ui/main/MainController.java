package sample.arochem.ui.main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;

public class MainController {

    @FXML
    void handleoptionaction(ActionEvent event) {

    }

    @FXML
    void handlereportsaction(ActionEvent event) {
        try {
            URL url = Paths.get("src/sample/arochem/ui/itemwisereport/itemWiseReport.fxml").toUri().toURL();
            Parent root = FXMLLoader.load(url);
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Arochem - Item Wise Report");
            primaryStage.setScene(new Scene(root, 844, 625));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void handlesetupaction(ActionEvent event) {
        try {
            URL url = Paths.get("src/sample/arochem/ui/setupscreen/SetupScreen.fxml").toUri().toURL();
            Parent root = FXMLLoader.load(url);
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Arochem - Setup");
            primaryStage.setScene(new Scene(root, 844, 625));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void handletransactionaction(ActionEvent event) {

    }

}
