package Sistema.Model;

import java.util.Scanner;

public class Produto {
    
    private String nomeProduto;
    private String numProduto;
    private double valorProduto;

    public Produto(){

    }


    public Produto(String nomeProduto, String numProduto, double valorProduto) {
        this.nomeProduto = nomeProduto;
        this.numProduto = numProduto;
        this.valorProduto = valorProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getNumProduto() {
        return numProduto;
    }

    public void setNumProduto(String numProduto) {
        this.numProduto = numProduto;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }


    public int escolhaProdutos(){
        Scanner in = new Scanner(System.in);

        System.out.println("Produtos disponiveis"
        +" 1 - Ps4 "
        +" 2 - Ps5 "
        +" 3 - Ps5 slim + GTA VI");
        int escolhaProds = Integer.parseInt(in.nextLine());

        //==============3 opções disponiveis==========================

       switch(escolhaProds){

         //Opção numero 1
         //=======================================================================================
        case 1: System.err.println(" Ps4"
        +"Deseja comprar um adicional"
        +"1 - Sim "
        +"2 - não ");
        int opPs4 = Integer.parseInt(in.nextLine());

        
        //Escolha 1
        //-------------------------------------------------------------------------------------------
        if(opPs4 == 1){//Bloco -------------------------------------------------------------------------------
          System.out.println("Adicionais para o produto ps4 "
          +"1 - Controle Ps4 - 220 reais "
          +"2 - 2x Controles Ps4 - 400 reais"
          +"3 - Jogo GTA V - 120 reais "
          +"4 - Jogo de sua escolha - (300 reais)");
          int adicionaisPs4 = Integer.parseInt(in.nextLine());

          switch(adicionaisPs4){

            case 1: System.out.println("Escolha -> opção 1 -> Controle Ps4 - valor - 220 reais");
                    this.valorProduto += 220;
                    System.out.println("Ps4 + 1 Controle Ps4 ");
                    this.valorProduto += 2200 + 220;
                    System.out.println("Valor a pagar "+valorProduto);
                    break;

            case 2: System.out.println("Escolha -> opção 2 -> 2x Controle Ps4 - valor - 400 reais");
                    this.valorProduto += 400;
                     System.out.println("Ps4 + 2 Controle Ps4 ");
                     System.out.println("Valor a pagar "+valorProduto);
                    this.valorProduto += 2200 + 400;
                    break;
            
            case 3:System.out.println("Escolha -> opção 3 -> Jogo GTA V - valor - 120 reais");
                    this.valorProduto += 120;
                     System.out.println("Ps4 + GTA V ps4 ");
                     System.out.println("Valor a pagar "+valorProduto);
                    this.valorProduto += 2200 + 120;

            case 4:System.out.println("Escolha -> opção 4 -> Jogo da sua Escolha - valor - 300 reais");
                    this.valorProduto += 300; 
                     System.out.println("Ps4 + 2 Controle Ps4 ");
                     System.out.println("Valor a pagar "+valorProduto);
                    this.valorProduto += 2200 + 400;


          }
        }//Bloco-------------------------------------------------------------------------------------------------

        //Escolha 2 
        //-------------------------------------------------------------------------------------------
        if(opPs4 == 2){
            System.out.println("Vc escolheu apenas o Ps4 "
            +" Valor de 2200 Reais");
            this.valorProduto += 2200;
            System.out.println("Valor a pagar "+valorProduto);

            System.out.println(" Adicionado ao seu carinho "
            +"Vc será redirecionado ao menu de compras...");
            break;
        }//-----------------------------------------------------------------------------------------
        


       //Opção numero 2 
       //=======================================================================================
        case 2: System.err.println(" Ps5"
        +"Deseja comprar um adicional"
        +"1 - Sim "
        +"2 - não ");
        int opPs5 = Integer.parseInt(in.nextLine());

        
        //Escolha 1
        //-------------------------------------------------------------------------------------------
        if(opPs5 == 1){//Bloco -------------------------------------------------------------------------------
          System.out.println("Adicionais para o produto ps4 "
          +"1 - Controle Ps4 - 220 reais "
          +"2 - 2x Controles Ps4 - 400 reais"
          +"3 - Jogo GTA V - 120 reais "
          +"4 - Jogo de sua escolha - (300 reais)");
          int adicionaisPs5 = Integer.parseInt(in.nextLine());

          switch(adicionaisPs5){

            case 1: System.out.println("Escolha -> opção 1 -> Controle Ps4 - valor - 220 reais");
                    this.valorProduto += 220;

            case 2: System.out.println("Escolha -> opção 2 -> 2x Controle Ps4 - valor - 400 reais");
                    this.valorProduto += 400;
          }
        }//Bloco-------------------------------------------------------------------------------------------------

        //Escolha 2 
        //-------------------------------------------------------------------------------------------
        if(opPs5 == 2){
            System.out.println("Vc escolheu apenas o Ps4 "
            +" Valor de 2200 Reais");
            this.valorProduto += 2200;

            System.out.println(" Adicionado ao seu carinho "
            +"Vc será redirecionado ao menu de compras...");
            break;
        }//-----------------------------------------------------------------------------------------
        

       }
        
        return 0;
    }
    
}
