package application.controller;

import application.model.CalendarEvent;
import application.view.DetailsView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * Controller for the Details scene.
 * Creates the DetailsView and populates the label with event details.
 * Handles the Back button to return to the main Calendar scene.
 *
 * @author John
 */
public class DetailsController {

   @FXML
   private Label detailsLabel;

   @FXML
   private Button backButton;

   private DetailsView detailsView;
   private javafx.scene.Scene mainScene;

   /**
    * Called automatically after FXML fields are injected.
    * Creates the DetailsView and gives it the detailsLabel.
    */
   @FXML
   public void initialize() {
      detailsView = new DetailsView(detailsLabel);
   }

   /**
    * Displays the given event's details in the Details scene.
    *
    * @param event the CalendarEvent to display
    */
   public void setEvent(CalendarEvent event) {
      detailsView.displayDetails(event);
   }

   /**
    * Sets the main scene reference so the Back button can return to it.
    *
    * @param mainScene the main Calendar scene
    */
   public void setMainScene(javafx.scene.Scene mainScene) {
      this.mainScene = mainScene;
   }

   /**
    * Handles a click on the Back button.
    * Switches the stage's scene back to the main Calendar scene.
    *
    * @param event the ActionEvent from the Back button
    */
   @FXML
   public void backAction(ActionEvent event) {
      Stage stage = (Stage) backButton.getScene().getWindow();
      stage.setScene(mainScene);
   }
}
