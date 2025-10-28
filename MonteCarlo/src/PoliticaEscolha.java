import java.util.ArrayList;
import java.util.List;

/*
 * Define a política de como navegar na Fonte de Números e
 * como extrair os dígitos para formar o número aleatório final
 */
public class PoliticaEscolha {

    private int linhaInicial;
    private int colunaInicial;
    private int[] indicesDosDigitos;
    private FonteNumerosAleatorios matriz;

    public PoliticaEscolha(int linhaInicial, int colunaInicial, int[] indicesDosDigitos, FonteNumerosAleatorios matriz) {
        this.linhaInicial = linhaInicial;
        this.colunaInicial = colunaInicial;
        this.indicesDosDigitos = indicesDosDigitos;
        this.matriz = matriz;
    }

    // Extrai os dígitos de um número de 6 dígitos, com base na política
    private String extrairDigitos(String numeroSeisDigitos) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < indicesDosDigitos.length; i++) {
            int indice = indicesDosDigitos[i];
            // Pega o caractere no índice especificado
            if (indice >= 0 && indice < numeroSeisDigitos.length()) {
                sb.append(numeroSeisDigitos.charAt(indice));
            }
        }
        return sb.toString();
    }

    // Executa a política para sortear 'n' números da fonte
    public List<Integer> sortearNumeros(FonteNumerosAleatorios fonte, int n) {
        List<Integer> numerosSorteados = new ArrayList<>();
        
        System.out.println("\nIniciando sorteio de " + n + " números com a política:");
        System.out.println(" - Começando em: (linha " + linhaInicial + ", coluna " + colunaInicial + ")");
        System.out.println(" - Extraindo dígitos nos índices: " + java.util.Arrays.toString(indicesDosDigitos));
        System.out.println("----------------------------------------");

        for (int i = 0; i < n; i++) {
            // 1. Define a navegação (Política simples: vertical, pulando coluna se estourar)
            int linhaAtual = (this.linhaInicial + i) % matriz.getLinhas(); 
            int colunaAtual = this.colunaInicial + ((this.linhaInicial + i) / matriz.getColunas()); 

            // 2. Pega o número "fonte" de 6 dígitos
            String numFonte = fonte.getNumero(linhaAtual, colunaAtual);

            // 3. Extrai os dígitos conforme a política
            String numExtraido = extrairDigitos(numFonte);

            // 4. Converte para inteiro e adiciona à lista
            numerosSorteados.add(Integer.parseInt(numExtraido));
        }
        
        System.out.println("Sorteio concluído. " + numerosSorteados.size() + " números extraídos.");
        return numerosSorteados;
    }
}