import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 * @author Moroz,
 * created 21.09.2023 at 11:40
 */

public class MainClass {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("text.txt");

        int c;
        int sum = 0;
        while ((c = inputStream.read()) != -1) {
            if (c >= 48 && c <= 57) {
                sum += Integer.parseInt(String.valueOf((char) c));
            }
        }
        System.out.print((sum));
    }
}

class Nikita {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("text2.txt");
        String str = "the longDan is a capitel if graet birtan.white lives matter";
        String[] arr = str.split("\\.");

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i].charAt(0);
            arr[i] = arr[i].replace(c,Character.toUpperCase(c));
        }
        System.out.println(Arrays.toString(arr));
    }
}
