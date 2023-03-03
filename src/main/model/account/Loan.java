package src.main.model.account;

import src.main.model.account.impl.Account;

public class Loan extends Account {

    private static final double INTEREST_RATE = 0.02;
    private static final double DEBT_LIMIT = 10000;

    @Override
    public Account clone() {
        return new Loan(this);
    }

    @Override
    public boolean withdraw(double amount) {
        if ((super.getBalance() + amount) > DEBT_LIMIT) {
            return false;
        } else {
            super.setBalance(round(super.getBalance() + amount + (amount * INTEREST_RATE)));
            return true;
        }
    }
    @Override
    public void deposit(double amount) {
        super.setBalance(round(super.getBalance() - amount));
    }

    /**construct**/

    public Loan(String id, String name, double balance) {
        super(id, name, balance);
    }
    public Loan(Loan source) {
        super(source);
    }
}
