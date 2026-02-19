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
      this.sales = sales;
	}

	@Override
	public double calcPreBonusPay() {
		// TODO calcPreBonusPay

		return sales * commissionRate;
	}

	@Override
	public String getJobCode() {
		// TODO getJobCode
		return "COMM";
	}

}
