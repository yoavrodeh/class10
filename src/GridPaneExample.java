import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
 
public class GridPaneExample extends Application {
   @Override
   public void start(Stage stage) {
       Scene scene = new Scene(createRoot());
       stage.setScene(scene);
       stage.show();
   }
   
   private Parent createRoot() {
	   GridPane gridPane = new GridPane();
	   gridPane.setPadding(new Insets(20));
	   gridPane.setHgap(10);
	   gridPane.setVgap(10);
	   
	   gridPane.add(new Label("Full Name"), 0, 0);
	   gridPane.add(new TextField("your name"), 1, 0);
	   gridPane.add(new Label("Age"), 0, 1);
	   gridPane.add(new TextField(), 1, 1);
	   Button button = new Button("Submit");
	   button.setMaxWidth(Double.MAX_VALUE);
	   gridPane.add(button, 0, 2, 2, 1);
	   
	   ColumnConstraints c = new ColumnConstraints();
	   c.setHalignment(HPos.RIGHT);
	   gridPane.getColumnConstraints().add(c);
	   return gridPane;
   }

public static void main(String[] args) {
       launch(args);
   }
}