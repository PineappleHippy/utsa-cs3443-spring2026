
/*
  Lab2 exercises the functionality of the HourlyEmployee,
  SalariedEmployee, CommissionEmployee, LimitedCommissionEmployee,
  Utility, and Company classes.
 */

public class Lab2 {

    public static void main(String[] args) {
	Company acme = new Company("Acme Corporation", 7, 2);

	HourlyEmployee hourly1 = new HourlyEmployee("Smith", 35);
	HourlyEmployee hourly2 = new HourlyEmployee("Jones", 30);

	SalariedEmployee salaried1 = new SalariedEmployee("Brown", 2000);

	CommissionEmployee commission1 = new CommissionEmployee("Green", 0.10);

	LimitedCommissionEmployee limitedCommission1 =
	    new LimitedCommissionEmployee("Anderson", 0.15, 1000);
	
	LimitedCommissionEmployee limitedCommission2 =
	    new LimitedCommissionEmployee("Fletcher", 0.20, 1200);

	LimitedCommissionEmployee limitedCommission3 =
	    new LimitedCommissionEmployee("Cooper", 0.10, 1500);

	hourly1.setHoursWorked(30);
	hourly2.setHoursWorked(40);
	hourly2.setBonus(50);
	commission1.setSales(20000);
	limitedCommission1.setSales(2000);
	limitedCommission2.setSales(10000);
	limitedCommission3.setSales(40000);
	limitedCommission3.setBonus(100);
	
	acme.addEmployee(hourly1);
	acme.addEmployee(hourly2);
	acme.addEmployee(salaried1);
	acme.addEmployee(commission1);
	acme.addEmployee(limitedCommission1);
	acme.addEmployee(limitedCommission2);
	acme.addEmployee(limitedCommission3);

	Utility electricity = new Utility("Electric Company", 0.13, 0.00);
	Utility internet = new Utility("Internet Provider", 0, 100);

	electricity.setUsage(1000);

	acme.addUtility(electricity);
	acme.addUtility(internet);
		
	System.out.println(acme.createPayrollListing());
	System.out.println(acme.createUtilityListing());
	System.out.println(acme.getName() + " total expenditures: "
			   + acme.calcTotalExpenditures() + "\n");

	
	Company spacely = new Company("Spacely Sprockets", 3, 4);
	LimitedCommissionEmployee limitedCommission4 =
	    new LimitedCommissionEmployee("Davis", 0.2, 1800);
	HourlyEmployee hourly3 = new HourlyEmployee("Wilson", 31);

	limitedCommission4.setBonus(2000);
	limitedCommission4.setSales(20000);
	hourly3.setHoursWorked(41);


	
	Utility water = new Utility("Water Company", 0.20, 0.00);
	water.setUsage(5000);

	spacely.addEmployee(limitedCommission4);
	spacely.addUtility(water);
	spacely.addEmployee(hourly3);
	
	System.out.println(spacely.createPayrollListing());
	System.out.println(spacely.createUtilityListing());
	System.out.println(spacely.getName() + " total expenditures: "
			   + spacely.calcTotalExpenditures() + "\n");

	System.out.println("Total employees in all companies: "
			   + Employee.getNumEmployees());
	
	
    }


}
