package com.mycompany.exerciciomemento.principal;

import com.mycompany.exerciciomemento.model.Produto;

/**
 *
 * @author gabriel.menegueti
 */
public class Principal {

    public static void main(String[] args) {
        
        Produto produto = new Produto("Caderno", 13.20, 19.60);

        System.out.println("Instancia criada: " + produto);
        
        Zelador zelador = Zelador.getInstancia();

        try {
            zelador.add(produto.criar());
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao adicionar um Produto Memento ao Zelador" + ex.getMessage());
        }

        produto.setCusto(21.0);
        
        System.out.println("Após alteração: " + produto);

        try {
            zelador.add(produto.criar());
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao adicionar um Produto Memento ao Zelador" + ex.getMessage());
        }

        try {
            produto.restaurar(zelador.desfazer());
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao restaurar um produto" + ex.getMessage());
        }
        
        System.out.println("Após desfazer: " + produto);

        try {
            produto.restaurar(zelador.refazer());
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao restaurar um produto" + ex.getMessage());
        }
        
        System.out.println("Após refazer: " + produto);
    }
}
