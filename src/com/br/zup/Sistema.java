package com.br.zup;

import java.util.Scanner;

public class Sistema {

    public static void menu(){
        System.out.println("Digite sair caso queira");
    }

    public static void executarSistema(){
        boolean continuar = true;
        while (continuar){
            menu();
            String resposta = new Scanner(System.in).nextLine();
            if(resposta.equalsIgnoreCase("sair")){
                continuar=false;
            }

            try{
                Estoque.informarVenda();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
