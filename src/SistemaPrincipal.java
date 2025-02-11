import Sistema.view.ClienteMenu;
import Sistema.view.UsuarioMenu;

import java.util.Scanner;

public class SistemaPrincipal {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int op = 0;
        try{
            do{
                System.out.println("User Menu"
                        +"\n 1 - Usuario"
                        +"\n 2 - Cliente"
                        +"\n 3 - Produto"
                        +"\n 4 - Pagamento"
                        +"\n 5 - Boleto");
                op = Integer.parseInt(in.nextLine());

                switch(op){

                    case 1:UsuarioMenu.usuarioMenu();break;
                    case 2:ClienteMenu.clienteMenu(usuarios, clientes);break;
                    case 3:;break;
                    case 4:;break;
                    default:System.out.println("Voltando para o Sistema Principal");
                        break;
                }

            }while(op != 4);
        } catch (NumberFormatException e) {
            System.out.println("Erro: Entrada inválida. Por favor, insira um número.");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
        } finally {
            in.close();
        }
    }
}
