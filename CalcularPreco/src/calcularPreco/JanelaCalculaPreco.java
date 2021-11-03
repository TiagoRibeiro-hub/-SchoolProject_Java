package calcularPreco;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class JanelaCalculaPreco extends JFrame {

    public JanelaCalculaPreco() {
        initComponentes();
    }
    
    private JTextField txtValorInserir = new JTextField();
    private JTextField txtValorResultado = new JTextField();
    private JLabel labelValorTaxa = new JLabel();
    private JSlider slider = new JSlider(0,25,0);
    
    public void initComponentes(){
        
        setSize(300, 350);
        setTitle("Calcular Preco");

        setLocationRelativeTo(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        
        initLabels();
        initTextBox();
        initSlider();
        initButton();
        setVisible(true);
        
    }
    
    public void initLabels(){
        // labelPreco
        JLabel labelPreco = new JLabel("Preço:");
        labelPreco.setBounds(25, 25, 50, 25);
        add(labelPreco);
        
        JLabel labelResult = new JLabel("Resultado:");
        labelResult.setBounds(25, 75, 65, 25);
        add(labelResult);
        
        // labelTaxa
        JLabel labelTaxa = new JLabel("Taxa:");
        labelTaxa.setBounds(25, 115, 50, 25);
        add(labelTaxa);
        
        // labelValorTaxa
        labelValorTaxa.setBounds(75, 115, 150, 25);
        add(labelValorTaxa);
    }
    
    public void initTextBox(){
        // txtValorInserir
        txtValorInserir.setBounds(100, 25, 150, 25);
        add(txtValorInserir);
        // txtValorResultado
        txtValorResultado.setBounds(100, 75, 150, 25);
        add(txtValorResultado);
    }
    
    public void initSlider(){
        // slider
        slider.setBounds(25, 150, 235, 50);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setMajorTickSpacing(5);
        slider.setMinorTickSpacing(1);
        add(slider);
        // event slider
        slider.addChangeListener((ChangeEvent e) -> {labelValorTaxa.setText(String.valueOf(slider.getValue()));});

    }
    
    public void initButton(){
        // new button
        JButton btnInserir = new JButton("Calcular");
        btnInserir.setBounds(25, 230, 100, 25);
        add(btnInserir);
        
        btnInserir.addActionListener((ActionEvent e) ->{ txtValorResultado.setText(calcular());});
    }
    
    public String calcular(){
        double valor = Double.parseDouble(txtValorInserir.getText());
        double taxa = Double.parseDouble(labelValorTaxa.getText());
        String preco = String.valueOf((valor * taxa / 100) + valor);
        return preco;
    }
    
    //////////////////////////   MAIN   //////////////////////////////
       public static void main(String[] args) {
        new JanelaCalculaPreco();

    }
    
}
