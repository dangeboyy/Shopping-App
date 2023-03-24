package shopping;

import compartment.BevaragesCompartment;
import compartment.MeatsCompartment;
import compartment.SnacksCompartment;
import compartment.VegetablesFruitsCompartment;
import io.FileIO;
import shoppingApp.Item;
import transfer.TransferToBasket;
import transfer.TransferToFridge;

import java.io.IOException;
import java.util.Scanner;

public class Shopping {
    FileIO fileIO = new FileIO();
    BevaragesCompartment bevaragesCompartment = new BevaragesCompartment();
    MeatsCompartment meatsCompartment = new MeatsCompartment();
    SnacksCompartment snacksCompartment = new SnacksCompartment();
    VegetablesFruitsCompartment vegetablesFruitsCompartment = new VegetablesFruitsCompartment();
    InventoryBag<Item> inventory = new InventoryBag<>();
    TransferToBasket transferToBasket = new TransferToBasket();
    TransferToFridge transferToFridge = new TransferToFridge();
    ShoppingBasket shoppingBasket = new ShoppingBasket();
    public void shoppingApp() throws IOException {
        inventory=fileIO.readInventory("inventory.txt");
        int control=1;//To control main while loop
        while (control==1){
            menü();
            Scanner scanner=new Scanner(System.in);
            int request1=scanner.nextInt();//reguest for menU
            if (request1==0){
                control=0;
                System.out.println("The program has been terminated by the user with 0 exit code");
            }
            else if(request1==1){
                int control2=1;//To control inner while loop
                while (control2==1) {
                    optioMenüPress1();
                    int request2=scanner.nextInt();//reguest for optionMenuPress1
                    if(request2==0){
                        System.out.println("Shopping ended");
                        control2=0;
                    }
                    if(request2==1){
                        System.out.println("Inventory List:");
                        inventory();
                        System.out.println("Please select an item to add your shopping basket");
                        int select=scanner.nextInt();//select an item from inventory
                        transferToBasket.transfer(inventory.getBag()[select-1],shoppingBasket);
                        if(shoppingBasket.isFull()){
                            System.out.println("Your bag is full shopping is finished.");
                            control2=0;
                        }
                    }
                    else if(request2==2){
                        shoppingBasket.displayItems();
                        System.out.print("Remaining capacity for your basket is :"+shoppingBasket.remainingSize()+"\n");
                    }
                }
            }
            else if(request1==2){
                shoppingBasket.displayItems();
                transferToFridge.transfer(shoppingBasket,snacksCompartment,meatsCompartment,bevaragesCompartment,vegetablesFruitsCompartment);
                transferToFridge.displayRemainingSizes(snacksCompartment,meatsCompartment,bevaragesCompartment,vegetablesFruitsCompartment);

            }
            else{
                System.out.println("Please enter a valid operation number");
            }
        }
    }

   public void menü(){
       System.out.println("What would you like to do?");
       System.out.println("1)Go to the mall to shopping");
       System.out.println("2)Finish shopping and go home to fill fridge");
       System.out.println("0)Exit the app");
   }
   public void inventory() throws IOException {
        inventory=fileIO.readInventory("inventory.txt");
        inventory.displayItems();

   }
   public void optioMenüPress1(){
       System.out.println("What would you like to do?");
       System.out.println("1)Shopping");
       System.out.println("2)See the basket");
       System.out.println("0)Finish shopping");
   }













}
