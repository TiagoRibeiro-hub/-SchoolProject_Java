package supermercado;
import supermercado.Produto;
import util.Teclado;
import java.util.ArrayList;

public class MainClass {
    public static void main(String[] args){
        
        Teclado t = new Teclado();
        int opcao;
        
        ArrayList<Produto> carrinho = new ArrayList<>();
        
        do{
            System.out.println("\n===Menu Principal====");
            System.out.println("1--> Adicionar Produto");
            System.out.println("2--> Ver Carrinho");
            System.out.println("0--> Sair\n");
            System.out.print("Introduza uma opção: ");
            opcao = t.getInt();
            
            if(opcao == 0){
                System.out.println("Tenha um bom dia!!");
                
            }else if(opcao == 1){
                System.out.println("\n===Dados do Produto==");
                String nome; String referencia;
                double preco; double iva;
                
            // ler dados    
                System.out.print("-introduza o nome: ");
                nome = t.getText();
                System.out.print("-introduza a referencia: ");
                referencia = t.getText();
                System.out.print("-introduza o preco: ");
                preco = t.getDouble();
                System.out.print("-introduza o IVA %: ");
                iva = t.getDouble();
                
            // criar produto e adicionar ao carrinho
                carrinho.add(new Produto(nome, referencia, preco, iva));            //Produto temp = new Produto(marca, referencia, preco, iva);
                System.out.print("Produto adicionado!!");                                                                  //carrinho.add(temp);
     
            }else if(opcao == 2){
                System.out.println("\n==Produtos no Carrinho==");
                double total = 0;
                
                // percorrer as entradas do carrinho e calcular o total a pagar
                for(Produto p:carrinho){
                    System.out.println("\n"+ p.getNome() +"->"+ p.getPrecoIva());
                    total += p.getPrecoIva();
                }
                System.out.println("\nO total a pagar é de: "+total+" $");
                
            }else{
                System.out.println("Opção inválida!!\n");
            }
            
            
        }while(opcao!=0);
        
        
        
        
        
        
//        Produto arroz = new Produto("Continente", "arr", 5.50, 6.0);
//        Produto laranjas = new Produto("Algarve", "lar", 8.0, 13.5);
//        Produto vassoura = new Produto("Continente", "vass", 3.50, 23.0);
//        
//        arroz.verMarca(); System.out.println();
//        arroz.verRef(); System.out.println();
//        arroz.verPreco(); System.out.println();
//        arroz.verIva();System.out.println();
//        System.out.println("O preco c/ iva: "+ arroz.getPrecoIva()+"$\n");
//        
//        
//        laranjas.verMarca(); System.out.println();
//        laranjas.verRef(); System.out.println();
//        laranjas.verPreco(); System.out.println();
//        laranjas.verIva();System.out.println();
//        System.out.println("O preco c/ iva: "+ laranjas.getPrecoIva()+"$\n");
//        
//        vassoura.verMarca(); System.out.println();
//        vassoura.verRef(); System.out.println();
//        vassoura.setPreco(4.50);        
//        vassoura.verPreco(); System.out.println();
//        vassoura.verIva();System.out.println();
//        System.out.println("O preco c/ iva: "+ vassoura.getPrecoIva()+"$\n");
        
    }
}
