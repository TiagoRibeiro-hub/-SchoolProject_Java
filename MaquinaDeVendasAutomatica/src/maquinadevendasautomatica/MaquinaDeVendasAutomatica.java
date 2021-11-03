package maquinadevendasautomatica;

public class MaquinaDeVendasAutomatica {

    public static void main(String[] args) {

        Menu mostrar = new Menu();
        Maquina maquina = new Maquina();

        int opcao, subopcao, subsubopcao, ordenacao;
        do {
            opcao = mostrar.menuPrincipal();

            switch (opcao) {
                case 1:
                    double montante;
                    int escolha,
                     nrProdutos;

                    if (maquina.confirmarSeMaquinaVazia()) {
                        break;
                    }
                    maquina.setMontante(montante = mostrar.introduzirMontante());
                    while (maquina.confirmarMontatnte()) {
                        maquina.setMontante(montante = mostrar.introduzirMontante());
                    }
                    maquina.mostrarProdutosDisponiveis(ordenacao = 0);
                    if (maquina.confirmarNrProdutos(nrProdutos = mostrar.introduzirQuantosProdutos())) {
                        break;
                    }
                    while (nrProdutos != 0) {
                        maquina.mostrarProdutosDisponiveis(ordenacao);
                        escolha = mostrar.escolherProduto();
                        double troco = maquina.entregarProduto(escolha, nrProdutos);
                        maquina.setMontante(troco);
                        nrProdutos -= 1;
                    }
                    break;
                case 2:
                    String senhaForn = "";
                    if (maquina.confirmarSenha(senhaForn = mostrar.introduzirSenha())) {
                        ordenacao = mostrar.escolherOrdenacao();
                        do {
                            subopcao = mostrar.menuFornecedores();
                            switch (subopcao) {
                                case 1:
                                    maquina.mostrarProdutosDisponiveis(ordenacao);

                                    String empresa = "",
                                     nome = "",
                                     tipo = "";
                                    double preco = 0;
                                    int quantidade = 0,
                                     escolhaTipo = 0;

                                    escolhaTipo = mostrar.introduzirTipo();
                                    empresa = mostrar.introduzirEmpresa();
                                    nome = mostrar.introduzirNome();
                                    preco = mostrar.introduzirPreco();
                                    quantidade = mostrar.introduzirQuantidade();

                                    if (escolhaTipo == 0) {
                                        break;
                                    }
                                    if (escolhaTipo == 1) {
                                        Bebida bebida = new Bebida();
                                        bebida.setEmpresa(empresa);
                                        bebida.receberProduto(nome, preco, tipo = "Bebida", quantidade);
                                    }
                                    if (escolhaTipo == 2) {
                                        Salgados salgados = new Salgados();
                                        salgados.setEmpresa(empresa);
                                        salgados.receberProduto(nome, preco, tipo = "Salgados", quantidade);
                                    }
                                    if (escolhaTipo == 3) {
                                        Doces doces = new Doces();
                                        doces.setEmpresa(empresa);
                                        doces.receberProduto(nome, preco, tipo = "Doces", quantidade);
                                    }
                                    maquina.inserirProdutoMaquina(nome, preco, tipo, quantidade);
                                    break;
                                case 2:
                                    do {
                                        subsubopcao = mostrar.menuTotais();

                                        switch (subsubopcao) {
                                            case 1:
                                                maquina.consultarVendas();
                                                maquina.mostrarProdutosDisponiveis(ordenacao);
                                                break;
                                            case 2:
                                                maquina.consultarTotaisProdMaquina();
                                                maquina.mostrarProdutosDisponiveis(ordenacao);
                                                break;
                                        }
                                    } while (subsubopcao != 0);
                                    break;
                            }

                        } while (subopcao != 0);
                        break;
                    }
            }

        } while (opcao != 0);

    }

}
