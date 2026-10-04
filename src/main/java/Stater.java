package Starter; // ඔබේ Package Name එක යොදන්න

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class Stater extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Absolute path එක ලෙස front slash '/' භාවිත කරන්න
        URL resource = getClass().getResource("/View/LoginPage.fxml");

        if (resource == null) {
            System.err.println("Error: FXML file not found at '/View/LoginPage.fxml'. Please check your resources directory!");
            return;
        }

        Parent root = FXMLLoader.load(resource);
        primaryStage.setTitle("Library Management System");
        primaryStage.setScene(new Scene(root));
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}