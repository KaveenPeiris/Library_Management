package Controller;

import Controller.Logic.LoginController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class LoginPageController {

    @FXML private Button btnClear, btnLogin;
    @FXML private PasswordField txtPassword;
    @FXML private TextField txtUsername;

    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtUsername.clear();
        txtPassword.clear();
    }

    @FXML
    void btnLoginOnAction(ActionEvent event) {
        String username = txtUsername.getText();
        String password = txtPassword.getText();

        if (LoginController.checkUserNameAndPassword(username, password)) {
            URL resource = getClass().getResource("/View/Homepage.fxml");

            if (resource == null) {
                System.err.println("Error: FXML file path එක පරීක්ෂා කරන්න!");
                return;
            }

            try {
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(new Scene(FXMLLoader.load(resource)));
                stage.setTitle("Library Management System");
                stage.centerOnScreen();
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            showAlert(Alert.AlertType.ERROR, "Login Failed", "Invalid Username or Password!");
        }
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}