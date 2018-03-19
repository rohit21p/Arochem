package sample.arochem.ui.setupscreen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;

public class SetupScreenController {

    @FXML
    void handlecouriersetupaction(ActionEvent event) {
        loadWindow("src/sample/arochem/ui/couriersetup/CourierSetup.fxml","Arochem - Courier Setup Form");
    }
    @FXML
    void handlecrmsetupaction(ActionEvent event) {
        loadWindow("src/sample/arochem/ui/crmsetup/CRMSetup.fxml","Arochem - CRM Setup Form");
    }

    @FXML
    void loadcustomersetup(ActionEvent event) {
        loadWindow("src/sample/arochem/ui/customersetup/CustomerSetup.fxml","Arochem - Customer Setup Form");
    }

    @FXML
    void loadproductsetup(ActionEvent event) {
        loadWindow("src/sample/arochem/ui/productsetupform/ProductSetup.fxml","Arochem - Product Setup Form");
    }

    @FXML
    void handlesamplesetupaction(ActionEvent event) {
        loadWindow("src/sample/arochem/ui/sampleissue/SampleIssue.fxml","Arochem - Sample Issue");
    }

    private void loadWindow(String path, String title) {
        try {
            URL url = Paths.get(path).toUri().toURL();
            Parent root = FXMLLoader.load(url);
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Arochem - Customer Setup Form");

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
