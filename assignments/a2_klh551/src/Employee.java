/**
 * Abstract base class representing a company employee.
 *
 * @author JDT|KLH551
 */
public abstract class Employee implements PayableEntity {
   private static int numEmployees = 0;
   private String name;
   private double bonus;

   public Employee(String name) {
      this.name = name;
      numEmployees++;
   }

   /**
    * Calculates the employee's pay before any bonus is applied.
    *
    * @return pre-bonus pay amount
    */
   public abstract double calcPreBonusPay();

   /**
    * Returns the job classification code for this employee type.
    *
    * @return job code string
    */
   public abstract String getJobCode();

   /**
    * Returns the total number of Employee instances created.
    *
    * @return total employee count
    */
   public static int getNumEmployees() {
      return numEmployees;
   }

   /**
    * Calculates total pay by adding the bonus to the pre-bonus pay.
    *
    * @return total pay amount
    */
   public double calcTotalPay() {
      double totalPay = calcPreBonusPay() + bonus;
      return totalPay;
   }

   /**
    * Returns the total amount owed to this employee.
    *
    * @return total pay amount
    */
   @Override
   public double amountOwed() {
      return calcTotalPay();
   }

   /**
    * Returns the employee's name.
    *
    * @return employee name
    */
   public String getName() {
      return name;
   }

   /**
    * Returns the employee's bonus amount.
    *
    * @return bonus amount
    */
   public double getBonus() {
      return bonus;
   }

   /**
    * Sets the employee's bonus amount.
    *
    * @param bonus the bonus value to assign
    */
   public void setBonus(double bonus) {
      this.bonus = bonus;
   }

   @Override
   /**
    * Returns a formatted string with the employee's name, job code, and pay details.
    *
    * @return formatted employee info string
    */
   public String toString() {
      String employeeInfo = String.format("%-15s %s $%8.2f $%8.2f",getName(), getJobCode(),calcPreBonusPay(),calcTotalPay());
      return employeeInfo;
   }
}