package shopping;

import shoppingApp.IBag;
import shoppingApp.Item;

public class ShoppingBasket implements IBag<Item> {

    private Item[] bag=new Item[30];
    private int numberOfEntries;
    private int weight;
    private int DEFAULT_CAPACITY = 2000;

    @Override
    public boolean add(Item newItem) {
        if (isFull()){
            System.out.println(getClass().getSimpleName()+" is full. Shopping is ended");
            return false;
        } else if (weight+ newItem.getItem_weight()<=DEFAULT_CAPACITY) {//Merte sor değiştirildi!
            bag[numberOfEntries]=newItem;
            weight=weight+newItem.getItem_weight();
            numberOfEntries++;
            System.out.println(newItem.getItem_name() + " is added to your "+getClass().getSimpleName()+" Remaining size is " + remainingSize());
            return true;
        } else {
            System.out.println("Warning Message:Remaining place for your basket is "+remainingSize()+". There is no enough space to add "+newItem.getItem_weight()+"g "+newItem.getItem_name());
            return false;
        }
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries==0;
    }

    @Override
    public boolean isFull() {

        return weight==DEFAULT_CAPACITY;
    }

    @Override
    public Item removeByIndex(int index) {
        Item deletedItem=null;
        if(!isEmpty() && index>=0){
            deletedItem = bag[index];
            weight=weight-bag[index].getItem_weight();
            bag[index]=null;
            return deletedItem;
        }
        return deletedItem;
    }

    @Override
    public Item remove() {
        Item result = null;
        if (!isEmpty()){
            result = bag[numberOfEntries-1];
            weight=weight-result.getItem_weight();
            bag[numberOfEntries-1]=null;
            numberOfEntries--;
        }

        return result;
    }

    @Override
    public Item remove(Item item) {
        int indx= getIndexOf(item);
        Item deletedItem = removeByIndex(indx);
        numberOfEntries--;
        System.out.println(item.getItem_name()+"removed from basket");
        return deletedItem;

    }

    @Override
    public int getItemCount() {
        return numberOfEntries;
    }

    @Override
    public int getIndexOf(Item item) {
        int where = -1; //if not found then return -1
        boolean found=false;
        int index = 0;
        while(!found){
            if (item.equals(bag[index])){
                found=true;
                where=index;
            }
            index++;
        }
        return where;
    }

    @Override
    public boolean contains(Item item) {
        return getIndexOf(item) >= 0;
    }

    @Override
    public void displayItems() {
        if(isEmpty()){
            System.out.println("Your basket is empty");
        }
        else{
            System.out.println("Your basket includes:");
            for(int i=0;i<bag.length;i++){
                if(bag[i]!=null){
                    System.out.println(bag[i].toString());
                }else {
                    i=bag.length;
                }

            }
        }

    }
    @Override
    public void dump() {
        while(!isEmpty()){
            remove();
        }
    }

    public Item[] getBag() {
        return bag;
    }
    public int remainingSize(){
        return DEFAULT_CAPACITY-weight;
    }
}
