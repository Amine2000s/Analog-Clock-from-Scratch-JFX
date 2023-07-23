package application;
	
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;


public class Main extends Application {
	Label  lblCurrentTime ; 

	@Override
	public void start(Stage primaryStage) {
		try {
			
			
			Clockpane clock = new Clockpane();
			
			String timeString = clock.getHour() + ":" + clock.getMinute() + ":" + clock.getSecond();
			
			//Label  lblCurrentTime = new Label(timeString);
			
			BorderPane pane = new BorderPane();
			
			EventHandler<ActionEvent> eventHandler = e -> {
				clock.setCurrentTime();
				clock.paintClock();
				
			};
			
			Label  lblCurrentTime = new Label(timeString);
			pane.setBottom(lblCurrentTime);
			
			BorderPane.setAlignment(lblCurrentTime, Pos.TOP_CENTER);
			Timeline animation = new Timeline(new KeyFrame(Duration.millis(1000),eventHandler));
			
			animation.setCycleCount(Timeline.INDEFINITE);
			
			animation.play();
			
			pane.setCenter(clock);
						
			pane.setBottom(lblCurrentTime);
			
			BorderPane.setAlignment(lblCurrentTime, Pos.TOP_CENTER);

			Scene scene = new Scene(pane, 300, 300);
			
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
