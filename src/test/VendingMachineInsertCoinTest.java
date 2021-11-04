package test;

import main.VendingMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class VendingMachineInsertCoinTest {
    VendingMachine VM;

    @BeforeEach
    void setUp() {
        VM = new VendingMachine();
    }

    @Test
    @DisplayName("Insert coins without selecting items")
    public void testInsertCoinNoSelection() {
        VM.insertCoin(100f);
        VM.getCurrentInsertedMoney();
    }

    @Test
    @DisplayName("Insert coins after selecting an item")
    public void testInsertCoin() {
        VM.selectItem("Coke");
        VM.insertCoin(100f);
        VM.getCurrentInsertedMoney();
    }

    @RepeatedTest(2)
    @DisplayName("Multiple insert")
    void testMultiplyWithZero() {
        VM.selectItem("Coke");
        VM.insertCoin(100);
        VM.getCurrentInsertedMoney();
        VM.insertCoin(100);
        VM.getCurrentInsertedMoney();
    }

}
