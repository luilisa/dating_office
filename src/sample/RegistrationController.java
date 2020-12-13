package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

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
    private Label label1;
    @FXML
    private Button close;
    public void registration() throws Exception {
        User user = new User(loginField.getText(), passwordField.getText());
        File file =
                new File("userData");
        Scanner sc = new Scanner(file);
        boolean userExists = false;
        while (sc.hasNextLine()) {
            userData = sc.nextLine().split(":");
            User acceptedUser = new User(userData[0],userData[1]);

            if (user.login.equals(acceptedUser.login)) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Ошибка");
                alert.setHeaderText("Пользователь с таким логином уже существует");
                alert.setContentText("Попробуйте другой логин");
                alert.showAndWait();
                userExists = true;
            }
        }

        if (!userExists) {
            FileWriter writer = new FileWriter(file, true);
            writer.write("\n"+user.login + ":" + user.password);
            label1.setTextFill(Color.GREEN);
            label1.setText("Регистрация успешно завершена");
            writer.close();

            Stage stage = new Stage();
            stage.setTitle("Ваш аккаунт");
            Parent root = FXMLLoader.load(getClass().getResource("AccountPage.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }


    }
    public void close() {
        Stage stage = (Stage) close.getScene().getWindow();
        stage.close();
    }
}

