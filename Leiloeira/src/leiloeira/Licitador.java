package leiloeira;

public class Licitador {

    public Licitador(String nome, String telefone, double valorLicitado) {
        this.nome = nome;
        this.telefone = telefone;
        this.valorLicitado = valorLicitado;
    }

    public Licitador(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }
    
    public Licitador(double valorLicitado) {
        this.valorLicitado = valorLicitado;
    }
    
    public Licitador() {
    }

    private String nome;
    private String telefone;
    private double valorLicitado = 0.0;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public double getValorLicitado() {
        return valorLicitado;
    }

    public void setValorLicitado(double valorLicitado) {
        this.valorLicitado = valorLicitado;
    }

}
