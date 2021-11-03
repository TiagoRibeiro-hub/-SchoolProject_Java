package bancochapagasta;

public class Conta {
    // construtores

    public Conta(int nrConta, String nome, int nrTelefone, String nib, double saldo, double plafond) {
        this.nrConta = nrConta;
        this.nome = nome;
        this.nrTelefone = nrTelefone;
        this.nib = nib;
        this.saldo = saldo;
        this.plafond = plafond;
    }
    
    public Conta() {}
    
    public Conta(String nib) {
        this.nib = nib;
    }

    //atributos
    private int nrConta;
    private String nome;
    private int nrTelefone;
    private String nib;
    private double saldo;
    private double plafond;
    private double montante;
    private int nrMovimentos;
    

    //metodos
    public int getNrConta() {
        return nrConta;
    }

    public void setNrConta(int nrConta) {
        this.nrConta = nrConta;
    }

    public String getNome() {
        return nome;
    }

    public int getNrTelefone() {
        return nrTelefone;
    }

    public String getNib() {
        return nib;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getPlafond() {
        return plafond;
    }

    public void setPlafond(double plafond) {
        this.plafond = plafond;
    }
    
    public double getNrMovimentos() {
        return montante;
    }

    public void setNrMovimentos(double montante) {
        this.plafond = montante;
    }
    
    public void depositar(double montante){
        saldo += montante;
        nrMovimentos++;
    }
    
    public boolean levantar(double montante){
        if(saldo + plafond >= montante){
            saldo -= montante;
            nrMovimentos++;
            return true;
        }else{
            return false;
        }
    }
    
}
