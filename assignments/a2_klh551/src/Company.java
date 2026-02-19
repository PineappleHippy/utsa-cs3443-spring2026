public class Company {

	private String name;
	private Employee[] employees;
	private Utility[] utilities;
	private int employeeIndex = 0;
	private int utilityIndex = 0;

   public Company(String name, int numEmployees, int numUtilities) {
		// TODO Company constructor
      this.name = name;
      employees = new Employee[numEmployees];
      utilities = new Utility[numUtilities];
	}

	public String getName() {
		// TODO getName
		return name;
	}

	public void addEmployee(Employee e) {
		// TODO addEmployee
      employees[employeeIndex] = e;
      employeeIndex++;

	}

	public void addUtility(Utility u) {
		// TODO addUtility
      utilities[utilityIndex] = u;
      utilityIndex++;
	}

	public String createPayrollListing() {
		// TODO createPayrollListing
      String title = String.format("%s Payroll\n", name);
      String columnLabels = String.format("%-15s %s %9s %-9s\n", "Name", "Code", "Pay", "Total Pay");
      String payrollListing = "";
      for (int i = 0; i < employeeIndex; i++) {
         payrollListing += employees[i].toString() + "\n";
      }
		return title + columnLabels + payrollListing;
	}

	public String createUtilityListing() {
		// TODO createUtilityListing
      String title = String.format("%s Utilities\n", name);
      String columnLabels = String.format("%-20s %-11s\n", "Name", "Bill Amount");
      String utilityListing = "";
      for (int i = 0; i < utilityIndex; i++) {
         utilityListing += utilities[i].toString() + "\n";
     }
      return title + columnLabels + utilityListing;
   }

	private double calcExpenditures(PayableEntity[] entities) {
		// TODO calcExpenditures
      double expenditures = 0;
      for (PayableEntity e : entities) {
         if (e == null) continue;
         else expenditures += e.amountOwed();
      }
		return expenditures;
	}

	public double calcTotalExpenditures() {
		// TODO calcTotalExpenditures
		return calcExpenditures(employees) + calcExpenditures(utilities);
	}

}
