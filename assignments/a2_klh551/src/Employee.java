public abstract class Employee implements PayableEntity {
	private static int numEmployees;
	private String name;
	private double bonus;

	public Employee(String name) {
		// TODO Employee constructor
	}

	public abstract double calcPreBonusPay();

	public abstract String getJobCode();
	
	public static int getNumEmployees() {
		// TODO getNumEmployees
		return 0;
	}
	
	public double calcTotalPay() {
		// TODO calcTotalPay
		return 0.0;
	}

	@Override
	public double amountOwed() {
		// TODO amountOwed
		return 0;
	}
	
	public String getName() {
		// TODO getName
		return "";
	}
	
	public double getBonus() {
		// TODO getBonus
		return 0.0;
	}
	
	public void setBonus(double bonus) {
		// TODO setBonus
	}
	
	@Override
	public String toString() {
		// TODO toString
		return "";
	}
}
