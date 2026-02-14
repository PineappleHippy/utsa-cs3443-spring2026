public class SalariedEmployee extends Employee {

	private double weeklyPay;

	public SalariedEmployee(String name, double weeklyPay) {
		super(name);
		this.weeklyPay = weeklyPay;
		// TODO SalariedEmployee constructor
	}

	@Override
	public double calcPreBonusPay() {
		// TODO calcPreBonusPay
		return 0;
	}

	@Override
	public String getJobCode() {
		// TODO getJobCode
		return null;
	}

}
