package src.main.model.account;

import src.main.model.account.impl.Account;

public class Savings extends Account {

    private static final double WITHDRAWAL_FEE = 5.00;

    @Override
    public Account clone() {
        return new Savings(this);
    }

    @Override
    public void deposit(double amount) {
        super.setBalance(round(super.getBalance() + amount));
    }
    @Override
    public boolean withdraw(double amount) {
        super.setBalance(round(super.getBalance() - amount - WITHDRAWAL_FEE));
        return true;
    }
    /**construct**/
    public Savings(String id, String name, double balance) {
        super(id, name, balance);
    }

    public Savings(Account source) {
        super(source);
    }
}
