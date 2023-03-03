package src.main.model.account.impl;

import java.text.DecimalFormat;

public abstract class Account {

    private String id;
    private String name;
    private double balance;



    @Override
    public int hashCode() {
        return 0;
    }
    @Override
    public String toString() {
        return (this.getClass().getSimpleName()) + "    " +
                "\t" + this.getId() + "" +
                "\t" + this.getName() + "" +
                "\t$" + this.getBalance() + "";
    }

    public abstract void deposit(double amount);
    public abstract boolean withdraw(double amount);

    public abstract Account clone();

    protected double round(double amount) {
        DecimalFormat format = new DecimalFormat("#.##");
        return  Double.parseDouble(format.format(amount));
    }


    /**construct**/

    public Account(String id, String name, double balance) {
        if (id == null || id.isBlank() || name == null || name.isBlank()) {
            throw new IllegalArgumentException("INVALID PARAMETERS");
        }
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public Account(Account source) {
        this.id = source.id;
        this.name = source.name;
        this.balance = source.balance;
    }

    /**get & set**/

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("ILLEGAL NAME");
        }
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("ILLEGAL ID");
        }
        this.id = id;
    }
}
