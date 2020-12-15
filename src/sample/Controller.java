package sample;

import dating_office_lib.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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


        User checkUser = User.findUser(textField1.getText());
        if ((checkUser != null) && (checkUser.password.equals(textField2.getText()))) {
            label1.setTextFill(Color.GREEN);
            label1.setText("Authorized");
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AccountPage.fxml"));

            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Ваш аккаунт");
            Parent root = (Parent)fxmlLoader.load();
            Scene scene = new Scene(root);

            AccountPage_Controller controller = fxmlLoader.getController();
            controller.initData(checkUser);

            stage.setScene(scene);
            stage.show();
            close();
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

    public void close() {
        Stage stage = (Stage) textField1.getScene().getWindow();
        stage.close();
    }

}