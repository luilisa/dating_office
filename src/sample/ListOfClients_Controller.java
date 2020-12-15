package sample;

import dating_office_lib.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class ListOfClients_Controller {
//    @FXML
//    private final ObservableList <Client> clientData = FXCollections.observableArrayList();
    @FXML
    private TableView<User> catalogTable;
    @FXML
    private TableColumn<User, String> clientName;
    @FXML
    private TableColumn <User, String>  productSurname;
    @FXML
    private TableColumn <User, String>  clientDateOfBirth;
    @FXML
    private TableColumn <User, String>  city;
    @FXML
    private TableColumn <User, String>  gender;
    @FXML
    private Label clientNameLabel;
    @FXML
    private Label reqField;
    @FXML
    private Label intField;
    @FXML
    private Label cityLabel;

    @FXML
    public void initialize() throws Exception {
        initData();
    }
    @FXML
    public void clickItem(MouseEvent event)
    {
        if (event.getClickCount() == 2) //Checking double click
        {
            System.out.println(catalogTable.getSelectionModel().getSelectedItem().getName());
            clientNameLabel.setText(catalogTable.getSelectionModel().getSelectedItem().getName());
            reqField.setText(catalogTable.getSelectionModel().getSelectedItem().requirments);
            intField.setText(catalogTable.getSelectionModel().getSelectedItem().intelligence);
        }
    }

    void initData() throws Exception {
        clientName.setCellValueFactory(new PropertyValueFactory<User, String>("name"));
        productSurname.setCellValueFactory(new PropertyValueFactory<User, String>("surname"));
        clientDateOfBirth.setCellValueFactory(new PropertyValueFactory<User, String>("birth"));
        city.setCellValueFactory(new PropertyValueFactory<User, String>("city"));
        gender.setCellValueFactory(new PropertyValueFactory<User, String>("gender"));
        catalogTable.setItems(User.getUserData());
    }

}