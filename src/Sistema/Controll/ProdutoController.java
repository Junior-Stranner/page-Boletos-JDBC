package Sistema.Controll;

import Sistema.Model.Produto;

import java.util.Scanner;

public class ProdutoController {

    public static void realizarCompra() {
        Scanner in = new Scanner(System.in);
        Produto produto = new Produto();

        double totalCompra = produto.escolhaProdutos(in);

        System.out.println("Compra finalizada. Total a pagar: R$" + totalCompra);
    }
}
