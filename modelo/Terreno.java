package modelo;

import java.io.Serializable;

public class Terreno extends Financiamento implements Serializable {
    private static final long serialVersionUID = 1L; // Número de versão para garantir consistência na serialização
    private String tipoZona;

    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, String tipoZona) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.tipoZona = tipoZona;
    }

    // Construtor padrão vazio necessário para serialização
    public Terreno() {
        super(0.0, 0, 0.0); // Valores padrão, você pode ajustar conforme necessário
        this.tipoZona = "";
    }

    @Override
    public void mostrarDadosEspecificos() {
        System.out.println("Tipo de zona: " + tipoZona);
    }

    @Override
    public double calcularPagamentoMensal() {
        double pagamentoMensalBase = super.calcularPagamentoMensal();
        return pagamentoMensalBase * 1.02; // Acrescenta 2% ao pagamento mensal
    }

    @Override
    public String toString() {
        return "Terreno{" +
                "valorImovel=" + getValorImovel() +
                ", prazoFinanciamento=" + getPrazoFinanciamento() +
                ", taxaJurosAnual=" + getTaxaJurosAnual() +
                ", tipoZona='" + tipoZona + '\'' +
                '}';
    }
}
