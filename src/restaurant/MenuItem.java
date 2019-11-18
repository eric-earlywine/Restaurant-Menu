package restaurant;

import java.time.LocalDate;
import java.util.Objects;

class MenuItem {
    private double price;
    private String name;
    private String description;
    private String category;
    private LocalDate dateAdded;
    MenuItem(String name, double price, String description, String category) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category.toUpperCase();
        this.dateAdded = LocalDate.now();
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
        LocalDate newDate = this.dateAdded.plusDays(16);
        LocalDate today = LocalDate.now();
         if (today.isBefore(newDate)) { return true; }
         return false;
    }

     String getName() {
         return name;
     }
    LocalDate getDateAdded() {
        return dateAdded;
    }
    void setDateAdded(LocalDate date) {
        this.dateAdded = date;
    }
     void setName(String name) {
         this.name = name;
     }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuItem menuItem = (MenuItem) o;
        return Objects.equals(name, menuItem.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
