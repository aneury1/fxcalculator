package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
		  /*  Value.insert_value(new Value("12"));
			Value.insert_value(new Value("*"));
			Value.insert_value(new Value("12"));
			Value.insert_value(new Value("12"));
		
			Value.calculate();
			
			
			
			
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();*/
			
			
			Parent root = FXMLLoader.load(getClass().getResource("calc.fxml"));
		
			Scene scene = new Scene(root,366.0,509.0);
		    primaryStage.setResizable(false);
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
