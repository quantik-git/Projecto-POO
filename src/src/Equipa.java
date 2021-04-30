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
}
