import java.util.ArrayList;
import java.util.List;

public class Greenhouse {
    private List<Plant> plantList = new ArrayList<>();

    Greenhouse() { }

    public void getPlants() {
        System.out.println("Plants in greenhouse: ");
        for (Plant plant : plantList) {
            System.out.println(plant.getName() + " : " + plant.getDescription());
        }
    }

    public void buyPlant(Plant plant) {
        this.plantList.add(plant);
        System.out.println("Plant " + plant.getName() + " was purchased");
    }

    public void removePlant(Plant plant) {

        String plantName = plant.getName();

        for (Plant p : plantList) {
            if (plant == p) {
                plantList.remove(p);
                System.out.println("Removed plant " + plantName);
                return;
            }

        }
        System.out.println("Plant not found");
    }

}
