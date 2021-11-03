package leiloeira;

import java.util.ArrayList;

public class Leilao {

    public Leilao(Produto produto, Licitador licitacoes, String dataAbertura, String dataEncerramento) {
        this.produto = produto;
        this.licitacoes = licitacoes;
        this.dataAbertura = dataAbertura;
        this.dataEncerramento = dataEncerramento;
    }

    public Leilao(Produto produto, Licitador licitacoes) {
        this.produto = produto;
        this.licitacoes = licitacoes;
    }

    public Leilao(Licitador vencedor, Produto produto) {
        this.vencedor = vencedor;
        this.produto = produto;
    }

    public Leilao(String dataAbertura, String dataEncerramento) {
        this.dataAbertura = dataAbertura;
        this.dataEncerramento = dataEncerramento;
    }

    public Leilao() {
    }

    private Produto produto;
    private Licitador licitacoes;
    private String dataAbertura;
    private String dataEncerramento;
    private Licitador vencedor;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Licitador getLicitacoes() {
        return licitacoes;
    }

    public void setLicitacoes(Licitador licitacoes) {
        this.licitacoes = licitacoes;
    }

    public String getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(String dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getDataEncerramento() {
        return dataEncerramento;
    }

    public void setDataEncerramento(String dataEncerramento) {
        this.dataEncerramento = dataEncerramento;
    }

    public Licitador getVencedor() {
        return vencedor;
    }

    public void setVencedor(Licitador vencedor) {
        this.vencedor = vencedor;
    }

    public String verDatas() {
        return "------------------------\nData de Inicio: " + getDataAbertura()
                + "\nData de Fecho: " + getDataEncerramento() + "\n------------------------\n";
    }

    public String verHistorico() {
        return "== Produto ==\n-------------------------\nNome: " + getProduto().getNome() + " / Valor Minimo Atual: " + getProduto().getValorMinimo()
                + "\n----------------------\n== Licitador ==\n----------------------\nNome: " + getLicitacoes().getNome()
                + " / Nr. telefone: " + getLicitacoes().getTelefone() + "\nValor licitado: " + getLicitacoes().getValorLicitado() + "\n----------------------\n";
    }

    public String verVencedor() {
        return "\n*** LICITADOR VENCEDOR DO PRODUTO ==> " + getProduto().getNome()
                + " <== ***\nParabéns: " + getVencedor().getNome() + "\n";
    }

}
