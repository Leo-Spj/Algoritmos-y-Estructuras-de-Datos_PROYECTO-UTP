/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROL;

import MODELO.CLASIFICACION.Novela;

/**
 *
 * @author brandonluismenesessolorzano
 */
public class Nodo {

    public Novela getNovela() {
        return novela;
    }

    public void setNovela(Novela novela) {
        this.novela = novela;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    public char getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }
    
    
    private Novela novela;
    private Nodo siguiente;
    private Nodo anterior;
    private char data;
    
    public Nodo(Novela novela) {
        this.novela = novela;
        this.siguiente = null;
        this.anterior = null;
    }
    
    public Nodo(char c) {
        this.data = c;
        this.siguiente = null;
    }
}
