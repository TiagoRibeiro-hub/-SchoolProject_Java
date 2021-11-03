package util;
import java.util.Scanner;

public class Teclado {
    // construtor
    public Teclado(){}
    
    // atributos
    private Scanner scanner = new Scanner(System.in);
    
    // metodos
    public String getText(){
        return scanner.nextLine();
    }
    
    public int getInt(){
        return Integer.parseInt(scanner.nextLine());
    }
    
    public double getDouble(){
        return Double.parseDouble(scanner.nextLine());
    }
            
}
