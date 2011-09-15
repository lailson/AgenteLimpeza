/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agentelimpeza;

/**
 *
 * @author lailson
 */
public class Celula {
    private int x; // Linha
    private int y; // Coluna
    private int valor;

    public Celula(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    
    
}
