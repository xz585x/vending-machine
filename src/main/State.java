package main;

public interface State {
    public void selectItem(String itemName);
    public void insertMoney(float amount);
    public void executeTransaction();
    public void cancelTransaction();
    public String toString(); // why???

}

