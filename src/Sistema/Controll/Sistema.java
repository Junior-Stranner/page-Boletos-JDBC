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

        try {

             int op = 0;

        while(op != 9){


            System.out.println("MENU "
            +"\n 1 - cadastrar pagante"
            +"\n 2 - Calcular Parcelas"
            +"\n 3 - Vizualiza dados do Pagante"
            +"\n 8 - Voltar e continuar a Gerando"
            +"\n 9 - Sair");
            op = Integer.parseInt(in.nextLine());
            switch(op){

                case 1: cadatrarPagante();break;
                case 2: calcularParcelas();break;
                case 3: mostraDados();break;
        
            }
    }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
         
     }
        return Sistema();
}

    public static void mostraDados() {

        for (Usuario usuario : usuarios) {

    }
}

    public static void calcularParcelas() {

        for (Boleto boleto : boletos) {

                 System.out.println("Data da Compra : "+boleto.getDataCompra());
                 System.out.println("Data de Vencimento : "+boleto.getDataVencimentoBoleto());

                 System.out.println("Valor Total da Compra é de "+boleto.getValorCompra());

             if(boleto.getDataVencimentoBoleto().isAfter(boleto.getDataCompra())){/* Postorior ou  maior ou depois de data atual*/
                System.out.println("Boleto não Vencido"
                +"\n ---------------");

                
            for(int parcela = 1; parcela <= boleto.getNumParcelasBoleto() ; parcela ++){
              boleto.setDataVencimentoBoleto(boleto.getDataVencimentoBoleto().plusMonths(1));

              System.out.println("número de Parcelas : "+parcela+"x vezes "
              + boleto.getDataVencimentoBoleto().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " do mês " + parcela);

              }

            boleto.setValorCompra(boleto.getValorCompra() / boleto.getNumParcelasBoleto());

           //   System.out.println("Valor Total da Compra ! " +boleto.getValorCompra());
              System.out.println("Valor Parcelado em  " +boleto.getNumParcelasBoleto()+"x vezes"+ " de "+boleto.getValorCompra());

              }else{

                 for(int parcela = 1; parcela <= boleto.getNumParcelasBoleto() ; parcela ++){
                     boleto.setValorCompra(boleto.getValorCompra() * 0.05);
              boleto.setDataVencimentoBoleto(boleto.getDataVencimentoBoleto().plusMonths(1));

            
              }


                System.out.println("Boleto Vencido - URGENTE");         
              }
               
        }
     }

    public static void cadatrarPagante()  {

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

         System.out.println("- }");

   System.out.println("=========================================================");
        System.out.println(" { - Boleto");

        System.out.println("Valor a pagar");
        double valorPagar = Double.parseDouble(in.nextLine());

        System.out.println("Digite em quantas veses o Produto será parcelado ?");
        int numParcelasBoleto = Integer.parseInt(in.nextLine());

       LocalDate dataCompra = LocalDate.now();
       LocalDate dataVencimentoBoleto ;
       System.out.println("Boleto vence em : "+(dataVencimentoBoleto = dataCompra.plusMonths(1)));

       System.out.println("- }");
      
  
        Boleto boleto = new Boleto();
        boleto.setDataCompra(dataCompra);
        boleto.setDataVencimentoBoleto(dataVencimentoBoleto);
        boleto.setNumParcelasBoleto(numParcelasBoleto);
        boleto.setValorPagar(numParcelasBoleto);
        Usuario usuario = new Usuario();
        usuario.setNome(nomeUsuario);
        usuario.setCpf(cpf);
        usuario.setDataNascimento(cpf);
    //    Boleto boleto = new Boleto(dataCompra,dataVencimentoBoleto,numParcelasBoleto,valorCompra);
         
         UsuarioPagaBoleto usuarioPagaBoleto = new UsuarioPagaBoleto(usuario, null, boleto);
         usuariosPagamBoletos.add(usuarioPagaBoleto);
    //    boletos.add(boleto);
 }
}
