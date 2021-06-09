import java.util.Scanner;

public class LateralController {
    public static int create(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Insira o cruzamento do jogador: ");
        int cruzamento = sc.nextInt();

        sc.close();
        return cruzamento;
    }
}
