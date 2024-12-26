package util;

import java.util.Scanner;

public class InterfaceUsuario {
    private Scanner scanner;

    public InterfaceUsuario() {
        scanner = new Scanner(System.in);
    }

    public double pedirValorImovel() {
        double valor = 0;
        boolean entradaValida = false;

        do {
            try {
                System.out.println("\nDigite o valor do imóvel (somente valores positivos):");
                valor = scanner.nextDouble();

                if (valor <= 0) {
                    throw new IllegalArgumentException("Valor inválido. O valor do imóvel deve ser positivo.");
                }

                entradaValida = true; // Se chegou até aqui, a entrada é válida
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
                scanner.nextLine(); // Limpar o buffer do scanner
            }
        } while (!entradaValida);

        return valor;
    }

    public int pedirPrazoFinanciamento() {
        int prazo = 0;
        boolean entradaValida = false;

        do {
            try {
                System.out.println("Digite o prazo do financiamento em anos (somente valores positivos):");
                prazo = scanner.nextInt();

                if (prazo <= 0) {
                    throw new IllegalArgumentException("Valor inválido. O prazo do financiamento deve ser positivo.");
                }

                entradaValida = true; // Se chegou até aqui, a entrada é válida
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
                scanner.nextLine(); // Limpar o buffer do scanner
            }
        } while (!entradaValida);

        return prazo;
    }

    public double pedirTaxaJuros() {
        double taxa = 0;
        boolean entradaValida = false;

        do {
            try {
                System.out.println("Digite a taxa de juros anual (somente valores positivos):");
                taxa = scanner.nextDouble();

                if (taxa <= 0) {
                    throw new IllegalArgumentException("Valor inválido. A taxa de juros deve ser positiva.");
                }

                entradaValida = true; // Se chegou até aqui, a entrada é válida
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
                scanner.nextLine(); // Limpar o buffer do scanner
            }
        } while (!entradaValida);
        return taxa;
    }

    public double pedirAreaConstruida() {
        double taxa = 0;
        boolean entradaValida = false;

        do {
            try {
                System.out.println("Digite a área construída (somente valores positivos):");
                taxa = scanner.nextDouble();

                if (taxa <= 0) {
                    throw new IllegalArgumentException("Valor inválido. A taxa de juros deve ser positiva.");
                }

                entradaValida = true; // Se chegou até aqui, a entrada é válida
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
                scanner.nextLine(); // Limpar o buffer do scanner
            }
        } while (!entradaValida);
        return taxa;
    }

    public double pedirAreaTerreno() {
        double taxa = 0;
        boolean entradaValida = false;

        do {
            try {
                System.out.println("Digite a área do terreno (somente valores positivos):");
                taxa = scanner.nextDouble();

                if (taxa <= 0) {
                    throw new IllegalArgumentException("Valor inválido. A taxa de juros deve ser positiva.");
                }

                entradaValida = true; // Se chegou até aqui, a entrada é válida
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
                scanner.nextLine(); // Limpar o buffer do scanner
            }
        } while (!entradaValida);
        return taxa;
    }
}
