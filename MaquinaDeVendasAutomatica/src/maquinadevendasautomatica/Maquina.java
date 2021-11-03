package maquinadevendasautomatica;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Maquina implements Operacoes {

    public Maquina() {
    }

    private ArrayList<Produto> slots = new ArrayList<>();
    private int totalProdutosMaquina = 0;
    private int totalProdutosVendidos = 0;
    private double vendas = 0;
    private double montante;
    private String senha = "senha";

    public ArrayList<Produto> getSlots() {
        return slots;
    }

    public void setSlots(ArrayList<Produto> slots) {
        this.slots = slots;
    }

    public int getTotalProdutosMaquina() {
        return totalProdutosMaquina;
    }

    public void setTotalProdutosMaquina(int totalProdutosMaquina) {
        this.totalProdutosMaquina = totalProdutosMaquina;
    }

    public int getTotalProdutosVendidos() {
        return totalProdutosVendidos;
    }

    public void setTotalProdutosVendidos(int totalProdutosVendidos) {
        this.totalProdutosVendidos = totalProdutosVendidos;
    }

    public double getVendas() {
        return vendas;
    }

    public void setVendas(double vendas) {
        this.vendas = vendas;
    }

    public double getMontante() {
        return montante;
    }

    public void setMontante(double montante) {
        this.montante = montante;
    }

    public boolean confirmarSeMaquinaVazia() {

        if (slots.size() == 0) {
            System.out.println("\n==========================\n** Máquina Vazia!! Volte mais tarde!! **\n==========================");
            return true;
        }
        return false;
    }
    
    public boolean confirmarSenha(String senhaForn){
        if(senhaForn.equals(senha)){
            System.out.println("\n==========================\n** BEM VINDO **\n==========================");
            return true;
        }else{
             System.out.println("\n==========================\n** SENHA ERRADA **\n==========================");
             return false;
        }
    }
    
    @Override
    public void mostrarProdutosDisponiveis(int tipo) {

        if (tipo == 1) {
            Collections.sort(slots, (Produto pro1, Produto pro2) -> pro1.getTipo().compareTo(pro2.getTipo()));
        }

        System.out.println("\nPRODUTOS DISPONIVEIS\n==========================");
        for (int i = 0; i < slots.size(); i++) {
            System.out.println((i + 1) + " -> " + slots.get(i).getNome() + " ( " + slots.get(i).getPreco() + " €)");
        }
        System.out.println("\n==========================");
    }

    public boolean confirmarMontatnte() {

        if (montante > 10) {
            System.out.println("** Insira um valor mais baixo **");
            return true;
        }
        return false;
    }

    public boolean confirmarSeMaquinaCheia() {

        if (slots.size() >= 3) {
            System.out.println("\n===============================\n** Máquina Cheia **");
            return true;
        }
        return false;
    }

    @Override
    public void inserirProdutoMaquina(String nome, double preco, String tipo, int quantidade) {
        int totalInseridos = 0, qtd = quantidade;
        int msg = 0;

        do {

            if (confirmarSeMaquinaCheia()) {
                System.out.println("Foram inseridos " + totalInseridos + " produtos de " + qtd + "\n==========================");
                msg = 0;
                break;
            } else {
                if (tipo.equals("Bebida")) {
                    slots.add(new Bebida(tipo, nome, preco));
                }
                if (tipo.equals("Salgados")) {
                    slots.add(new Salgados(tipo, nome, preco));
                }
                if (tipo.equals("Doces")) {
                    slots.add(new Doces(tipo, nome, preco));
                }
                totalProdutosMaquina++;
                msg = 1;
            }
            quantidade--;
            totalInseridos++;

        } while (quantidade != 0);

        if (msg == 1) {
            System.out.println("\n=============================\n** Produto inserido com Sucesso **");
            System.out.println("Foram inseridos " + totalInseridos + " produtos de " + qtd + "\n==========================");
        }
    }

    public boolean confirmarNrProdutos(int escolha) {

        if (escolha > slots.size()) {
            System.out.println("\n=============================\nSó se encontram desponiveis: " + slots.size() + "\n==========================\n");
            return true;
        }
        return false;
    }

    public boolean confirmarPagamento(int index) {
        double troco = 0;

        for (int i = 0; i < slots.size(); i++) {
            if (montante < slots.get(index).getPreco()) {
                troco = slots.get(index).getPreco() - montante;
                System.out.println("\n" + slots.get(index).getNome() + ": Crédito insuficiente! Faltam " + troco + "€");
                return false;
            }
        }
        return true;
    }

    @Override
    public double entregarProduto(int index, int nrProdutos) {
        double troco = 0;
        index -= 1;

        for (int i = 0; i < slots.size(); i++) {
            if (confirmarPagamento(index)) {
                troco = montante - slots.get(index).getPreco();
                if (nrProdutos == 1) {
                    System.out.println("\nRetirar " + slots.get(index).getNome() + "\nTroco de " + troco + "€");
                } else {
                    System.out.println("\n==========================\nRetirar " + slots.get(index).getNome() + "\n==========================\n");
                }
                eliminarProdutoMaquina(index);
                break;
            }
        }
        return troco;
    }

    @Override
    public void eliminarProdutoMaquina(int index) {
        double x = 0;

        for (int i = 0; i < slots.size(); i++) {
            x = slots.get(index).getPreco();
        }
        vendas += x;
        totalProdutosVendidos++;
        slots.remove(index);
        totalProdutosMaquina--;
    }

    public void consultarVendas() {

        System.out.println("\n==========================\nO total de vendas foi de: " + vendas + " €\n==========================\n");
    }

    public void consultarTotaisProdMaquina() {
        System.out.println("\n==========================\nTotal Produtos na Maquina: " + totalProdutosMaquina + "\nTotal Produtos Vendidos: " + totalProdutosVendidos + "\n==========================\n");

    }

}
