import java.util.Date;
import java.util.List;

/**
 * Habilidade global em falta
 */
public class Equipa {
    private static final int MAX_TITULARES = 11;
    private static final int MAX_SUPLENTES = 11;
    private int idEquipa;
    private String nome;
    private Date data_de_fundacao;
    private List<Futebolista> plantel; // composição
    private List<Futebolista> titulares;
    private List<Futebolista> suplentes;

    public Equipa(int idEquipa, String nome, Date data_de_fundacao, List<Futebolista> plantel, List<Futebolista> titulares, List<Futebolista> suplentes) {
        this.idEquipa = idEquipa;
        this.nome = nome;
        this.data_de_fundacao = data_de_fundacao;
        this.plantel = plantel;
        this.titulares = titulares;
        this.suplentes = suplentes;
    }

    public Equipa(Equipa equipa) {
        this.idEquipa = equipa.getIdEquipa();
        this.nome = equipa.getNome();
        this.data_de_fundacao = equipa.getData_de_fundacao();
        this.plantel = equipa.getPlantel();
        this.titulares = equipa.getTitulares();
        this.suplentes = equipa.getSuplentes();
    }

    public Equipa clone() {
        return new Equipa(this);
    }

    public int getIdEquipa() {
        return idEquipa;
    }

    public void setIdEquipa(int idEquipa) {
        this.idEquipa = idEquipa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData_de_fundacao() {
        return data_de_fundacao;
    }

    public void setData_de_fundacao(Date data_de_fundacao) {
        this.data_de_fundacao = data_de_fundacao;
    }

    public List<Futebolista> getPlantel() {
        return plantel;
    }

    public void setPlantel(List<Futebolista> plantel) {
        plantel.forEach(this::addPlantel);
    }

    public void addPlantel(Futebolista futebolista) {
        this.plantel.add(futebolista.clone());
    }

    public List<Futebolista> getTitulares() {
        return titulares;
    }

    public void setTitulares(List<Futebolista> titulares) {
        titulares.forEach(this::addTitular);
    }

    /**
     * Decidir se vamos return boolean para sinalizar se foi possível adicionar o jogador
     * @param futebolista
     */
    public void addTitular(Futebolista futebolista) {
        if (this.titulares.size() < MAX_TITULARES) {
            this.titulares.add(futebolista);
        }
    }

    public void replaceTitular(int index, Futebolista futebolista) {
        this.plantel.set(index, futebolista);
    }

    public List<Futebolista> getSuplentes() {
        return suplentes;
    }

    public void setSuplentes(List<Futebolista> suplentes) {
        suplentes.forEach(this::addSuplente);
    }

    public void addSuplente(Futebolista suplente) {
        if (this.suplentes.size() < MAX_SUPLENTES) {
            this.suplentes.add(suplente);
        }
    }
}
