import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Gera uma matriz de números aleatórios de 6 dígitos
 * Garante que não há números repetidos na matriz
 */
public class FonteNumerosAleatorios {

    private String[][] matrizNumeros;
    private int linhas;
    private int colunas;

    public FonteNumerosAleatorios(int linhas, int colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.matrizNumeros = new String[linhas][colunas];
        
        System.out.println("Gerando fonte de " + (linhas * colunas) + " números aleatórios únicos de 6 dígitos...");
        
        // 1. Criar uma lista com todos os números possíveis de 0 a 999.999
        List<Integer> numerosPossiveis = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            numerosPossiveis.add(i);
        }

        // 2. Embaralhar a lista
        Collections.shuffle(numerosPossiveis);

        // 3. Preencher a matriz com os primeiros (linhas * colunas) números
        int k = 0; // Índice da lista embaralhada
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                if (k < numerosPossiveis.size()) {
                    // Formata o número para ter 6 dígitos, com zeros à esquerda
                    String numeroFormatado = String.format("%06d", numerosPossiveis.get(k));
                    this.matrizNumeros[i][j] = numeroFormatado;
                    k++;
                }
            }
        }
        System.out.println("Fonte de números aleatórios gerada com sucesso!");
        //printExemplo();
    }

    // Retorna o número de 6 dígitos em uma posição específica da matriz.
    public String getNumero(int linha, int coluna) {
        if (linha >= 0 && linha < this.linhas && coluna >= 0 && coluna < this.colunas) {
            return matrizNumeros[linha][coluna];
        }
        throw new IndexOutOfBoundsException("Posição (" + linha + "," + coluna + ") fora dos limites da matriz.");
    }

    // Imprime um pequeno exemplo (5x5) da matriz gerada para verificação.
    public void printExemplo() {
        System.out.println("--- Exemplo da Matriz Gerada (5x5) ---");
        for (int i = 0; i < 5 && i < this.linhas; i++) {
            for (int j = 0; j < 5 && j < this.colunas; j++) {
                System.out.print(matrizNumeros[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("----------------------------------------");
    }

    public int getLinhas() {
        return linhas;
    }

    public int getColunas() {
        return colunas;
    }

    
}