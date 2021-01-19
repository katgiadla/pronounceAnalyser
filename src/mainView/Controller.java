package mainView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;

public class Controller {

    @FXML
    private MenuButton MenuWord;

    @FXML
    private TextField FileField;

    @FXML
    private Button BrowseFile;

    @FXML
    private TextArea ResultTextArea;

    @FXML
    void initialize() { }

    public void chooseFile(ActionEvent event) {
        FileChooser fc = new FileChooser();
        File chosenFile = fc.showOpenDialog(null);

        if (chosenFile != null) {
            FileField.setText(chosenFile.getAbsolutePath());
        } else {
            System.out.println("Where is file?");
        }
    }
}