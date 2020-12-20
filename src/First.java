import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class First extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		StackPane root = new StackPane();
		Scene scene = new Scene(root, 
				300, 200, Color.CRIMSON);
		stage.setTitle("JavaFX Demo");
		stage.setScene(scene);
		stage.show();
	}
}