package main;

public class HasSelectionState extends AbstractState {
    public HasSelectionState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void selectItem(String itemName) {
        vendingMachine.setCurrentSelectedItem(itemName);
    }

    @Override
    public void insertMoney(float amount) {
        vendingMachine.setCurrentInsertedMoney(amount);
        vendingMachine.changeToInsertedMoneyState();
    }

    @Override
    public void executeTransaction() {
        System.out.println("Please make a payment first.");
    }

    @Override
    public void cancelTransaction() {
        vendingMachine.setCurrentSelectedItem("");
        vendingMachine.changeToNoSelectionState();
        System.out.println("Transaction cancelled");

    }
}
