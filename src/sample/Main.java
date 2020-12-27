package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("StartPage.fxml"));
        primaryStage.getIcons().add(new Image("file:///" + "C:\\Users\\User\\IdeaProjects\\Курсовая\\dating_office\\heart.png"));
        primaryStage.setTitle("Доброго времени суток!");
        primaryStage.setScene(new Scene(root, 410, 315));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
