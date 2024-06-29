package lab4.probE;

public class CheckingAccount extends Account {
    private final String accountId;
    private final double balance;
    private final double monthlyFee;

    public CheckingAccount(String accountId, double balance, double monthlyFee) {
        this.accountId = accountId;
        this.balance = balance;
        this.monthlyFee = monthlyFee;
    }

    @Override
    public String getAccountId() {
        return accountId;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public double computeUpdatedBalance() {
        return balance - monthlyFee;
    }
}
