package maquinadevendasautomatica;

public interface Operacoes {

    public abstract void inserirProdutoMaquina(String nome, double preco, String tipo, int quantidade);

    public abstract void mostrarProdutosDisponiveis(int tipo);

    public abstract double entregarProduto(int index, int nrProdutos);

    public abstract void eliminarProdutoMaquina(int index);

}
