package com.mycompany.exerciciomemento.model;

/**
 *
 * @author gabriel.menegueti
 */
public class MementoProduto {
    private String nome;
    private double custo;
    private double preco;

    MementoProduto(String nome, double custo, double preco) {
        this.nome = nome;
        this.custo = custo;
        this.preco = preco;
    }
    
    MementoProduto(){
        
    }

    String getNome() {
        return nome;
    }

    double getCusto() {
        return custo;
    }

    double getPreco() {
        return preco;
    }
     
}
