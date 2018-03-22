package sample.arochem.ui.reportscreen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;

public class ReportScreenController {

    @FXML
    void handlecitywisereportaction(ActionEvent event) {
        loadWindow("src/sample/arochem/ui/citywisereport/CityWiseReport.fxml","Arochem - City Wise Report");
    }

    @FXML
    void handleitemwisereportaction(ActionEvent event) {
        loadWindow("src/sample/arochem/ui/itemwisereport/itemWiseReport.fxml","Arochem - Item Wise Report");
    }

    private void loadWindow(String path, String title) {
        try {
            URL url = Paths.get(path).toUri().toURL();
            Parent root = FXMLLoader.load(url);
            Stage primaryStage = new Stage();
            primaryStage.setTitle(title);

            if(title.equals("Arochem - Product Setup Form")) {
                primaryStage.setScene(new Scene(root, 1000, 800));
            }
            else {
                primaryStage.setScene(new Scene(root, 844, 625));
            }
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
