import Models.Jogo;

public class JogoController {
    private static Mundo mundo = Mundo.getInstance();

    public static void tabela() {
        for (Jogo jogo : mundo.getJogos()) {
            if (jogo.getGolosCasa() > jogo.getGolosVisitante());
        }
    }
}
