public class Cucumber extends Vegetable {

    Cucumber(float weight, int count) {
        super(weight, count);
    }

    @Override
    public float getCalorie() {
        return super.calorie;
    }

    @Override
    public int getCount() {
        return super.count;
    }

    @Override
    public float getWeight() {
        return super.weight;
    }

    @Override
    public String getVegetableType() {
        return "Cucumber";
    }
}
