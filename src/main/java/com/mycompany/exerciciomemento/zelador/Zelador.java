package com.mycompany.exerciciomemento.zelador;

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
    
    private Zelador(){
        this.elementosDesfazer = new Stack<>();
        this.elementosRefazer = new Stack<>();
    }
    
    public static Zelador getInstancia(){
        if(instancia == null){
            instancia = new Zelador();
        }
        return instancia;
    }
    
    public void add(MementoProduto memento) throws Exception{
        if(elementosDesfazer.size() > 5){
            elementosDesfazer.remove(0);    
        }
        elementosDesfazer.push(memento);
    }
    
    public MementoProduto desfazer() throws Exception{
        MementoProduto produtoMemento;
        if(!elementosDesfazer.isEmpty()){
            produtoMemento = elementosDesfazer.pop();
            if(elementosRefazer.size() > 5){
                elementosRefazer.remove(0); 
            }
            elementosRefazer.push(produtoMemento);
            return elementosDesfazer.lastElement();
        }
        
        throw new Exception("Não há estados salvos");
        
    }
    
    public MementoProduto refazer() throws Exception{
        MementoProduto produtoMemento;
        if(!elementosRefazer.isEmpty()){
            produtoMemento = elementosRefazer.pop();
            this.add(produtoMemento);
            return produtoMemento;
        }
 
        throw new Exception("Não há estados salvos");
        
    }
   
}
