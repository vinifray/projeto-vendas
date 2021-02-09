package com.br.zup;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Estoque {
    private static List<Produto> produtos = Arrays.asList(
            new Produto("Maça", 2.00, 40),
            new Produto("Pão", 0.35, 100)
    );

    public static void informarVenda() throws Exception {
        System.out.println("Qual produto foi vendido? ");
        String nomeProduto = new Scanner(System.in).nextLine();

        Produto produto = pesquisarProduto(nomeProduto);
        System.out.println(produto);

        System.out.println("Qual quantidade vendida");
        int quantidadeVenda = new Scanner(System.in).nextInt();

        if(quantidadeVenda > produto.getQuantidadeEstoque()){
            throw new Exception("Indisponível no estoque");
        }

        int estoque = produto.getQuantidadeEstoque();
        estoque -= quantidadeVenda;
        int vendasDoProduto = produto.getQuantidadeVendas();
        vendasDoProduto += quantidadeVenda;

        produto.setQuantidadeEstoque(estoque);
        produto.setQuantidadeVendas(vendasDoProduto);
        System.out.println("Atualizado "+ produto);

    }

    public static Produto pesquisarProduto(String nomeProduto) throws Exception {
        for(Produto produto: produtos){
            if(produto.getNome().equalsIgnoreCase(nomeProduto)){
                return produto;
            }
        }
        throw new Exception("Produto não foi encontrado");
    }
}
