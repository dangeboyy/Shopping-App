package compartment;

import shoppingApp.IBag;
import shoppingApp.Item;

public class VegetablesFruitsCompartment implements IBag<Item> {


    private Item[] bag=new Item[30];
    private int numberOfEntries;
    private int weight;
    private int DEFAULT_CAPACITY = 3000;

    @Override
    public boolean add(Item newItem) {
        if (isFull()){
            System.out.println(getClass().getSimpleName()+" is full");
            return false;
        } else if (weight+ newItem.getItem_weight()<=DEFAULT_CAPACITY) {
            bag[numberOfEntries]=newItem;
            weight=weight+newItem.getItem_weight();
            numberOfEntries++;
            System.out.println(newItem.getItem_name() + " is added to your "+getClass().getSimpleName()+" Remaining size is. " + remainingSize() + "g");

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
        Item deletedItem;
        deletedItem = bag[index];
        weight=weight-deletedItem.getItem_weight();
        bag[index]=null;

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
        weight=weight-deletedItem.getItem_weight();
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
        if(isEmpty()){
            System.out.println("Your vegetables and fruits compartment is empty");
        }
        else{
            System.out.println("Your vegetables and fruits compartment includes:");
            for(int i=0;i< numberOfEntries;i++){
                System.out.println(bag[i].getItem_weight()+"g "+bag[i].getItem_name());
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
