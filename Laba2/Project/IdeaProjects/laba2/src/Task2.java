//: laba2/Task2.java
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Программа среди чисел находит число-палиндром.
 *
 * @version 1.0
 * @author: Egor Moroz
 * created 21.09.2023 at 11:40
 */

public class Task2 {
    /**
     * Точка входа в класс и приложение
     *
     * @param args Массив строковых аргументов
     * @throws exceptions Исключения не выдаются
     */
    public static void main(String[] args) {

        System.out.println("Developer: Moroz");

        // устанавливает формат даты
        String pattern = "dd-MM-yyyy hh:mm:ss";
        // SimpleDateFormat устанавливает формат даты обьекту simpleDateFormat
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        // Форматирование применяется к текущей дате
        String date = simpleDateFormat.format(new Date());
        // Вывод текущей даты и времени
        System.out.println("Current date: " + date);

        // Создается массив чисел
        int[] numbers = { 123, 131, 6475, 111, 343, 94849, 124 };
        // Копия массива чисел numbers для проверки равно ли первернутое число
        // Числу до переворачивания
        int[] old = { 123, 131, 6475, 111, 343, 94849, 124 };

        // Цикл проходит по  массиву numbers
        for (int i = 0; i < numbers.length; i++) {

            // revertNum сохраняет промежуточное значение перевернутого числа
            int revertNum = 0;

            // Пока число не равно нулю
            while (numbers[i] != 0) {
                // делим нацело число из массива numbers и получаем последнюю цифру
                // прибавляем цифру к revertNum
                revertNum += numbers[i] % 10;
                // умножаем revertNum на десять, чтобы получить десятки
                revertNum *= 10;
                // делим число из массива numbers на 10, чтобы отбросить последнюю цифру
                numbers[i] /= 10;
            }

            // отбрасывается нуль в конце revertNum и сравнивается со старым значением числа
            // если число палиндром, то при переворчаивании числа оно останется таким же
            if (revertNum / 10 == old[i]) {
                // вывод палиндрома в консоль
                System.out.println(old[i]);
            }
        }
    }
}
///:~


