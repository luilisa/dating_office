package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.util.Scanner;

public class Controller {

    String[] userData;
    @FXML
    private TextField textField1;
    @FXML
    private TextField textField2;
    @FXML
    private Label label1;
    public void handleButtonAction() throws Exception {
        User user = new User(textField1.getText(), textField2.getText());
        File file =
                new File("userData");
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine())
            userData = sc.nextLine().split(":");
        User acceptedUser = new User(userData[0],userData[1]);

        if ((user.login.equals(acceptedUser.login)) && (user.password.equals(acceptedUser.password))) {
            label1.setTextFill(Color.GREEN);
            label1.setText("Authorized");
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка");
            alert.setHeaderText("Неверный логин или пароль");
            alert.setContentText("Проверьте корректность введённых данных");
            alert.showAndWait();
        }
    }
    public void toRegistrationButton() throws Exception {
        Stage stage = new Stage();
        stage.setTitle("Регистрация");
        Parent root = FXMLLoader.load(getClass().getResource("Registration.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void cancelButton() {
        textField1.setText("");
        textField2.setText(" ");
    }
}