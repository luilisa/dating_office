package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

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
    private Label label1;
    @FXML private ImageView imgPic;

    @FXML
    public void initialize() throws Exception {
        AnchorPane anchorpane = new AnchorPane();
        anchorpane.getStyleClass().add("pane");
        initData();
    }
    @FXML
    public void clickItem(MouseEvent event) throws FileNotFoundException {
        if (event.getClickCount() == 2) //Checking double click
        {
            System.out.println(catalogTable.getSelectionModel().getSelectedItem().getName());
            clientNameLabel.setText(catalogTable.getSelectionModel().getSelectedItem().getName());
            User tmpuser = User.getUserByNameSurname(catalogTable.getSelectionModel().getSelectedItem().getName(), catalogTable.getSelectionModel().getSelectedItem().getSurname());
            reqField.setText(tmpuser.requirments);
            intField.setText(tmpuser.intelligence);
            Image image = new Image(tmpuser.img);
            imgPic.setImage(image);
            label1.setText("");
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

    public void setMeeting() throws IOException {
        Stage stage = (Stage) clientNameLabel.getScene().getWindow();
        User u = (User) stage.getUserData();
        File file =
                new File("Dates.txt");
        label1.setTextFill(Color.GREEN);
        label1.setText("Date is set");
        FileWriter writer = new FileWriter(file, true);
        writer.write(u.getName() + "+" + catalogTable.getSelectionModel().getSelectedItem().getName() + "\n");
        writer.close();
    }

    public void backToAcc() throws IOException {
        Stage thisStage = (Stage) clientNameLabel.getScene().getWindow();
        User u = (User) thisStage.getUserData();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AccountPage.fxml"));

        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Ваш аккаунт");
        Parent root = (Parent)fxmlLoader.load();
        Scene scene = new Scene(root);

        AccountPage_Controller controller = fxmlLoader.getController();
        controller.initData(u);
        stage.getIcons().add(new Image("file:///" + "C:\\Users\\User\\IdeaProjects\\Курсовая\\dating_office\\heart.png"));
        stage.setScene(scene);
        stage.show();
        close();
    }

    public void close() {
        Stage stage = (Stage) reqField.getScene().getWindow();
        stage.close();
    }

}