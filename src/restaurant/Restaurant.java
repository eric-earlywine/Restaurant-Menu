package restaurant;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class Restaurant {
    public static void main(String[] args) {
        MenuItem item1 = new MenuItem("Crab", 6.50, "Delicious crab","Appetizer");
        MenuItem item2 = new MenuItem("Rice", 2.50, "Delicious rice","Appetizer");
        MenuItem item3 = new MenuItem("Steak", 14.50, "Delicious steak","Main Course");
        MenuItem item4 = new MenuItem("Bacon Cheeseburger", 9.50, "Delicious burger","Main Course");
        MenuItem item5 = new MenuItem("Broccoli Cheese Soup (Cup)", 3.00, "Delicious soup","Appetizer");
        MenuItem item6 = new MenuItem("Broccoli Cheese Soup (Bowl)", 6.50, "Delicious soup","Main Course");
        MenuItem item7 = new MenuItem("6 Chocolate Chip Cookies", 4.50, "Delicious cookies","Dessert");
        MenuItem item8 = new MenuItem("Pecan Pie", 3.50, "Delicious pie","Dessert");
        MenuItem item9 = new MenuItem("Crab", 3.45, "Delicious crab", "Appetizer");
        ArrayList<MenuItem> myItems = new ArrayList<>(Arrays.asList(item1, item2, item3, item4, item5, item6, item7, item8, item9));
        Menu myMenu = new Menu("Eric's restaurant");
        myMenu.add(myItems);
        myMenu.add(new MenuItem("Fries", 2.99, "Delicious fries", "Snack"), "Snack");
        myMenu.displayMenu();
        if (item1.isNewItem()) { item1.setDateAdded(LocalDate.of(2017, 3, 14)); }
        myMenu.displayMenu(item1);
        myMenu.remove(item2, item2.getCategory());
        myMenu.displayMenu();
    }
}
