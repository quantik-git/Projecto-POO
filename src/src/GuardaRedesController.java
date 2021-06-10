import java.util.Scanner;

public class GuardaRedesController {
    public static int create(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Insira a elasticidade do jogador: ");
        return sc.nextInt();
    }

}
