package mainView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;

public class Controller {

    @FXML
    private ComboBox<WORD> MenuWord;

    @FXML
    private TextField FileField;

    @FXML
    private Button BrowseFile;

    @FXML
    private TextArea ResultTextArea;

    @FXML
    void initialize() {
        MenuWord.getItems().setAll(WORD.values());
    }

    private File chosenFile;

    public void chooseFile(ActionEvent event) {

        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("WAVE File", "*.wav")
        );

        chosenFile = fc.showOpenDialog(null);

        if (chosenFile != null) { FileField.setText(chosenFile.getAbsolutePath()); }
        else { System.out.println("Where is file?"); }

        //TODO Wysłanie pliku do analizy
    }

    public void startAnalyse(ActionEvent event) {

        WORD selectedItem = MenuWord.getSelectionModel().getSelectedItem();

        //TODO Wybór odpowiedniego słowa
        //TODO Uruchomienie analizy
    }
}