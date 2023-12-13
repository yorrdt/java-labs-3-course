
/*
На плоскости задано N  отрезков. Найти точку пересечения двух отрезков, имеющую минимальную абсциссу. Использовать класс TreeMap.
*/

import java.util.Map;
import java.util.TreeMap;

public class Task2 {
    public static void main(String[] args) {
        Line line1_1 = new Line(2, 2, 7,3);
        System.out.println(line1_1.getLinesCoors());
        Line line1_2 = new Line(4, 1, 5, 6);
        System.out.println(line1_2.getLinesCoors());

        // double Ya1 =
        double Xa1 = (line1_2.getB() - line1_1.getB()) / (line1_1.getTg() - line1_2.getTg());
        System.out.println(Xa1);

        Line line2_1 = new Line(10, 4, 15, 2);
        System.out.println(line2_1.getLinesCoors());
        Line line2_2 = new Line(11, 5, 12, 1);
        System.out.println(line2_2.getLinesCoors());

        double Xa2 = (line2_2.getB() - line2_1.getB()) / (line2_1.getTg() - line2_2.getTg());
        System.out.println(Xa2);

        Map<String, Double> map = new TreeMap<>();
        map.put("Line1", Xa1);
        map.put("Line2", Xa2);

        for (Map.Entry<String, Double> item : map.entrySet()) {
            System.out.println(item.getKey() + " : " + item.getValue());
        }
    }
}

class Line {
    private float x1, y1;
    private float x2, y2;
    private float tg;
    private float b;

    public Line(float x1, float y1, float x2, float y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;

        this.tg = (y1 - y2) / (x1 - x2);
        this.b = this.y1 - this.tg * this.x1;
    }

    @Override
    public String toString() {
        return "Line{" +
                "x1=" + x1 +
                ", y1=" + y1 +
                ", x2=" + x2 +
                ", y2=" + y2 +
                '}';
    }

    public float getX1() {
        return x1;
    }

    public float getY1() {
        return y1;
    }

    public float getX2() {
        return x2;
    }

    public float getY2() {
        return y2;
    }

    public float getTg() {
        return tg;
    }

    public float getB() {
        return b;
    }

    public String getLinesCoors() {
        return "(" + this.x1 + "; " + this.y1 + ")" + " - " + "(" + this.x2 + "; " + this.y2 + ")";
    }
}
