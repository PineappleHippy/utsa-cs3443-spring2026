public class LimitedCommissionEmployee extends CommissionEmployee {

	private double basePay;

	public LimitedCommissionEmployee(String name, double commissionRate, double basePay) {
		super(name, commissionRate);
		this.basePay = basePay;
	}

	@Override
	public double calcPreBonusPay() {
      double maxPreBonusPay = basePay *2;
      double commision = super.calcPreBonusPay();
      if (commision < basePay) return basePay;
      else if(commision > maxPreBonusPay) return maxPreBonusPay;
      else return commision;
	}

	@Override
	public String getJobCode() {
		return "LCOM";
	}

}
