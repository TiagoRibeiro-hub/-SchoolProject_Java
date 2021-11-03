//package bancochapagasta;
//
//import util.Teclado;
//import bancochapagasta.Conta;
//import java.util.ArrayList;
//import java.util.Random;
//
//public class Correcao {
//
//    public static void main(String[] args) {
//
//        Teclado op = new Teclado();
//        int operacao;
//        
//        ArrayList<Conta> contas = new ArrayList<>();
//        int nrConta = 1;
//        int opcao;
//        
//        do {
//            System.out.println("\n=== Menu Principal ====");
//            System.out.println("1--> Adicionar Conta");
//            System.out.println("2--> Pesquisar Conta");
//            System.out.println("0--> Sair\n");
//            System.out.print("Introduza uma opção: ");
//            opcao = op.getInt();
//
//            if (opcao == 0) {
//                System.out.println("Programa Fechado!!");
//            } else if (opcao == 1) {
//                String nome;
//                String nib;
//                int nrTelefone;
//                double saldo;
//                double plafond;
//
//                System.out.print("Introdiza o nome: ");
//                nome = op.getText();
//
//                System.out.print("Itroduza o numero de telefone: ");
//                nrTelefone = op.getInt();
//
//                System.out.print("Itroduza o NIB: ");
//                nib = op.getText();
//
//                System.out.print("Itroduza o saldo: ");
//                saldo = op.getDouble();
//
//                System.out.print("Itroduza o plafond: ");
//                plafond = op.getDouble();
//
//                contas.add(new Conta(nrConta, nome, nrTelefone, nib, saldo, plafond));
//                nrConta++;
//
//            } else if (opcao == 2) {
//                int nr;
//                boolean existe = false;
//                Conta temp = new Conta();
//
//                System.out.print("Introduzir nr conta: ");
//                nr = op.getInt();
//
//                for (Conta list : contas) {
//                    if (list.getNrConta() == nr) {
//                        existe = true;
//                        temp = list;  // copiar conta encontrada
//                        break;
//                    }
//                }
//
//                if (existe) {
//                    int subopcao;
//                    double montante;
//                    do {
//                        System.out.println("\n=== Opções de Conta ====");
//                        System.out.println("1--> Levantamento");
//                        System.out.println("2--> Depositar");
//                        System.out.println("3--> Ver Dados");
//                        System.out.println("0--> Sair\n");
//                        System.out.print("Introduza uma opção: ");
//                        subopcao = op.getInt();
//
//                        if (subopcao == 0) {
//                            System.out.println("Programa Fechado!!");
//                        } else if (subopcao == 1) {
//                            System.out.println("Introduza o montante a levantar: ");
//                            montante = op.getDouble();
//                            if (temp.levantar(montante)) {
//                                System.out.println("Levantamento Efectuado!!");
//                            } else {
//                                System.out.println("Saldo Insuficiente!!");
//                            }
//                        } else if (subopcao == 2) {
//                            System.out.println("Introduza o montante a depositar: ");
//                            montante = op.getDouble();
//                            temp.depositar(montante);
//
//                        } else if (subopcao == 3) {
//                               System.out.print("\n=== Dados Pessoais ===");
//                               System.out.print("Nome: "+ temp.getNome());
//                               System.out.print("Numero de conta: "+ temp.getNrConta());
//                               System.out.print("Saldo: "+ temp.getSaldo());
//                               System.out.print("Nt. movimentos: "+ temp.getNrMovimentos());
//                        }
//
//                    } while (subopcao == 0);
//                } else {
//                    System.err.println("Conta não encontrada!!");
//                }
//
//            } else {
//                System.err.println("\nOpção inválida!!");
//            }
//
//        } while (opcao != 0);
//
//    }
//}
