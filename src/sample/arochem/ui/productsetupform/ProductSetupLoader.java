package sample.arochem.ui.productsetupform;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ProductSetupLoader extends Application {

        @Override
        public void start(Stage primaryStage) throws Exception{
            Parent root = FXMLLoader.load(getClass().getResource("ProductSetup.fxml"));
            primaryStage.setTitle("Arochem - Product Setup Form");
            primaryStage.setScene(new Scene(root, 1338, 890));
            primaryStage.show();
        }


        public static void main(String[] args) {
            launch(args);
        }
}
