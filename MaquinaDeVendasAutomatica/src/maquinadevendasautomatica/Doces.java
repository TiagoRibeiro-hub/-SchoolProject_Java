package maquinadevendasautomatica;

public class Doces extends Comida{

    public Doces(String empresa, String tipo, String nome, double preco) {
        super(empresa, tipo, nome, preco);
    }
    
    public Doces(String tipo, String nome, double preco) {
        super(tipo, nome, preco);
    }

    public Doces() {
    }
    
    @Override
    public void receberProduto(String nome, double preco, String tipo, int quantidade){
    
        setNome(nome);setPreco(preco);setTipo(tipo);setTipo(tipo);
    }
}
