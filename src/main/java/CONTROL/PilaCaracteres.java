/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROL;

public class PilaCaracteres {
    
    private Nodo cima;
    
    public PilaCaracteres(){
        cima = null;
    }
    
    public void apilar(char c){
        Nodo nuevoNodo = new Nodo(c);
        nuevoNodo.setSiguiente(cima);
        cima = nuevoNodo;
    }
    
    public char desapilar(){
        char c;
        c = cima.getData();
        cima = cima.getSiguiente();
        return c;
    }

    public Nodo getCima() {
        return cima;
    }

    public void setCima(Nodo cima) {
        this.cima = cima;
    }
    

}