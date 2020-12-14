package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;

import javax.swing.text.TableView;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class ListOfClients_Controller implements Initializable {
    @FXML
    private final ObservableList <Client> clientData = FXCollections.observableArrayList();
    @FXML
    private TableView catalogTable;
    @FXML
    private TableColumn<Client, String> clientName;
    @FXML
    private TableColumn <Client, String>  productSurname;
    @FXML
    private TableColumn <Client, Date>  clientDateOfBirth;
    @FXML
    private TableColumn <Client, String>  city;
    @FXML
    private Label clientNameLabel;
    @FXML
    private Label clientSurnameLabel;
    @FXML
    private Label clientDateOfBirthLabel;
    @FXML
    private Label cityLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}