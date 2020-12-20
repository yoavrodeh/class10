
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class OneLabel extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		StackPane root = new StackPane(makeLabel());
		Scene scene = new Scene(root);
		stage.setScene(scene);
		root.setPadding(new Insets(40));
		stage.show();
	}

	private Node makeLabel() {
		Label label = new Label(" My Neighbour Totoro ");
		Image image = new Image("file:resources/totoro.jpg");
		label.setGraphic(new ImageView(image));
		label.setFont(new Font("Cambria", 50));

		BackgroundFill bgFill = new BackgroundFill(
				Color.PINK, new CornerRadii(10), null);
		Background bg = new Background(bgFill);
		label.setPadding(new Insets(50, 10, 20, 10));
		label.setBackground(bg);

		return label;
	}

}