package test;

import main.VendingMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VendingMachineSelectItemTest {
    VendingMachine VM;

    @BeforeEach
    void setUp() {
        VM = new VendingMachine();

    }

    @Test
    @DisplayName("Select an item")
    public void testInsertCoin() {
        VM.selectItem("Coke");
    }

    @RepeatedTest(2)
    @DisplayName("Reselect")
    void testMultiplyWithZero() {
        VM.selectItem("Sprite");
        VM.selectItem("Coke");
        VM.selectItem("Snack");
    }


}
