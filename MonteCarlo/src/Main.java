public class Main {
    public static void main(String[] args) {
        
        // --- 1. DEFINIÇÃO DO PROBLEMA ---
        ProblemaSimulacao problema = new ProblemaSimulacao();
        
        // Adiciona as faixas de probabilidade 
        problema.addFaixa(4, 0, 14);
        problema.addFaixa(7, 15, 29);
        problema.addFaixa(8, 30, 67);
        problema.addFaixa(13, 68, 92);
        problema.addFaixa(14, 93, 99);

        // Adiciona as frequências reais para Média Ponderada
        problema.addFrequenciaReal(4, 0.15);
        problema.addFrequenciaReal(7, 0.15);
        problema.addFrequenciaReal(8, 0.38);
        problema.addFrequenciaReal(13, 0.25);
        problema.addFrequenciaReal(14, 0.07);

        // --- 2. GERAÇÃO DA FONTE DE NÚMEROS ---
        FonteNumerosAleatorios fonte = new FonteNumerosAleatorios(500, 500);

        // --- 3. DEFINIÇÃO DA POLÍTICA ---
        // A política é "tomando o segundo e o terceiro números"
        // Ex: "2[94]07" -> 94
        int[] indices = {1, 2}; // Pega o 2º e 3º dígito (índices 1 e 2)
        
        // Política: Começa na Coluna 0, Linha 0 e usa os índices {1, 2}
        PoliticaEscolha politicaExemplo = new PoliticaEscolha(0, 0, indices, fonte);

        // --- 4. EXECUÇÃO DO SIMULADOR ---
        Simulador simulador = new Simulador(fonte, problema, politicaExemplo);

        simulador.rodarSimulacao(40);

        simulador.rodarSimulacao(100000);
    }
}