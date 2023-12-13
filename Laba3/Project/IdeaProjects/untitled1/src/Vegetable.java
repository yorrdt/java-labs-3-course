public abstract class Vegetable {
    protected final float calorie;
    protected final float weight;
    protected final int count;

    public Vegetable(float weight, int count) {
        this.calorie = (int) Math.floor( ((weight / 100) * 23) * count );
        this.weight = weight;
        this.count = count;
    }

    public abstract float getCalorie();
    public abstract int getCount();
    public abstract float getWeight();
    public abstract String getVegetableType();
}
