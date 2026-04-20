package application.view;

import application.model.CalendarEvent;
import javafx.scene.control.Label;

/**
 * Responsible for updating the Label in the Details scene with
 * the full information of a selected CalendarEvent.
 *
 * @author John
 */
public class DetailsView {

   private Label detailsLabel;

   /**
    * Constructs a DetailsView with the label to update.
    *
    * @param detailsLabel the Label in the Details scene to populate
    */
   public DetailsView(Label detailsLabel) {
      this.detailsLabel = detailsLabel;
   }

   /**
    * Populates the details label with the full event information.
    * Displays date, event name, category, location, admission, and description.
    *
    * @param event the CalendarEvent whose details are to be displayed
    */
   public void displayDetails(CalendarEvent event) {
      String text = "Date: " + event.getMonth() + "/" + event.getDay() + "\n"
            + "Event: "    + event.getName()      + "\n"
            + "Category: " + event.getCategory()  + "\n"
            + "Location: " + event.getLocation()  + "\n"
            + "Admission: "+ event.getAdmission()  + "\n\n"
            + event.getDescription();
      detailsLabel.setText(text);
   }
}
