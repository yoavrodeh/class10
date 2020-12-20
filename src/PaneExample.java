
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class PaneExample extends Application {

	@Override
	public void start(Stage stage) {
		Pane root = new Pane();
		Scene scene = new Scene(root);
		stage.setTitle("JavaFX Demo");
		stage.setScene(scene);
		setup(root);
		stage.show();
	}

	private void setup(Pane root) {
		root.setStyle("-fx-background-color: black;");
		root.setPrefSize(200, 200);
		Circle circle = new Circle(50, Color.BLUE);
		circle.relocate(20, 20);
		Rectangle rectangle = new Rectangle(100, 100, Color.RED);
		rectangle.relocate(70, 70);
		root.getChildren().addAll(circle, rectangle);
	}

	public static void main(String[] args) {
		launch(args);
	}
}