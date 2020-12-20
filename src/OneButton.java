
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class OneButton extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		Scene scene = new Scene(makeVBox());
		stage.setScene(scene);
		stage.show();
	}

	private int i;

	private VBox makeVBox() {
		Label label = new Label("Never Pressed");
		Button button = new Button("Press me!");

		class LabelIncreaser
				implements EventHandler<ActionEvent> {
			@Override
			public void handle(ActionEvent event) {
				i++;
				label.setText("Pressed " + i + " times");
			}
		}

		button.setOnAction(new LabelIncreaser());
		VBox vbox = new VBox(20, button, label);
		vbox.setPrefWidth(200);
		vbox.setAlignment(Pos.CENTER);
		vbox.setPadding(new Insets(20));
		return vbox;
	}
}