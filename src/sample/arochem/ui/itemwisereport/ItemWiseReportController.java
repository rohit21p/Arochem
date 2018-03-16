package sample.arochem.ui.itemwisereport;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

public class ItemWiseReportController {

    @FXML
    private TableColumn<?, ?> date;

    @FXML
    private TableColumn<?, ?> refNo;

    @FXML
    private TableColumn<?, ?> custName;

    @FXML
    private TableColumn<?, ?> city;

    @FXML
    private TableColumn<?, ?> subName;

    @FXML
    private TableColumn<?, ?> quantity;

    @FXML
    private TableColumn<?, ?> rate;

    @FXML
    private JFXComboBox<?> selectItemName;

    @FXML
    private JFXButton showReport;

    @FXML
    private JFXButton close;

    @FXML
    private JFXTextField itemName;

}
