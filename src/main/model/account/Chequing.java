package src.main.model.account;

import src.main.model.account.impl.Account;
import src.main.model.account.impl.Taxable;

public class Chequing extends Account implements Taxable {

    private static final double OVERDRAFT_FEE = 5.50;
    private static final double OVERDRAFT_LIMIT = -200;

    private static final double TAXABLE_INCOME = 3000;
    private static final double TAX_RATE = 0.15;

    @Override
    public Account clone() {
        return new Chequing(this);
    }

    @Override
    public void tax(double income) {
        double tax = Math.max(0, income - TAXABLE_INCOME) * TAX_RATE;
        super.setBalance(round(super.getBalance() - tax));
    }

    @Override
    public boolean withdraw(double amount) {

        if ((super.getBalance() - amount ) < OVERDRAFT_LIMIT) {
            return false;

        } else if ((super.getBalance() - amount) < 0) {
            super.setBalance(round(super.getBalance() - amount - OVERDRAFT_FEE));

        } else {
            super.setBalance(round(super.getBalance() - amount));
        }
        return true;
    }

    @Override
    public void deposit(double amount) {
        super.setBalance(round(super.getBalance() + amount));
    }

    /**construct**/
    public Chequing(String id, String name, double balance) {
        super(id, name, balance);
    }

    public Chequing(Chequing source) {
        super(source);
    }
}
