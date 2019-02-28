package by.javatr.scanner;

        import java.util.Scanner;

public class EnterFromConsole {

    public static double EnterDouble() {
        Scanner scanner = new Scanner(System.in);
        double a;

        while(!scanner.hasNextDouble()) {
            scanner.nextLine();
        }

        a = scanner.nextDouble();
        return a;
    }
}