package src.test;

import org.junit.Before;
import org.junit.Test;
import src.main.model.Transaction;

import static org.junit.Assert.assertEquals;

public class TransactionTests {

    Transaction transaction;

    @Before
    public void setup() {

        transaction =
                new Transaction(Transaction.Type.WITHDRAW,
                        1546905600,
                        "f84c43f4-a634-4c57-a644-7602f8840870",
                        624.99);
    }

    @Test
    public void correctDateTest() {

        assertEquals("08-01-2019", transaction.returnDate());
    }

}
