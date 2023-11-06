package Activities;
import org.junit.jupiter.api.Test;
import Activities.BankAccount;
import Activities.NotEnoughFundsException;
import static org.junit.jupiter.api.Assertions.*;


public class Activity2 {

    @Test
    void notEnoughFunds() {

        BankAccount account = new BankAccount(5);
        assertThrows(NotEnoughFundsException.class, () -> account.withdraw(20),
                "Balance must be greater than amount of withdrawal");
    }

    @Test
    void enoughFunds() {
        BankAccount account = new BankAccount(100);
        assertDoesNotThrow(() -> account.withdraw(50));
    }
}