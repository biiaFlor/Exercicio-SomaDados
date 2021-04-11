/**
 * @author Beatriz
 */
package ProcessaDados;

import java.util.Random;
import javax.swing.JOptionPane;

public class JogoDado {
    private int numeroGerado;    
    private int numeroRecebido;    
    private int chances = 3;
    
    public void JogaDado(){
        setNumeroGerado();
    }
    
    public void setNumeroGerado() {
        Random gerador = new Random();
        int soma;
        
        do{
            int num1 = gerador.nextInt(6);
            int num2 = gerador.nextInt(6);
            soma = num1+num2;
            this.numeroGerado = soma;
        }while(soma>12);
    }
    
    public void setNumeroRecebido(int num) {
        this.numeroRecebido = num;
    }
    
    public void jogaNovamente(){
        Object[] options = { "Sim", "Não" };
        int opcao = JOptionPane.showOptionDialog(null, "Deseja iniciar o jogo novamente?", "Fim de Jogo", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

        if(opcao == 0){
            this.chances = 3;
            setNumeroGerado();
        }
        else{
            System.exit(0);
        }
    }
    
    public void resultadoJogo(){
        if(this.numeroRecebido == this.numeroGerado){
           JOptionPane.showMessageDialog(null, "Ótimo palpite. Você acertou!");
           jogaNovamente();
        }
        else{
           this.chances--;
           if(this.chances>0){
                JOptionPane.showMessageDialog(null, "Ops, não foi dessa vez! Agora você só tem " + this.chances + " chances.");
           }
           else if(this.chances<0){
                JOptionPane.showMessageDialog(null, "Suas chances acabaram. Reinicie o jogo para mais chances");
                jogaNovamente();
           }
           else{
                JOptionPane.showMessageDialog(null, "Ops, não foi dessa vez! Suas chances acabaram. A soma dos números do dados era " + this.numeroGerado);
                jogaNovamente();
           }
        }
    } 
}
