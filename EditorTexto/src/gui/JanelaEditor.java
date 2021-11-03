package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.event.ChangeEvent;
import javax.swing.filechooser.FileNameExtensionFilter;

public class JanelaEditor extends JFrame {

    public JanelaEditor() {
        initComponentes();
    }

    private JTextArea caixaTexto = new JTextArea();
    private JScrollPane scroll = new JScrollPane(caixaTexto);
    private JSlider slider = new JSlider(0, 255, 0);
    private JToolBar barraFerramenta = new JToolBar();

    // ITEMS MENU FICHEIRO
    private JMenuItem ficheiroAbrir = new JMenuItem("Abrir");
    private JMenuItem ficheiroGuardar = new JMenuItem("Guardar");
    private JMenuItem ficheiroSair = new JMenuItem("Sair");

    // ITEMS MENU EDITAR
    private JMenuItem editarCopiar = new JMenuItem("Copiar");
    private JMenuItem editarCortar = new JMenuItem("Cortar");
    private JMenuItem editarColar = new JMenuItem("Colar");

    // ITEMS SUB MENU CAIXA DE TEXTO
    private JMenuItem editarCorTexto = new JMenuItem("Cor do Texto");
    private JMenuItem editarAumentarTexto = new JMenuItem("Aumentar Texto (5px)");
    private JMenuItem editarReduzirTexto = new JMenuItem("Diminuir Texto (5px)");
    private JMenuItem editarFont = new JMenuItem("Tipo de Letra");
    
    //caixa para escolher localização e nome do ficheiro (LER / GRAVAR)
    private JFileChooser sistemaFicheiros = new JFileChooser();

    // FILTROS
    private FileNameExtensionFilter filterTxt = new FileNameExtensionFilter("Text files", "txt");

    // criar botões para barra de ferramentas
    private JButton bfAbrir = new JButton();
    private JButton bfGuardar = new JButton();
    private JButton bfCopiar = new JButton();
    private JButton bfCortar = new JButton();
    private JButton bfColar = new JButton();
    private JButton bfCorTexto = new JButton();
    private JButton bfAumentarTexto = new JButton();
    private JButton bfReduzirTexto = new JButton();
    private JButton bfFont = new JButton();
    
    
    private void initComponentes() {
        setTitle("Editor XPTO");
        setSize(800, 600);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(this);

        setLayout(new BorderLayout());
        addComponentes();
        criarMenus();
        criarBarraFerramentas();
        addEventos();
        addIcons();
        setVisible(true);
    }

    private void addComponentes() {
        // caixa de texto
        caixaTexto.setBackground(Color.black);
        caixaTexto.setForeground(Color.white);
        caixaTexto.setCaretColor(Color.yellow);
        caixaTexto.setLineWrap(true);
        caixaTexto.setWrapStyleWord(true);

        add(scroll, BorderLayout.CENTER);

        // slider
        add(slider, BorderLayout.SOUTH);

    }

    // CRIAR MENU E RESPECTIVAS ENTRADAS \\
    private void criarMenus() {
        //crirar barra de Menu (container)
        JMenuBar barraMenu = new JMenuBar();
        //aplicar Barra de Menu à JFrame
        setJMenuBar(barraMenu);

        JMenu menuFicheiro = new JMenu("Ficheiro"); //--> criar entrada (Menu Ficheiro (container)) no Menu Barra 
        //adicionar Menu Ficheiro à barra de Menu
        barraMenu.add(menuFicheiro);

        //criar items de Ficheiro como atributos JMenuItem        
        //adicionar Items ao Menu Ficheiro
        menuFicheiro.add(ficheiroAbrir);
        menuFicheiro.add(ficheiroGuardar);
        menuFicheiro.addSeparator();
        menuFicheiro.add(ficheiroSair);

        JMenu menuEditar = new JMenu("Editar"); //--> criar entrada (Menu Editar (container)) no Menu Barra
        //add Menu Barra
        barraMenu.add(menuEditar);

        //criar items de Edita como atributos JMenuItem        
        //adicionar Items ao Menu Editar
        menuEditar.add(editarCopiar);
        menuEditar.add(editarCortar);
        menuEditar.add(editarColar);
        menuEditar.addSeparator();

        JMenu editarCaixaTexto = new JMenu("Caixa Texto");//--> criar entrada (Sub Menu Caixa de Texto (container)) no Menu Editar
        //add Menu Editar
        menuEditar.add(editarCaixaTexto);
        //adicionar Items ao Menu Caixa de Texto
        editarCaixaTexto.add(editarFont);
        editarCaixaTexto.add(editarCorTexto);
        editarCaixaTexto.add(editarAumentarTexto);
        editarCaixaTexto.add(editarReduzirTexto);
        

    }

