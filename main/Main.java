package main;

import modelo.Apartamento;
import modelo.Casa;
import modelo.Financiamento;
import modelo.Terreno;
import util.InterfaceUsuario;


import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
        ArrayList<Financiamento> financiamentos = new ArrayList<>();

        // Solicitando dados do utilizador para o primeiro financiamento
        System.out.println("\nInserindo dados para o Financiamento 1:");
        double valorImovel1 = interfaceUsuario.pedirValorImovel();
        int prazoFinanciamento1 = interfaceUsuario.pedirPrazoFinanciamento();
        double taxaJurosAnual1 = interfaceUsuario.pedirTaxaJuros();
        double areaConstruida1 = interfaceUsuario.pedirAreaConstruida();
        double areaTerreno1 = interfaceUsuario.pedirAreaTerreno();

        financiamentos.add(new Casa(valorImovel1, prazoFinanciamento1, taxaJurosAnual1, areaConstruida1, areaTerreno1));

        // Adicionando os demais financiamentos diretamente
        financiamentos.add(new Casa(500000, 10, 0.10, 800, 1000));
        financiamentos.add(new Apartamento(500000, 10, 0.10, 80, 10));
        financiamentos.add(new Apartamento(500000, 10, 0.10, 80, 10));
        financiamentos.add(new Terreno(500000, 10, 0.10, "Comercial"));

        // Calculando os totais
        double totalValorImoveis = 0;
        double totalValorFinanciamentos = 0;

        for (Financiamento financiamento : financiamentos) {
            totalValorImoveis += financiamento.getValorImovel();
            totalValorFinanciamentos += financiamento.calcularTotalPagamento();
        }

        // Formatando os valores para exibição
        DecimalFormat df = new DecimalFormat("#,##0.00");

        // Exibindo os resultados
        System.out.println("Detalhes dos Financiamentos:");
        for (int i = 0; i < financiamentos.size(); i++) {
            System.out.println("Financiamento " + (i + 1) + " - valor do imóvel: R$ " + df.format(financiamentos.get(i).getValorImovel())
                    + ", valor do financiamento: R$ " + df.format(financiamentos.get(i).calcularTotalPagamento()));
        }

        System.out.println("Total de todos os imóveis: R$ " + df.format(totalValorImoveis));
        System.out.println("Total de todos os financiamentos: R$ " + df.format(totalValorFinanciamentos));

        // Salvando os dados serializados
        salvarDadosSerializados(financiamentos);

        // Lendo os dados serializados
        ArrayList<Financiamento> financiamentosLidos = lerDadosSerializados();

        if (financiamentosLidos != null) {
            System.out.println("\nFinanciamentos lidos do arquivo serializado:");
            for (Financiamento financiamento : financiamentosLidos) {
                financiamento.mostrarDadosFinanciamento();
                financiamento.mostrarDadosEspecificos();
                System.out.println();
            }
        }
    }

    private static void salvarDadosSerializados(ArrayList<Financiamento> financiamentos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("financiamentos.txt"))) {
            oos.writeObject(financiamentos);  // Serializa o ArrayList de Financiamento
            System.out.println("\nDados serializados e salvos em 'financiamentos.txt'.");
        } catch (IOException e) {
            System.err.println("Erro ao salvar dados serializados: " + e.getMessage());
        }
    }
    private static ArrayList<Financiamento> lerDadosSerializados() {
        ArrayList<Financiamento> financiamentosLidos = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("financiamentos.txt"))) {
            Object obj = ois.readObject();
            if (obj instanceof ArrayList<?>) {
                financiamentosLidos = (ArrayList<Financiamento>) obj;
            } else {
                System.err.println("Erro: O objeto lido não é uma instância de ArrayList");
            }
        } catch (IOException | ClassNotFoundException e) {

        }
        return financiamentosLidos;
    }
}