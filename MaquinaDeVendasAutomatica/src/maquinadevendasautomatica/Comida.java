package maquinadevendasautomatica;

public class Comida extends Produto {

    public Comida(String empresa, String tipo, String nome, double preco) {
        super(tipo, nome, preco);
        this.empresa = empresa;
    }
    
    public Comida(String tipo, String nome, double preco) {
        super(tipo, nome, preco);
    }

    public Comida() {
    }
     
    private String empresa;

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
 
    @Override
    public void receberProduto(String nome, double preco, String tipo, int quantidade){};
}
