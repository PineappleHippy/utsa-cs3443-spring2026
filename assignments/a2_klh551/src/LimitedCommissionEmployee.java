public class LimitedCommissionEmployee extends CommissionEmployee {

	private double basePay;

	public LimitedCommissionEmployee(String name, double commissionRate, double basePay) {
		super(name, commissionRate);
		this.basePay = basePay;
		// TODO LimitedCommissionEmployee constructor
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
