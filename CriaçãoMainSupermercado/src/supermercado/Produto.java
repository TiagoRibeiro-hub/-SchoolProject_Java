package supermercado;


public class Produto {
    // construtores
    public Produto(String valorNome, String valorRef, double valorPreco, double valorIva){
        nome = valorNome;
        referencia = valorRef;
        preco = valorPreco;
        iva = valorIva / 100;
    }
    
    // atributos
    private String nome;
    private String referencia;
    private double preco;
    private double iva;
    private double precoIva;
    
    
    // metodos
    public String getNome(){return nome;}
    public void setNome(String valorMarca){nome = valorMarca;}
    public void verNome(){
        System.out.print("Nome do Produto: "+ nome);
    } 
    
    public String getRef(){return referencia;}
    public void setRef(String valorReferencia){referencia = valorReferencia;}
    public void verRef(){
        System.out.print("Referência: "+ referencia);
    }
    
    public double getPreco(){return preco;}
    public void setPreco(double valorPreco){preco = valorPreco;}
    public void verPreco(){
        System.out.print("Preço: "+ preco + " $");
    }
    
    public double getIva(){return iva;}
    public void setIva(double valorIva){iva = valorIva;}
    public void verIva(){
        System.out.print("IVA: " + iva + " %");
    }
    
    public double getPrecoIva(){
        return preco * iva + preco;
    }
   
}    

