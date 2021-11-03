package oficinamecanica;

import java.util.ArrayList;

public class Veiculo {

    //construtor
    public Veiculo(String matricula, String marca, String modelo, String estado, int operacoes, String historico, double pagar) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.estado = estado;
        this.operacoes = operacoes;
        this.historico = historico;
        this.pagar = pagar;
    }

    public Veiculo() {
    }

    //atributo    
    private String matricula;
    private String marca;
    private String modelo;
    private String estado;
    private int operacoes;
    private String historico;
    private double pagar;
    
    //metodos
    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getOperacoes() {
        return operacoes;
    }

    public String getHistorico() {
        return historico;
    }

    public String setHistorico(String reparacoes) {
        if (historico == null) {
            return historico = reparacoes;
        } else {
            return historico += reparacoes;
        }
    }

    public double getPagar() {
        return pagar;
    }

///--------------
    public String Aguardar() {
        return "Aguardar";
    }

    public String Reparar() {
        return "Reparar";
    }

    public String Reparado() {
        return "Reparado";
    }
///--------------

    public double PrecoOleo() {
        return 40.00;
    }

    public double PrecoVidro() {
        return 150.00;
    }

    public double PrecoLuz() {
        return 60.00;
    }

    public double PrecoTravoes() {
        return 80.00;
    }

    public void TotalPagar(double montante) {
        pagar += montante;
        operacoes++;
    }

    public String MudarOleo() {
        return "\nMudar Oleo - 40eur";
    }

    public String SubstituirVidro() {
        return "\nSubstituir Vidro - 150eur";
    }

    public String MudarLuzes() {
        return "\nMudar Luzes - 60eur";
    }

    public String Travoes() {
        return "\nTravoes 80eur2";
    }
//------------------- 
//Operaçoes

    public void RegMudarOleo() {
        setHistorico(MudarOleo());
        TotalPagar(PrecoOleo());
        System.out.println("==============================");
        System.out.println("Operação Concluida com Sucesso");
        System.out.println("==============================");
    }

    public void RegSubstituirVidro() {
        setHistorico(SubstituirVidro());
        TotalPagar(PrecoVidro());
        System.out.println("==============================");
        System.out.println("Operação Concluida com Sucesso");
        System.out.println("==============================");
    }

    public void RegMudarLuzes() {
        setHistorico(MudarLuzes());
        TotalPagar(PrecoLuz());
        System.out.println("==============================");
        System.out.println("Operação Concluida com Sucesso");
        System.out.println("==============================");
    }

    public void RegTravoes() {
        setHistorico(Travoes());
        TotalPagar(PrecoTravoes());
        System.out.println("==============================");
        System.out.println("Operação Concluida com Sucesso");
        System.out.println("==============================");
    }

    public void ReporAguardar() {
        setEstado(Aguardar());
        System.out.println("==============================");
        System.out.println("Operação Concluida com Sucesso");
        System.out.println("==============================");
    }

    public void ReporReparar() {
        setEstado(Reparar());
        System.out.println("==============================");
        System.out.println("Operação Concluida com Sucesso");
        System.out.println("==============================");
    }

    public void ReporReparado() {
        setEstado(Reparado());
        System.out.println("==============================");
        System.out.println("Operação Concluida com Sucesso");
        System.out.println("==============================");
    }

    public void MostrarInfoVeiculo() {
        System.out.println("\n==== Informaçoes do veiculo ====");
        System.out.println("Matricula: " + getMatricula());
        System.out.println("Marca: " + getMarca());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Estado: " + getEstado());
        System.out.println("Operacoes: " + getOperacoes());
        System.out.println("----------------------------");
        System.out.println("Historico de Reparações: " + getHistorico());
        System.out.println("-----------------------------");
        System.out.println("\nTotal a Pagar: " + getPagar());
        System.out.println("================================");
    }

    public void MostrarListaVeiculos() {
        System.out.println("Matricula: " + getMatricula());
        System.out.println("Estado: " + getEstado());
        System.out.println("=========================");
    }
}
