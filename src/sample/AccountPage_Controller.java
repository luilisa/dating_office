package sample;

import dating_office_lib.User;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.time.format.DateTimeFormatter;

public class AccountPage_Controller {
    @FXML
    private Label nameSurnameLabel;
    @FXML
    private Label dateOfBirthLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label genderLabel;
    @FXML
    private TextArea reqField;
    @FXML
    private TextArea intField;
    private User user;


    @FXML
    public void initialize() {
    }

    void initData(User user) {
        this.user = user;
        nameSurnameLabel.setText(user.getName());
        dateOfBirthLabel.setText(user.getBirth());
        cityLabel.setText(user.getCity());
        genderLabel.setText(user.getGender());
    }
    public void saveReqInt() throws Exception {
        this.user.updateReqInt(reqField.getText(), intField.getText());
    }
    public void saveInfo() throws Exception {
//        this.user.updateInfo(reqField.getText(), intField.getText());
    }
    public void deleteAcc() throws Exception {
        this.user.delete();
        close();
    }
    public void close() {
        Stage stage = (Stage) intField.getScene().getWindow();
        stage.close();
    }

    public void goToFind() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ListOfClients.fxml"));

        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Список зарегистрированных пользователей");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        stage.setScene(scene);
        stage.show();

        close();
    }
}