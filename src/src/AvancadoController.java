import java.util.Scanner;

public class AvancadoController {
    public static int create(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Insira o drible do jogador: ");
        int drible = sc.nextInt();

        return drible;
    }
}
