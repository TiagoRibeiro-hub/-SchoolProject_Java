package maquinadevendasautomatica;

import util.ScannerInput;

public class Menu {

    ScannerInput op = new ScannerInput();

    private String lerOpcaoString() {
        try {
            return op.getText();
        } catch (Exception erro) {
            System.err.println("\n** Comando Inválido!! **\nEscolha uma opcao: ");
            return lerOpcaoString();
        }
    }

    private int lerOpcaoInt() {
        try {
            return op.getInt();
        } catch (Exception erro) {
            System.err.println("\n** Comando Inválido!! **\nEscolha uma opcao: ");
            return lerOpcaoInt();
        }
    }

    private double lerOpcaoDouble() {
        try {
            return op.getDouble();
        } catch (Exception erro) {
            System.err.println("\n** Comando Inválido!! **\nEscolha uma opcao: ");
            return lerOpcaoDouble();
        }
    }

    public int menuPrincipal() {
        System.out.println("\nMENU PRINCIPAL");
        System.out.println("==========================");
        System.out.println("1 -> Comprar Produto");
        System.out.println("2 -> Menu Fornecedores");
        System.out.println("0 -> Sair");
        System.out.print("Escolha uma opção: ");
        return lerOpcaoInt();
    }

    public int menuFornecedores() {
        System.out.println("\nFORNECEDORES");
        System.out.println("==========================");
        System.out.println("1 -> Introduzir Produto");
        System.out.println("2 -> Consultar Totais");
        System.out.println("0 -> Sair");
        System.out.print("Escolha uma opção: ");
        return lerOpcaoInt();
    }

    public int menuTotais() {
        System.out.println("\nTOTAIS");
        System.out.println("==========================");
        System.out.println("1 -> Total de Vendas");
        System.out.println("2 -> Total Produtos na Maquina / Total Produtos Vendidos");
        System.out.println("0 -> Sair");
        System.out.print("Escolha uma opção: ");
        return lerOpcaoInt();
    }

    public int escolherOrdenacao() {
        String x = "";
        int y = 0;
        System.out.print("\nOrdenar Produtos por tipo? (S/N) > ");
        x = lerOpcaoString().toLowerCase();
        if (x.equals("s")) {
            return y += 1;
        }
        return y;
    }

    public String introduzirSenha() {
        System.out.print("Introduza a senha: ");
        return lerOpcaoString();
    }

    public double introduzirMontante() {
        System.out.print("\nIntroduza Montante: ");
        return lerOpcaoDouble();
    }

    public String introduzirNome() {
        System.out.print("> Introduza o Nome: ");
        return lerOpcaoString();
    }

    public double introduzirPreco() {
        System.out.print("> Introduza o Preço: ");
        return lerOpcaoDouble();
    }

    public int introduzirQuantidade() {
        System.out.print("> Introduza a Quantidade: ");
        return lerOpcaoInt();
    }

    public int introduzirTipo() {
        System.out.print("> Introduza tipo:: Bebida(1) Comida:: Salgados(2) Doces(3) // SAIR(0) -> ");
        return lerOpcaoInt();
    }

    public String introduzirEmpresa() {
        System.out.print("> Introduza Empresa: ");
        return lerOpcaoString();
    }

    public int escolherProduto() {
        System.out.print("\nEscolha um Produto -> ");
        return lerOpcaoInt();
    }

    public int introduzirQuantosProdutos() {
        System.out.print("> Quantos Produtos quer escolher -> ");
        return lerOpcaoInt();
    }
}
