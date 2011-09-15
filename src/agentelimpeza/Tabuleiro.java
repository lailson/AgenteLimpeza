package agentelimpeza;

/**
 *
 * @author lailson
 */
public class Tabuleiro {

    // atributos
    private int nrLinhas;  // Define o tamanho do tabuleiro
    private int nrColunas; // .......
    private int tabuleiro[][]; // define uma matrizde posicões  - Ambiente

    /** Cria uma nova instância do Tabuleiro - Ambiente */
    public Tabuleiro(int nrLinhas, int nrColunas) {
        // recebe o tamanho do tabuleiro
        this.nrLinhas = nrLinhas;
        this.nrColunas = nrColunas;

        // instanciar a matriz
        tabuleiro = new int[nrLinhas][nrColunas];
        tabuleiro[0][0] = 3;

        // this.esvaziarTabuleiro();
    }

    /** Coloca um objeto numa determinada posicao do tabuleiro
     *  @param linha linha onde o objeto deve ser colocada
     *  @param coluna coluna onde o objeto deve ser colocada
     *  @param objeto a ser colocado
     *  0 -> Celula limpa
     *  1 -> Celula com sujeira
     *  2 -> Celula com obstaculo
     *  3 -> Celula com Agente 
     */
    public void setObjeto(int linha, int coluna, int objeto) {
        this.tabuleiro[linha][coluna] = objeto;
    }

    /** Retorna o objeto de uma determinada posicao do tabuleiro
     *  @param linha linha do objeto
     *  @param coluna coluna do objeto
     */
    public int getObjeto(int linha, int coluna) {
        return this.tabuleiro[linha][coluna];
    }

    /** Retorna se uma determinada posicao do tabuleiro esta lima - Valor 0 (Zero) 
     *  @param linha linha do objeto
     *  @param coluna coluna do objeto
     */
    public boolean estaLiimpa(int linha, int coluna) {
        return (this.tabuleiro[linha][coluna] == 0);
    }

    /** Retorna se uma determinada posicao do tabuleiro esta suja - Valor 1 (Um)  */
    public boolean estaSuja(int linha, int coluna) {
        return (this.tabuleiro[linha][coluna] == 1);
    }

    /** Retorna se uma determinada posicao do tabuleiro tem obstaculo - Valor 2 (Dois) */
    public boolean temObstaculo(int linha, int coluna) {
        return (this.tabuleiro[linha][coluna] == 2);
    }

    /** Limpa todo o tabuleiro - Setar todas as Celulas com valor 0 (Zero) */
    public void zerarTabuleiro() {
        int i, j;
        for (i = 0; i < this.nrLinhas; i++) {
            for (j = 0; j < this.nrColunas; j++) {
                this.tabuleiro[i][j] = 0;
            }
        }
    }

    /** Retorna o numero de Colunas do tabuleiro */
    public int getNrColunas() {
        return nrColunas;
    }

    /** Retorna o numero de Linhas do tabuleiro */
    public int getNrLinhas() {
        return nrLinhas;
    }

    /** Retorna quantidade de posicoes limpas */
    public int getCountLivres() {
        int i, j, count = 0;
        for (i = 0; i < this.nrLinhas; i++) {
            for (j = 0; j < this.nrColunas; j++) {
                if (this.tabuleiro[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    /** Retorna quantidade de posicoes sujas */
    public int getCountSujas() {
        int i, j, count = 0;
        for (i = 0; i < this.nrLinhas; i++) {
            for (j = 0; j < this.nrColunas; j++) {
                if (this.tabuleiro[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    /** Retorna quantidade de posicoes com obstáculos */
    public int getCountObstaculos() {
        int i, j, count = 0;
        for (i = 0; i < this.nrLinhas; i++) {
            for (j = 0; j < this.nrColunas; j++) {
                if (this.tabuleiro[i][j] == 2) {
                    count++;
                }
            }
        }
        return count;
    }

    /**Gerar objetos aleatórios no tabuleiro */
    public void setObjetosAleatorios() {
        int i, j;
        for (i = 0; i < this.nrLinhas; i++) {
            for (j = 0; j < this.nrColunas; j++) {
                if (i == 0 && j == 0) {
                    this.tabuleiro[0][0] = 3;
                } else {
                    this.tabuleiro[i][j] = (int) (Math.random() * 3);
                }
            }
        }

    }

    /* Verifica se uma celula é adjacente a outra 
     * @param x1 posicao atual em relacao ao eixo x
     * @param y1 posicao atual em relacao ao eixo y
     * @param x2 posicao a ser verificada em relacao ao eixo x
     * @param y2 posicao a ser verificada em relacao ao eixo y
     */
    public boolean isAdjacente(int x1, int y1, int x2, int y2) {
        // Verifica a célula de cima 
        if (x1 == x2 && y1 == y2 + 1 && y2 + 1 < this.nrColunas) {
            return true;
        }
        // Verifica a célula de baixo
        if (x1 == x2 && y1 == y2 - 1 && y2 - 1 >= 0) {
            return true;
        }
        // Verifica a célula da frente
        if (x1 == x2 + 1 && y1 == y2 && x2 + 1 < this.nrLinhas) {
            return true;
        }
        // Verifica a célula de traz
        if (x1 == x2 - 1 && y1 == y2 && x2 - 1 >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public void imprimeTabuleiro() {
        int i, j;
        for (j = nrLinhas-1; j >= 0; j--) {
            System.out.print("|");
            for (i=0; i<nrColunas; i++) {
                System.out.print(this.tabuleiro[i][j] + " ");
            }
            System.out.println("|");
        }
    }
    
    
//    public void imprimeTabuleiro1() {
//        int i, j;
//        for (j = nrLinhas-1; j >= 0; j--) {
//            System.out.print("|");
//            for (i=0; i<nrColunas; i++) {
//                System.out.print("x: "+ i + " y: "+ j);
//            }
//            System.out.println("|");
//        }
}
