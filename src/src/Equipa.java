import java.util.Date;
import java.util.List;

/**
 * Habilidade global em falta
 */
public class Equipa {
    private int idEquipa;
    private String nome;
    private Date data_de_fundacao;
    private List<Futebolista> plantel; // composição
    private List<Futebolista> titulares;
    private List<Futebolista> suplentes;

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("IdEquipa: ").append(this.idEquipa + "\n");
        sb.append("Nome: ").append(this.nome + "\n");
        sb.append("DataDeFundacao: ").append(this.data_de_fundacao + "\n");
        sb.append("Plantel: ").append(this.plantel + "\n");
        sb.append("Titulares: ").append(this.titulares + "\n");
        sb.append("Suplentes: ").append(this.suplentes + "\n");

        return sb.toString();
    }
}
