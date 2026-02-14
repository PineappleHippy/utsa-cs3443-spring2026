package a2_klh551;

public class Utility implements PayableEntity {

	private String name;
	private double usage;
	private double rate;
	private double base;

	public Utility(String name, double rate, double base) {
		// TODO Utility constructor
	}

	public void setUsage(double usage) {
		// TODO setUsage
	}

	@Override
	public double amountOwed() {
		// TODO amountOwed
		return 0;
	}

	@Override
	public String toString() {
		// TODO toString
		return "";
	}

}
