package sample.arochem.ui.couriersetup;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CourierSetupLoader extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("CourierSetup.fxml"));
        primaryStage.setTitle("Arochem - Courier Setup Form");
        primaryStage.setScene(new Scene(root, 844, 625));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
