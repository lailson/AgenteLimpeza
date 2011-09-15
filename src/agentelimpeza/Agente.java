/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agentelimpeza;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author lailson
 */
public class Agente {

    private Tabuleiro ambiente;
    private int contPassos = 0; // Conta o numero de passos dado pelo Agente
    private int contLimpas; // Conta o numero de Sujeira que o Agente limpou
    private Stack<Celula> passos; // Pilha de celulas que o Agente andou
    private ArrayList<Celula> adjacentes = new ArrayList<Celula>(); // Lista de Adjacentes de uma determinada celula
    private Celula atual; // Celula atual - Onde o agente se encontra
    private int flag =0;
    
    public Agente(int x, int y, Tabuleiro ambiente) {
        atual = new Celula(x, y);
        try {
            this.passos.add(atual);
        } catch (Exception e) {
        }
        this.ambiente = ambiente;
    }

    public Celula proximoPasso(int x, int y, Celula anterior) {
        for(;;){ 
        int i, j;
        Celula proxima = new Celula(0, 0);
        
        //System.out.println("Anterior: X: "+anterior.getX()+" Y: " +anterior.getY());
        // Procurar Celulas que são adjacentes e estão sujas
        for (i = 0; i < ambiente.getNrLinhas(); i++) {
            for (j = 0; j < ambiente.getNrColunas(); j++) {
                //System.out.println("i: "+i+" j: "+j+" x: "+x+" y: "+y );
                if (ambiente.estaSuja(i, j)) //System.out.println("esta suja");
                {
                    if (ambiente.isAdjacente(x, y, i, j) && ambiente.estaSuja(i, j) ) {
                        ambiente.setObjeto(anterior.getX(), anterior.getY(), 0);
                        proxima.setX(i);
                        proxima.setY(j);
                       
                        ambiente.setObjeto(i, j, 3); 
                        System.out.println("O Agente foi para a Celula Suja : " + "X: " + proxima.getX() + " Y: " + proxima.getY());
                        contPassos++;
                        return proxima;
                    }
                }
            }
        }
        flag = (int) (Math.random() * 4);
        int aux = x+1; // Direita
        if (ambiente.isAdjacente(x, y, aux, y) && aux<ambiente.getNrColunas() && !ambiente.temObstaculo(aux, y) && flag==0){
            ambiente.setObjeto(anterior.getX(), anterior.getY(), 0);
            proxima.setX(aux);
            proxima.setY(y);
            ambiente.setObjeto(aux, y, 3);
            System.out.println("O Agente foi para a Celula da Direita: "+"X: "+ proxima.getX()+" Y: "+proxima.getY());
            System.out.println("Anterior- X: "+anterior.getX()+" Y: "+anterior.getY()+ "\nProxima- X: "+ proxima.getX()+" Y: "+proxima.getY());
            contPassos++;
            return proxima;
        } 
        
        aux = y+1; // Cima
        if (ambiente.isAdjacente(x, y, x, aux) && aux<ambiente.getNrColunas() && !ambiente.temObstaculo(x, aux) && flag==1){
            ambiente.setObjeto(anterior.getX(), anterior.getY(), 0);
            proxima.setX(x);
            proxima.setY(aux);
            
            ambiente.setObjeto(x,aux, 3);
            System.out.println("O Agente foi para a Celula de Cima: "+"X: "+ proxima.getX()+" Y: "+proxima.getY());
            System.out.println("Anterior- X: "+anterior.getX()+" Y: "+anterior.getY()+ "\nProxima- X: "+ proxima.getX()+" Y: "+proxima.getY());
            contPassos++;
            return proxima;
        }
        
        aux = x-1; // Traz
        if (ambiente.isAdjacente(x, y, aux,y) && aux>=0 && !ambiente.temObstaculo(aux, y) && flag == 2){
            ambiente.setObjeto(anterior.getX(), anterior.getY(), 0);
            proxima.setX(aux);
            proxima.setY(y);
            ambiente.setObjeto(aux,y, 3);
            System.out.println("O Agente foi para a Celula de traz: "+"X: "+ proxima.getX()+" Y: "+proxima.getY());
            System.out.println("Anterior- X: "+anterior.getX()+" Y: "+anterior.getY()+ "\nProxima- X: "+ proxima.getX()+" Y: "+proxima.getY());
            contPassos++;
            return proxima;
        }
        
        aux = y-1; // Baixo
        if (ambiente.isAdjacente(x, y, x,aux) && aux>=0 && !ambiente.temObstaculo(x, y-1) && flag == 3){
            ambiente.setObjeto(anterior.getX(), anterior.getY(), 0);
            proxima.setX(x);
            proxima.setY(y-1);
            ambiente.setObjeto(x,y-1, 3);
            System.out.println("O Agente foi para a Celula de baixo: "+"X: "+ proxima.getX()+" Y: "+proxima.getY());
            System.out.println("Anterior- X: "+anterior.getX()+" Y: "+anterior.getY()+ "\nProxima- X: "+ proxima.getX()+" Y: "+proxima.getY());
            contPassos++;
            return proxima;
        }
       flag = (int) (Math.random() * 4);
        }
             
       
    }

    public int getContLimpas() {
        return contLimpas;
    }

    public int getContPassos() {
        return contPassos;
    }
    
    
}
