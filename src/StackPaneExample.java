

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class StackPaneExample extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		StackPane root = new StackPane();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		setup(root);
		stage.show();
	}

	private void setup(StackPane root) {
		Label title = new Label("Here's the title");
		title.setFont(new Font("Cambria", 20));
		StackPane.setAlignment(title, Pos.BOTTOM_CENTER);

		ObservableList<String> names = FXCollections.observableArrayList(
				"Julia", "Ian", "Sue", "Matthew", "Hannah", "Stephan",
				"Denise");
		ListView<String> list = new ListView<String>(names);
		StackPane.setMargin(list, new Insets(8, 8, 30, 8));
		root.getChildren().addAll(list, title);
	}
}