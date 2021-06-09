import java.util.Date;

public class Atleta {

    private String nome;

    public Atleta(String nome) {
        this.nome = nome;
    }

    public Atleta(Atleta atleta) {
        this.nome =atleta.getNome();

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
