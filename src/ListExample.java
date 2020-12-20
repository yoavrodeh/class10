import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListExample extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		Scene scene = new Scene(makeVBox());
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private VBox makeVBox() {
		ListView<String> lview = new ListView<>();
		ObservableList<String> items = lview.getItems();
		items.addAll("Orange Juice", "Coffee", 
				"Scrambled Tofu", "Hummus", "Pita");
		
		lview.getSelectionModel().selectedItemProperty().
			addListener(new ChangeListener<String>() {
				@Override
				public void changed(
					ObservableValue<? extends String> o,
					String oldValue, String newValue) {
						System.out.println(newValue);
					}
				});
		
		Button b = new Button("Press");
		b.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				items.add("Lentil Soup");
			}
		});
		return new VBox(lview, b);
	}
}