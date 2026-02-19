public class Utility implements PayableEntity {

	private String name;
	private double usage;
	private double rate;
	private double base;

	public Utility(String name, double rate, double base) {
      this.name = name;
      this.rate = rate;
      this.base = base;
	}

	public void setUsage(double usage) {
      this.usage = usage;
	}

	@Override
	public double amountOwed() {
		return (usage * rate) + base;
	}

	@Override
	public String toString() {
      String utilityInfo = String.format("%-20s $%10.2f", name, amountOwed());
		return utilityInfo;
	}
}
