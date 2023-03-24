package transfer;


import shoppingApp.Item;
import shopping.ShoppingBasket;
import compartment.BevaragesCompartment;
import compartment.MeatsCompartment;
import compartment.SnacksCompartment;
import compartment.VegetablesFruitsCompartment;

public class TransferToFridge {
    public void transfer(ShoppingBasket basket, SnacksCompartment snack, MeatsCompartment meat, BevaragesCompartment bevarage, VegetablesFruitsCompartment veg) {
        for (Item item : basket.getBag()) {
            if(item!=null){
                if (item.getCompartment().equals("snacks")) {
                    snack.add(item);
                    basket.remove(item);
                }else if (item.getCompartment().equals("meats")){
                    meat.add(item);
                    basket.remove(item);
                }else if (item.getCompartment().equals("beverages")){
                    bevarage.add(item);
                    basket.remove(item);
                }else if (item.getCompartment().equals("vegetables and fruits")){
                    veg.add(item);
                    basket.remove(item);
                }else {
                    System.out.println("There is no such compartment what did you buy? ");
                }
            }

        }
    }
    public void displayRemainingSizes(SnacksCompartment snack, MeatsCompartment meat, BevaragesCompartment bevarage, VegetablesFruitsCompartment veg){
        System.out.println("Remaining size for all compartment:");
        System.out.println("Remaining size for Snack Compartment:"+snack.remainingSize());
        System.out.println("Remaining size for Meat Compartment:"+meat.remainingSize());
        System.out.println("Remaining size for Bevarage Compartment:"+bevarage.remainingSize());
        System.out.println("Remaining size for Vegetables and Fruits Compartment:"+veg.remainingSize());
    }


}
