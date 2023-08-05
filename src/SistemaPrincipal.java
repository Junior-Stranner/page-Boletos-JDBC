import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import Sistema.Boleto;
import Sistema.Usuario;

public class SistemaPrincipal {
    
    static ArrayList <Usuario> usuarios = new ArrayList<>();
    static ArrayList <Boleto> boletos = new ArrayList<>();
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) throws ParseException {

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
        
            }
    }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
         
     }
}

    private static void calcularParcelas() {

        for (Boleto boleto : boletos) {
        Calendar calender = Calendar.getInstance();
        calender.setTime(boleto.getDataAtualHoje());

            System.out.println("Valor Total da Compra é de "+boleto.getValorCompra());

            for(int parcelas = 1; parcelas <= boleto.getNumParcelasBoleto() ; parcelas ++){
                calender.add(Calendar.MONTH, 1);

                System.out.println("Parcela número : " + parcelas + " Vencimento é em : "
                + new SimpleDateFormat("dd/MM/yy").format(calender.getTime()));
               
            }

               boleto.setValorCompra(boleto.getValorCompra() / boleto.getNumParcelasBoleto());

                 if(boleto.getDataVencimentoBoleto().after(boleto.getDataAtualHoje())){/* Postorior ou  maior ou depois de data atual*/
                System.out.println("Boleto não Vencido");
              }else{
                System.out.println("Boleto Vencido - URGENTE");
              }

              System.out.println("Valor Total da Compra ! " +boleto.getValorCompra());
              System.out.println("Valor Parcelado em  " +boleto.getNumParcelasBoleto()+"x vezes"+ " de "+boleto.getValorCompra());

        }
    }

    private static void cadatrarPagante() throws ParseException {

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/mm/yyy");

    // LocalDateTime dataAtualHoje;
   //  LocalDateTime dataVencimentoBoleto;

        System.out.println("Nome do Pagante ");
        String nomeUsuario = in.nextLine();

      //  System.out.println("Data de Hoje");
        Date dataAtualHoje = simpleDateFormat.parse("05/08/2023");
        Date dataVencimentoBoleto = simpleDateFormat.parse("10/08/2023");

        System.out.println("Valor Da Compra ");
        double valorCompra = Double.parseDouble(in.nextLine());

        System.out.println("Digite em quantas veses o Produto será parcelado ?");
        int numParcelasBoleto = Integer.parseInt(in.nextLine());

        System.out.println(" Número doa Compra ");
        int numeroCompra = Integer.parseInt(in.nextLine());

        Usuario usu = new Usuario(nomeUsuario,numeroCompra);
        Boleto boleto = new Boleto(dataAtualHoje,dataVencimentoBoleto,numParcelasBoleto,valorCompra);
        usuarios.add(usu);
        boletos.add(boleto);
    }
}
