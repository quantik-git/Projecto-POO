import Models.Equipa;
import Models.Jogo;

import java.util.concurrent.TimeUnit;
import java.util.Random;

public class JogoController {
    private static Mundo mundo = Mundo.getInstance();

    public static void simularJogo() {
        Random rand = new Random();
        int atacante = rand.nextInt(2);
        Jogo jogo = null;
        String[] equipas = mundo.getEquipas().keySet()
                .stream().filter(nome -> !nome.equals(mundo.getEquipaEscolhida())).toArray(String[]::new);

        int escolha = Menu.gerar(equipas);

        if (escolha == 0) return;

        Equipa[] participantes = {
                mundo.getEquipa(equipas[escolha - 1]),
                mundo.getEquipa(mundo.getEquipaEscolhida())
        };

        if (participantes[0].getTitulares().size() < Equipa.NUM_TITULARES)
            EquipaController.definirTitulares(participantes[0].getNome());

        if (participantes[0].getTitulares().size() < Equipa.MIN_SUPLENTES)
            EquipaController.definirSuplentes(participantes[0].getNome());

        jogo = new Jogo(participantes[1].getNome(), participantes[0].getNome());

        System.out.println("Inicio do jogo");
        for (int i = 0; i < 18; i++) {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException ignored) {}

            System.out.println(participantes[atacante].getNome() + " ataca");

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException ignored) {}

            // calcula resultado do ataque
            int sorte = rand.nextInt(75) + 1;
            int ataque = (int) ((float) participantes[atacante].getOverall() * 0.70 + (float) sorte * 0.30);
            if (ataque > participantes[atacante ^ 1].getOverall()) {
                System.out.println(participantes[atacante].getNome() + " marca!");

                if (atacante == 0)
                    jogo.addGolosVisitante();
                else
                    jogo.addGolosCasa();
            } else {
                System.out.println(participantes[atacante].getNome() + " falha!");
            }

            atacante ^= 1;
        }

        System.out.println(jogo.getCasa() + "  -  " + jogo.getVisitante());
        System.out.println(jogo.getGolosCasa() + " - " + jogo.getGolosVisitante());
    }

    public static void consultarJogo() {
        for (Jogo jogo : mundo.getJogos()) {
            System.out.println(jogo.toString());
        }
    }
}
