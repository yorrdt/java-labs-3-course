import java.util.TreeSet;

public class Salad {

    VegetableComparator vegetableComparator = new VegetableComparator();
    TreeSet<Vegetable> salad = new TreeSet<Vegetable>(vegetableComparator);
    Salad() { }

    public void addIngredient(Vegetable ingredient) {
        this.salad.add(ingredient);
    }

    public void getSaladIngredients() {
        for (Vegetable v : salad) {
            System.out.println(v.getVegetableType() + " " + v.count + " " + v.weight + " " + v.calorie);
        }
    }

    private void printIngredientInfo(Vegetable v) {
        System.out.println(v.getVegetableType() + " " + v.count + " " + v.weight + " " + v.calorie);
    }

    void getCalorieFromRange(float cr1, float cr2) {
        for (Vegetable v : salad) {
            if (v.getCalorie() >= cr1 && v.getCalorie() <= cr2) {
                this.printIngredientInfo(v);
            }
        }
    }
}
