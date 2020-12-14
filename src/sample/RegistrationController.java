package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import dating_office_lib.User;
import java.io.File;
import java.io.FileWriter;
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
        User user = new User(nameField.getText(), surnameField.getText(), emailField.getText(), genderField.getValue(), loginField.getText(), passwordField.getText(), dateOfBirthField.getAccessibleText());
        user.write();
        //        File file =
//                new File("userData");
//        Scanner sc = new Scanner(file);
//        boolean userExists = false;
//        while (sc.hasNextLine()) {
//            userData = sc.nextLine().split(":");
//            User acceptedUser = new User(nameField.getText(), surnameField.getText(), emailField.getText(), genderField.getValue(), loginField.getText(), passwordField.getText(), dateOfBirthField.getText());
//
//            if (user.login.equals(acceptedUser.login)) {
//                Alert alert = new Alert(Alert.AlertType.ERROR);
//                alert.setTitle("Ошибка");
//                alert.setHeaderText("Пользователь с таким логином уже существует");
//                alert.setContentText("Попробуйте другой логин");
//                alert.showAndWait();
//                userExists = true;
//            }
//        }
//
//        if (!userExists) {
//            FileWriter writer = new FileWriter(file, true);
//            writer.write("\n"+user.login + ":" + user.password);
//            label1.setTextFill(Color.GREEN);
//            label1.setText("Регистрация успешно завершена");
//            writer.close();
//
//            Stage stage = new Stage();
//            stage.setTitle("Ваш аккаунт");
//            Parent root = FXMLLoader.load(getClass().getResource("AccountPage.fxml"));
//            Scene scene = new Scene(root);
//            stage.setScene(scene);
//            stage.show();
//        }


    }
    public void close() {
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
    }
}

