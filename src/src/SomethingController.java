import Models.Equipa;

import java.util.Scanner;

public class SomethingController {
    public static void novoJogo() {
        Mundo mundo = Mundo.getInstance();
        Scanner sc = new Scanner(System.in);
        String equipaEscolhida = "";

        for (String nome : mundo.getEquipas().keySet()) {
            System.out.println(nome);
        }

        equipaEscolhida = sc.nextLine();

        mundo.setEquipaEscolhida(equipaEscolhida);
    }
}
