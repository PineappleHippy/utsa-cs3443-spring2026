package a2_klh551;

public class HourlyEmployee extends Employee {
	
	private double hourlyWage;
	private double hoursWorked;

	public HourlyEmployee(String name, double hourlyWage) {
		super(name);
		this.hourlyWage = hourlyWage;
		// TODO HourlyEmployee constructor
	}
	
	public void setHoursWorked(double hoursWorked) {
		// TODO setHoursWorked
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
