/**
 * An employee paid a fixed weekly salary.
 *
 * @author JDT|KLH551
 */
public class SalariedEmployee extends Employee {

   private double weeklyPay;

   public SalariedEmployee(String name, double weeklyPay) {
      super(name);
      this.weeklyPay = weeklyPay;
   }

   /**
    * Returns the fixed weekly pay as the pre-bonus pay.
    *
    * @return weekly pay amount
    */
   @Override
   public double calcPreBonusPay() {
      return weeklyPay;
   }

   /**
    * Returns the job code for salaried employees.
    *
    * @return "SLRY"
    */
   @Override
   public String getJobCode() {
      return "SLRY";
   }

}
