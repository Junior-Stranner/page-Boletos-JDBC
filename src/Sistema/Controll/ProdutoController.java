package Sistema.Controll;

import Sistema.Model.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Sistema.Model.Produto.escolhaProdutos;

public class ProdutoController {

    private static List<Produto> produtos = new ArrayList<>();

    public static void realizarCompra() {
        Scanner in = new Scanner(System.in);

        double totalCompra = escolhaProdutos(in);
        System.out.println("Compra finalizada. Total a pagar: R$" + totalCompra);

        Produto produto = new Produto("Compra finalizada", totalCompra);
        produtos.add(produto);

        for (Produto p : produtos) {
            System.out.println(p.toString());
        }

        System.out.println("Total a pagar: R$" + totalCompra);
    }

    public static void mostrarProdutos(){
        for (Produto p : produtos){
            System.out.println(p.toString());
        }
    }

}