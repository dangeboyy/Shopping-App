package shopping;

import shoppingApp.IBag;
import shoppingApp.Item;

public class InventoryBag<T> implements IBag<Item> {
    private Item[] bag=new Item[30];
    private int numberOfEntries;
    private int weight;
    private int DEFAULT_CAPACITY = 100000;

    @Override
    public boolean add(Item newItem) {
        if (isFull()){
            System.out.println("Your bag is full");
            return false;
        } else if (weight+ newItem.getItem_weight()<DEFAULT_CAPACITY) {
            bag[numberOfEntries]=newItem;
            weight=weight+newItem.getItem_weight();
            numberOfEntries++;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries==0;
    }

    @Override
    public boolean isFull() {
        return weight>=DEFAULT_CAPACITY;
    }

    @Override
    public Item removeByIndex(int index) {
        Item deletedItem;
        deletedItem = bag[index];
        bag[index]=null;

        return deletedItem;

    }

    @Override
    public Item remove() {
        Item result = null;
        if (!isEmpty()){
            result = bag[numberOfEntries-1];
            bag[numberOfEntries-1]=null;
            numberOfEntries--;
        }

        return result;
    }

    @Override
    public Item remove(Item item) {
        int indx= getIndexOf(item);
        Item deletedItem = removeByIndex(indx);
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
        while(!found && index<numberOfEntries){
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
        for(int i=0;i< numberOfEntries;i++){
            System.out.println(i+1+")"+bag[i].getItem_name()+" "+bag[i].getItem_weight()+"g");
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