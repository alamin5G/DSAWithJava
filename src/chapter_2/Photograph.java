package chapter_2;

public class Photograph implements Sellable, Transportable{

    private String description;
    private int price;
    private boolean color;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    @Override
    public String description() {
        return this.description;
    }

    @Override
    public int listPrice() {
        return this.price;
    }

    @Override
    public int lowesPrice() {
        return this.price/2;
    }

    @Override
    public int weight() {
        return 0;
    }

    @Override
    public boolean isHazardous() {
        return false;
    }
}
