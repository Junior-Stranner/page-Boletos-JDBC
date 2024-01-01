package Sistema.Controll;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import Sistema.Model.Boleto;
import Sistema.Model.Produto;
import Sistema.Model.Usuario;
import Sistema.Model.UsuarioPagaBoleto;

public class Sistema {
    
    static ArrayList <UsuarioPagaBoleto> usuariosPagamBoletos = new ArrayList<>();
 //   static ArrayList <Boleto> boletos = new ArrayList<>();
    static Scanner in = new Scanner(System.in);
    public static  int Sistema() {
   
             int op = 0;

    
            System.out.println("MENU "
            +"\n 1 - cadastrar pagante"
            +"\n 2 - Calcular Parcelas"
            +"\n 3 - Vizualiza dados do Pagante"
            +"\n 9 - Sair");
           return op = Integer.parseInt(in.nextLine());
           
  
    }

    public static void mostraDados() {

      for (UsuarioPagaBoleto usuarioPagaBoleto : usuariosPagamBoletos) {
         
        System.out.println(usuariosPagamBoletos);
      }
}

    public static void calcularParcelas() {

       
      for (UsuarioPagaBoleto usuarioPagaBoleto : usuariosPagamBoletos) {

        usuarioPagaBoleto.getBoleto().setValorPagar(usuarioPagaBoleto.getProduto().getValorProduto());


                 System.out.println("Data da Compra : "+usuarioPagaBoleto.getBoleto().getDataCompra());
                 System.out.println("Data de Vencimento : "+usuarioPagaBoleto.getBoleto().getDataVencimentoBoleto());

                 System.out.println("Valor Total da Compra é de "+usuarioPagaBoleto.getBoleto().getValorPagar());

             if(usuarioPagaBoleto.getBoleto().getDataVencimentoBoleto().isAfter(usuarioPagaBoleto.getBoleto().getDataCompra())){/* Postorior ou  maior ou depois de data atual*/
                System.out.println("Boleto não Vencido"
                +"\n ---------------");

                
            for(int parcela = 1; parcela <= usuarioPagaBoleto.getBoleto().getNumParcelasBoleto() ; parcela ++){
              usuarioPagaBoleto.getBoleto().setDataVencimentoBoleto(usuarioPagaBoleto.getBoleto().getDataVencimentoBoleto().plusMonths(1));

              System.out.println("número de Parcelas : "+parcela+"x vezes "
              + usuarioPagaBoleto.getBoleto().getDataVencimentoBoleto().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " do mês " + parcela);

              }

             usuarioPagaBoleto.getBoleto().setValorPagar( usuarioPagaBoleto.getBoleto().getValorPagar() / usuarioPagaBoleto.getBoleto().getNumParcelasBoleto());

           //   System.out.println("Valor Total da Compra ! " +boleto.getValorCompra());
              System.out.println("Valor Parcelado em  " +usuarioPagaBoleto.getBoleto().getNumParcelasBoleto()+"x vezes"+ " de "+usuarioPagaBoleto.getBoleto().getValorPagar());

              }else{

                 for(int parcela = 1; parcela <= usuarioPagaBoleto.getBoleto().getNumParcelasBoleto() ; parcela ++){
                     usuarioPagaBoleto.getBoleto().setValorPagar(usuarioPagaBoleto.getBoleto().getValorPagar() * 0.05);
              usuarioPagaBoleto.getBoleto().setDataVencimentoBoleto(usuarioPagaBoleto.getBoleto().getDataVencimentoBoleto().plusMonths(1));

            
              }
                System.out.println("Boleto Vencido - URGENTE");         
              }
               
        }
     }

    public static void cadatrarPagante()  {
      Produto produto = new Produto();
    // LocalDateTime dataAtualHoje;
   //  LocalDateTime dataVencimentoBoleto;
       System.out.println(" { - Cliente");

        System.out.println("Nome do Pagante ");
        String nomeUsuario = in.nextLine();
        System.out.println("Digite o seu cpf");
        String cpf = in.nextLine();
        System.out.println("Data de Nascimento");
        String dataNascimento = in.nextLine();

        System.out.println("- }");

           System.out.println("=========================================================");

        System.out.println("{ - Produto");


        produto.escolhaProdutos();

         System.out.println("- }");

   System.out.println("=========================================================");
        System.out.println(" { - Boleto");

        System.out.println("Valor a pagar" +produto.getValorProduto());

        System.out.println("Digite em quantas veses o Produto será parcelado ?");
        int numParcelasBoleto = Integer.parseInt(in.nextLine());

       LocalDate dataCompra = LocalDate.now();
       LocalDate dataVencimentoBoleto ;
       System.out.println("Boleto vence em : "+(dataVencimentoBoleto = dataCompra.plusMonths(1)));

       System.out.println("- }");
      
        double valorPagar = 0;
        Boleto boleto = new Boleto();
        boleto.setValorPagar(valorPagar);
        boleto.setDataCompra(dataCompra);
        boleto.setDataVencimentoBoleto(dataVencimentoBoleto);
        boleto.setNumParcelasBoleto(numParcelasBoleto);
        boleto.setValorPagar(valorPagar);
        Usuario usuario = new Usuario();
        usuario.setNome(nomeUsuario);
        usuario.setCpf(cpf);
        usuario.setDataNascimento(cpf);
    //    Boleto boleto = new Boleto(dataCompra,dataVencimentoBoleto,numParcelasBoleto,valorCompra);
         
         UsuarioPagaBoleto usuarioPagaBoleto = new UsuarioPagaBoleto(usuario, produto, boleto);
         usuariosPagamBoletos.add(usuarioPagaBoleto);
    //    boletos.add(boleto);
 }
}
