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


    public double escolhaProdutos(){
        Scanner in = new Scanner(System.in);

        System.out.println("Produtos disponiveis"
        +" 1 - Ps4 "
        +" 2 - Ps5 "
        +" 3 - Ps5 slim + GTA VI"
        +" 4 - Acessórios");
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
        if(opPs4 == 1){
          System.out.println("Adicionais para o produto ps4 "
          +"\n 1 - Controle Ps4 - 220 reais "
          +"\n 2 - 2x Controles Ps4 - 400 reais"
          +"\n 3 - Jogo GTA V - 120 reais "
          +"\n 4 - Jogo de sua escolha - (300 reais)");
          int adicionaisPs4 = Integer.parseInt(in.nextLine());

          switch(adicionaisPs4){

            case 1: System.out.println("Escolha -> opção 1 -> Controle Ps4 - valor - 220 reais");
                    this.valorProduto += 2200 + 220;
                    System.out.println("Ps4 + 1 Controle Ps4 ");
                    System.out.println("Valor total pagar "+valorProduto);
                    break;

            case 2: System.out.println("Escolha -> opção 2 -> 2x Controle Ps4 - valor - 400 reais");
                   this.valorProduto += 2200 + 400;
                     System.out.println("Ps4 + 2 Controle Ps4 ");
                     System.out.println("Valor total pagar "+valorProduto);                   
                    break;
            
            case 3:System.out.println("Escolha -> opção 3 -> Jogo GTA V - valor - 120 reais");
                     this.valorProduto += 2200 + 120;               
                    System.out.println("Ps4 + GTA V ps4 ");
                     System.out.println("Valor total pagar "+valorProduto);              
                    break;

            case 4:System.out.println("Digite o jogo que vc queira");
                    String jogoEscolhaps4 = in.nextLine();
                     this.valorProduto += 2200 + 300;
                     System.out.println("Vc escolheu "+jogoEscolhaps4);
                     System.out.println("Valor total pagar "+valorProduto);
                    break;

          }
        }else{
            System.out.println("Vc escolheu apenas o Ps4 "
            +" Valor de 2200 Reais");
            this.valorProduto += 2200;
            System.out.println("Valor a pagar "+valorProduto);

            System.out.println(" Adicionado ao seu carinho "
            +"Vc será redirecionado ao menu de compras...");
            break;
        }
        
       //Opção numero 3 
       //=======================================================================================
        case 2: System.err.println(" Ps5"
        +"Deseja comprar um adicional"
        +"\n 1 - Sim "
        +"\n 2 - não ");
        int opPs5 = Integer.parseInt(in.nextLine());

        
        //Escolha 1
        //-------------------------------------------------------------------------------------------
        if(opPs5 == 1){
          System.out.println("Adicionais para o produto ps5 "
          +"\n 1 - Controle Ps5 - 360 reais "
          +"\n 2 - 2x Controles Ps5 - 650 reais"
          +"\n 3 - Jogo GTA VI - 530 reais "
          +"\n 4 - Jogo de sua escolha - (450 reais)");
          int adicionaisPs5 = Integer.parseInt(in.nextLine());

          switch(adicionaisPs5){

            case 1: System.out.println("Escolha -> opção 1 -> Controle Ps5 - valor - 360 reais");
                      this.valorProduto += 4000 + 360;
                      System.out.println("Ps5 + Controle ps5");
                      System.out.println("Valor total pagar"+valorProduto);
                    break;

            case 2: System.out.println("Escolha -> opção 2 -> 2x Controle Ps5 - valor - 650 reais");
                    this.valorProduto += 4000 + 650;
                    System.out.println("Ps5 + 2x Controle ps5");
                    System.out.println("Valor total pagar"+valorProduto);
                    break;

            case 3:  System.out.println("Escolha -> opção 3 -> GTA VI - valor - 530 reais");
                    this.valorProduto += 4000 + 530;
                    System.out.println("Ps5 + GTA VI");
                    System.out.println("Valor total pagar"+valorProduto);
                    break;     
                    
            case 4: System.out.println("Digite o jogo que vc queira");
                    String jogoEscolhaps5 = in.nextLine();
                     this.valorProduto += 4000 + 300;
                     System.out.println("Vc escolheu "+jogoEscolhaps5);
                     System.out.println("Valor total pagar "+valorProduto);
    
                    break;     
          }
        }else{
            System.out.println("Vc escolheu apenas o Ps5 "
            +" Valor de 4000 Reais");
            this.valorProduto += 4000;

            System.out.println(" Adicionado ao seu carinho "
            +"Vc será redirecionado ao menu de compras...");
            break;
        }
        
         //Opção numero 3 
       //=======================================================================================
        case 3: System.err.println(" Ps5 Slim"
        +"Deseja comprar um adicional"
        +"\n 1 - Sim "
        +"\n 2 - não ");
        int opPs5Slim = Integer.parseInt(in.nextLine());

        
        //Escolha 1
        //-------------------------------------------------------------------------------------------
        if(opPs5Slim == 1){
          System.out.println("Adicionais para o produto ps5 Slim "
          +"\n 1 - Controle Ps5(Slim) - 380 reais "
          +"\n 2 - 2x Controles Ps5(Slim) - 700 reais"
          +"\n 3 - Jogo GTA VI - 530 reais "
          +"\n 4 - Jogo de sua escolha - (450 reais)");
          int adicionaisPs5Slim = Integer.parseInt(in.nextLine());

          switch(adicionaisPs5Slim){

            case 1: System.out.println("Escolha -> opção 1 -> Controle Ps5(Slim) - valor - 380 reais");
                      this.valorProduto += 4800 + 380;
                      System.out.println("Ps5 + Controle ps5");
                      System.out.println("Valor total pagar"+valorProduto);
                    break;

            case 2: System.out.println("Escolha -> opção 2 -> 2x Controle Ps5(Slim) - valor - 700 reais");
                    this.valorProduto += 4800 + 700;
                    System.out.println("Ps5 + 2x Controle ps5 (Slim)");
                    System.out.println("Valor total pagar"+valorProduto);
                    break;

            case 3:  System.out.println("Escolha -> opção 3 -> GTA VI - valor - 530 reais");
                    this.valorProduto += 4800 + 530;
                    System.out.println("Ps5 + GTA VI");
                    System.out.println("Valor total pagar"+valorProduto);
                    break;     
                    
            case 4: System.out.println("Digite o jogo que vc queira");
                    String jogoEscolhaps5Slim = in.nextLine();
                     this.valorProduto += 4800 + 300;
                     System.out.println("Vc escolheu "+jogoEscolhaps5Slim);
                     System.out.println("Valor total pagar "+valorProduto);
    
                    break;     

          }

        }else {
            System.out.println("Vc escolheu apenas o Ps5 Slim"
            +" Valor de 4800 Reais");
            this.valorProduto += 4800;

            System.out.println(" Adicionado ao seu carinho "
            +"Vc será redirecionado ao menu de compras...");
            break;
        }//-----------------------------------------------------------------------------------------
        

           //Opção numero 4 
       //=======================================================================================
        case 4: System.err.println(" Adicionais"
        +"Deseja continnuar comprando "
        +"\n 1 - Sim "
        +"\n 2 - não ");
        int adicionais = Integer.parseInt(in.nextLine());

        
        //Escolha 1
        //-------------------------------------------------------------------------------------------
        if(adicionais == 1){
          System.out.println("Adicionais  "
          +"\n 1 - Call od Duty - 299 reais"
          +"\n 2 - Jogo Ea 2024 - 199 reais"
          +"\n 3 - Jogo GTA VI - 530 reais "
          +"\n 4 - Controle Vermelho/azul - 400");
          int adicionaisEscolha= Integer.parseInt(in.nextLine());

          switch(adicionaisEscolha){

            case 1: System.out.println("Escolha -> opção 1 -> Jogo Call of Duty - valor - 299 reais");
                      this.valorProduto +=299;
                      System.out.println("Jogo Call of Duty ");
                      System.out.println("Valor total pagar"+valorProduto);
                    break;

            case 2: System.out.println("Escolha -> opção 2 -> Jogo Ea 2024 - valor - 700 reais");
                    this.valorProduto += 199;
                    System.out.println("Jogo Ea 2024");
                    System.out.println("Valor total pagar"+valorProduto);
                    break;

            case 3:  System.out.println("Escolha -> opção 3 -> GTA VI - valor - 530 reais");
                    this.valorProduto += 530;
                    System.out.println("Ps5 + GTA VI");
                    System.out.println("Valor total pagar"+valorProduto);
                    break;     
                    
            case 4: System.out.println("Controle Vermelho/azul");
                     this.valorProduto +=  400;
                     System.out.println("Valor total pagar "+valorProduto);
                    break;     
          }

        }else {
            System.out.println("Sair");
            break;
        }//-----------------------------------------------------------------------------------------
        
       }
        
        return this.valorProduto;
    }
    
}
