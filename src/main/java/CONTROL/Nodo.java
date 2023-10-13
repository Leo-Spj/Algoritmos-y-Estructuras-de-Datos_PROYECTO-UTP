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
    private Novela novela;
    private Nodo siguiente;
    private Nodo anterior;

    public Nodo(Novela novela) {
        this.novela = novela;
        this.siguiente = null;
        this.anterior = null;
    }
}
