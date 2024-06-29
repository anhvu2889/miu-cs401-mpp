package lab4.probE;

import java.util.ArrayList;
import java.util.List;

class Employee {
    private String name;
    private final List<Account> accounts;

    public Employee(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public double computeUpdatedBalanceSum() {
        double sum = 0;
        for (Account account : accounts) {
            sum += account.computeUpdatedBalance();
        }
        return sum;
    }
}