    private void criarBarraFerramentas() {
        //adicionar botoes à barra de ferramentas
        // Abrir
        barraFerramenta.add(bfAbrir);
        bfAbrir.setToolTipText("Abrir Ficheiro");

        // Guardar
        barraFerramenta.add(bfGuardar);
        bfGuardar.setToolTipText("Guardar num documento de texto");
        
        barraFerramenta.addSeparator();
        // COPIAR
        barraFerramenta.add(bfCopiar);
        bfCopiar.setToolTipText("Copiar");
        
        // CORTAR
        barraFerramenta.add(bfCortar);
        bfCortar.setToolTipText("Cortar");
        
        // COLAR
        barraFerramenta.add(bfColar);
        bfColar.setToolTipText("Colar");
        
        barraFerramenta.addSeparator();
        
        // EDITAR FONT
        barraFerramenta.add(bfFont);
        bfFont.setToolTipText("Escolher tipo de letra");
        
        // COR TEXTO
        barraFerramenta.add(bfCorTexto);
        bfCortar.setToolTipText("Escolher cor do Texto");
        
        //AUMENTAR TEXTO
         barraFerramenta.add(bfAumentarTexto);
        bfCortar.setToolTipText("Aumentar Texto 5pt.");
        
        //DIMINUIR TEXTO
         barraFerramenta.add(bfReduzirTexto);
        bfCortar.setToolTipText("Reduzir Texto 5pt.");
        
        //adicionar barra de ferramentas á frame
        add(barraFerramenta, BorderLayout.NORTH);
   
    }

