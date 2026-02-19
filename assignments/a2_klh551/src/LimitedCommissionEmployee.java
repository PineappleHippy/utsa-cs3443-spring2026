/**
 * A commission employee whose pay is bounded between a base pay and twice the base pay.
 *
 * @author JDT|KLH551
 */
public class LimitedCommissionEmployee extends CommissionEmployee {

   private double basePay;

   public LimitedCommissionEmployee(String name, double commissionRate, double basePay) {
      super(name, commissionRate);
      this.basePay = basePay;
   }

   /**
    * Returns commission pay clamped between basePay and twice basePay.
    *
    * @return pre-bonus pay amount
    */
   @Override
   public double calcPreBonusPay() {
      double maxPreBonusPay = basePay *2;
      double commision = super.calcPreBonusPay();
      if (commision < basePay) return basePay;
      else if(commision > maxPreBonusPay) return maxPreBonusPay;
      else return commision;
   }

   /**
    * Returns the job code for limited commission employees.
    *
    * @return "LCOM"
    */
   @Override

   public String getJobCode() {
      return "LCOM";
   }

}
