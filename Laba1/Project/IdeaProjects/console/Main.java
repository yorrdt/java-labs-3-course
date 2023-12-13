import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

	System.out.print("Введите имя: ");

	Scanner in = new Scanner(System.in);
        String name = in.nextLine();

        System.out.println("Добро пожаловать, " + name);

	int sum = 0;
	int proizv = 1;
        for(String i : args) {
		sum += Integer.parseInt(i);
		proizv *= Integer.parseInt(i);
        }

	System.out.println("sum: " + sum);
	System.out.println("proizv: " + proizv);
    }
}
