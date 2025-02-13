package com.mycompany.exerciciomemento.model;

/**
 *
 * @author gabriel.menegueti
 */
public class Produto {
    private String nome;
    private double custo;  
    private double preco;
    private MementoProduto mementoProduto;
    
    public Produto(String nome, double custo, double preco) {
        this.nome = nome;
        this.custo = custo;
        this.preco = preco;
        this.mementoProduto = criar();
    }

    public String getNome() {
        return nome;
    }

    public double getCusto() {
        return custo;
    }

    public double getPreco() {
        return preco;
    }

    public MementoProduto getMementoProduto() {
        return mementoProduto;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    public MementoProduto criar(){
        return new MementoProduto(nome, custo, preco);
    }
    
    public void restaurar(MementoProduto memento){
        this.nome = memento.getNome();
        this.custo = memento.getCusto();
        this.preco = memento.getPreco();
    }

    @Override
    public String toString() {
        return "Produto{" + "nome=" + nome + ", custo=" + custo + ", preco=" + preco + '}';
    }
    
}
