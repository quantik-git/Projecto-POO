import Models.Jogo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class JogoController {
    private static Mundo mundo = Mundo.getInstance();

    public static void tabela() {
        for (Jogo jogo : mundo.getJogos()) {
            if (jogo.getGolosCasa() > jogo.getGolosVisitante());
        }
    }
}
