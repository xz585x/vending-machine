package test;

import main.VendingMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class VendingMachineCancelTransactionTest {
    VendingMachine VM;

    @BeforeEach
    void setUp() {
        VM = new VendingMachine();

    }

    @Test
    @DisplayName("Cancel a transaction without selection")
    public void testCancelTransactionWithoutSelection() {
        VM.cancelTransaction();
    }

    @Test
    @DisplayName("Cancel a transaction without inserting coins")
    public void testCancelTransactionWithoutInsertingCoins() {
        VM.selectItem("Coke");
        VM.cancelTransaction();
    }

    @Test
    @DisplayName("Cancel a transaction after inserting coins")
    public void testCancelTransactionAfterInsertingCoins() {
        VM.selectItem("Coke");
        VM.insertCoin(10f);
        VM.cancelTransaction();
    }


}
