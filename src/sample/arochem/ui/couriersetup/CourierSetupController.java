package sample.arochem.ui.couriersetup;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.event.ActionEvent;

public class CourierSetupController {

    @FXML
    private JFXTextField nametf;

    @FXML
    private JFXTextField contacttf;

    @FXML
    private JFXTextField Addresstf;

    @FXML
    private JFXButton submitbtn;

    @FXML
    private JFXComboBox<?> pincodecb;

    @FXML
    private JFXComboBox<?> citycb;

    @FXML
    private JFXComboBox<?> statecb;

    @FXML
    private JFXComboBox<?> categorycb;

    @FXML
    private JFXTextField searchcb;

    @FXML
    private JFXButton searchbtn;

    @FXML
    private JFXButton closebtn;

    @FXML
    private TableView<?> tableview;

    @FXML
    private TableColumn<?, ?> namecol;

    @FXML
    private TableColumn<?, ?> citycol;

    @FXML
    private TableColumn<?, ?> contactcol;

    @FXML
    private TableColumn<?, ?> addresscol;

    @FXML
    private TableColumn<?, ?> docketcol;

    @FXML
    void handlecloseaction(ActionEvent event) {

    }

    @FXML
    void handlesearchaction(ActionEvent event) {

    }

    @FXML
    void handlesubmitaction(ActionEvent event) {

    }

}
