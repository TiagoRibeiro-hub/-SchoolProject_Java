package maquinadevendasautomatica;

public class Salgados extends Comida{

    public Salgados(String empresa, String tipo, String nome, double preco) {
        super(empresa, tipo, nome, preco);
    }

    public Salgados(String tipo, String nome, double preco) {
        super(tipo, nome, preco);
    }

    public Salgados() {
    }
    
    @Override
    public void receberProduto(String nome, double preco, String tipo, int quantidade){
    
        setNome(nome);setPreco(preco);setTipo(tipo);setTipo(tipo);
    }
    
}
