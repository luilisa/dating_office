package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

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
    @FXML private ImageView img;


    @FXML
    public void initialize() {
        GridPane grid = new GridPane();
        grid.getStyleClass().add("grid");
    }

    void initData(User user) {
        this.user = user;
        nameSurnameLabel.setText(user.getName());
        dateOfBirthLabel.setText(user.getBirth());
        cityLabel.setText(user.getCity());
        genderLabel.setText(user.getGender());
        reqField.setText(user.requirments);
        intField.setText(user.intelligence);
        Image image = new Image(user.img);
        img.setImage(image);
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

    public void changeImg() throws Exception {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG & GIF Images", "jpg", "gif");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to open this file: " +
                    chooser.getSelectedFile().getName());
        }
        System.out.println("file:///" + chooser.getSelectedFile().getAbsolutePath());
        Image image = new Image("file:///" + chooser.getSelectedFile().getAbsolutePath());
        img.setImage(image);
        this.user.updatePic("file:///" + chooser.getSelectedFile().getAbsolutePath());
    }

    public void goToFind() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("ListOfClients.fxml"));

        Stage stage = new Stage(StageStyle.DECORATED);
        stage.setTitle("Список зарегистрированных пользователей");
        stage.setUserData(this.user);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        stage.getIcons().add(new Image("file:///" + "C:\\Users\\User\\IdeaProjects\\Курсовая\\dating_office\\heart.png"));
        stage.setScene(scene);
        stage.show();

        close();
    }
}