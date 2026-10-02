package Controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

//test

public class BookManagementController extends HomePageController implements Initializable {

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnDashboard;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnLogout;

    @FXML
    private Button btnUpdate;

    @FXML
    private TableColumn<String[], String> colAuthor;

    @FXML
    private TableColumn<String[], String> colCategory;

    @FXML
    private TableColumn<String[], String> colId;

    @FXML
    private TableColumn<String[], String> colQty;

    @FXML
    private TableColumn<String[], String> colTitle;

    @FXML
    private TableView<String[]> tblBooks;

    @FXML
    private TextField txtAuthor;

    @FXML
    private TextField txtCategory;

    @FXML
    private TextField txtBookId;

    @FXML
    private TextField txtQty;

    @FXML
    private TextField txtTitle;

    // String Array list for table data: [0]=ID, [1]=Title, [2]=Author, [3]=Category, [4]=Qty
    private final ObservableList<String[]> bookList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Table Columns Mapping (Index wise)
        colId.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()[0]));
        colTitle.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()[1]));
        colAuthor.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()[2]));
        colCategory.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()[3]));
        colQty.setCellValueFactory(data -> new SimpleStringProperty(data.getValue()[4]));

        // Bind list to table
        tblBooks.setItems(bookList);

        // Select row action
        tblBooks.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                txtBookId.setText(newVal[0]);
                txtTitle.setText(newVal[1]);
                txtAuthor.setText(newVal[2]);
                txtCategory.setText(newVal[3]);
                txtQty.setText(newVal[4]);
            }
        });
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        if (!validateInputs()) return;

        String id = txtBookId.getText().trim();

        // Check Duplicate ID
        for (String[] row : bookList) {
            if (row[0].equalsIgnoreCase(id)) {
                showAlert(Alert.AlertType.ERROR, "Duplicate Error", "A book with ID '" + id + "' already exists.");
                return;
            }
        }

        try {
            int qty = Integer.parseInt(txtQty.getText().trim());
            String[] newRow = new String[]{
                    id,
                    txtTitle.getText().trim(),
                    txtAuthor.getText().trim(),
                    txtCategory.getText().trim(),
                    String.valueOf(qty)
            };

            bookList.add(newRow);
            clearFields();
            showAlert(Alert.AlertType.INFORMATION, "Success", "Book added successfully!");
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Validation Error", "Quantity must be a valid number.");
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        int selectedIndex = tblBooks.getSelectionModel().getSelectedIndex();
        if (selectedIndex < 0) {
            showAlert(Alert.AlertType.WARNING, "Selection Error", "Please select a book from the table to update.");
            return;
        }

        if (!validateInputs()) return;

        try {
            int qty = Integer.parseInt(txtQty.getText().trim());
            String[] updatedRow = new String[]{
                    txtBookId.getText().trim(),
                    txtTitle.getText().trim(),
                    txtAuthor.getText().trim(),
                    txtCategory.getText().trim(),
                    String.valueOf(qty)
            };

            bookList.set(selectedIndex, updatedRow);
            tblBooks.refresh(); // Table එක Update වූ බව පෙන්වීමට refresh කිරීම
            clearFields();
            showAlert(Alert.AlertType.INFORMATION, "Success", "Book updated successfully!");
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Validation Error", "Quantity must be a valid number.");
        }
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String[] selectedBook = tblBooks.getSelectionModel().getSelectedItem();
        if (selectedBook == null) {
            showAlert(Alert.AlertType.WARNING, "Selection Error", "Please select a book from the table to delete.");
            return;
        }

        bookList.remove(selectedBook);
        clearFields();
        showAlert(Alert.AlertType.INFORMATION, "Success", "Book deleted successfully!");
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();
    }

    @FXML
    void btnDashboardOnAction(ActionEvent event) {
        // Navigation for Dashboard
    }

    @FXML
    void btnLogoutOnAction(ActionEvent event) {
        // Logout action
    }

    private void clearFields() {
        txtBookId.clear();
        txtTitle.clear();
        txtAuthor.clear();
        txtCategory.clear();
        txtQty.clear();
        tblBooks.getSelectionModel().clearSelection();
    }

    private boolean validateInputs() {
        if (txtBookId.getText().isBlank() || txtTitle.getText().isBlank() ||
                txtAuthor.getText().isBlank() || txtCategory.getText().isBlank() ||
                txtQty.getText().isBlank()) {
            showAlert(Alert.AlertType.ERROR, "Validation Error", "All fields are required.");
            return false;
        }
        return true;
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}