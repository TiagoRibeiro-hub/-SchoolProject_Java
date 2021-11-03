package leiloeira;

import java.time.LocalDate;
import util.Teclado;

public class Menus {

    public Menus() {
    }

    Teclado op = new Teclado();

    private int lerOpcao() {
        System.out.print("Escolha uma opção: ");
        return op.getInt();
    }

    public int mostrarMenu() {
        System.out.println("\n== BEM VINDO ==");
        System.out.println("Criar Leilão (1)");
        System.out.println("Inserir Produto(2)");
        System.out.println("Inscrever Licitador(3)");
        System.out.println("LEILAO(4)");
        System.out.println("Sair(0)");
        return lerOpcao();
    }

    public int mostrarMenuLeilao() {
        System.out.println("----------------------------------");
        System.out.println("\n== Leilão ==");
        System.out.println("Entrar(1)");
        System.out.println("Ver informacoes do leilao(2)");
        System.out.println("Sair(0)");
        return lerOpcao();

    }

    public int mostrarMenuInfo() {
        System.out.println("----------------------------------");
        System.out.println("Ver Produtos e Precos Iniciais (1)");
        System.out.println("Ver historico de produtos/licitacoes/Licitadores (2)");
        System.out.println("Ver Vencedores (3)");
        System.out.println("Sair(0)");
        return lerOpcao();
    }

}
