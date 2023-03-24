package shoppingApp;

public class Item {
    private String item_name;
    private String compartment;
    private int item_weight;

    public Item(String item_name, String compartment, int item_weight) {
        this.item_name = item_name;
        this.compartment = compartment;
        this.item_weight = item_weight;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getCompartment() {
        return compartment;
    }

    public void setCompartment(String compartment) {
        this.compartment = compartment;
    }

    public int getItem_weight() {
        return item_weight;
    }

    public void setItem_weight(int item_weight) {
        this.item_weight = item_weight;
    }

    public String toString() {
        return item_name + " " + " " + item_weight+" g";
    }

    public boolean equals(Object obj) {
        if (obj instanceof Item){
            Item item = (Item) obj;
            return item.getItem_name().equals(item_name) && item.getItem_weight()==item_weight && item.getCompartment().equals(compartment);
        }else{
            return false;
        }
    }
}
