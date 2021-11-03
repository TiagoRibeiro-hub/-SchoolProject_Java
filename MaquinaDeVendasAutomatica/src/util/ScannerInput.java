package util;
import java.util.Scanner;

public class ScannerInput {

    public ScannerInput() {
    }
    
    private Scanner scanner = new Scanner(System.in);
    
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
