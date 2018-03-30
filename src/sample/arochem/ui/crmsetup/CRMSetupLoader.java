package sample.arochem.ui.crmsetup;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CRMSetupLoader extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("CRMSetup.fxml"));
        primaryStage.setTitle("CRM Setup");
        primaryStage.setScene(new Scene(root, 844, 625));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
