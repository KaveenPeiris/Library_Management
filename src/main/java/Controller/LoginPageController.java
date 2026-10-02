package Controller;

import Controllers.Login.LoginController; // 1. Import LoginController
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginPageController {

    @FXML
    private Button btnClear;

    @FXML
    private Button btnLogin;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUsername;

    // 2. Instantiate the LoginController
    private LoginController loginController = new LoginController();

    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtUsername.clear();
        txtPassword.clear();
    }



    @FXML
    void btnLoginOnAction(ActionEvent event) {
        if (loginController.checkUserNameAndPassword(txtUsername.getText(), txtPassword.getText())) {


            java.net.URL resource = getClass().getResource("/View/Homepage.fxml");


            if (resource == null) {
                System.err.println("Error: /view/Home_Page.fxml සොයාගැනීමට නොහැක! File path එක පරීක්ෂා කරන්න.");
                return;
            }

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            try {
                stage.setScene(new Scene(FXMLLoader.load(resource)));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}