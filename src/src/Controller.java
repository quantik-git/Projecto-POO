import java.util.Scanner;

public class Controller {

    public void menu() {
        Scanner sc = new Scanner(System.in);

        System.out.println("O que pretende fazer?\n" +
                "1) Criar jogador" +
                "2) Criar Equipa" +
                "3) Associar jogador a uma equipa" +
                "4) Consultar os jogadores" +
                "5) Consultar as equipas" +
                "6) Mostrar um jogador" +
                "7) Mostrar uma equipa" +
                "8) Mudar um jogador de equipa");

    }

}
