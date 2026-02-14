package a2_klh551;

public class CommissionEmployee extends Employee {

	private double commissionRate;
	private double sales;

	public CommissionEmployee(String name, double commissionRate) {
		super(name);
		this.commissionRate = commissionRate;
		// TODO CommissionEmployee constructor
	}

	public void setSales(double sales) {
		// TODO setSales
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
