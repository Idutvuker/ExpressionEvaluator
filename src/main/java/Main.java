import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Evaluator evaluator = new Evaluator();

        System.out.println("Hello");

        System.out.println("Enter expression");
        while (true) {
            try {
                System.out.println(evaluator.eval(scanner.nextLine()));
                break;
            } catch (Exception e) {
                System.out.println("Invalid expression! Enter valid one:");
            }
        }

    }
}
