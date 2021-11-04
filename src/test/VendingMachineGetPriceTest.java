package test;

import main.VendingMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class VendingMachineGetPriceTest {
    VendingMachine VM;

    @BeforeEach
    void setUp() {
        VM = new VendingMachine();

    }

    @Test
    @DisplayName("Select NO item and get the price")
    public void testGetPriceWithoutSelection() {
        String itemName = VM.getCurrentSelectedItem();
        VM.getPrice(itemName);

    }

    @Test
    @DisplayName("Select an item and get the price")
    public void testGetPriceWithSelection() {
        VM.selectItem("Coke");
        String itemName = VM.getCurrentSelectedItem();
        itemName = VM.getCurrentSelectedItem();
        VM.getPrice(itemName);

    }

}
