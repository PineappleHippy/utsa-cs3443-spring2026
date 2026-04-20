package application.view;

import application.model.CalendarEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Responsible for populating and sorting the VBox inside the ScrollPane
 * of the main Calendar scene.
 *
 * @author John
 */
public class MainView {

   private VBox vBox;
   private ArrayList<CalendarEvent> events;
   private EventHandler<ActionEvent> detailsHandler;

   /**
    * Constructs a MainView with the VBox to populate, the list of events, and the
    * event handler for Details buttons.
    *
    * @param vBox           the VBox inside the ScrollPane to populate
    * @param events         the list of CalendarEvent objects to display
    * @param detailsHandler the ActionEvent handler for each Details button
    */
   public MainView(VBox vBox, ArrayList<CalendarEvent> events, EventHandler<ActionEvent> detailsHandler) {
      this.vBox           = vBox;
      this.events         = events;
      this.detailsHandler = detailsHandler;
   }

   /**
    * Populates the VBox with one HBox row per CalendarEvent.
    * Each row contains a Details Button (with the CalendarEvent stored as user data)
    * and a Label showing the event's date, category, and name.
    *
    * @param eventList the list of CalendarEvents to display
    */
   public void displayEvents(ArrayList<CalendarEvent> eventList) {
      LinkedList<HBox> rows = new LinkedList<HBox>();

      for (CalendarEvent event : eventList) {
         // Details button
         Button detailsBtn = new Button("Details");
         detailsBtn.setMinWidth(55);
         detailsBtn.setUserData(event);
         detailsBtn.setOnAction(detailsHandler);

         // Brief label: MM/DD Category: Name
         String briefText = event.getMonth() + "/" + event.getDay()
               + " " + event.getCategory() + ": " + event.getName();
         Label briefLabel = new Label(briefText);
         briefLabel.setMinWidth(250);
         briefLabel.setWrapText(true);

         // HBox row
         HBox row = new HBox(5, detailsBtn, briefLabel);
         rows.add(row);
      }

      vBox.getChildren().setAll(rows);
   }

   /**
    * Sorts the events by date (month then day), breaking ties by category then name,
    * and refreshes the display.
    */
   public void sortByDate() {
      Collections.sort(events, new Comparator<CalendarEvent>() {
         public int compare(CalendarEvent a, CalendarEvent b) {
            if (a.getMonth() != b.getMonth()) return a.getMonth() - b.getMonth();
            if (a.getDay()   != b.getDay())   return a.getDay()   - b.getDay();
            int catCmp = a.getCategory().compareTo(b.getCategory());
            if (catCmp != 0) return catCmp;
            return a.getName().compareTo(b.getName());
         }
      });
      displayEvents(events);
   }

   /**
    * Sorts the events by category, breaking ties by date then name,
    * and refreshes the display.
    */
   public void sortByCategory() {
      Collections.sort(events, new Comparator<CalendarEvent>() {
         public int compare(CalendarEvent a, CalendarEvent b) {
            int catCmp = a.getCategory().compareTo(b.getCategory());
            if (catCmp != 0) return catCmp;
            if (a.getMonth() != b.getMonth()) return a.getMonth() - b.getMonth();
            if (a.getDay()   != b.getDay())   return a.getDay()   - b.getDay();
            return a.getName().compareTo(b.getName());
         }
      });
      displayEvents(events);
   }

   /**
    * Sorts the events by name, breaking ties by date then category,
    * and refreshes the display.
    */
   public void sortByName() {
      Collections.sort(events, new Comparator<CalendarEvent>() {
         public int compare(CalendarEvent a, CalendarEvent b) {
            int nameCmp = a.getName().compareTo(b.getName());
            if (nameCmp != 0) return nameCmp;
            if (a.getMonth() != b.getMonth()) return a.getMonth() - b.getMonth();
            if (a.getDay()   != b.getDay())   return a.getDay()   - b.getDay();
            return a.getCategory().compareTo(b.getCategory());
         }
      });
      displayEvents(events);
   }
}
