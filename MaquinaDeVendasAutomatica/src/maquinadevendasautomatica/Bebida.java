package maquinadevendasautomatica;

public class Bebida extends Produto{

    public Bebida(String empresa, String tipo, String nome, double preco) {
        super(tipo, nome, preco);
        this.empresa = empresa;
    }
    
    public Bebida(String tipo, String nome, double preco) {
        super(tipo, nome, preco);
    }

    public Bebida() {
    }

    private String empresa;

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    @Override
    public void receberProduto(String nome, double preco, String tipo, int quantidade){
    
        setNome(nome);setPreco(preco);setTipo(tipo);setTipo(tipo);
    }
    
}
