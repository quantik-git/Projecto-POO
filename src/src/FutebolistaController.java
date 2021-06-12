import Models.*;
import Views.Form;
import Views.Menu;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class FutebolistaController {
    private static Mundo mundo = Mundo.getInstance();

    public static void consultarJogador() {
        int escolha = Menu.gerar(mundo.getFutebolistas().stream().map(Futebolista::toStringEsp).toArray(String[]::new));

        show(mundo.getFutebolistas().get(escolha - 1));
    }

    public static void show(Futebolista escolhido) {
        System.out.println(escolhido.toString());
    }

    public static Futebolista create() {
        ArrayList<Callable<Futebolista>> commands = new ArrayList<>();
        Futebolista jogador = null;
        String[] options = {
                "Guarda-Redes",
                "Defesa",
                "Lateral",
                "Medio",
                "Avançado"
        };

        int tipodejogador = Menu.gerar(options);

        if (tipodejogador == 0) return null;

        String nome = Form.inputLine("Insira o nome do jogador: ");
        int velocidade = Form.inputInt("Insira a velocidade do jogador: ", 0, 100);
        int resistencia = Form.inputInt("Insira a resistencia do jogador: ", 0, 100);
        int destreza =  Form.inputInt("Insira a destreza do jogador: ", 0, 100);
        int impulsao =  Form.inputInt("Insira a impulsao do jogador: ", 0, 100);
        int cabeceamento = Form.inputInt("Insira o cabeceamento do jogador: ", 0, 100);
        int remate = Form.inputInt("Insira o remate do jogador: ", 0, 100);
        int passe = Form.inputInt("Insira o passe do jogador: ", 0, 100);
        int especial = Form.inputInt("Insira o atributo especial do jogador: ", 0, 100);

        commands.add(() -> null);
        commands.add(() -> new GuardaRedes(nome, null, velocidade, resistencia, destreza, impulsao, cabeceamento, remate, passe, especial));
        commands.add(() -> new Defesa(nome, null, velocidade, resistencia, destreza, impulsao, cabeceamento, remate, passe, especial));
        commands.add(() -> new Lateral(nome, null, velocidade, resistencia, destreza, impulsao, cabeceamento, remate, passe, especial));
        commands.add(() -> new Medio(nome, null, velocidade, resistencia, destreza, impulsao, cabeceamento, remate, passe, especial));
        commands.add(() -> new Avancado(nome, null, velocidade, resistencia, destreza, impulsao, cabeceamento, remate, passe, especial));

        try {
            jogador = commands.get(tipodejogador).call();
        } catch (Exception ignored) {}

        // caso escolham sair
        if (jogador == null) return null;

        show(jogador);
        mundo.addFutebolista(jogador);

        return jogador;
    }
}
