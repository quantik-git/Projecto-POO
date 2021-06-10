import java.util.Scanner;

public class MedioController {
    public static int create(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Insira a recuperacao do jogador: ");
        int recuperacao = sc.nextInt();

        return recuperacao;
    }
}
