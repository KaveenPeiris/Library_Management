package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class IssueBookController {

    @FXML
    private Button btnBack;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnIssueBook;

    @FXML
    private TableColumn<?, ?> colBookId;

    @FXML
    private TableColumn<?, ?> colDueDate;

    @FXML
    private TableColumn<?, ?> colIssueDate;

    @FXML
    private TableColumn<?, ?> colIssueId;

    @FXML
    private TableColumn<?, ?> colMemberId;

    @FXML
    private DatePicker dpDueDate;

    @FXML
    private DatePicker dpIssueDate;

    @FXML
    private TableView<?> tblIssuedBooks;

    @FXML
    private TextField txtBookId;

    @FXML
    private TextField txtIssueId;

    @FXML
    private TextField txtMemberId;

    @FXML
    void btnBackOnAction(ActionEvent event) {

    }

    @FXML
    void btnClearOnAction(ActionEvent event) {

    }

    @FXML
    void btnIssueBookOnAction(ActionEvent event) {

    }

}
