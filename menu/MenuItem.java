package menu;
import java.lang.*;

 public class MenuItem {
    private String name;
    private double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String ConvertString() {
    	String s = name + " - $" + String.format("%.2f", price);
        return s;
    }
}