package src.test;

import org.junit.Before;
import org.junit.Test;
import src.main.model.Bank;
import src.main.model.Transaction;
import src.main.model.account.Chequing;

import static org.junit.Assert.assertEquals;


public class BankTests {

    Bank bank;

    @Before
    public void setup() {

        bank = new Bank();
        bank.addAccount(new Chequing("7ee3db4f-c1ba-425c-a83d-c73381c89569","Michael Scott",1524.51));
    }

    @Test
    public void succesfulTransactionTest() {

        this.bank.executeTransactions(
                new Transaction(Transaction.Type.WITHDRAW, 1546905600, "7ee3db4f-c1ba-425c-a83d-c73381c89569", 364.91));
        this.bank.executeTransactions(
                new Transaction(Transaction.Type.DEPOSIT, 1578528000, "7ee3db4f-c1ba-425c-a83d-c73381c89569", 311.62));

        assertEquals(2, bank.getTransaction("7ee3db4f-c1ba-425c-a83d-c73381c89569").length);
    }

    @Test
    public void failedTransactionTest() {

        this.bank.executeTransactions(
                new Transaction(Transaction.Type.WITHDRAW, 1546905600, "7ee3db4f-c1ba-425c-a83d-c73381c89569", 1000000));
    }

    @Test
    public void taxDeduction() {

        this.bank.executeTransactions(new Transaction(Transaction.Type.DEPOSIT, 1578700800, "7ee3db4f-c1ba-425c-a83d-c73381c89569", 4000));
        this.bank.executeTransactions(new Transaction(Transaction.Type.WITHDRAW, 1578700800, "7ee3db4f-c1ba-425c-a83d-c73381c89569", 500));

        this.bank.deductTaxes();
        assertEquals(4949.51, bank.getAccount("7ee3db4f-c1ba-425c-a83d-c73381c89569").getBalance(), 0);
    }


}
