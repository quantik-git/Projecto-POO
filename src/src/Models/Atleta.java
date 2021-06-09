package Models;

import java.util.Date;

public class Atleta {
    //private int idAtleta;
    private String nome;
    private Date data_de_nascimento;

    public Atleta(String nome, Date data_de_nascimento) {
        this.nome = nome;
        this.data_de_nascimento = data_de_nascimento;
    }

    public Atleta(Atleta atleta) {
        this.nome =atleta.getNome();
        this.data_de_nascimento = atleta.getData_de_nascimento();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData_de_nascimento() {
        return data_de_nascimento;
    }

    public void setData_de_nascimento(Date data_de_nascimento) {
        this.data_de_nascimento = data_de_nascimento;
    }
}
