/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROL;

public class ColaCaracteres {
    
    private Nodo frente;
    private Nodo fin;

    public ColaCaracteres() {
        this.frente = null;
        this.fin = null;
    }

    public void encolar(char c) {
        
        Nodo nuevoNodo = new Nodo(c);
        
        if (frente == null) {
            frente = nuevoNodo;
            fin = nuevoNodo;
        } else {
            fin.setSiguiente(nuevoNodo); 
            fin = nuevoNodo;
        }
    }

    public char desencolar() {
        
        char valor = frente.getData();
        frente = frente.getSiguiente();
        
        if (frente == null) {
            fin = null;
        }
        return valor;
    }

    public Nodo getFrente() {
        return frente;
    }

    public void setFrente(Nodo frente) {
        this.frente = frente;
    }    
}
