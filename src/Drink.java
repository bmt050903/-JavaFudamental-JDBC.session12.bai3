public abstract class Drink implements IPromotion {
    protected int id;
    protected String name;
    protected double price;


    public Drink(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public abstract void prepare();

    @Override
    public void applyDiscount(double percentage) {
        price = price - (price * percentage / 100);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
