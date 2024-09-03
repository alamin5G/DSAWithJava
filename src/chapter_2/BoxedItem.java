package chapter_2;

public class BoxedItem implements Sellable, Transportable{

    private int weight;
    private boolean hazardous;
    private int width;
    private int height;
    private int depth;

    private String description;
    private int price;


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
        return this.weight;
    }

    @Override
    public boolean isHazardous() {
        return this.hazardous;
    }

    public int insuredValue(){
        return this.price*2;
    }

    public void setBox(int height, int width, int depth){
        this.height = height;
        this.width = width;
        this.depth = depth;
    }
}
