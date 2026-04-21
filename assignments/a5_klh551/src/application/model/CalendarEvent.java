package application.model;

/**
 * Represents a single community calendar event with all its associated details.
 * Instances are created by EventListings when reading from the CSV data file.
 *
 * @author John
 */
public class CalendarEvent {

   private String category, name, location;
   private int month, day;
   private String admission, description;

   /**
    * Constructs a CalendarEvent with all event details.
    *
    * @param category    the event category (e.g. Music, Comedy)
    * @param name        the event name
    * @param location    the venue or location
    * @param month       the month number of the event
    * @param day         the day of the month of the event
    * @param admission   the admission price or price range
    * @param description a detailed description of the event
    */
   public CalendarEvent(String category, String name, String location,
                        int month, int day, String admission, String description) {
      this.category    = category;
      this.name        = name;
      this.location    = location;
      this.month       = month;
      this.day         = day;
      this.admission   = admission;
      this.description = description;
   }

   /**
    * Returns the event category.
    * @return the category string
    */
   public String getCategory() { return category; }

   /**
    * Returns the event name.
    * @return the name string
    */
   public String getName() { return name; }

   /**
    * Returns the event location.
    * @return the location string
    */
   public String getLocation() { return location; }

   /**
    * Returns the month number of the event.
    * @return the month as an int
    */
   public int getMonth() { return month; }

   /**
    * Returns the day of the month of the event.
    * @return the day as an int
    */
   public int getDay() { return day; }

   /**
    * Returns the admission price or range.
    * @return the admission string
    */
   public String getAdmission() { return admission; }

   /**
    * Returns the detailed description of the event.
    * @return the description string
    */
   public String getDescription() { return description; }
}