    // EVENTOS \\
    private void addEventos() {
        // JANELA
        //detectar click no X da Janela
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                confirmarSair();
            }
        });
        // SLIDER
        slider.addChangeListener((ChangeEvent e) -> {
            caixaTexto.setBackground(new Color(slider.getValue(), slider.getValue(), slider.getValue()));
            caixaTexto.setForeground(new Color(100, 100, slider.getValue()));
        });

        // ----------- MENU FICHEIRO ----------- \\
        // SAIR
        ficheiroSair.addActionListener((ActionEvent e) -> {
            confirmarSair();
        });
        // ABRIR
        ficheiroAbrir.addActionListener((ActionEvent e) -> {
            abrirFicheiro();
        });
        // GUARDAR
        ficheiroGuardar.addActionListener((ActionEvent e) -> {
            gravarFicheiro();
        });

        // ----------- MENU EDITAR ----------- \\
        // COPIAR
        editarCopiar.addActionListener((ActionEvent e) -> {
            copiar();
        });
        // CORTAR
        editarCortar.addActionListener((ActionEvent e) -> {
            cortar();
        });
        // COLAR
        editarColar.addActionListener((ActionEvent e) -> {
            colar();
        });
        
                // ----------- SUB MENU CAIXA DE TEXTO ----------- \\
        // MUDAR COR DE TEXTO
        editarCorTexto.addActionListener((ActionEvent e) -> {
            escolherCorTexto();
        });
        // AUMENTAR TEXTO 5PX
        editarAumentarTexto.addActionListener((ActionEvent e) -> {
            aumentarTexto5px();
        });
        // REDUZIR TEXTO 5PX
        editarReduzirTexto.addActionListener((ActionEvent e) -> {
            reduzirTexto5px();
        });
        // TIPO DE LETRA
        editarFont.addActionListener((ActionEvent e) -> {
            escolherFont();
        });
        
                  // ----------- BARRA DE FERRAMENTAS ----------- \\
        // BOTÃO ABRIR
        bfAbrir.addActionListener((ActionEvent e) -> {
            abrirFicheiro();
        });
        // BOTÃO FECHAR
        bfGuardar.addActionListener((ActionEvent e) -> {
            gravarFicheiro();
        });
        // BOTÃO COPIAR
        bfCopiar.addActionListener((ActionEvent e) -> {
            copiar();
        });
        // BOTÃO CORTAR
        bfCortar.addActionListener((ActionEvent e) -> {
            cortar();
        });
        // BOTÃO COLAR
        bfColar.addActionListener((ActionEvent e) -> {
            colar();
        });
        // BOTÃO COR TEXTO
        bfCorTexto.addActionListener((ActionEvent e) -> {
            escolherCorTexto() ;
        });
        // BOTÃO AUMENTAR TEXTO
        bfAumentarTexto.addActionListener((ActionEvent e) -> {
            aumentarTexto5px();
        });
        // BOTÃO REDUZIR TEXTO
        bfReduzirTexto.addActionListener((ActionEvent e) -> {
            reduzirTexto5px();
        });
        // BOTÂO TIPO DE LETRA
        bfFont.addActionListener((ActionEvent e) -> {
            escolherFont();
        });
    }

    // ICONS \\
    private void addIcons() {
        //BARRA MENU FICHEIRO
        ficheiroAbrir.setIcon(new ImageIcon(getClass().getResource("/icons/Folder.png")));
        ficheiroGuardar.setIcon(new ImageIcon(getClass().getResource("/icons/Save.png")));
        ficheiroSair.setIcon(new ImageIcon(getClass().getResource("/icons/Turn off.png")));
        
        //BARRA MENU EDITAR
        editarCopiar.setIcon(new ImageIcon(getClass().getResource("/icons/Copy.png")));
        editarCortar.setIcon(new ImageIcon(getClass().getResource("/icons/Cut.png")));
        editarColar.setIcon(new ImageIcon(getClass().getResource("/icons/Paste.png")));
        editarCorTexto.setIcon(new ImageIcon(getClass().getResource("/icons/3d bar chart.png")));
        editarAumentarTexto.setIcon(new ImageIcon(getClass().getResource("/icons/Up.png")));
        editarReduzirTexto.setIcon(new ImageIcon(getClass().getResource("/icons/Down.png")));
        editarFont.setIcon(new ImageIcon(getClass().getResource("/icons/Modify.png")));
        
        //BARRA FERRAMENTAS BOTOES 
        bfAbrir.setIcon(new ImageIcon(getClass().getResource("/icons/Folder.png")));
        bfGuardar.setIcon(new ImageIcon(getClass().getResource("/icons/Save.png")));
        bfCopiar.setIcon(new ImageIcon(getClass().getResource("/icons/Copy.png")));
        bfCortar.setIcon(new ImageIcon(getClass().getResource("/icons/Cut.png")));
        bfColar.setIcon(new ImageIcon(getClass().getResource("/icons/Paste.png")));
        bfCorTexto.setIcon(new ImageIcon(getClass().getResource("/icons/3d bar chart.png")));
        bfAumentarTexto.setIcon(new ImageIcon(getClass().getResource("/icons/Up.png")));
        bfReduzirTexto.setIcon(new ImageIcon(getClass().getResource("/icons/Down.png")));
        bfFont.setIcon(new ImageIcon(getClass().getResource("/icons/Modify.png")));
    }

    // FUNCOES \\
    public void confirmarSair() {
        // SAIR
        // quando a janela fechar
        if (JOptionPane.showConfirmDialog(rootPane, "Quer gravar antes de sair", "Gravar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
            gravarFicheiro();
            System.exit(0);
        } else {
            if (JOptionPane.showConfirmDialog(rootPane, "Tem a certeza que quer Sair", "Sair", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }

    }

    public void copiar() {
        Clipboard clipCopy = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection strCopy = new StringSelection(caixaTexto.getText());
        clipCopy.setContents(strCopy, strCopy);
    }

    public void cortar() {
        Clipboard clipCut = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection strCut = new StringSelection(caixaTexto.getText());
        clipCut.setContents(strCut, strCut);
        caixaTexto.setText("");
    }

    public void colar() {
        Clipboard clipCut = Toolkit.getDefaultToolkit().getSystemClipboard();
        try {
            Transferable paste = clipCut.getContents(null);
            if (paste.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                caixaTexto.setText((String) paste.getTransferData(DataFlavor.stringFlavor));
            }
        } catch (Exception ex) {
            caixaTexto.setText("");
        }
    }

    // CAIXA TEXTO
    public void escolherFont(){
        Fonte caixaDialogo = new Fonte(this, true);
        caixaDialogo.setVisible(true);
        
        if (!caixaDialogo.getCancelar()){
            Font novaFonte = new Font(caixaDialogo.getTipoLetra(), caixaTexto.getFont().getStyle(), caixaTexto.getFont().getSize());

            //aplicar
            caixaTexto.setFont(novaFonte);
        }
    };
    
    public void escolherCorTexto() {
        Color corInicial = caixaTexto.getForeground();
        Color corSeleccionada = JColorChooser.showDialog(rootPane, "Seleccione uma cor", corInicial);

        if (corInicial != corSeleccionada && corSeleccionada != null) {
            caixaTexto.setForeground(corSeleccionada);
        }
    }

    public void aumentarTexto5px() {
        int aumentar = caixaTexto.getFont().getSize() + 5;
        caixaTexto.setFont(new Font(caixaTexto.getFont().getFamily(), caixaTexto.getFont().getStyle(), aumentar));
    }

    public void reduzirTexto5px() {
        int reduzir = caixaTexto.getFont().getSize() - 5;
        caixaTexto.setFont(new Font(caixaTexto.getFont().getFamily(), caixaTexto.getFont().getStyle(), reduzir));
    }

    // FICHEIROS
    private void abrirFicheiro() {
        abrirFicheiroTxt();
        if (sistemaFicheiros.showOpenDialog(this) == JOptionPane.OK_OPTION) {
            // iniciar leitura do ficheiro seleccionado
            caixaTexto.setText("");
            try {
                String linhaLida;
                FileReader ficheiro = new FileReader(sistemaFicheiros.getSelectedFile());
                BufferedReader entradaDados = new BufferedReader(ficheiro);

                while ((linhaLida = entradaDados.readLine()) != null) {
                    caixaTexto.append(linhaLida + "\n");
                }
                entradaDados.close();
                ficheiro.close();

            } catch (IOException erro) {
                JOptionPane.showMessageDialog(rootPane, "Erro ao abrir ficheiro!\n" + erro, "Abrir Ficheiro", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    public void abrirFicheiroTxt() {
        sistemaFicheiros.setFileFilter(filterTxt);
    }

    private void gravarFicheiro() {
        if (sistemaFicheiros.showSaveDialog(this) == JOptionPane.OK_OPTION) {

            try {
                String nomeFicheiro = gravarFicheiroTxt();

                FileWriter ficheiro = new FileWriter(nomeFicheiro);
                BufferedWriter saidaDados = new BufferedWriter(ficheiro);

                saidaDados.write(caixaTexto.getText());
                saidaDados.close();
                ficheiro.close();

            } catch (IOException erro) {
                JOptionPane.showMessageDialog(rootPane, "Erro ao guardar ficheiro!\n" + erro, "Abrir Ficheiro", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    public String gravarFicheiroTxt() {
        String nomeFicheiro = sistemaFicheiros.getSelectedFile().toString();
        String extensao = nomeFicheiro.substring(nomeFicheiro.length() - 4).toLowerCase();
        if (!extensao.equals(".txt")) {
            nomeFicheiro += ".txt";
        }
        return nomeFicheiro;
    }

// ------------- MAIN --------------- \\
    public static void main(String[] args) {
        new JanelaEditor();
    }
}
