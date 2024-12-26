package modelo;

import java.io.Serializable;

public class Apartamento extends Financiamento implements Serializable {
    private static final long serialVersionUID = 1L; // Número de versão para garantir consistência na serialização
    private int numeroVagas;
    private int numeroAndar;


    public Apartamento() {
        super(0.0, 0, 0.0); // Valores padrão, você pode ajustar conforme necessário
        this.numeroVagas = 0;
        this.numeroAndar = 0;
    }

    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, int numeroVagas, int numeroAndar) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.numeroVagas = numeroVagas;
        this.numeroAndar = numeroAndar;
    }

    @Override
    public void mostrarDadosEspecificos() {
        System.out.println("Número de vagas na garagem: " + numeroVagas);
        System.out.println("Número do andar: " + numeroAndar);
    }

    @Override
    public double calcularPagamentoMensal() {
        double taxaMensal = getTaxaJurosAnual() / 12 / 100;
        int prazoMeses = getPrazoFinanciamento() * 12;
        double expoente = Math.pow(1 + taxaMensal, prazoMeses);
        double pagamentoMensal = (getValorImovel() * taxaMensal * expoente) / (expoente - 1);
        return pagamentoMensal;
    }

    @Override
    public String toString() {
        return "Apartamento{" +
                "valorImovel=" + getValorImovel() +
                ", prazoFinanciamento=" + getPrazoFinanciamento() +
                ", taxaJurosAnual=" + getTaxaJurosAnual() +
                ", numeroVagas=" + numeroVagas +
                ", numeroAndar=" + numeroAndar +
                '}';
    }
}