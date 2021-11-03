//package leiloeira;
//
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import util.Teclado;
//
//public class Teste {
//
//    public static void main(String[] args) {
//
//        Teclado op = new Teclado();
//        int opcao, yyI, mmI, ddI, yyF, mmF, ddF;
//        String dti, dtf;
//        Menus menu = new Menus();
//        
//        LocalDate dtInicio = LocalDate.now();
//        LocalDate dtFinal = LocalDate.now();
//
//        ArrayList<Produto> produtosIniciais = new ArrayList<>();
//        ArrayList<Produto> produtos = new ArrayList<>();
//        ArrayList<Licitador> compradores = new ArrayList<>();
//        ArrayList<Leilao> infoLeilao = new ArrayList<>();
//        ArrayList<Leilao> historico = new ArrayList<>();
//        ArrayList<Leilao> vencedor = new ArrayList<>();
//
//        boolean leilaoNormal = false, leilaoIngles = false;
//
//        do {
//
//            opcao = menu.mostrarMenu();
//
//            if (opcao == 0) {
//                System.out.println("== ADEUS ==\n** Programa Fechado **");
//            } else if (opcao == 1) {
//
//                if (leilaoNormal == true || leilaoIngles == true) {
//                    System.out.println("** Leilao em curso!! **");
//                } else {
//                      
//                    System.out.print("\nQual o tipo de leilao: Leilao(1) ou Leilao Ingles (2)....Sair (3)");
//                    opcao = op.getInt();
//
//                    System.out.println("\n** Data e Hora de Inicio **");
//                    System.out.println("-------------------------\n** Data **");
//                    System.out.print("Ano: ");
//                    yyI = op.getInt();
//                    dtInicio = dtInicio.withYear(yyI);
//                    System.out.print("Mes: ");
//                    mmI = op.getInt();
//                    dtInicio = dtInicio.withMonth(mmI);
//                    System.out.print("Dia: ");
//                    ddI = op.getInt();
//                    dtInicio = dtInicio.withDayOfMonth(ddI);
//                    System.out.print("-------------------------\n** Data e Hora Final **\n");
//                    System.out.println("-------------------------\n** Data **");
//                    System.out.print("Ano: ");
//                    yyF = op.getInt();
//                    dtFinal = dtFinal.withYear(yyF);
//                    System.out.print("Mes: ");
//                    mmF = op.getInt();
//                    dtFinal = dtFinal.withMonth(mmF);
//                    System.out.print("Dia: ");
//                    ddF = op.getInt();
//                    dtFinal = dtFinal.withDayOfMonth(ddF);
//                    
//                    dti = dtInicio.format(DateTimeFormatter.ISO_DATE);
//                    dtf = dtFinal.format(DateTimeFormatter.ISO_DATE);
//                    
//                    infoLeilao.add(new Leilao(dti, dtf));
//                    
//                    switch (opcao) {
//                        case 1:
//                            leilaoNormal = true;
//                            for(Leilao l: infoLeilao){
//                            System.out.println("*** Leilao Criado com Sucesso!! ***\n"+l.verDatas());
//                           }
//                            break;
//                        case 2:
//                            leilaoIngles = true; for(Leilao l: infoLeilao){
//                            System.out.println("*** Leilao Inglês Criado com Sucesso!! ***\n"+l.verDatas());
//                           }
//                            break;
//                        case 3:
//                            System.out.println("** Adeus!! **");
//                            break;
//                    }
//                }
//            } else if (opcao == 2) {
//// INSERIR PRODUTOS A LEILOAR                                
//                String nome;
//                double valorMinimo;
//
//                System.out.println("\n** NOVO PRODUTO **\n-----------------------\n");
//                System.out.print("Nome: ");
//                nome = op.getText();
//                System.out.print("Valor minimo: ");
//                valorMinimo = op.getDouble();
//
//                produtosIniciais.add(new Produto(nome, valorMinimo));
//                produtos.add(new Produto(nome, valorMinimo));
//
//            } else if (opcao == 3) {
//// INSCRIÇAO DE COMPRADORES                
//                String nome, telefone;
//
//                System.out.println("\n** NOVO LICITADOR **\n-----------------------\n");
//                System.out.print("Nome: ");
//                nome = op.getText();
//                System.out.print("Telefone: ");
//                telefone = op.getText();
//
//                compradores.add(new Licitador(nome, telefone));
//// MENU DO LEILAO                
//            } else if (opcao == 4) {
//
//                if (leilaoNormal == false && leilaoIngles == false) {
//                    System.out.println("\n*** Não existem leiloes disponiveis!! ***");
//                } else {
//                    
//                    if(leilaoNormal == true){
//                        System.out.println("\n*** Leilao Agendado **");
//                    }
//                    if(leilaoIngles == true){
//                        System.out.println("\n*** Leilao Ingles Agendado **");
//                    }
//// CONFIRMACAO DATA E HORA 
//                    LocalDate dhSistema = LocalDate.now();
//                    int dI = dhSistema.compareTo(dtInicio), dF = dhSistema.compareTo(dtFinal);
//                    
//                    if (dI >= 0 && dF <= 0) {
//                        int subopcao;
//                        do {
//                            subopcao = menu.mostrarMenuLeilao();
//
//                            if (subopcao == 0) {
//                                System.out.print("** Saiu do leilão **");
//
//                            } else if (subopcao == 1) {
//// CONFIRMAR SE ESTA INSCRITO NO LEILAO   
//                                String nomeLicitador, nomeProduto;
//                                double valorMinimo, valorLicitado;
//                                boolean confirmacao = false;
//                                Licitador tempL = new Licitador();
//
//                                System.out.print("Introduza o seu Nome: ");
//                                nomeLicitador = op.getText();
//
//                                for (Licitador listaNomes : compradores) {
//                                    if (nomeLicitador.equals(listaNomes.getNome())) {
//                                        confirmacao = true;
//                                        tempL = listaNomes;
//                                        break;
//                                    }
//                                }
//                                if (confirmacao) {
//
//                                    System.out.println("\n== PRONTO PARA GASTAR DINHEIRO ==\n");
//                                    System.out.println("== PRODUTOS DISPONIVEIS ==\n-----------------------");
//                                    for (Produto p : produtos) {
//                                        System.out.println(p.mostrarProdutos());
//                                    }
//// ESCOLHA DO PRODUTO QUE QUER LICITAR      
//                                    Produto tempP = new Produto();
//                                    confirmacao = false;
//
//                                    System.out.println("Escolha um produto: ");
//                                    nomeProduto = op.getText();
//                                    for (Produto p : produtos) {
//                                        if (nomeProduto.equals(p.getNome())) {
//                                            confirmacao = true;
//                                            tempP = p;
//                                        }
//                                    }
//                                    if (confirmacao) {
//                                        boolean aceite = false;
//                                        do {
//
//                                            System.out.println("Insira a sua licitação: ");
//                                            valorLicitado = op.getDouble();
//                                            tempL.setValorLicitado(valorLicitado);
//
//                                            if (leilaoNormal == true) {
//                                                aceite = true;
//                                                System.out.println("Licitaçaõ aceite");
//
//                                                if (valorLicitado > tempP.getValorMinimo()) {
//                                                    for (Leilao v : vencedor) {
//                                                        if (v.getProduto().getNome().contains(tempP.getNome())) {
//                                                            vencedor.remove(v);
//                                                        }
//                                                    }
//                                                    tempP.setValorMinimo(valorLicitado);
//                                                    vencedor.add(new Leilao(new Licitador(tempL.getNome(), tempL.getTelefone(), tempL.getValorLicitado()),
//                                                            new Produto(tempP.getNome(), tempP.getValorMinimo())));
//                                                }
//
//                                            } else if (leilaoIngles == true) {
//
//                                                if (valorLicitado <= tempP.getValorMinimo()) {
//                                                    System.out.println("Licite outra vez, valor minimo maior que " + tempP.getValorMinimo());
//                                                } else {
//                                                    for (Leilao v : vencedor) {
//                                                        if (v.getProduto().getNome().contains(tempP.getNome())) {
//                                                            vencedor.remove(v);
//                                                        }
//                                                    }
//                                                    tempP.setValorMinimo(valorLicitado);
//                                                    aceite = true;
//                                                    vencedor.add(new Leilao(new Licitador(tempL.getNome(), tempL.getTelefone(), tempL.getValorLicitado()),
//                                                            new Produto(tempP.getNome(), tempP.getValorMinimo())));
//                                                    System.out.println("Licitaçaõ aceite");
//                                                }
//                                            }
//
//                                        } while (aceite != true);
//// UPDATE DO HISTORICO -- LICITAÇAO                                
//                                        historico.add(new Leilao(new Produto(tempP.getNome(), tempP.getValorMinimo()),
//                                                new Licitador(tempL.getNome(), tempL.getTelefone(), tempL.getValorLicitado())));
//
//                                    } else {
//                                        System.out.println("\n*** Produto inválido ***");
//                                    }
//
//                                } else {
//                                    System.out.println("\n*** Por favor insira novo licitador ***");
//                                }
//// RESULTADOS
//                            } else if (subopcao == 2) {
//                                int subsubopcao;
//                                do {
//                                    subsubopcao = menu.mostrarMenuInfo();
//
//                                    switch (subsubopcao) {
//
//                                        case 1:
//                                            System.out.println("\n== PRODUTOS E PREÇOS INICIAIS ==\n");
//                                            for (Produto p : produtosIniciais) {
//                                                System.out.println(p.mostrarProdutos());
//                                                break;
//                                            }
//                                        case 2:
//                                            System.out.println("\n== PRODUTOS E PREÇOS FINAIS // LICITADORES ==\n");
//                                            for (Leilao h : historico) {
//                                                System.out.println(h.verHistorico());
//                                            }
//                                        case 3:
//                                            for (Leilao v : vencedor) {
//                                                System.out.println(v.verVencedor());
//                                            }
//                                    }
//                                } while (subsubopcao != 0);
//                            }
//                        } while (subopcao != 0);
//
//                    } else {
//                        System.out.println("\n** PRÓXIMO AGENDAMENTO **");
//                        for(Leilao i: infoLeilao){
//                            System.out.println(i.verDatas());
//                        }
//                    }
//                }
//            }
//
//        } while (opcao != 0);
//
//    }
//}