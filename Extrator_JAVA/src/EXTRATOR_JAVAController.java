import com.sun.prism.impl.Disposer.Record;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class EXTRATOR_JAVAController implements Initializable{

    @FXML
    private TextField URL;

    @FXML
    private ComboBox Choix_Extrateur;

    @FXML
    private TableView<?> IdTable;

    @FXML
    private Button IdModifier;

    @FXML
    private Button IdSauvergarde;

    @FXML
    void ChoisirExtrateur(MouseEvent event) {
        
        String s=Choix_Extrateur.getSelectionModel().getSelectedItem().toString();

    }

    @FXML
    void EntrerUrl(MouseEvent event) {

    }

    @FXML
    void Modifier(MouseEvent event) {

    }

    @FXML
    void TableExtrateur(MouseEvent event) {

    }

    @FXML
    void sauvegarder(MouseEvent event) {

    }
    
    @Override
    public void initialize(URL url,ResourceBundle rb){
        ObservableList<String> list;
        list = FXCollections.observableArrayList("wiki_extrator","wiki_pedia_extrator","python_extrator");
        Choix_Extrateur.setItems(list);
        
         TableView<Record> tableView = new TableView<>();

     ObservableList<Record> dataList
            = FXCollections.observableArrayList();
    
    }
    
    
     
}