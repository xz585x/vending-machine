
/* Preparation for OOD interview questions
* By HappyJajavava
*
* Clarify:
* a common vending machine;
* includes items including Coke, Sprite, and Snack
* accept string input for selecting items
* accept coins only for payment
*
* Core Object:
* Vending machine
* Input: ItemName (property of class Item)
* Input: payment as Coins (class Coin)
* Inside Vending machine: class Item (inherited by Coke,Sprite, and Snack) for selection
* Inside Vending machine: receipt (doesn't need it here)
* Inside Vending machine: itemInfo (including price, nutrient, etc.), simplified as a hashmap<Item, Float>, a property
*                               in vending machine
* Output: Purchased Item (class Item)
*
* User cases (State design pattern)
* select an item
* insert coin
* execute transaction
* cancel transaction
*
* */




package main;

import java.util.HashMap;
import java.util.Map;

public class VendingMachine {


    private String currentSelectedItem; // setter and getter
    private float currentInsertedMoney;
    public static final float PRICE_OF_NON_EXISTED_ITEM = (float) 0;
    private State state;
    private String toPrintState;
    private NoSelectionState noSelectionState;
    private HasSelectionState hasSelectionState;
    private InsertedMoneyState insertedMoneyState;
    private Map<String, Float> itemPrice;


    //    Constructor
    public VendingMachine() {
        currentSelectedItem = "";
        currentInsertedMoney = 0;
        noSelectionState = new NoSelectionState(this);
        hasSelectionState = new HasSelectionState(this);
        insertedMoneyState = new InsertedMoneyState(this);
        state = noSelectionState;
        toPrintState ="Current selection: " + currentSelectedItem + "/n" +
                "Price: " + currentInsertedMoney + "/n" +
                "State: " + state;

        itemPrice = new HashMap<>();
        itemPrice.put("Coke", 10f);
        itemPrice.put("Sprite", 15f);
        itemPrice.put("Snack", 20f);
    }

    //    setter
    public void setCurrentSelectedItem(String itemName) {
        if (itemName != "") {
            this.currentSelectedItem = itemName;
            System.out.println("The selected item is " + itemName);
        }

    }

    //    getter
    public String getCurrentSelectedItem() {
        return currentSelectedItem;

    }

    //    setter
    public float getCurrentInsertedMoney() {
        System.out.println("The total inserted money is " + currentInsertedMoney);
        return currentInsertedMoney;
    }
    //    getter
    public void setCurrentInsertedMoney(float currentInsertedMoney) {
        this.currentInsertedMoney += currentInsertedMoney;
        System.out.println("The inserted amount is " + currentInsertedMoney);
    }
    //    make a payment
    public float makePayment(float price) {
        if (this.currentInsertedMoney < price) {
            System.out.println("No enough payment inserted." + "\n");
        } else {
            this.currentInsertedMoney = currentInsertedMoney - price;
            System.out.println("Successful payment!");
        }

        return this.currentInsertedMoney;
    }
    //    empty currentInsertedMoney
    public float emptyInsertedMoney() {
        float change = this.currentInsertedMoney;
        this.currentInsertedMoney = 0;
        return change;
    }

    //    check the price of the desired Item
    public float getPrice(String itemName) {
        if (itemName == null) {
            System.out.println("The item name is not valid.");
            return PRICE_OF_NON_EXISTED_ITEM;

        }
        Float price = itemPrice.get(itemName);

        if (price != null) {
            System.out.println("The price of " + itemName + " is " + price + "\n");
            return price;
        } else {
            System.out.println("This item doesn't exist.");
            return PRICE_OF_NON_EXISTED_ITEM;
        }
    }


    //    change states
    public void changeToNoSelectionState() {
        state = noSelectionState;
    }
    public void changeToHasSelectionState() {
        state = hasSelectionState;
    }
    public void changeToInsertedMoneyState() {
        state = insertedMoneyState;
    }

    //    behaviors of this vending machine
    public void selectItem(String itemName) {
        state.selectItem(itemName);

    }
    public void insertCoin(float amount) {
        state.insertMoney(amount);
    }
    public void executeTransaction() {
        state.executeTransaction();
    }
    public void cancelTransaction() {
        state.cancelTransaction();
    }

}
