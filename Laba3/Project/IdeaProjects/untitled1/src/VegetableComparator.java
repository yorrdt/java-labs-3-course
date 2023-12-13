import java.util.Comparator;

public class VegetableComparator implements Comparator<Vegetable> {

    @Override
    public int compare(Vegetable o1, Vegetable o2) {
        if (o1.calorie == o2.calorie) return 0;

        return (o1.calorie > o2.calorie) ? 1 : -1;
    }
}
