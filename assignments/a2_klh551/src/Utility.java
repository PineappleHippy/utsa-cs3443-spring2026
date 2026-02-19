/**
 * Represents a utility bill calculated from usage, rate, and a base charge.
 *
 * @author JDT|KLH551
 */
public class Utility implements PayableEntity {

   private String name;
   private double usage;
   private double rate;
   private double base;

   public Utility(String name, double rate, double base) {
      this.name = name;
      this.rate = rate;
      this.base = base;
   }

   /**
    * Sets the usage amount for this billing period.
    *
    * @param usage units of usage consumed
    */
   public void setUsage(double usage) {
      this.usage = usage;
   }

   /**
    * Calculates the total bill as usage times rate plus the base charge.
    *
    * @return total amount owed
    */
   @Override
   public double amountOwed() {
      return (usage * rate) + base;
   }

   /**
    * Returns a formatted string with the utility name and bill amount.
    *
    * @return formatted utility info string
    */
   @Override
   public String toString() {
      String utilityInfo = String.format("%-20s $%10.2f", name, amountOwed());
      return utilityInfo;
   }
}
