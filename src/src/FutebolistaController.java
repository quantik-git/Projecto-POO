import Models.*;

public class FutebolistaController {
    private static Mundo mundo = Mundo.getInstance();

    public void index() {
        for (Futebolista futebolista : mundo.getFutebolistas()) {
            show(futebolista.getNome());
        }
    }

    public void show(String nome) {
        Futebolista escolhido = mundo.getFutebolista(nome);

        System.out.println(escolhido.toString());
    }

    public static void show(Futebolista escolhido) {
        System.out.println(escolhido.toString());
    }

    public static void create(){
        // TODO menu tem opção de sair que não devia ser possivel
        String[] options = {
                "Guarda-Redes",
                "Defesa",
                "Lateral",
                "Medio",
                "Avançado"
        };

        int tipodejogador = Menu.gerar(options);

        String nome = Form.inputLine("Insira o nome do jogador: ");
        int velocidade = Form.inputInt("Insira a velocidade do jogador: ", 0, 100);
        int resistencia = Form.inputInt("Insira a resistencia do jogador: ", 0, 100);
        int destreza =  Form.inputInt("Insira a destreza do jogador: ", 0, 100);
        int impulsao =  Form.inputInt("Insira a impulsao do jogador: ", 0, 100);
        int cabeceamento = Form.inputInt("Insira o cabeceamento do jogador: ", 0, 100);
        int remate = Form.inputInt("Insira o remate do jogador: ", 0, 100);
        int passe = Form.inputInt("Insira o passe do jogador: ", 0, 100);

        Futebolista jogador = null;

        switch (tipodejogador) {
            case 1:
                int elasticidade = GuardaRedesController.create();
                jogador = new GuardaRedes(nome, numero, velocidade, resistencia, destreza, impulsao, cabeceamento, remate, passe, elasticidade);
                break;
            case 2:
                int roubo_de_bola = DefesaController.create();
                jogador = new Defesa(nome, numero, velocidade, resistencia, destreza, impulsao, cabeceamento, remate, passe, roubo_de_bola);
                break;
            case 3:
                int cruzamento = LateralController.create();
                jogador = new Lateral(nome, velocidade, resistencia, destreza, impulsao, cabeceamento, remate, passe, cruzamento);
                break;
            case 4:
                int recuperacao = MedioController.create();
                jogador = new Medio(nome, velocidade, resistencia, destreza, impulsao, cabeceamento, remate, passe, recuperacao);
                break;
            case 5:
                int drible = AvancadoController.create();
                jogador = new Avancado(nome, velocidade, resistencia, destreza, impulsao, cabeceamento, remate, passe, drible);
                break;
        }

        show(jogador);

        mundo.addFutebolista(jogador);
    }
}
