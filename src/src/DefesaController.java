import java.util.Scanner;

public class DefesaController {
    public static int create(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Insira o roubo de bola do jogador: ");
        int roubo_de_bola = sc.nextInt();

        return roubo_de_bola;
    }

}
