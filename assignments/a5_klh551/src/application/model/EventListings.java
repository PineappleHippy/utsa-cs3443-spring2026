package application.model;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Reads calendar event data from a CSV file and produces an ArrayList of CalendarEvent objects.
 * Uses getClass().getResource() to locate the file in a portable, file-system-independent way.
 *
 * @author John
 */
public class EventListings {

   private ArrayList<CalendarEvent> events;

   /**
    * Reads all events from events.csv and populates the events list.
    *
    * @throws Exception if the file cannot be found or read
    */
   public EventListings() throws Exception {
      events = new ArrayList<CalendarEvent>();

      URL url = getClass().getResource("events.csv");
      File file = new File(url.toURI());
      Scanner scanner = new Scanner(file);

      while (scanner.hasNextLine()) {
         String line = scanner.nextLine().trim();
         if (line.isEmpty()) continue;

         // Split on comma, but only the first 6 commas (description may contain commas)
         String[] parts = line.split(",", 7);

         String category    = parts[0];
         String name        = parts[1];
         String location    = parts[2];
         int    month       = Integer.parseInt(parts[3]);
         int    day         = Integer.parseInt(parts[4]);
         String admission   = parts[5];
         String description = parts[6];

         events.add(new CalendarEvent(category, name, location, month, day, admission, description));
      }

      scanner.close();
   }

   /**
    * Returns the list of CalendarEvent objects read from the CSV file.
    *
    * @return an ArrayList of CalendarEvent objects
    */
   public ArrayList<CalendarEvent> getEvents() {
      return events;
   }
}
