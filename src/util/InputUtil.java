package util;

import java.util.Scanner;

public class InputUtil {
    private static final Scanner scanner = new Scanner(System.in);

    public static String inputString(String msg) {
        System.out.print(msg);
        return scanner.nextLine();
    }

    public static int inputInt(String msg) {
        System.out.print(msg);
        return Integer.parseInt(scanner.nextLine());
    }

    public static void closeScanner() {
        scanner.close();
    }
}