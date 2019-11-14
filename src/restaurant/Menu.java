package restaurant;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Menu {
    private String name;
    private HashMap<String, ArrayList<MenuItem>> items = new HashMap<>();
    private Date lastUpdated;

    Menu(String name, ArrayList<MenuItem> items) {
//        ArrayList<String> categories = new ArrayList<>();
//        for (MenuItem item : items) {
//            if (!categories.contains(item.getCategory())) {
//                categories.add(item.getCategory());
//            }
//        }
//        for (String cat : categories) {
//            ArrayList<MenuItem> categoryItems = new ArrayList<>();
//            for (MenuItem item : items) {
//                if (!categoryItems.contains(item) && item.getCategory() == cat) {
//                    categoryItems.add(item);
//                }
//            }
//            this.items.put(cat, categoryItems);
//        }
        this.add(items);
        this.name = name;
        this.lastUpdated = new Date();
    }
    Menu(String name) {
        this.name = name;
        this.lastUpdated = new Date();
    }
    void add(MenuItem item, String cat) {
        if (this.items.containsKey(cat)) {
            this.items.get(cat).add(item);
        } else {
            ArrayList<MenuItem> thisList = new ArrayList<>();
            thisList.add(item);
            this.items.put(cat, thisList);
        }
        this.lastUpdated = new Date();
    }
    void add(ArrayList<MenuItem> items) {
        ArrayList<String> categories = new ArrayList<>();
        for (MenuItem item : items) {
            if (!categories.contains(item.getCategory())) {
                categories.add(item.getCategory());
            }
        }
        for (String cat : categories) {
            ArrayList<MenuItem> categoryItems = new ArrayList<>();
            for (MenuItem item : items) {
                if (!categoryItems.contains(item) && item.getCategory() == cat) {
                    categoryItems.add(item);
                }
            }
            this.items.put(cat, categoryItems);
        }
    }
    void remove(MenuItem item, String cat) {
        for (String key : this.items.keySet()) {
            if (this.items.get(key).contains(item)) {
                this.items.get(key).remove(item);
            }
        }
        this.lastUpdated = new Date();
    }
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
}
