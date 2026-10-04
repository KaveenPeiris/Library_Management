package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ReturnBookController {

    @FXML
    private Button btnReturn;

    @FXML
    private DatePicker dpReturnDate;

    @FXML
    private Label lblBorrowedDate;

    @FXML
    private Label lblDueDate;

    @FXML
    private Label lblMemberInfo;

    @FXML
    private TextField txtIssueId;

    @FXML
    void btnReturnOnAction(ActionEvent event) {

    }

}
