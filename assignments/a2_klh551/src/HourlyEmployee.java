/**
 * An employee paid by the hour, with overtime for hours over 40.
 *
 * @author JDT|KLH551
 */
public class HourlyEmployee extends Employee {

   private double hourlyWage;
   private double hoursWorked;

   public HourlyEmployee(String name, double hourlyWage) {
      super(name);
      this.hourlyWage = hourlyWage;
   }

   /**
    * Sets the number of hours worked this pay period.
    *
    * @param hoursWorked hours worked
    */
   public void setHoursWorked(double hoursWorked) {
      this.hoursWorked = hoursWorked;
   }

   /**
    * Calculates pay with 1.5x overtime rate for hours beyond 40.
    *
    * @return pre-bonus pay amount
    */
   @Override
   public double calcPreBonusPay() {
      if (hoursWorked <= 40) return hoursWorked * hourlyWage;
      else return 40 * hourlyWage + (hoursWorked - 40) * hourlyWage * 1.5;
   }

   /**
    * Returns the job code for hourly employees.
    *
    * @return "HRLY"
    */
   @Override
   public String getJobCode() {
      return "HRLY";
   }

}
