public class HourlyEmployee extends Employee {
	
	private double hourlyWage;
	private double hoursWorked;

	public HourlyEmployee(String name, double hourlyWage) {
		super(name);
		this.hourlyWage = hourlyWage;
	}
	
	public void setHoursWorked(double hoursWorked) {
      this.hoursWorked = hoursWorked;
	}
	
	@Override
	public double calcPreBonusPay() {
      if (hoursWorked <= 40) return hoursWorked * hourlyWage;
      else return 40 * hourlyWage + (hoursWorked - 40) * hourlyWage * 1.5;
	}

	@Override
	public String getJobCode() {
		return "HRLY";
	}

}
