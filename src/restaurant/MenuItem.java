package restaurant;

 class MenuItem {
    private double price;
    private String name;
    private String description;
    private String category;
    private boolean newItem = true;
    MenuItem(String name, double price, String description, String category) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
    }
    double getPrice() {
        return price;
    }

    void setPrice(double price) {
        this.price = price;
    }

     String getDescription() {
        return description;
    }

     void setDescription(String description) {
        this.description = description;
    }

     String getCategory() {
        return category;
    }

     void setCategory(String category) {
        category = category;
    }

    boolean isNewItem() {
         return newItem;
     }

     void setNewItem(boolean newItem) {
         this.newItem = newItem;
     }

     String getName() {
         return name;
     }

     void setName(String name) {
         this.name = name;
     }
 }
