/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agentelimpeza;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author lailson
 */
public class AgenteLimpeza {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Celula passo = new Celula(0,0);
        Tabuleiro ambiente = new Tabuleiro(5,5);
        ambiente.setObjetosAleatorios();
        ambiente.imprimeTabuleiro();
        Agente agente = new Agente(0,0,ambiente);
        int passos=0;
        while(ambiente.getCountSujas() != 0) {
            
            passo = agente.proximoPasso(passo.getX(),passo.getY(), passo);
            ambiente.imprimeTabuleiro();
            System.out.println("");
            passos++;
         //   if (passos>= )
           
        }
        ambiente.imprimeTabuleiro(); 
        System.out.println("Total de passes: "+agente.getContPassos());
      
    }


}
