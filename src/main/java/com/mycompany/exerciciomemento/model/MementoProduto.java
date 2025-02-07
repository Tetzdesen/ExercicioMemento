package com.mycompany.exerciciomemento.model;

/**
 *
 * @author gabriel.menegueti
 */
public class MementoProduto {
    private String nome;
    private double custo;
    private double preco;

    protected MementoProduto(String nome, double custo, double preco) {
        this.nome = nome;
        this.custo = custo;
        this.preco = preco;
    }
    
    protected MementoProduto(){
        
    }

    protected String getNome() {
        return nome;
    }

    protected double getCusto() {
        return custo;
    }

    protected double getPreco() {
        return preco;
    }
     
}
