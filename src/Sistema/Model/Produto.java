package Sistema.Model;

import java.util.List;
import java.util.Scanner;

public class Produto {
    private short produtoId;
    private String nomeProduto;
    private double valorProduto;
    private short quantidade_estoque;

    public Produto(short produtoId, String nomeProduto, double valorProduto, short quantidade_estoque) {
        this.produtoId = produtoId;
        this.nomeProduto = nomeProduto;
        this.valorProduto = valorProduto;
        this.quantidade_estoque = quantidade_estoque;
    }

    public Produto(String nomeProduto, double valorProduto) {
        this.nomeProduto = nomeProduto;
        this.valorProduto = valorProduto;
    }


    public static double calcularPreco(Scanner in, Produto produto) {
        System.out.print("Quantas unidades de " + produto.getNomeProduto() + " deseja comprar? ");
        int quantidade = in.nextInt();

        double total = quantidade * produto.getValorProduto();

        System.out.println("Deseja adicionar um acessório?");
        System.out.println("1. Sim (+ R$10,00 por unidade)");
        System.out.println("2. Não");
        int opcaoAdicional = in.nextInt();

        if (opcaoAdicional == 1) {
            total += quantidade * 10.0;
            System.out.println("Acessório adicionado.");
        }

        System.out.println("Valor total para " + produto.getNomeProduto() + ": R$" + total);
        return total;
    }


    public static double escolhaProdutos(Scanner in) {
        double totalCompra = 0.0;
        boolean continuar = true;
    
        List<Produto> produtosDisponiveis = List.of(
                new Produto("Camiseta", 50.0),
                new Produto("Calça", 100.0),
                new Produto("Tênis", 200.0),
                new Produto("Boné", 30.0)
        );
    
        while (continuar) {
            System.out.println("\nSelecione um produto:");
    
            for (int i = 0; i < produtosDisponiveis.size(); i++) {
                Produto produto = produtosDisponiveis.get(i);
                System.out.printf("%d. %s - R$%.2f%n", i + 1, produto.getNomeProduto(), produto.getValorProduto());
            }
    
            System.out.println("5. Cancelar último item");
            System.out.println("0. Finalizar compra");
            int opcao = in.nextInt();
    
            switch (opcao) {
                case 1, 2, 3, 4:
                    Produto selecionado = produtosDisponiveis.get(opcao - 1);
                    totalCompra += calcularPreco(in, selecionado); break;
                case 5: 
                    totalCompra = cancelarUltimoItem(in, totalCompra);break;
                case 0: 
                    System.out.println("Compra finalizada.");
                    continuar = false;break;
                default: 
                    System.out.println("Opção inválida. Tente novamente.");
            }
                System.out.printf("Total parcial: R$%.2f%n", totalCompra);
        }
    
        return totalCompra;
    }
    

    public static double cancelarUltimoItem(Scanner in, double totalCompra) {
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


    @Override
    public String toString() {
        return "Produto{" +
                "produtoId=" + produtoId +
                ", nomeProduto='" + nomeProduto + '\'' + 
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

    public double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public short getQuantidade_estoque() {
        return quantidade_estoque;
    }

    public void setQuantidade_estoque(short quantidade_estoque) {
        this.quantidade_estoque = quantidade_estoque;
    }
}

