import java.util.*;

/**
 * Habilidade global em falta
 */
public class Equipa {
    private static final int NUM_TITULARES = 11;
    private static final int MAX_SUPLENTES = 12;
    private static final int MIN_SUPLENTES = 3;
    //private int idEquipa;
    private String nome;
    private Date data_de_fundacao;
    private Map<Integer, Futebolista> plantel; //Numero da camisola, Jogador
    private List<Futebolista> titulares;
    private List<Futebolista> suplentes;

    public Equipa(String nome, Date data_de_fundacao, Map<Integer, Futebolista> plantel, List<Futebolista> titulares, List<Futebolista> suplentes) {
        this.nome = nome;
        this.data_de_fundacao = data_de_fundacao;
        this.plantel = plantel;
        this.titulares = titulares;
        this.suplentes = suplentes;
    }

    public Equipa(String nome, Date data_de_fundacao) {
        this.nome = nome;
        this.data_de_fundacao = data_de_fundacao;
        this.plantel = new HashMap<>();
        this.titulares = new ArrayList<>();
        this.suplentes = new ArrayList<>();
    }

    public Equipa(Equipa equipa) {
        this.nome = equipa.getNome();
        this.data_de_fundacao = equipa.getData_de_fundacao();
        this.plantel = equipa.getPlantel();
        this.titulares = equipa.getTitulares();
        this.suplentes = equipa.getSuplentes();
    }

    public static Equipa parse(String s) {
        Date data = new Date();
        return new Equipa(s, data);
    }

    public Equipa clone() {
        return new Equipa(this);
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

    public Map<Integer, Futebolista> getPlantel() {
        return plantel;
    }

    public void setPlantel(Map<Integer, Futebolista> plantel) {
        plantel.forEach(this::addPlantel);
    }

    public void addPlantel(Integer numero, Futebolista futebolista) {
        this.plantel.put(numero, futebolista.clone());
    }

    public List<Futebolista> getTitulares() {
        return titulares;
    }

    public void setTitulares(List<Futebolista> titulares) {
        titulares.forEach(this::addTitular);
    }

    /**
     * Decidir se vamos Throw Exception para sinalizar se foi possível adicionar o jogador
     * @param futebolista
     */
    public void addTitular(Futebolista futebolista) {
        if (this.titulares.size() < NUM_TITULARES) {
            this.titulares.add(futebolista);
        }
    }

    public void replaceTitular(int numero, Futebolista futebolista) {
        this.plantel.replace(numero, futebolista);
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

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Nome: ").append(this.nome + "\n");
        sb.append("DataDeFundacao: ").append(this.data_de_fundacao + "\n");
        sb.append("Plantel: ").append(this.plantel + "\n");
        sb.append("Titulares: ").append(this.titulares + "\n");
        sb.append("Suplentes: ").append(this.suplentes + "\n");

        return sb.toString();
    }
}
