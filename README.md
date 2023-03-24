The Shopping App

```
● Strings
● Arrays
● File I/O
● ADTs
● Generics
● Bags
```
You are expected to implement “The Shopping App” using Java. In the app, the user has a fridge to fill
and she/he can go to the mall to buy groceries.

When the user goes to the mall to shop, she/he has a basket with a size of 2000 grams. The user adds
products to the basket. During shopping, the user can check the items that are in the basket already. If
an item that the user selects cannot be added to the basket because of exceeding the basket capacity,
your program should print a warning message. Shopping is finished when the user enters finish
shopping, or the basket is full.

The items in the inventory of the mall are listed together in “inventory.txt” file where each line is formed
as:

```
item_name,item_compartment,item_weight(grams)
```
After finishing shopping, the user heads home to fill her/his fridge. The fridge has four compartment
with their limited size:

[0] Vegetables and Fruits 3000 grams
[1] Meats 5000 grams
[2] Beverages 4000 grams
[3] Snacks 2000 grams

Each item has to be put into their corresponding compartment. During the program run, you should be
able to check the status of the fridge (remaining capacities of each compartment). If some of the items
cannot be put to their corresponding compartments according to their remaining capacity, your program
has to print a warning message. (e.g. If the remaining capacity of Vegetables and Fruits is 200 grams
and you try to add a tomato to the fridge, the program should print a message like “tomato cannot be
added to the fridge”).

After filling the fridge, the user can go shopping again, and return back to fill her/his fridge. Your
program should end when the user enters exit, or all compartments are full.


Your code must have the interface, class and method implementations given below.The bullets (I), (C),
and (M) stand for interface, class, method respectively.

I. IBag

```
M. public boolean add(T newItem);
```
```
M. public boolean isEmpty();
```
```
M. public boolean isFull();
```
```
M. public T removeByIndex(int index);
```
```
M. public T remove();
```
```
M. public T remove(T item);
```
```
M. public int getItemCount();
```
```
M. public int getIndexOf(T item);
```
```
M. public boolean contains(T item);
```
```
M. public void displayItems();
```
```
M. public void dump(); // removes all the items from the bag
```
```
M. public boolean transferTo(IBag<T> targetBag, T item);
```
C. ShoppingApp

```
M. public static void main(String[] args);
```
C. FileIO

```
M. public static InventoryBag<Item> readInventory();
```
C. Item

```
M. public String toString();
```
```
M. public boolean equals(Object obj);
```
C. ShoppingBasket implements IBag

C. MeatsCompartment implements IBag

C. VegetablesFruitsCompartment implements IBag

C. BevaragesCompartment implements IBag

C. SnacksCompartment implements IBag

p.s. You can add more classes and methods to your program according to your design.



