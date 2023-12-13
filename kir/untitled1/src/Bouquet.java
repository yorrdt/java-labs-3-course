import java.util.*;

public class Bouquet {
    private List<Flower> flowerList = new ArrayList<>();

    public void addFlower(Flower flower, int count) {
        for (int i = 0; i < count; i++) {
            flowerList.add(flower);
        }
    }

    public void printBouquet() {
        for (Flower f : flowerList) {
            System.out.println(f.getName() + " " + f.getStemLength() + " " + f.getFreshnessLevel() + " " + f.getPrice());
        }
    }

    public float getBouquetPrice() {
        float price = 0;

        for (Flower f : flowerList) {
            price += f.getPrice();
        }

        return price;
    }

    public void sortByFreshness() {
        flowerList.sort(new Comparator<Flower>() {
            @Override
            public int compare(Flower o1, Flower o2) {
                if (o1.getFreshnessLevel() == o2.getFreshnessLevel()) return 0;

                return (o1.getFreshnessLevel() < o2.getFreshnessLevel()) ? 1 : -1;
            }
        });
    }
    public void findStemLengthInRange(float stemLength1, float stemLength2) {
        List<Flower> output = new ArrayList<>();

        for (Flower f : flowerList) {
            if (f.getStemLength() >= stemLength1 && f.getStemLength() <= stemLength2) {
                output.add(f);
            }
        }

        for (Flower f : output) {
            System.out.println(f.getName() + " " + f.getStemLength() + " " + f.getFreshnessLevel() + " " + f.getPrice());
        }
    }
}
