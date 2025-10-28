import java.util.ArrayList;
import java.util.List;

/*
 * Usa a Fonte, o Problema e a Política para rodar 'n' rodadas
 * e calcular a soma e a média simulada, comparando com a real
 */
public class Simulador {

    private FonteNumerosAleatorios fonte;
    private ProblemaSimulacao problema;
    private PoliticaEscolha politica;

    public Simulador(FonteNumerosAleatorios fonte, ProblemaSimulacao problema, PoliticaEscolha politica) {
        this.fonte = fonte;
        this.problema = problema;
        this.politica = politica;
    }

    public void rodarSimulacao(int n) {
        // 1. Usa a política para sortear 'n' números
        List<Integer> numerosSorteados = politica.sortearNumeros(fonte, n);

        // 2. Armazena os valores simulados
        List<Integer> valoresSimulados = new ArrayList<>();
        
        // 3. Calcula a SOMA
        long somaSimulada = 0;

        // for (int numero : numerosSorteados) {
        for (int i = 0; i < numerosSorteados.size(); i++) {
            int valor = problema.getValorSimulado(numerosSorteados.get(i));
            
            if (valor != -1) {
                valoresSimulados.add(valor);
                somaSimulada += valor;
            }
        }

        // 4. Calcula a MÉDIA SIMULADA
        double mediaSimulada = (double) somaSimulada / n;

        // 5. Pega a MÉDIA PONDERADA REAL
        double mediaRealPonderada = problema.getMediaPonderadaReal();

        // 6. Imprime o Relatório
        System.out.println("\n--- RELATÓRIO DA SIMULAÇÃO (" + n + " RODADAS) ---");
        System.out.println("Soma dos Valores Simulados: " + somaSimulada);
        System.out.printf("Média Simulada (Soma/N):  %.4f\n", mediaSimulada);
        System.out.printf("Média Ponderada (Real):   %.4f\n", mediaRealPonderada);
        System.out.printf("Diferença (Simulada - Real): %.4f\n", (mediaSimulada - mediaRealPonderada));
        System.out.println("==============================================");
    }
}