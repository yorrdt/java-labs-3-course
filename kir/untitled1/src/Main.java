public class Main {
    public static void main(String[] args) {

        Bouquet bouquet = new Bouquet();

        Flower redRose = new RedRose("Red rose", 4, 0.8f, 20);
        Flower orchid = new Orchid("Orchid", 6, 0.5f, 12);
        Flower gypsophila = new Gypsophila("Gypsophila", 5, 0.6f, 15);

        bouquet.addFlower(redRose, 5);
        bouquet.addFlower(orchid, 3);
        bouquet.addFlower(gypsophila, 1);

        bouquet.printBouquet();

        System.out.println("---------------------------------------------");

        bouquet.sortByFreshness();
        bouquet.printBouquet();

        System.out.println("---------------------------------------------");

        bouquet.findStemLengthInRange(12, 19);

        System.out.println("---------------------------------------------");

        float price = bouquet.getBouquetPrice();
        System.out.println("Цена на текущий собранный букет равна: " + price + "BYN");


    }
}
