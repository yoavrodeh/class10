import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class SliderExample extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		Scene scene = new Scene(makeHBox());
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private HBox makeHBox() {
		Slider slider = new Slider(-50, 50, 0);
		slider.setMajorTickUnit(10);
		slider.setShowTickLabels(true);
		slider.setShowTickMarks(true);
		Label label = new Label("   0");
		HBox hbox = new HBox(20, slider, label);
		hbox.setPadding(new Insets(10));

		slider.valueProperty().addListener(
			new ChangeListener<Number>() {
				@Override
				public void changed(
					ObservableValue<? extends Number> o,
					Number oldVal, Number newVal) {
					label.setText(
							"" + newVal.intValue());
				}
			});
		return hbox;
	}
}