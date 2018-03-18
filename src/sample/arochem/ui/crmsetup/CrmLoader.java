package sample.arochem.ui.crmsetup;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class CrmLoader extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("crmsetup.fxml"));
        primaryStage.setTitle("Arochem - CRM Setup");
        primaryStage.setScene(new Scene(root, 844, 625));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
