package src.test;


import org.junit.Before;
import org.junit.Test;
import src.main.model.account.Chequing;
import src.main.model.account.Loan;
import src.main.model.account.Savings;
import src.main.model.account.impl.Account;
import src.main.model.account.impl.Taxable;

import static junit.framework.TestCase.assertEquals;


public class AccountTests {

    Account[] accounts;

    @Before
    public void setup() {
        accounts = new Account[] {
                new Chequing("f84c43f4-a634-4c57-a644-7602f8840870", "Michael Scott",1524.51),
                new Savings("4991bf71-ae8f-4df9-81c1-9c79cff280a5","Phoebe Buffay",2537.31),
                new Loan("23a8bae0-1725-4282-8401-2fd418b75682","Dean Winchester",2930.24)
        };
    }
    @Test
    public void withdrawTest() {
        accounts[0].withdraw(1440);
        assertEquals(84.51, accounts[0].getBalance());
    }

    @Test
    public void overdraftTest() {
        accounts[0].withdraw(1534.43);
        assertEquals(-15.42, accounts[0].getBalance());
    }

    @Test
    public void overdraftLimitTest() {
        accounts[0].withdraw(1725.0);
        assertEquals(1524.51, accounts[0].getBalance());
    }

    @Test
    public void depositCheckTest() {
        accounts[0].deposit(1000);
        assertEquals(2524.51, accounts[0].getBalance());
    }

    @Test
    public void incomeTaxTest() {
        double income = 4000;
        accounts[0].deposit(income);
        ((Taxable)accounts[0]).tax(income);
        assertEquals(5374.51, accounts[0].getBalance());
    }

    @Test
    public void withdrawFeeTest() {
        accounts[1].withdraw(100);
        assertEquals(2432.31, accounts[1].getBalance());
    }

    @Test
    public void depositSavingsTest() {
        accounts[1].deposit(100);
        assertEquals(2637.31, accounts[1].getBalance());
    }

    @Test
    public void depositLoanTest() {
        accounts[2].deposit(1000);
        assertEquals(1930.24, accounts[2].getBalance());
    }

    @Test
    public void withdrawInterestTest() {
        accounts[2].withdraw(2930.24);
        assertEquals(5919.08, accounts[2].getBalance());
    }

    @Test
    public void withdrawLimitTest() {
        accounts[2].withdraw(7500);
        assertEquals(2930.24, accounts[2].getBalance());
    }


}
