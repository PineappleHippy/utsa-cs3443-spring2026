package application.controller;

import application.model.CalendarEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Event handler for the Details buttons in the main Calendar scene.
 * When a Details button is clicked, this handler retrieves the CalendarEvent
 * stored as the button's user data and delegates to MainController to switch scenes.
 *
 * @author John
 */
public class DetailsButtonEventHandler implements EventHandler<ActionEvent> {

   private MainController mainController;

   /**
    * Constructs a DetailsButtonEventHandler tied to the given MainController.
    *
    * @param mainController the MainController to notify when a Details button is clicked
    */
   public DetailsButtonEventHandler(MainController mainController) {
      this.mainController = mainController;
   }

   /**
    * Handles a Details button click by extracting the CalendarEvent from the button's
    * user data and passing it to the MainController's detailsScene method.
    *
    * @param event the ActionEvent fired by the Details button
    */
   @Override
   public void handle(ActionEvent event) {
      javafx.scene.control.Button btn = (javafx.scene.control.Button) event.getSource();
      CalendarEvent calEvent = (CalendarEvent) btn.getUserData();
      mainController.detailsScene(calEvent);
   }
}
