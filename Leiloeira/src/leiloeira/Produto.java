package leiloeira;

public class Produto {

    public Produto(String nome, double valorMinimo) {
        this.nome = nome;
        this.valorMinimo = valorMinimo;
    }

    public Produto() {
    }

    private String nome;
    private double valorMinimo;
    private double valorInicial;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorMinimo() {
        return valorMinimo;
    }

    public void setValorMinimo(double valorMinimo) {
        this.valorMinimo = valorMinimo;
    }

    public double getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(double valorInicial) {
        this.valorInicial = valorInicial;
    }

    public String mostrarProdutos() {
        return "Nome: " + getNome() + "\nValor Minimo: " + getValorMinimo() + "\n-----------------------";
    }

    public String mostrarProdutosInicial() {
        return "Nome: " + getNome() + "\nValor Minimo: " + getValorInicial() + "\n-----------------------";
    }
}
