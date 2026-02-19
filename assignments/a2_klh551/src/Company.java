/**
 * Represents a company with employees and utilities, supporting payroll and expense reporting.
 *
 * @author JDT|KLH551
 */
public class Company {

   private String name;
   private Employee[] employees;
   private Utility[] utilities;
   private int employeeIndex = 0;
   private int utilityIndex = 0;

   public Company(String name, int numEmployees, int numUtilities) {
      this.name = name;
      employees = new Employee[numEmployees];
      utilities = new Utility[numUtilities];
   }

   /**
    * Returns the company's name.
    *
    * @return company name
    */
   public String getName() {
      return name;
   }

   /**
    * Adds an employee to the company's employee list.
    *
    * @param e the employee to add
    */
   public void addEmployee(Employee e) {
      employees[employeeIndex] = e;
      employeeIndex++;

   }

   /**
    * Adds a utility to the company's utility list.
    *
    * @param u the utility to add
    */
   public void addUtility(Utility u) {
      utilities[utilityIndex] = u;
      utilityIndex++;
   }

   /**
    * Builds and returns a formatted payroll listing for all employees.
    *
    * @return payroll listing string
    */
   public String createPayrollListing() {
      String title = String.format("%s Payroll\n", name);
      String columnLabels = String.format("%-15s %s %9s %-9s\n", "Name", "Code", "Pay", "Total Pay");
      String payrollListing = "";
      for (int i = 0; i < employeeIndex; i++) {
         payrollListing += employees[i].toString() + "\n";
      }
      return title + columnLabels + payrollListing;
   }

   /**
    * Builds and returns a formatted listing of all utility bills.
    *
    * @return utility listing string
    */
   public String createUtilityListing() {
      String title = String.format("%s Utilities\n", name);
      String columnLabels = String.format("%-20s %-11s\n", "Name", "Bill Amount");
      String utilityListing = "";
      for (int i = 0; i < utilityIndex; i++) {
         utilityListing += utilities[i].toString() + "\n";
      }
      return title + columnLabels + utilityListing;
   }

   /**
    * Sums the amount owed by each non-null entity in the given array.
    *
    * @param entities array of payable entities to sum
    * @return total expenditures for the array
    */
   private double calcExpenditures(PayableEntity[] entities) {
      double expenditures = 0;
      for (PayableEntity e : entities) {
         if (e == null) continue;
         else expenditures += e.amountOwed();
      }
      return expenditures;
   }

   /**
    * Returns the sum of all employee pay and utility bills.
    *
    * @return total company expenditures
    */
   public double calcTotalExpenditures() {
      return calcExpenditures(employees) + calcExpenditures(utilities);
   }

}
