import Models.*;

import java.util.Scanner;

public class FutebolistaController {
    Mundo mundo = Mundo.getInstance();

    public void index() {
        for (Futebolista futebolista : mundo.getFutebolistas()) {
            System.out.println(futebolista.getNome());
        }
    }

    public void show(String nome) {
        Futebolista escolhido = mundo.getFutebolista(nome);

        System.out.println(escolhido.toString());
    }

    public Futebolista create(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Que tipo de jogador pretende criar?\n" +
                           "1) Guarda-Redes\n" +
                           "2) Defesa\n" +
                           "3) Lateral\n" +
                           "4) Medio\n" +
                           "5) Avancado");
        int tipodejogador = sc.nextInt();

        while (tipodejogador > 5 || tipodejogador < 0){
            System.out.println("Jogador inválido, insira novamente: ");
            tipodejogador = sc.nextInt();
        }
        System.out.println("Insira o nome do jogador: ");
        String nome = sc.nextLine();
        System.out.println("Insira o numero do jogador: ");
        int numero = sc.nextInt();
        System.out.println("Insira a velocidade do jogador: ");
        int velocidade = sc.nextInt();
        System.out.println("Insira a resistencia do jogador: ");
        int resistencia = sc.nextInt();
        System.out.println("Insira a destreza do jogador: ");
        int destreza = sc.nextInt();
        System.out.println("Insira a impulsao do jogador: ");
        int impulsao = sc.nextInt();
        System.out.println("Insira o cabeceamento do jogador: ");
        int cabeceamento = sc.nextInt();
        System.out.println("Insira o remate do jogador: ");
        int remate = sc.nextInt();
        System.out.println("Insira o passe do jogador: ");
        int passe = sc.nextInt();

        Futebolista jogador = null;

        switch (tipodejogador){
            case 1:
                int elasticidade = GuardaRedesController.create();
                jogador = new GuardaRedes(nome, numero, velocidade, resistencia, destreza, impulsao, cabeceamento, remate, passe, elasticidade);
                break;
            case 2:
                int roubo_de_bola = DefesaController.create();
                jogador = new Defesa(nome, numero, velocidade, resistencia, destreza, impulsao, cabeceamento, remate, passe, roubo_de_bola);
                break;
            case 3: int cruzamento = LateralController.create();
                    jogador = new Lateral(nome, numero, velocidade, resistencia, destreza, impulsao, cabeceamento, remate, passe, cruzamento);
                    break;
            case 4: int recuperacao = MedioController.create();
                    jogador = new Medio(nome, numero, velocidade, resistencia, destreza, impulsao, cabeceamento, remate, passe, recuperacao);
                    break;
            case 5: int drible = AvancadoController.create();
                    jogador = new Avancado(nome, numero, velocidade, resistencia, destreza, impulsao, cabeceamento, remate, passe, drible);
                    break;
            default:
                System.out.println("Ups!");
        }

        sc.close();
        return jogador;
    }
}
