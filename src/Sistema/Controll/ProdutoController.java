package Sistema.Controll;

import Sistema.Model.Produto;

import java.util.Scanner;

public class ProdutoController {

    // Método para realizar a compra
    public static Produto realizarCompra(Produto produto) {
        Scanner in = new Scanner(System.in);

        double totalCompra = produto.escolhaProdutos(in);
        System.out.println("Compra finalizada. Total a pagar: R$" + totalCompra);

        return produto;
    }

}