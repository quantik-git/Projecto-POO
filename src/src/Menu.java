import java.util.Scanner;

public class Menu {
    public static int gerar(String[] options) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int selected = -1;

        while (selected < 0 || selected > options.length) {
            sb.append("\n** MENU **\n");
            for (int i = 0; i < options.length; i++) {
                sb.append((i + 1)).append(" - ").append(options[i]).append("\n");
            }
            sb.append("0 - Sair");

            System.out.println(sb);
            selected = sc.nextInt();
        }

        return selected;
    }
}
