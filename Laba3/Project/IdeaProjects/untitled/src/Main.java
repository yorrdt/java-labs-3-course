public class Main {
    public static void main(String[] args) {

        Greenhouse winterGarden = new Greenhouse();

        Plant bushPlant = new BushPlant("Малина", "Многолетнее растение с очень развитым и извилистым корневищем, на котором образуется множество придаточных корней");
        Plant floweringPlant = new FloweringPlant("Роза", "Листопадные или вечнозеленые кустарники и кустарнички высотой от 15 см до 3 м и выше, некоторые виды с длинными (до 7-9 м), тонкими, стелющимися по земле или цепляющими за опору побегами");
        Plant indoorPlant = new IndoorPlant("Кактус", "Колючие растения, приспособившиеся к жизни в засушливых пустынях, на малоплодородных плоскогориях южных стран, относящиеся к обширному семейству кактусовых");

        winterGarden.buyPlant(bushPlant);
        winterGarden.buyPlant(floweringPlant);
        winterGarden.buyPlant(indoorPlant);

        winterGarden.getPlants();

        bushPlant.waterPlant();
        floweringPlant.setPlantLightning(true);
        indoorPlant.setTemperature(18);

        bushPlant.editName("Крыжовник", "Раскидистый кустарник с колючими ветками и съедобными плодами");

        winterGarden.getPlants();

        winterGarden.removePlant(floweringPlant);

        winterGarden.getPlants();
    }
}
