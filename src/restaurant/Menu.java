package restaurant;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Menu {
    private String name;
    public HashMap<String, ArrayList<MenuItem>> items = new HashMap<>();
    private Date lastUpdated;

    Menu(String name, ArrayList<MenuItem> items) {
        this.add(items);
        this.name = name;
        this.lastUpdated = new Date();
    }
    Menu(String name) {
        this.name = name;
        this.lastUpdated = new Date();
    }
    void add(MenuItem item, String cat) {
        cat = cat.toUpperCase();
        if (this.items.containsKey(cat)) {
            if (this.items.get(cat).contains(item)) {
                System.out.println("Duplicate menu item prevented from being added.");
                return;
            }
            this.items.get(cat).add(item);
        } else {
            ArrayList<MenuItem> thisList = new ArrayList<>();
            thisList.add(item);
            this.items.put(cat, thisList);
        }
        this.lastUpdated = new Date();
    }
    void add(ArrayList<MenuItem> items) {
        for (MenuItem item : items) {
            this.add(item, item.getCategory());
        }
    }
    boolean remove(MenuItem item, String cat) {
        for (String key : this.items.keySet()) {
            if (this.items.get(key).contains(item)) {
                this.items.get(key).remove(item);
                this.lastUpdated = new Date();
                return true;
            }
        }
        return false;
    }
    void remove(ArrayList<MenuItem> items) {
        for (MenuItem item : items) {
            this.remove(item, item.getCategory());
        }
    }
    Date getLastUpdated() { return this.lastUpdated; }
    void displayMenu() {
        System.out.println("*******" + this.name.toUpperCase() + "********");
        for (String cat : this.items.keySet()) {
            System.out.println("\n" + cat.toUpperCase() + "\n----------------------");
            for (MenuItem item : this.items.get(cat)) {
                String str = "";
                if (item.isNewItem()) {
                    str = "***NEW***";
                }
                System.out.println("\n*****\nName: " + item.getName() + " " + str);
                System.out.println("Description: " + item.getDescription());
                System.out.println("Price: " + item.getPrice());
            }
        }
        System.out.println("Our dynamic menu was just updated on: " + this.lastUpdated + "!!");
    }
    void displayMenu(MenuItem item) {
        System.out.println("*******" + this.name.toUpperCase() + "********");
        System.out.println("\n" + item.getCategory() + "\n----------------------");
        String str = "";
        if (item.isNewItem()) {
            str = "***NEW***";
        }
        System.out.println("\n*****\nName: " + item.getName() + " " + str);
        System.out.println("Description: " + item.getDescription());
        System.out.println("Price: " + item.getPrice());
        System.out.println("Item added on: " + item.getDateAdded());
    }
    void displayMenu(String category) {
        category = category.toUpperCase();
        if (this.items.containsKey(category)) {
            System.out.println("*******" + this.name.toUpperCase() + "********");
            System.out.println("\n" + category + "\n----------------------");
            for (MenuItem item : this.items.get(category)) {
                String str = "";
                if (item.isNewItem()) {
                    str = "***NEW***";
                }
                System.out.println("\n*****\nName: " + item.getName() + " " + str);
                System.out.println("Description: " + item.getDescription());
                System.out.println("Price: " + item.getPrice());
            }
        } else {
            System.out.println("No category, " + category + ", found.");
        }
    }
}
