package Telas;

/**
 * @author Beatriz
 */

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class Tela extends JFrame{
    private final String urlImage = "src\\Imagem\\dados.png";
    private JPanel painelPrincipal;
    private JPanel painelImagem;
    private JPanel painelBotoes;
    
    private JButton botaoIniciar;
    private JButton botaoSair;
    
    public Tela(){
        criarComponentes();
    }
    
    private void criarComponentes(){        
        botaoIniciar = new JButton("Iniciar");
        botaoIniciar.addActionListener((e)-> {
            iniciaJogo();
        });
        
        botaoSair = new JButton("Sair");
        botaoSair.addActionListener((e) -> {
            sair();
        });
        
        JLabel labelFundo = new JLabel();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(urlImage).getImage().getScaledInstance(90, 80, Image.SCALE_DEFAULT));
        labelFundo.setIcon(imageIcon);
        
        painelPrincipal = new JPanel();
        painelImagem = new JPanel();         
        painelBotoes = new JPanel(); 
        
        painelImagem.add(labelFundo);

        painelBotoes.add(botaoIniciar);
        painelBotoes.add(botaoSair);
        
        painelPrincipal.add(painelImagem); 
        painelPrincipal.add(painelBotoes); 
        
        add(painelPrincipal);
        
        setTitle("Jogo dos dados");
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private void iniciaJogo() {
        TelaJogo telaJogo = new TelaJogo();
        telaJogo.setVisible(true);
    }
    
    private void sair() {
        System.exit(0);
    }
}
