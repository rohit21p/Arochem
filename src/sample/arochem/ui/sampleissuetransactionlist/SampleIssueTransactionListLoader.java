package sample.arochem.ui.sampleissuetransactionlist;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SampleIssueTransactionListLoader extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sampleIssueTransactionList.fxml"));
        primaryStage.setTitle("Arochem - Sample Issue Transaction List");
        primaryStage.setScene(new Scene(root, 775, 530));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
