import java.util.Scanner;

public class Form {

    public static int inputInt(String label, int min, int max) {
        Scanner sc = new Scanner(System.in);
        int ret;

        do {
            System.out.println(label);
            ret = sc.nextInt();
        } while (ret < min || ret > max);

        return ret;
    }

    public static String inputLine(String label) {
        Scanner sc = new Scanner(System.in);
        String ret;

        System.out.println(label);
        ret = sc.nextLine();

        return ret;
    }
}
