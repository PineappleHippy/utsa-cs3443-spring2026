package application.controller;

import application.model.CalendarEvent;
import application.model.EventListings;
import application.view.MainView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Controller for the main Calendar scene.
 * Loads calendar events, populates the view, handles sort button actions,
 * and manages switching to the Details scene.
 *
 * @author John
 */
public class MainController {

   @FXML
   private VBox vBox;

   private MainView mainView;
   private Scene mainScene;

   /**
    * Called automatically after the FXML fields are injected.
    * Loads events from the model, creates the DetailsButtonEventHandler and MainView,
    * and triggers the initial display of events.
    */
   @FXML
   public void initialize() {
      try {
         EventListings listings = new EventListings();
         ArrayList<CalendarEvent> events = listings.getEvents();

         DetailsButtonEventHandler handler = new DetailsButtonEventHandler(this);
         mainView = new MainView(vBox, events, handler);
         mainView.displayEvents(events);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   /**
    * Handles a click on the "Sort by date" button.
    * Tells the MainView to sort events by date.
    *
    * @param event the ActionEvent from the button click
    */
   @FXML
   public void sortByDateAction(ActionEvent event) {
      mainView.sortByDate();
   }

   /**
    * Handles a click on the "Sort by name" button.
    * Tells the MainView to sort events by name.
    *
    * @param event the ActionEvent from the button click
    */
   @FXML
   public void sortByNameAction(ActionEvent event) {
      mainView.sortByName();
   }

   /**
    * Handles a click on the "Sort by category" button.
    * Tells the MainView to sort events by category.
    *
    * @param event the ActionEvent from the button click
    */
   @FXML
   public void sortByCategoryAction(ActionEvent event) {
      mainView.sortByCategory();
   }

   /**
    * Switches the stage to the Details scene and passes the selected CalendarEvent
    * to the DetailsController for display.
    *
    * @param calEvent the CalendarEvent whose details should be shown
    */
   public void detailsScene(CalendarEvent calEvent) {
      try {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/Details.fxml"));
         Parent root = loader.load();

         DetailsController detailsController = loader.getController();
         detailsController.setEvent(calEvent);

         Stage stage = (Stage) vBox.getScene().getWindow();
         mainScene = vBox.getScene();
         detailsController.setMainScene(mainScene);
         stage.setScene(new Scene(root));
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   /**
    * Returns the main Calendar scene so the DetailsController can navigate back to it.
    *
    * @return the main Scene
    */
   public Scene getMainScene() {
      return mainScene;
   }
}
