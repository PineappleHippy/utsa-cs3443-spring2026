public class SalariedEmployee extends Employee {

	private double weeklyPay;

	public SalariedEmployee(String name, double weeklyPay) {
		super(name);
		this.weeklyPay = weeklyPay;
	}

	@Override
	public double calcPreBonusPay() {
		return weeklyPay;
	}

	@Override
	public String getJobCode() {
		return "SLRY";
	}

}
