import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
Занести стихотворения одного автора в список. Провести сортировку по возрастанию длин строк.
*/

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("text.txt"));

        List<String> str = new ArrayList<>();

        String line;
        while ( (line = br.readLine()) != null) {
            str.add(line);
        }

        str.sort(Comparator.comparingInt(String::length));

        for (int i = 0; i < str.size(); i++) {
            System.out.println(str.get(i));
        }
    }
}
