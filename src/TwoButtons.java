import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TwoButtons extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		Scene scene = new Scene(makeGridPane());
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private GridPane makeGridPane() {
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10));
		grid.setHgap(10);
		grid.setVgap(10);
		grid.add(makeButton("First Button"), 0, 0);
		grid.add(makeButton("Second Button"), 1, 1);	
		return grid;
	}
	
	private class Mouse1 implements 
			EventHandler<MouseEvent> {
		private String color;
		public Mouse1(String color) {
			this.color = color;
		}
		@Override
		public void handle(MouseEvent e) {
			Button b = (Button) e.getSource();
			b.setStyle("-fx-background-color: " + color);
		}
	}
	
	private Button makeButton(String msg) {
		Button btn = new Button(msg);
		btn.setOnMouseEntered(new Mouse1("yellow"));
		btn.setOnMouseExited(new Mouse1("green"));			
		return btn;
	}	
}