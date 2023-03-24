package io;

import shopping.InventoryBag;
import shoppingApp.Item;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class FileIO {//This class uses for file operations(read file and fill object according to the inventory file)
    public InventoryBag<Item> readInventory(String filename) throws IOException {
        InventoryBag<Item> itemInventoryBag=new InventoryBag<>();
        BufferedReader bufferedReader;
        try{
            String currentLine;
            bufferedReader=new BufferedReader(new FileReader(filename));
            while ((currentLine=bufferedReader.readLine())!=null){
                String lines[]=currentLine.split(",");
                int item_weight=Integer.parseInt(lines[2]);
                Item item=new Item(lines[0],lines[1],item_weight);
                itemInventoryBag.add(item);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return itemInventoryBag;
    }

}
