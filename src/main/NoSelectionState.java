package main;

class NoSelectionState extends AbstractState {

    public NoSelectionState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void selectItem(String itemName) {
        vendingMachine.setCurrentSelectedItem(itemName);
        vendingMachine.changeToHasSelectionState();
    }

    @Override
    public void insertMoney(float amount) {
        System.out.println("Please make a selection first.");
    }

    @Override
    public void executeTransaction() {
        System.out.println("Please make a selection first.");

    }

    @Override
    public void cancelTransaction() {
        System.out.println("Please make a selection first.");

    }

    @Override
    public String toString() {
        return "No selection";
    }
}
