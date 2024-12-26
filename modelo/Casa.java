package modelo;

import java.io.Serializable;

public class Casa extends Financiamento implements Serializable {
    private static final long serialVersionUID = 1L; // Número de versão para garantir consistência na serialização
    private double areaConstruida;
    private double areaTerreno;

    // Construtor padrão vazio necessário para serialização
    public Casa() {
        super(0.0, 0, 0.0); // Valores padrão, você pode ajustar conforme necessário
        this.areaConstruida = 0.0;
        this.areaTerreno = 0.0;
    }

    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, double areaConstruida, double areaTerreno) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.areaConstruida = areaConstruida;
        this.areaTerreno = areaTerreno;
    }

    @Override
    public void mostrarDadosEspecificos() {
        System.out.println("Área construída: " + areaConstruida + " m²");
        System.out.println("Tamanho do terreno: " + areaTerreno + " m²");
    }

    public boolean validarJuros(double valorJuros, double valorAcrescimo) throws DescontoMaiorDoQueJurosException {
        if (valorAcrescimo > valorJuros) {
            throw new DescontoMaiorDoQueJurosException("O acréscimo é maior do que os juros da mensalidade.");
        }
        return true;
    }

    @Override
    public double calcularPagamentoMensal() {
        double pagamentoMensalBase = super.calcularPagamentoMensal();
        double acrescimo = 80; // Acréscimo de R$ 80 ao pagamento mensal

        // Calcula os juros mensais
        double jurosMensal = getValorImovel() * (getTaxaJurosAnual() / 12);

        try {
            validarJuros(jurosMensal, acrescimo);
        } catch (DescontoMaiorDoQueJurosException e) {
            System.out.println("Erro ao validar juros: " + e.getMessage());
            acrescimo = jurosMensal; // Define o acréscimo para ser igual aos juros
        }

        return pagamentoMensalBase + acrescimo;
    }

    @Override
    public String toString() {
        return "Casa{" +
                "valorImovel=" + getValorImovel() +
                ", prazoFinanciamento=" + getPrazoFinanciamento() +
                ", taxaJurosAnual=" + getTaxaJurosAnual() +
                ", areaConstruida=" + areaConstruida +
                ", areaTerreno=" + areaTerreno +
                '}';
    }
}