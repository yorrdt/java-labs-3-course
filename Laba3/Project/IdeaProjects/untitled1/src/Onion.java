public class Onion extends Vegetable {


    Onion(float weight, int count) {
        super(weight, count);
    }

    @Override
    public String getVegetableType() {
        return "Onion";
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
}
