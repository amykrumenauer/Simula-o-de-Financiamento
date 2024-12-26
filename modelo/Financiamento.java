package modelo;

public abstract class Financiamento {
    private double valorImovel;
    private int prazoFinanciamento;
    private double taxaJurosAnual;

    //Primeiro metódo construtor
    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    //Gets para cada atributo privado
    public double getValorImovel(){
        return this.valorImovel;
    }
    public int getPrazoFinanciamento() {
        return prazoFinanciamento;
    }
    public double getTaxaJurosAnual() {
        return taxaJurosAnual;
    }

    //Metódo abstrato que será implementado pelas subclasses
    public abstract void mostrarDadosEspecificos();

    // Método para mostrar os dados do financiamento
    public void mostrarDadosFinanciamento() {
        System.out.println("Valor do imóvel: R$" + valorImovel);
        System.out.println("Valor total do financiamento: R$" + calcularTotalPagamento());
    }

    //Segundo metódo para calcular pagamento mensal
    public double calcularPagamentoMensal() {
        double taxaMensal = taxaJurosAnual / 12 / 100; // Convertendo a taxa anual para mensal
        int prazoMeses = prazoFinanciamento * 12; // Convertendo o prazo do financiamento para meses
        double pagamentoMensal = (valorImovel * taxaMensal) / (1 - Math.pow(1 + taxaMensal, -prazoMeses));
        return pagamentoMensal;
    }

    //Terceiro metódo para calcular o total do pagamento
    public double calcularTotalPagamento() {
        return calcularPagamentoMensal() * prazoFinanciamento * 12;
    }
}