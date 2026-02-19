public abstract class Employee implements PayableEntity {
	private static int numEmployees = 0;
	private String name;
	private double bonus;

	public Employee(String name) {
      this.name = name;
      numEmployees++;
	}

	public abstract double calcPreBonusPay();

	public abstract String getJobCode();
	
	public static int getNumEmployees() {
		return numEmployees;
	}
	
	public double calcTotalPay() {
      double totalPay = calcPreBonusPay() + bonus;
		return totalPay;
	}

	@Override
	public double amountOwed() {
		return calcTotalPay();
	}
	
	public String getName() {
		return name;
	}
	
	public double getBonus() {
		return bonus;
	}
	
	public void setBonus(double bonus) {
      this.bonus = bonus;
	}
	
	@Override
	public String toString() {
      String employeeInfo = String.format("%-15s %s $%8.2f $%8.2f",getName(), getJobCode(),calcPreBonusPay(),calcTotalPay());
		return employeeInfo;
	}
}
