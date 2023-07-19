package application;
	
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			
			Clockpane clock = new Clockpane();
			
			String timeString = clock.getHour() + ":" + clock.getMinute() + ":" + clock.getSecond();
			
			Label lblCurrentTime = new Label(timeString);
			
			BorderPane pane = new BorderPane();
			
			
			
			pane.setCenter(clock);
						
			pane.setBottom(lblCurrentTime);
			
			BorderPane.setAlignment(lblCurrentTime, Pos.TOP_CENTER);

			Scene scene = new Scene(pane, 500, 500);
			
			primaryStage.setTitle("AminCLock");
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
