package main;

public class InsertedMoneyState extends AbstractState {

    public InsertedMoneyState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void selectItem(String itemName) {
        vendingMachine.setCurrentSelectedItem(itemName);
    }

    @Override
    public void insertMoney(float amount) {
        vendingMachine.setCurrentInsertedMoney(amount);
    }

    @Override
    public void executeTransaction() {
        String currentSelectedItem = vendingMachine.getCurrentSelectedItem();
        float price = vendingMachine.getPrice(currentSelectedItem);

        vendingMachine.makePayment(price);
        vendingMachine.emptyInsertedMoney();
        vendingMachine.setCurrentSelectedItem("");
        System.out.print("The transaction is completed." + "\n");
    }

    @Override
    public void cancelTransaction() {
        float change = vendingMachine.emptyInsertedMoney();
        vendingMachine.setCurrentSelectedItem("");
        System.out.println("The transaction is cancelled.");

    }
}
