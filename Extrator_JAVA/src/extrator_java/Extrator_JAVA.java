/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extrator_java;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 *
 */
public class Extrator_JAVA extends Application {
    private Stage stagePrincipal;
    @Override
    public void start(Stage primaryStage) {
     /*   Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();*/
                stagePrincipal = primaryStage;
		//Ca ne vous rappelle pas une JFrame ?
		stagePrincipal.setTitle("EXTRATOR_JAVA");
		
		//Nous allons utiliser nos fichier FXML dans ces deux méthodes
		initialisationConteneurPrincipal();
		
     
    }
    
    private void initialisationConteneurPrincipal() {
		//On créé un chargeur de FXML
		FXMLLoader loader = new FXMLLoader();
		//On lui spécifie le chemin relatif à notre classe
		//du fichier FXML a charger : dans le sous-dossier view
		loader.setLocation(Extrator_JAVA.class.getResource("view.fxml"));
		try {
			//Le chargement nous donne notre conteneur
			AnchorPane conteneurPrincipal = (AnchorPane) loader.load();
			//On définit une scène principale avec notre conteneur
			Scene scene = new Scene(conteneurPrincipal);
			//Que nous affectons à notre Stage
			stagePrincipal.setScene(scene);
			//Pour l'afficher
			stagePrincipal.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
