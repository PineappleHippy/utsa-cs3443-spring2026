package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Entry point for the Community Events Calendar JavaFX application.
 * Loads the main Calendar scene from Calendar.fxml and displays it.
 *
 * @author John
 */
public class Main extends Application {

   /**
    * Initializes and displays the primary stage with the Calendar scene.
    *
    * @param primaryStage the primary window provided by the JavaFX runtime
    */
   @Override
   public void start(Stage primaryStage) throws Exception {
      Parent root = FXMLLoader.load(getClass().getResource("/application/view/Calendar.fxml"));
      primaryStage.setTitle("Calendar");
      primaryStage.setScene(new Scene(root));
      primaryStage.show();
   }

   /**
    * Launches the JavaFX application.
    *
    * @param args command-line arguments (unused)
    */
   public static void main(String[] args) {
      launch(args);
   }
}
