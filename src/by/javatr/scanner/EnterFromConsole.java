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

    public static String EnterString() {
        Scanner scanner = new Scanner(System.in);
        String a;

        while(!scanner.hasNextLine()) {
            scanner.nextLine();
        }

        a = scanner.nextLine();
        return a;
    }
}