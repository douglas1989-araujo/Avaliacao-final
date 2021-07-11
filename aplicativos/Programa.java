package aplicativos;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


import classes.Produto;
import classes.Venda;

public class Programa {
    public static void main(String[] args) throws InterruptedException, IOException {
      
      
        final int MAX_ELEMENTOS = 2;
        int opcao, qtdCadastrados= 0;
        int qtdVda;
        int numVda = 0;
        int tamanho;
        Produto[] produtos = new Produto[MAX_ELEMENTOS];
        Venda[] vendas = new Venda[MAX_ELEMENTOS];
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("\n****\nMENU\n****\n");
            System.out.println("1 - CADASTRAR PRODUTO");
            System.out.println("2 - CONSUTAR PRODUTOS");
            System.out.println("3 - LISTAR PRODUTOS");
            System.out.println("4 - VENDAS POR PERIODO");
            System.out.println("5 - REALIZAR VENDAS");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = in.nextInt();
            in.nextLine(); 
            if (opcao == 1) {
                tamanho = produtos.length;
               if (qtdCadastrados == tamanho ) {
                 Produto[] produtos2= new Produto[produtos.length + produtos.length];
                for (int i =0; i < produtos.length; i++) {
                    produtos2[i]= produtos[i];
                }
                    produtos = produtos2;
                  
                   continue;
                
                }
                  Produto prod = new Produto();
                  System.out.println("Codigo....:");
                  prod.setCodigo(in.nextLine());
                  System.out.println("Nome:....");
                  prod.setNome(in.nextLine());
                  System.out.println("Valor:...");
                  prod.setValor(in.nextDouble());
                  System.out.println("Quantidade em Estoque....:");
                  prod.setQuantidadeEstoque(in.nextInt());
                  produtos[qtdCadastrados]= prod;
                    qtdCadastrados = qtdCadastrados + 1;
                    System.out.println("\nProduto cadastrado com sucesso.");
                
                 } else if (opcao == 2) {
                  System.out.println("Digite o nome do Produto ");
                 String buscaCod = in.nextLine();
                  boolean achou = false;
                  Produto codEncontrado = null;
                  for(int i =0; !achou && i<qtdCadastrados; i++){
                  achou = buscaCod.equals(produtos[i].getNome());
                   codEncontrado = produtos[i];
                  }if(achou){
                    System.out.println("codigo    " + codEncontrado.getCodigo()  +",   Nome   " + codEncontrado.getNome() +",   valor  " +codEncontrado.getValor() + ",   QTDE.ESTOQUE  " + codEncontrado.getQuantidadeEstoque());
                 
                }else{
                  System.out.println("Produto não encontrado");
                }
                voltarMenu(in);
                continue;
                 
            } else if (opcao == 3) {
          
              
              if (qtdCadastrados == 0) {
                System.out.println("\nNão há Produtos a exibir.");
                voltarMenu(in);
                continue;
            }

              System.out.println("Lista de Produtos Cadastrados");
              System.out.println("=============================");

            for (int i = 0; i < qtdCadastrados; i++) {
               System.out.printf("\nCodigo: %s,   Descrição: %s,   Valor Unitario: %s,   Quantidade em Estoque: %s\n  ", produtos[i].getCodigo(), produtos[i].getNome(), produtos[i].getValor(), produtos[i].getQuantidadeEstoque());
              
              }  
                
                 
                voltarMenu(in);
                 continue;
            } else if (opcao == 4) {
              for (int i = 0; i <numVda; i++) {
                System.out.printf("%s  %s  %s  %s\n  " , vendas[i].getCodigo(), vendas[i].getNome(),vendas[i].getValor(), vendas[i].getData() );
              }
               continue;
            }else if (opcao == 5) {
               
               qtdVda = vendas.length;
              if(qtdVda == vendas.length){
                Venda []vendas2 = new Venda[vendas.length + vendas.length];
                for (int i = 0; i < vendas.length; i++) {
                  vendas2[i] = vendas[i];
                 }
                   vendas = vendas2;
                   
                }
                 
                 System.out.println("******************");
                 System.out.println("REGISTRO DE VENDAS");
                 System.out.println("******************");
                 System.out.println("Digite o Codigo do Produto ");
                 String buscaCod = in.nextLine();
                 boolean achou = false;
                 Produto codEncontrado = null;
               for(int i =0; !achou && i<qtdCadastrados; i++){
                  achou = buscaCod.equals(produtos[i].getCodigo());
                  codEncontrado = produtos[i];
                }if(achou){
                  if(codEncontrado.getQuantidadeEstoque() == 0){
                    System.out.println("Não sera possivel realizar a venda, estoque zerado");
                    voltarMenu(in);
                  }else{
                   System.out.println("Produto Encontrado  "  + codEncontrado.getNome());
                   System.out.println("Data [dd/mm/aaaa]");
                   String data = in.nextLine();
                   DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                   LocalDate date = LocalDate.parse(data,formatter);
                   
                   Venda vend = new Venda();
                   vend.setCodigo(codEncontrado.getCodigo());
                   vend.setNome(codEncontrado.getNome());
                   vend.setData(date);
                   System.out.println("Quantidade...:");
                   vend.setQtdVendida(in.nextInt());
                   codEncontrado.setQuantidadeEstoque(codEncontrado.getQuantidadeEstoque() - vend.getQtdVendida());  
                   vend.setValor(codEncontrado.getValor()* vend.getQtdVendida());
                    
                   vendas[numVda] = vend;
                    numVda = numVda +1;
                   
                  }
                   
                     
                   
                
                  }else{
                   System.out.println("Produto não encontrado");
                 }
                
                 voltarMenu(in);
                 continue; 
                
            }else if (opcao != 0) {
                System.out.println("\nOpção inválida!");
            }    
            
        } while (opcao != 0);

        System.out.println("Fim do programa!");
      
        in.close();
      }   
    

    
    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");
        
        System.out.flush();
    
    
        }
  }
  