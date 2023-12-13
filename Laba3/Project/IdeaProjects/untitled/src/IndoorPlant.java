public class IndoorPlant implements Plant{

    private boolean isWatered = false;
    private float temperature = 18;
    private boolean isLight = false;
    private String name;
    private String description;

    IndoorPlant(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public void setTemperature(float temperature) {
        this.temperature = temperature;
        System.out.println(this.getName() + " set temperature to " + this.temperature);
    }

    @Override
    public void waterPlant() {
        this.isWatered = true;
        System.out.println(this.getName() + " is watered");
    }

    @Override
    public void setPlantLightning(boolean isLight) {
        this.isLight = isLight;
        System.out.println("For " + this.getName() + " set light to " + this.isLight);
    }

    @Override
    public void editName(String newName, String newDescription) {
        this.name = newName;
        this.description = newDescription;
    }

    @Override
    public void getPlant() {
        System.out.println("Plant name: " + this.name);
        System.out.println("Plant description" + this.description);
    }
}
