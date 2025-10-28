import java.util.ArrayList;
import java.util.List;

/*
 * Define o problema a ser simulado
 * Armazena as faixas de probabilidade e as frequências reais
 * para calcular a média ponderada
 */
public class ProblemaSimulacao {

    private static class FaixaProbabilidade {
        int valor;
        int min;
        int max;
        FaixaProbabilidade(int valor, int min, int max) {
            this.valor = valor; this.min = min; this.max = max;
        }
    }

    private static class ValorFrequencia {
        int valor;
        double frequencia;
        ValorFrequencia(int valor, double frequencia) {
            this.valor = valor; this.frequencia = frequencia;
        }
    }

    private List<FaixaProbabilidade> faixas;
    private List<ValorFrequencia> frequenciasReais;

    public ProblemaSimulacao() {
        this.faixas = new ArrayList<>();
        this.frequenciasReais = new ArrayList<>();
    }

    // Adiciona uma faixa de probabilidade
    public void addFaixa(int valor, int min, int max) {
        faixas.add(new FaixaProbabilidade(valor, min, max));
    }

    // Adiciona a frequência real para o cálculo da média ponderada
    public void addFrequenciaReal(int valor, double frequencia) {
        frequenciasReais.add(new ValorFrequencia(valor, frequencia));
    }

    // Recebe um número sorteado e retorna o valor correspondente
    public int getValorSimulado(int numeroSorteado) {
        for (int i = 0; i < faixas.size(); ++i) {
            FaixaProbabilidade faixa = faixas.get(i);
            if (numeroSorteado >= faixa.min && numeroSorteado <= faixa.max) {
                return faixa.valor;
            }
        }
        // Retorna -1 se o número não cair em nenhuma faixa (erro)
        return -1; 
    }

    // Calcula a Média Ponderada Real do problema
    public double getMediaPonderadaReal() {
        double somaPonderada = 0.0;
        for (int i = 0; i < frequenciasReais.size(); ++i) {
            ValorFrequencia vf = frequenciasReais.get(i);
            somaPonderada += (vf.valor * vf.frequencia);
        }
        return somaPonderada;
    }
}