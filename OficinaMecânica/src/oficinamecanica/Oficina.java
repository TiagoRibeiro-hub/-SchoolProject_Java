package oficinamecanica;

import util.Teclado;
import oficinamecanica.Veiculo;
import java.util.ArrayList;

public class Oficina {

    public static void main(String[] args) {

        Teclado op = new Teclado();
        int opcao;

        ArrayList<Veiculo> carro = new ArrayList<>();

        Veiculo est = new Veiculo();

        int operacoes = 0;
        double pagar = 0;
        String estado;

        do {
            System.out.println("\n=== Menu Principal ===");
            System.out.println("1 -> Registar Veículo");
            System.out.println("2 -> Veiculos Registados");
            System.out.println("3 -> Alterar Estado");
            System.out.println("4 -> Visualizar Veículo");
            System.out.println("5 -> Visualizar Lista de Veiculos");
            System.out.println("0 - > Sair");
            System.out.print("Escolha uma opção: ");
            opcao = op.getInt();

            if (opcao == 0) {
                System.out.print("Programa Fechado");
////-----------------------------------
//// Registo Veiculo
            } else if (opcao == 1) {
                String matricula, marca, modelo, historico;

                System.out.print("\nIntroduza a matricula: ");
                matricula = op.getText();
                System.out.print("Introduza a marca: ");
                marca = op.getText();
                System.out.print("Introduza o modelo: ");
                modelo = op.getText();
                estado = est.Aguardar();
                historico = est.getHistorico();

                carro.add(new Veiculo(matricula, marca, modelo, estado, operacoes, historico, pagar));

                System.out.print("\nCarro registado com sucesso!!\n");
////-----------------------------------
////Veiculos Registados
            } else if (opcao == 2) {
                String matr;
                boolean existe = false;

                System.out.print("\nIntroduza a matricula: ");
                matr = op.getText();

                for (Veiculo c : carro) {
                    if (matr.equals(c.getMatricula())) {
                        existe = true;
                        est = c;
                        break;
                    }
                }
                if (existe) {
////-----------------------------------
////Menu Veiculos Registados
                    do {
                        System.out.println("\n=== Menu Veiculos Registados ===");
                        System.out.println("1 -> Registar Reparação");
                        System.out.println("2 -> Consultar Total de Operações");
                        System.out.println("3 -> Consultar Histórico de Reparações");
                        System.out.println("4 -> Consultar Total a Pagar");
                        System.out.println("9 - > Sair");
                        System.out.print("Escolha uma opção: ");
                        opcao = op.getInt();

                        if (opcao == 0) {
                            System.out.print("Menu Fechado");
////-----------------------------------
//-----------------------------------
// Registar Reparaçoes
                        } else if (opcao == 1) {
                            do {
                                System.out.println("\n=== Reparações ===");
                                System.out.println("1 -> Mudar Óleo");
                                System.out.println("2 -> Substituir Vidro");
                                System.out.println("3 -> Mudar Luzes");
                                System.out.println("4 -> Travões");
                                System.out.println("0 - > Sair");
                                System.out.print("Escolha uma opção: ");
                                opcao = op.getInt();

                                if (opcao == 0) {
                                    System.out.println("=========================");
                                    System.out.println("Menu Reparações Fechado!!");
                                    System.out.println("=========================");
                                } else if (opcao == 1) {
                                    est.RegMudarOleo();
                                } else if (opcao == 2) {
                                    est.RegSubstituirVidro();
                                } else if (opcao == 3) {
                                    est.RegMudarLuzes();              
                                } else if (opcao == 4) {
                                    est.RegTravoes();
                                }
                            } while (opcao != 0);
////-----------------------------------
////-----------------------------------
//// Consultar Total de Operações
                        } else if (opcao == 2) {
                            System.out.println("===============================");
                            System.out.println("\n== Total de Operações: " + est.getOperacoes());
                            System.out.println("===============================");
////-----------------------------------
////-----------------------------------
//// Consultar Total a Pagar
                        } else if (opcao == 3) {
                            System.out.println("===============================");
                            System.out.println("\n== Historico de Reparações: " + est.getHistorico());
                            System.out.println("===============================");
////-----------------------------------
////-----------------------------------
//// Consultar Histórico de Reparações
                        } else if (opcao == 4) {
                            System.out.println("=============================");
                            System.out.println("\n== Total a Pagar: " + est.getPagar() + " €");
                            System.out.println("=============================");
                        }
                    } while (opcao != 9);
                } else {
                    System.err.println("Matricula não encontrada!!");
                }
////-----------------------------------
//// Fim Menu Veiculos Registados
////-----------------------------------
////-----------------------------------
//// Alterar Estado
            } else if (opcao == 3) {
                String matr;
                boolean existe = false;

                System.out.print("Introduza a matricula: ");
                matr = op.getText();

                for (Veiculo c : carro) {
                    if (matr.equals(c.getMatricula())) {
                        existe = true;
                        est = c;
                        break;
                    }
                }
                if (existe) {
                    do {
                        System.out.println("\n=== Alterar Estado ===");
                        System.out.println("1 -> Aguardar");
                        System.out.println("2 -> Reparar");
                        System.out.println("3 -> Reparado");
                        System.out.println("9 - > Sair");
                        System.out.print("Escolha uma opção: ");
                        opcao = op.getInt();

                        if (opcao == 10) {
                            System.out.println("=============================");
                            System.out.println("Menu Alterar Estado Fechado!!");
                            System.out.println("=============================");
                        } else if (opcao == 1) {
                            est.ReporAguardar();
                        } else if (opcao == 2) {
                            est.ReporReparar();
                        } else if (opcao == 3) {
                            est.ReporReparado();
                        }

                    } while (opcao != 9);
                } else {
                    System.err.println("Matricula não encontrada!!");
                }
////-----------------------------------
////Visualizar Veículo
            } else if (opcao == 4) {
                String matr;
                boolean existe = false;

                System.out.print("Introduza a matricula: ");
                matr = op.getText();

                for (Veiculo c : carro) {
                    if (matr.equals(c.getMatricula())) {
                        existe = true;
                        break;
                    }
                }
                if (existe) {
                    for (Veiculo c : carro) {
                        if (matr.equals(c.getMatricula())) {
                            c.MostrarInfoVeiculo();
                        }
                    }
                } else {
                    System.err.println("Matricula não encontrada!!");
                }
////-----------------------------------
////Visualizar Lista
            } else if (opcao == 5) {
                System.out.println("=== Lista de veiculos ===");
                for (Veiculo c : carro) {
                    c.MostrarListaVeiculos();
                }
            }

        } while (opcao != 0);
    }
}
