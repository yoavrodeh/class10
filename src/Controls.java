import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Controls extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		FlowPane root = new FlowPane();
		Scene scene = new Scene(root, 500, 500, Color.BLACK);
		stage.setScene(scene);
		setup(root);
		stage.show();
	}

	private void setup(FlowPane root) {
		Button b = new Button("Button");
		Label l = new Label("Label");
		TextField tf = new TextField("Text Field");
		PasswordField pf = new PasswordField();
		CheckBox cb = new CheckBox("Check");
		
		ChoiceBox<String> cb1 = new ChoiceBox<String>(FXCollections.observableArrayList(
			    "First", "Second", "Third")
			);
		
		
		root.setHgap(10);
		root.setVgap(10);
		root.setPadding(new Insets(10));
		root.getChildren().addAll(b, l, tf, pf, cb, cb1);
		
	}

}