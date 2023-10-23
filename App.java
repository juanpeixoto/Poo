import java.util.ArrayList;
import java.util.Scanner;

import javax.management.openmbean.CompositeData;

import java.util.Arrays;


public class App {
    public static void main(String[] args) {
        GaragemLocomotivas garagemLocomotivas = new GaragemLocomotivas(200);
        GaragemVagoes garagemVagoes = new GaragemVagoes(1000);
        GaragemTrem garagemTrem = new GaragemTrem();
        Scanner  scanner = new Scanner(System.in);
        int opcao;
        int idTrem;
        int idLocomotiva;
        int idVagao;
        int editarTrem;
        char rFinal; 
        

        for(int i = 0; i<300; i++){
            Locomotivas locomotivas = new Locomotivas(i+1, 200);
            garagemLocomotivas.addLocomotiva(locomotivas);
        }

        for(int i=0; i<8000; i++){
            Vagoes vagoes = new Vagoes(i+1, 50);
            garagemVagoes.addVagão(vagoes);
        }


        do{
            System.out.println(" Opcoes: ");
            System.out.println(" 1 - Criar um trem. ");
            System.out.println(" 2 - Editar um trem. ");
            System.out.println(" 3 - Listar os trens criados. ");
            System.out.println(" 4 - Desfazer algum trem. ");
            System.out.println(" Digite a opcao que voce deseja: ");

            opcao = scanner.nextInt();

            switch(opcao){
                case 0 :
                    System.out.println("\n Encerrando o programa.");
                    break;
                
                case 1:
                    System.out.println("Voce deseja criar um trem. Digite o ID que voce quer para o seu Trem: ");
                    idTrem = scanner.nextInt();
                    Composicao trem = new Composicao(idTrem);
                    trem.addLocomotiva(garagemLocomotivas.removerLocomotivas());
                    garagemTrem.addTrem(trem);
                    System.out.println("\n Trem criado com sucesso.");
                    break;

                case 2:
                    System.out.println("Qual o trem que voce deseja editar? Coloque o id dele.");
                    idTrem = scanner.nextInt();
                    for(Composicao verificaTrem : garagemTrem.garagemTrem){
                        if(trem.getId == idTrem){
                            editarTrem = scanner.nextInt();
                            do{ 
                                System.out.println("\n Qual das opcoes de editar trem você deseja: ");
                                System.out.println("\n 1 - Inserir locomotiva: ");
                                System.out.println("\n 2 - Inserir um vagao: ");
                                System.out.println("\n 3 - Remover o ultimo elemento do trem: ");
                                System.out.println("\n 4 - Listar locomotivas livres:  ");
                                System.out.println("\n 5 - Listar vagoes livres:  ");
                                System.out.println("\n 0 - Encerrar edicao do trem. ");

                                switch(editarTrem){
                                    case 0: 
                                        System.out.println("Encerrando edicao de trem.");
                                        break;
                                    
                                    case 1:
                                            trem.addLocomotiva(garagemLocomotivas.removerLocomotivas());
                                            break;
                                    
                                    case 2:
                                        trem.addVagoes(garagemVagoes.removerVagao());
                                        break;
                                    case 3: 
                                        if(trem.getQtdVagoes()>0){
                                            garagemVagoes.addVagão(trem.rVagoes());
                                        }
                                        else{
                                            if(trem.getQtdLocomotivas()>1){
                                                garagemLocomotivas.addLocomotiva(trem.rLocomotivasTrem());
                                            else{
                                                System.out.println(" Essa é a ultima locomotiva do trem, deseja mesmo se desfazer do trem? \n Digite s para sim");
                                                rFinal = scanner.nextLine().charAt(0);
                                                if(rFinal == 's'){
                                                    garagemLocomotivas.addLocomotiva(trem.rLocomotivasTrem());
                                                    garagemTrem.removeDaGaragemTrem(idTrem);
                                                }
                                               else{
                                                System.out.println("\n Voce nao desfez o trem. ");
                                               }
                                             }
                                        }
                                        break;

                                    case 4:
                                        
                               
                            
                                }



                            }while(editarTrem != 0);
                            
                        }
                    }
                
                    
                case 3:
                    garagemTrem.listarComposicaos();
                    break;

                case 4:
                    System.out.println("Digite o id do trem que quer desfazer: ");
                    idTrem = scanner.nextInt();
                    for(Composicao tremx : garagemTrem.garagemTrem){
                        if(tremx.getIdComposicao() == idTrem){
                            for(Vagoes vagaox : tremx.tremx){
                                garagemVagoes.addVagão(tremx.rVagoes());
                            }
                            for(Locomotivas locomotivasx : tremx.tremx){
                                garagemLocomotivas.addLocomotiva(tremx.rLocomotivasTrem());
                            }
                            garagemTrem.removeDaGaragemTrem(idTrem);
                            
                        }

                    }


                    
                    



            }

        } while(opcao !=0);
    }
}































/* 
        for(int i=0; i<100 ; i++){
            Locomotivas locomotivas = new Locomotivas(i+1, 100);
            garagemLocomotivas.addLocomotiva(locomotivas);
            System.out.println("\n"+ garagemLocomotivas.toString());
        }

        for(Locomotivas locomotiva : garagemLocomotivas.garagemLocomotivas){
            if(locomotiva !=null){
                System.out.println("\n" +"\n"+ locomotiva.toString());
            
            }
        }

 
        for(Locomotivas locomotivas : garagemLocomotivas.garagemLocomotivas){
            if(locomotivas!= null){
                System.out.println("\n"+"\n"+locomotivas.toString());
            }
        }


        for(int i=0; i<900; i++){
            Vagoes vagoes = new Vagoes(i+1, 200);
            garagemVagoes.addVagão(vagoes);
        }

for (Vagoes vagao : garagemVagoes.garagemVagoes) {
            if (vagao != null) {
                System.out.println("\n " + "\n" + vagao.toString());
            }
        }


        for (Vagoes vagao : garagemVagoes.garagemVagoes) {
            if (vagao != null) {
                System.out.println(vagao.toString());
            }
        }
     
        for(int i=0; i<=0; i++ ){
            Composicao trem = new Composicao(i+1);
            for(int j=0; j<3; j++){
                trem.addLocomotiva(garagemLocomotivas.removerLocomotivas());
            }

            for(int j=0; j<80; j++){
                trem.addVagoes(garagemVagoes.removerVagao());
            }

            garagemTrem.addTrem(trem);
        }


        
        System.out.println("\n" + "\n" + "Funcionando"+ garagemTrem.listarComposicaos());
        System.out.println("FIM");
             

         

        

         System.out.println("\n"+"\n" + trem.toString());
        System.out.println("\n" + trem.getQtdVagoes());

         for (Vagoes vagao : garagemVagoes.garagemVagoes) {
            if (vagao != null) {
                System.out.println("\n"+"\n"+vagao.toString());
            }
        }


        for (int i=0; i<20; i++){

            garagemVagoes.addVagão(trem.rVagoes());
        }



       

      for (Vagoes vagao : garagemVagoes.garagemVagoes) {
            if (vagao != null) {
                System.out.println("\n"+"\n"+vagao.toString());
            }
        }
      











 */ 
    


