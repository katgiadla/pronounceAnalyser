package mainView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.Arrays;

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
        //TODO Uruchomienie analizy
    }
}