package com.mycompany.exerciciomemento.principal;

import com.mycompany.exerciciomemento.model.MementoProduto;
import java.util.Stack;

/**
 *
 * @author gabriel.menegueti
 */
public class Zelador {

    private final Stack<MementoProduto> elementosDesfazer;
    private final Stack<MementoProduto> elementosRefazer;

    private static Zelador instancia = null;

    private int idUltimoDesfazer = 0;
    private int idUltimoRefazer = 0;
    private final int QTD_DESFAZER = 5;
    private final int QTD_REFAZER = 5;

    private int mementoAtual = 0;

    private Zelador() {
        this.elementosDesfazer = new Stack<>();
        this.elementosRefazer = new Stack<>();
    }

    public static Zelador getInstancia() {
        if (instancia == null) {
            instancia = new Zelador();
        }
        return instancia;
    }

    public void add(MementoProduto memento) throws Exception {
        
        elementosDesfazer.push(memento);

        idUltimoDesfazer = elementosDesfazer.size() - QTD_DESFAZER;
        mementoAtual = elementosDesfazer.size() - 1;
    }

    public MementoProduto desfazer() throws Exception {
        
        verificarEstadosVazio();
        
        verificarQuantidadeDesfazer();
      
        elementosRefazer.push(elementosDesfazer.pop());
        
        return elementosDesfazer.lastElement();

    }

    public MementoProduto refazer() throws Exception {
        MementoProduto produtoMemento;
        
        verificarEstadosVazio();
        
        verificarQuantidadeRefazer();
        
        produtoMemento = elementosRefazer.pop();
        
        this.add(produtoMemento);
        
        return produtoMemento;
    }

    private void verificarEstadosVazio() {
        if (elementosDesfazer.size() < 0) {
            throw new RuntimeException("Não existe elementos para se desfazer");
        }

        if (elementosRefazer.size() < 0) {
            throw new RuntimeException("Não existe elementos para se refazer");
        }
    }
    
     private void verificarQuantidadeDesfazer() {
        if (elementosDesfazer.size() > 5) {
             elementosDesfazer.remove(0);
        }
    }

    private void verificarQuantidadeRefazer() throws Exception {
        if (elementosRefazer.size() > 5) {
             elementosRefazer.remove(0);
        }
    }

}
