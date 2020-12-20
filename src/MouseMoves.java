import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class MouseMoves extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		Scene scene = new Scene(makeRoot(), 300, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private StackPane makeRoot() {
		StackPane root = new StackPane();
		root.setOnMouseMoved(
				new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				double red = e.getSceneX() /
						root.getWidth();
				double green = e.getSceneY() / 
						root.getHeight();		
				Color p = new Color(red,green,0.0,1.0);
				BackgroundFill b = 
					new BackgroundFill(p, null, null);
				root.setBackground(new Background(b));
			}
		});
		return root;
	}
}