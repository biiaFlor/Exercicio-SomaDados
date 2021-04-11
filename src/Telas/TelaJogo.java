package Telas;

/**
 * @author Beatriz
 */

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static java.lang.Integer.parseInt;
import javax.swing.JTextField;
import ProcessaDados.JogoDado;

public class TelaJogo extends JFrame{
    private JPanel painelPrincipal;
    private JPanel painelBotoes;
    
    private JButton botaoJogar;
    private JButton botaoSair;    
    
    private JTextField textboxNumeroInserido;

    private JogoDado jogoDado;
            
    public TelaJogo(){
        criarComponentes();
        inciaJogo();
    }
    
    private void inciaJogo(){
        jogoDado = new JogoDado();
        jogoDado.setNumeroGerado();
    }
    
    private void criarComponentes(){
        botaoJogar = new JButton("Jogar");
        botaoJogar.addActionListener((e)-> {
            jogaJogo();
        });
        
        botaoSair = new JButton("Sair");
        botaoSair.addActionListener((e) -> {
            sair();
        });
        
        textboxNumeroInserido = new JTextField(10);
        
        painelPrincipal = new JPanel();
        painelBotoes = new JPanel(); 
        
        painelBotoes.setBorder(BorderFactory.createTitledBorder("Qual a soma dos dados?"));
        painelBotoes.add(textboxNumeroInserido);
        painelBotoes.add(botaoJogar);
        painelBotoes.add(botaoSair);
        painelPrincipal.add(painelBotoes);     
        
        add(painelPrincipal);
        
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private void jogaJogo() {
        if(!textboxNumeroInserido.getText().equals("")){
            if(textboxNumeroInserido.getText().matches("[0-9]+")){
                int palpite = parseInt(textboxNumeroInserido.getText());
                jogoDado.setNumeroRecebido(palpite);
                jogoDado.resultadoJogo();
            }
            else{
                JOptionPane.showMessageDialog(null, "Ops! São permitidos apenas números nesse jogo.");
            }
        }
        else{
           JOptionPane.showMessageDialog(null, "Ops! Você esqueceu de dar seu palpite.");
        }
    }
    
    private void sair() {
        System.exit(0);
    }
}
