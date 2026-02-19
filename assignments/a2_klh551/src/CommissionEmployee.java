/**
 * An employee paid solely by a commission rate on sales.
 *
 * @author JDT|KLH551
 */
public class CommissionEmployee extends Employee {

   private double commissionRate;
   private double sales;

   public CommissionEmployee(String name, double commissionRate) {
      super(name);
      this.commissionRate = commissionRate;
   }

   /**
    * Sets the total sales amount for this pay period.
    *
    * @param sales total sales amount
    */
   public void setSales(double sales) {
      this.sales = sales;
   }

   /**
    * Calculates pay as sales multiplied by the commission rate.
    *
    * @return pre-bonus pay amount
    */
   @Override
   public double calcPreBonusPay() {
      return sales * commissionRate;
   }

   /**
    * Returns the job code for commission employees.
    *
    * @return "COMM"
    */
   @Override
   public String getJobCode() {
      return "COMM";
   }

}
