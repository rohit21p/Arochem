package sample.arochem.ui.citywisereport;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class CityWiseLoader extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("CityWiseReport.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setTitle("Arochem - City Wise Report");
        primaryStage.setScene(new Scene(root, 844, 625));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
