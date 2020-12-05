/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extrator_java;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import com.gembox.spreadsheet.*;
import com.sun.prism.impl.Disposer;
import java.io.BufferedReader;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import javafx.event.EventHandler;

/**
 * FXML Controller class
 *@ author YEO KEVIN
 * 
 */
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;

public class ViewController implements Initializable{

   
    private String PATH="";
    
    
    @FXML
    private TextField url;
    
    @FXML
    private Button recherche;
    

    @FXML
    private ComboBox<String> listederoulante;

    @FXML
    private ComboBox<String> id_extra;
    
  static {
        SpreadsheetInfo.setLicense("FREE-LIMITED-KEY");
    }

    @FXML 
    public TableView table;

    public void charger(ActionEvent event) throws IOException {
        
        String uri = PATH+"/output/"+ listederoulante.getSelectionModel().getSelectedItem();
        
        
        System.out.println(uri);
        ExcelFile workbook = ExcelFile.load(uri);
        ExcelWorksheet worksheet = workbook.getWorksheet(0);
        String[][] sourceData = new String[100][26];
        for (int row = 0; row < sourceData.length; row++) {
            for (int column = 0; column < sourceData[row].length; column++) {
                ExcelCell cell = worksheet.getCell(row, column);
                if (cell.getValueType() != CellValueType.NULL)
                    sourceData[row][column] = cell.getValue().toString();
            }
        }
        fillTable(sourceData);
    }
    
    
    @FXML
    void Rafraichir(ActionEvent event) {
        
         listederoulante.setItems(null);
         table.setItems(null);

    }

    
  
    void Rechercher() {
        
       String urlDeREcherche =  url.getText().toString();
       
       String extractor = id_extra.getSelectionModel().getSelectedItem();
        
       
        appelBsh(urlDeREcherche, extractor);
        
        remplirListDeroulante() ;
         
           
    }
    
    
    private void remplirListDeroulante(){
        
        ObservableList<String> listeFichier= FXCollections.observableArrayList(); 
        
        String filepath = PATH+"/output" ;
        
        File outputdir = new File(filepath) ;
        
        File[] filelist =  outputdir.listFiles() ;
        
        
        for (File file : filelist) {
            
            listeFichier.add( file.getName() ) ;
            
        }
        
        
        listederoulante.setItems(listeFichier);
    }

    private void fillTable(String[][] dataSource) {
        table.getColumns().clear();

        ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();
        for (String[] row : dataSource)
            data.add(FXCollections.observableArrayList(row));
        table.setItems(data);

        for (int i = 0; i < dataSource[0].length; i++) {
            final int currentColumn = i;
            TableColumn<ObservableList<String>, String> column = new TableColumn<>(ExcelColumnCollection.columnIndexToName(currentColumn));
            column.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue().get(currentColumn)));
            column.setEditable(true);
            column.setCellFactory(TextFieldTableCell.forTableColumn());
            column.setOnEditCommit(
                    (TableColumn.CellEditEvent<ObservableList<String>, String> t) -> {
                        t.getTableView().getItems().get(t.getTablePosition().getRow()).set(t.getTablePosition().getColumn(), t.getNewValue());
                    });
            table.getColumns().add(column);
        }
    }

    public void sauvegarder(ActionEvent event) throws IOException {
        ExcelFile file = new ExcelFile();
        ExcelWorksheet worksheet = file.addWorksheet("sheet");
        for (int row = 0; row < table.getItems().size(); row++) {
            ObservableList cells = (ObservableList) table.getItems().get(row);
            for (int column = 0; column < cells.size(); column++) {
                if (cells.get(column) != null)
                    worksheet.getCell(row, column).setValue(cells.get(column).toString());
            }
        }

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("XLSX files (*.xlsx)", "*.xlsx"),
                new FileChooser.ExtensionFilter("XLS files (*.xls)", "*.xls"),
                new FileChooser.ExtensionFilter("ODS files (*.ods)", "*.ods"),
                new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv"),
                new FileChooser.ExtensionFilter("HTML files (*.html)", "*.html")
        );
        File saveFile = fileChooser.showSaveDialog(table.getScene().getWindow());

        file.save(saveFile.getAbsolutePath());
    }
    
    
    
    /**
     * appel system
     * @param location
     * @param resources 
     */
    
    public void appelBsh(String url, String extractorType){
    try {
        ProcessBuilder pb;
        String cOutput;
        if (extractorType.equals("python_extrator")){
            pb=new ProcessBuilder(PATH+"/bas.sh");
            Process s = pb.start();
            OutputStream os=s.getOutputStream();
            PrintStream prs=new PrintStream(os);
            prs.println("1");
            prs.flush();
            prs.println(url);
            prs.flush();
            
            BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
            cOutput= br.readLine();
            System.out.println(cOutput);
           
             
        }else if(extractorType.equals("wiki_pedia_extrator")|| extractorType.equals("wiki_extrator")){
            pb=new ProcessBuilder(PATH+"/javabas.sh");
            Process p = pb.start();
            OutputStream os=p.getOutputStream();
            PrintStream ps=new PrintStream(os);
            ps.println(2);
            
            ps.flush();
            
            ps.println(url);
            ps.flush();
              
            ps.println(5);
            ps.flush();
            
            BufferedReader br=new BufferedReader(new InputStreamReader(p.getInputStream()));
            cOutput= br.readLine();
            System.out.println(cOutput);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        PATH = System.getProperty("user.dir");

        //File file=new File(path);

        //PATH=file.getParent();
       
        
        ObservableList<String> list;
        list = FXCollections.observableArrayList("wiki_extrator","wiki_pedia_extrator","python_extrator");
        id_extra.setItems(list);
        
        recherche.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Rechercher() ;

            }
        });
        
    }

   
}

