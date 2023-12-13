public abstract class Flower {

    private String name;
    private float price;
    private float freshnessLevel;
    private float stemLength;

    public Flower(String name, float price, float freshnessLevel, float stemLength) {
        this.name = name;
        this.price = price;
        this.freshnessLevel = freshnessLevel;
        this.stemLength = stemLength;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public float getFreshnessLevel() {
        return freshnessLevel;
    }

    public float getStemLength() {
        return stemLength;
    }
}
