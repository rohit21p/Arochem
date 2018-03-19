package sample.arochem.ui.reportscreen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ReportScreenLoader extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("ReportScreen.fxml"));
        primaryStage.setTitle("Arochem - Reports");
        primaryStage.setScene(new Scene(root, 844, 750));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
