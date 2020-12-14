package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import dating_office_lib.User;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.FileWriter;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class RegistrationController {
    String[] userData;
    @FXML
    private TextField loginField;
    @FXML
    private TextField passwordField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField surnameField;
    @FXML
    private TextField emailField;
    @FXML
    private ChoiceBox<String> genderField;
    @FXML
    private DatePicker dateOfBirthField;
    @FXML
    private Label label1;
    @FXML
    private Button close;
    public void registration() throws Exception {
        User user = new User(nameField.getText(), surnameField.getText(), emailField.getText(), genderField.getValue(), loginField.getText(), passwordField.getText(), dateOfBirthField.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        if (user.write()) {
            label1.setTextFill(Color.GREEN);
            label1.setText("Регистрация успешно завершена");
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AccountPage.fxml"));

            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Ваш аккаунт");
            Parent root = (Parent)fxmlLoader.load();
            Scene scene = new Scene(root);

            AccountPage_Controller controller = fxmlLoader.getController();
            controller.initData(user);

            stage.setScene(scene);
            stage.show();
            close();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText("Пользователь с таким логином уже существует");
            alert.setContentText("Попробуйте другой логин");
            alert.showAndWait();
        }

    }
    public void close() {
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
    }
}

