package Sistema.Teste;

import Sistema.Controll.Sistema;

public class SistemaPrincipalTeste {

  public static void main(String[]args){

    try {

        int op = 0;

   while(op != 9){
     
    op = Sistema.Sistema();
       switch(op){

           case 1: Sistema.cadatrarPagante();break;
           case 2: Sistema.calcularParcelas();break;
           case 3: Sistema.mostraDados();break;
   
       }
}
   } catch (Exception e) {
       // TODO: handle exception
       e.printStackTrace();
       System.out.println("Erro ao carregar o menu ....");
    
}
    
  }
    
}
