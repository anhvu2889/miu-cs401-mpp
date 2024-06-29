package lab4.probC;


public class PayCheck {
    private final double grossPay;
    private final double fica;
    private final double state;
    private final double local;
    private final double medicare;
    private final double socialSecurity;

    public PayCheck(double grossPay, double fica, double state, double local, double medicare, double socialSecurity) {
        this.grossPay = grossPay;
        this.fica = fica;
        this.state = state;
        this.local = local;
        this.medicare = medicare;
        this.socialSecurity = socialSecurity;
    }

    public void print() {
        System.out.println(STR."""
        Pay Check
                Gross Pay: \{grossPay}
                FICA: \{fica}
                State: \{state}
                Local: \{local}
                Medicare: \{medicare}
                Social Security: \{socialSecurity}
                """
        );
    }

    public double getNetPay() {
        return grossPay - fica - state - medicare - socialSecurity;
    }
}
