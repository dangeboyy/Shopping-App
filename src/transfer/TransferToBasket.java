package transfer;

import shoppingApp.Item;
import shopping.ShoppingBasket;

public class TransferToBasket {
    public ShoppingBasket transfer(Item item, ShoppingBasket basket){
        basket.add(item);
        return basket;
    }

}
