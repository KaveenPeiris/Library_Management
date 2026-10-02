package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HomePageController {

    @FXML private Button btnBookManagement;
    @FXML private Button btnLogout;

    @FXML private Label lblTotalBooks;
    @FXML private Label lblTotalMembers;
    @FXML private Label lblBorrowedBooks;
    @FXML private Label lblOverdueBooks;

    @FXML
    void btnBookManagementOnAction(ActionEvent event) {
        navigateTo("/view/BookManagement.fxml", event);
    }

    @FXML
    void btnLogoutOnAction(ActionEvent event) {
        navigateTo("/view/LoginPage.fxml", event);
    }

    private void navigateTo(String fxmlPath, ActionEvent event) {
        try {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource(fxmlPath))));
            stage.show();
        } catch (IOException e) {
            System.err.println("Error loading FXML at: " + fxmlPath);
            e.printStackTrace();
        }
    }
}