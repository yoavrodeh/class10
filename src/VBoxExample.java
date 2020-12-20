import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VBoxExample extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		Scene scene = new Scene(makeVBox());
		stage.setScene(scene);
		stage.show();
	}
	
	private VBox makeVBox() {
		VBox v = new VBox(5);
		v.setPadding(new Insets(10));
		Button b1 = new Button("One very long button");
		Button b2 = new Button("Button");
		Button b3 = new Button("Medium Button");	
		v.getChildren().addAll(b1, b2, b3);
		return v;
	}
}