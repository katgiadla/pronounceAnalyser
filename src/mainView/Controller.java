package mainView;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    private String pathnameInput;
    private String pathnameOutput;

    public void chooseFile(ActionEvent event) {

        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("WAVE File", "*.wav")
        );

        chosenFile = fc.showOpenDialog(null);

        if (chosenFile != null) { FileField.setText(chosenFile.getAbsolutePath()); }
        else { System.out.println("Where is file?"); }
    }

    private static ArrayList<File> createListOfFile(String pathname) throws IOException {
        List<File> contentOfFolder = null;
        ArrayList<File> filesFromFolder = null;

        try {
            contentOfFolder = Files.walk(Paths.get(pathname))
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        filesFromFolder = new ArrayList<File>(contentOfFolder);

        return filesFromFolder;
    }

    private void copyToFile(String pathnameFile, WORD selectedWord) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(pathnameFile);
        FileOutputStream fileOutputStream = new FileOutputStream(
                pathnameInput + "/new.wav");

        int bufferSize;
        byte[] bufffer = new byte[512];
        while ((bufferSize = fileInputStream.read(bufffer)) > 0) {
            fileOutputStream.write(bufffer, 0, bufferSize);
        }
        fileInputStream.close();
        fileOutputStream.close();
    };

    private void chooseWord(WORD word){
        switch (word) {
            case ADER: {
                pathnameInput = "C://Users/Kasia/Music/Engineers thesis/Ader/wavFiles";
                pathnameOutput = "C://Users/Kasia/Pictures/Engineers thesis/Ader/Ader";
                break;
            }
            case ODER: {
                pathnameInput = "C://Users/Kasia/Music/Engineers thesis/oder/wavFiles";
                pathnameOutput = "C://Users/Kasia/Pictures/Engineers thesis/oder/oder";
                break;
            }
            case KIEPE: {
                pathnameInput = "C://Users/Kasia/Music/Engineers thesis/Kiepe/wavFiles";
                pathnameOutput = "C://Users/Kasia/Pictures/Engineers thesis/Kiepe/Kiepe";
                break;
            }
            case KIPPE: {
                pathnameInput = "C://Users/Kasia/Music/Engineers thesis/Kippe/wavFiles";
                pathnameOutput = "C://Users/Kasia/Pictures/Engineers thesis/Kippe/Kippe";
                break;
            }
            case BETEN: {
                pathnameInput = "C://Users/Kasia/Music/Engineers thesis/beten/wavFiles";
                pathnameOutput = "C://Users/Kasia/Pictures/Engineers thesis/beten/beten";
                break;
            }
            case BETTEN: {
                pathnameInput = "C://Users/Kasia/Music/Engineers thesis/betten/wavFiles";
                pathnameOutput = "C://Users/Kasia/Pictures/Engineers thesis/betten/betten";
                break;
            }
            case KÖCHE: {
                pathnameInput = "C://Users/Kasia/Music/Engineers thesis/Köche/wavFiles";
                pathnameOutput = "C://Users/Kasia/Pictures/Engineers thesis/Köche/Köche";
                break;
            }
            case KÜCHE: {
                pathnameInput = "C://Users/Kasia/Music/Engineers thesis/Küche/wavFiles";
                pathnameOutput = "C://Users/Kasia/Pictures/Engineers thesis/Küche/Küche";
                break;
            }
            case SCHERE: {
                pathnameInput = "C://Users/Kasia/Music/Engineers thesis/Schere/wavFiles";
                pathnameOutput = "C://Users/Kasia/Pictures/Engineers thesis/Schere/Schere";
                break;
            }
            case SCHÄRE: {
                pathnameInput = "C://Users/Kasia/Music/Engineers thesis/Schäre/wavFiles";
                pathnameOutput = "C://Users/Kasia/Pictures/Engineers thesis/Schäre/Schäre";
                break;
            }
            case UMIFAHREN: {
                pathnameInput = "C://Users/Kasia/Music/Engineers thesis/umIfahren/wavFiles";
                pathnameOutput = "C://Users/Kasia/Pictures/Engineers thesis/umIfahren/UmIfaren";
                break;
            }
            case UMFAHREN: {
                pathnameInput = "C://Users/Kasia/Music/Engineers thesis/umfahren/wavFiles";
                pathnameOutput = "C://Users/Kasia/Pictures/Engineers thesis/umfahren/umfaren";
                break;
            }
            case RÖSTEN: {
                pathnameInput = "C://Users/Kasia/Music/Engineers thesis/rösten/wavFiles";
                pathnameOutput = "C://Users/Kasia/Pictures/Engineers thesis/rösten/rösten";
                break;
            }
            case RÜSTEN: {
                pathnameOutput = "C://Users/Kasia/Pictures/Engineers thesis/rüsten/rüsten";
                pathnameInput = "\"C://Users/Kasia/Music/Engineers thesis/rüsten/wavFiles";
                break;
            }
            default: {
                break;
            }
        }
    }

    public void startAnalyse(ActionEvent event) throws IOException {

        WORD selectedItem = MenuWord.getSelectionModel().getSelectedItem();
        chooseWord(selectedItem);

        copyToFile(chosenFile.getAbsolutePath(), selectedItem);

        ResultTextArea.setText(pathnameInput);
        //TODO Uruchomienie analizy
    }
}