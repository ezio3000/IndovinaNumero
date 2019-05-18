package it.polito.tdp.numero;
	
import it.polito.tdp.numero.model.NumeroModel;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			//righe aggiunte 
			
			FXMLLoader loader =new FXMLLoader(getClass().getResource("Numero.fxml"));
			//fine righe aggiunte
			//BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Numero.fxml")); //FXMLLoder. ...   restiruisce un valore
			
			BorderPane root = (BorderPane)loader.load(); //sostituendo la classe FXMLLoader con l'oggetto loader
			                                                                                  //in modo da accedere ai vari metodi
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			NumeroModel model =new NumeroModel();
			NumeroController controller = loader.getController();//aggiunta
			controller.setModel(model);//aggiunta
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
