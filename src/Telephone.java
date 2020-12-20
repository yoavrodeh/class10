import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Telephone extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		Scene scene = new Scene(createRoot());
		stage.setScene(scene);
		stage.show();
	}

	private VBox createRoot() {
		VBox root = new VBox();
		Label label = new Label("Speaker:");
		TextArea textBox = new TextArea();
		GridPane grid = new GridPane();
		root.getChildren().addAll(label, textBox, grid);
		root.setPadding(new Insets(10));

		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++) {
				String t = "" + (1 + i * 3 + j);
				Button b = new Button(t);
				b.setFont(new Font("Arial", 20));
				grid.add(b, i, j);
			}
		return root;
	}
}