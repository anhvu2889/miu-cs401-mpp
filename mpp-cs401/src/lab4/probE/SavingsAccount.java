package lab4.probE;

public class SavingsAccount extends Account {
    private final String accountId;
    private final double balance;
    private final double interestRate;

    public SavingsAccount(String accountId, double balance, double interestRate) {
        this.accountId = accountId;
        this.balance = balance;
        this.interestRate = interestRate;
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
        return balance + balance * interestRate;
    }
}
