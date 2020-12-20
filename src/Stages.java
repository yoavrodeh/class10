import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Stages extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		// First window is just a button.
		Button button = new Button("Toggle Other");
		Scene scene = new Scene(button, 200, 200);
		stage.setTitle("JavaFX Demo");
		stage.setScene(scene);
		stage.setX(300);
		stage.setY(300);
		
		stage.show();
		
		// second window:
		Stage s = new Stage();
		s.setScene(new Scene(new StackPane(), 200, 200));		
		s.show();
		
		// button toggles if the other window is showing or not.
		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				if (s.isShowing())
					s.hide();
				else 
					s.show();
			}
		});
	}
}