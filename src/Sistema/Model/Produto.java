package Sistema.Model;

import java.util.Scanner;

public class Produto {
    private short produtoId;
    private String nomeProduto;
    private String numProduto;
    private double valorProduto;
    private short quantidade_estoque;

    public Produto() {
    }

    public double escolhaProdutos(Scanner in) {
        double totalCompra = 0.0;
        boolean continuar = true;

        while (continuar) {
            System.out.println("\nSelecione um produto:");
            System.out.println("1. Camiseta - R$50,00");
            System.out.println("2. Calça - R$100,00");
            System.out.println("3. Tênis - R$200,00");
            System.out.println("4. Boné - R$30,00");
            System.out.println("5. Cancelar último item");
            System.out.println("0. Finalizar compra");
            int opcao = in.nextInt();

            switch (opcao) {
                case 1 -> totalCompra += calcularPreco(in, "Camiseta", 50.0);
                case 2 -> totalCompra += calcularPreco(in, "Calça", 100.0);
                case 3 -> totalCompra += calcularPreco(in, "Tênis", 200.0);
                case 4 -> totalCompra += calcularPreco(in, "Boné", 30.0);

                case 5 -> totalCompra = cancelarUltimoItem(in, totalCompra);
                case 0 -> {
                    System.out.println("Finalizando compra...");
                    continuar = false;
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }

            System.out.println("Total parcial: R$" + totalCompra);
        }

        return totalCompra;
    }

    // Método para cancelar o último item adicionado
    public double cancelarUltimoItem(Scanner in, double totalCompra) {
        if (totalCompra > 0) {
            System.out.print("Digite o valor do item a ser removido: ");
            double valorRemovido = in.nextDouble();
            if (valorRemovido <= totalCompra) {
                totalCompra -= valorRemovido;
                System.out.println("Item removido. Novo total: R$" + totalCompra);
            } else {
                System.out.println("Valor inválido. Nenhuma alteração feita.");
            }
        } else {
            System.out.println("Nenhum item na compra para remover.");
        }
        return totalCompra;
    }

    // Método para calcular o preço do produto selecionado
    public double calcularPreco(Scanner in, String produto, double precoUnitario) {
        System.out.print("Quantas unidades de " + produto + " deseja comprar? ");
        int quantidade = in.nextInt();

        double total = quantidade * precoUnitario;

        System.out.println("Deseja adicionar um acessório?");
        System.out.println("1. Sim (+ R$10,00 por unidade)");
        System.out.println("2. Não");
        int opcaoAdicional = in.nextInt();

        if (opcaoAdicional == 1) {
            total += quantidade * 10.0;
            System.out.println("Acessório adicionado.");
        }

        System.out.println("Valor total para " + produto + ": R$" + total);
        return total;
    }


    @Override
    public String toString() {
        return "Produto{" +
                "produtoId=" + produtoId +
                ", nomeProduto='" + nomeProduto + '\'' + 
                ", numProduto='" + numProduto + '\'' +
                ", valorProduto=" + valorProduto +
                ", quantidade_estoque=" + quantidade_estoque +
                '}';
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
}

