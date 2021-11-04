package test;

import main.VendingMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class VendingMachineExecuteTransactionTest {
    VendingMachine VM;

    @BeforeEach
    void setUp() {
        VM = new VendingMachine();
    }

    @Test
    @DisplayName("Execute transaction without selecting items")
    public void testExecuteTransactionNoSelection() {
       VM.executeTransaction();
    }

    @Test
    @DisplayName("Execute transaction after selecting an item but without inserting coins")
    public void testExecuteTransactionWithoutInsertCoin() {
        VM.selectItem("Coke");
        VM.executeTransaction();
    }

    @Test
    @DisplayName("Execute transaction after inserting coins less than the item price")
    public void testExecuteTransactionAfterInsertCoinLessThanPrice() {
        VM.selectItem("Coke");
        VM.insertCoin(1f);
        VM.executeTransaction();
    }

    @Test
    @DisplayName("Execute transaction after inserting enough coins")
    public void testExecuteTransactionAfterInsertEnoughCoin() {


        VM.selectItem("Coke");
        VM.insertCoin(10f);
        VM.executeTransaction();
    }

    @Test
    @DisplayName("Execute transaction after inserting enough coins by multiple times")
    public void testExecuteTransactionAfterInsertEnoughCoinByMultipleInsertion() {


        VM.selectItem("Coke");
        VM.insertCoin(5f);
        VM.insertCoin(5f);
        VM.executeTransaction();
    }


}
