import java.util.Scanner;

public class GuardaRedesController {
    public static int create(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Insira a elasticidade do jogador: ");
        int elasticidade = sc.nextInt();

        sc.close();
        return elasticidade;
    }

}
