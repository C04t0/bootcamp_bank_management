package src.main.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Transaction implements Comparable<Transaction>{

    public enum Type{WITHDRAW, DEPOSIT};
    private Type type;
    private long timestamp;
    private String id;
    private double amount;

    public String returnDate() {
        Date date = new Date(this.timestamp * 1000);
        return new SimpleDateFormat("dd-MM-yyyy").format(date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, timestamp, id, amount);
    }

    @Override
    public boolean equals(Object obj) {
        Transaction transaction = (Transaction) obj;
        return Objects.equals(type, transaction.type) && timestamp == transaction.getTimestamp();
    }

    @Override
    public int compareTo(Transaction o) {
        return Double.compare(this.timestamp, o.timestamp);
    }

    @Override
    public String toString() {
        return (type) + "   " +
                "\t" + this.returnDate() + "" +
                "\t" + id + "" +
                "\t$" + amount + "";
    }

    /**construct**/

    public Transaction(Type type, long timestamp, String id, double amount) {
        if (id.isBlank() || id == null || amount < 0) {
            throw new IllegalArgumentException("Invalid parameters");
        }
        this.type = type;
        this.timestamp = timestamp;
        this.id = id;
        this.amount = amount;
    }

    public Transaction(Transaction source) {
        this.type = source.type;
        this.timestamp = source.timestamp;
        this.id = source.id;
        this.amount = source.amount;
    }

    /**get & set**/

    public void setType (Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setId(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("INVALID ID");
        }
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setAmount(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Amount cannot be less than zero");
        }
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}
