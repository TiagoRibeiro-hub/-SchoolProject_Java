package maquinadevendasautomatica;

public abstract class Produto {

    public Produto(String tipo, String nome, double preco) {
        this.tipo = tipo;
        this.nome = nome;
        this.preco = preco;
    }
    
    public Produto(){};
    
    private String tipo;
    private String nome;
    private double preco;
    private int quantidade;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public void receberProduto(String nome, double preco, String tipo, int quantidade){};
 
}
