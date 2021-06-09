import Models.Equipa;

public class EquipaController {
    Mundo mundo = Mundo.getInstance();

    public void index() {
        for (String equipa : mundo.getEquipas().keySet()) {
            System.out.println(equipa);
        }
    }

    public void transferir(String vendedor, String comprador, String nome) {
        Equipa ant = mundo.getEquipa(vendedor);
        Equipa prox = mundo.getEquipa(comprador);


    }

    public void show(String nome) {
        Equipa escolhido = mundo.getEquipa(nome);

        System.out.println(escolhido.toString());
    }

    public Equipa create(String nome) {
        return new Equipa(nome);
    }
}
