package sample.arochem.ui.itemwisereport;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ItemWiseReportLoader extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("itemWiseReport.fxml"));
        primaryStage.setTitle("Arochem - Item Wise Report");
        primaryStage.setScene(new Scene(root, 844, 625));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

