public interface Plant {
    String getName();
    String getDescription();
    void setTemperature(float temperature);
    void waterPlant();

    void setPlantLightning(boolean isLight);
    void editName(String newName, String newDescription);
    void getPlant();
}
