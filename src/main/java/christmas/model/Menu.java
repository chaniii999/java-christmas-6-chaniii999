package christmas.model;

public class Menu {

    private final String name;
    private final int price;
    private final String type;
    private final int count;

    public Menu(String name,int price,String type,int count) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public int getCount() {
        return count;
    }



}
