public class Main {
    public static void main(String[] args) {

        Salad salad = new Salad();

        Vegetable tomato = new Tomato(400, 4);
        Vegetable onion = new Onion(100, 6);
        Vegetable cucumber = new Cucumber(100, 1);

        salad.addIngredient(tomato);
        salad.addIngredient(onion);
        salad.addIngredient(cucumber);

        salad.getSaladIngredients();

        System.out.println("After sorting: ");
        salad.getCalorieFromRange(20, 150);
    }
}
