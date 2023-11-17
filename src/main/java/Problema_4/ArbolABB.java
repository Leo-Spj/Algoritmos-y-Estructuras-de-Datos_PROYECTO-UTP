/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Problema_4;

import java.util.Scanner;

/**
 *
 * @author Alexis
 */

// Clase que representa el árbol binario de búsqueda (ABB)
class ArbolABB {
    private NodoABB raiz;  // Raíz del árbol

    // Constructor que inicializa el árbol con una raíz nula
    public ArbolABB() {
        this.raiz = null;
    }

    // Método para insertar un libro en el árbol
    public void insertar(Arreglo libro) {
        raiz = insertarRec(raiz, libro);
    }

    // Método privado de inserción recursiva
    private NodoABB insertarRec(NodoABB raiz, Arreglo libro) {
        // Si la raíz es nula, se crea un nuevo nodo con el libro
        if (raiz == null) {
            raiz = new NodoABB(libro);
            return raiz;
        }

        // Si el ISBN del libro es menor, se inserta en el subárbol izquierdo
        if (libro.getIsbn().compareTo(raiz.libro.getIsbn()) < 0) {
            raiz.izquierda = insertarRec(raiz.izquierda, libro);
        }
        // Si el ISBN del libro es mayor, se inserta en el subárbol derecho
        else if (libro.getIsbn().compareTo(raiz.libro.getIsbn()) > 0) {
            raiz.derecha = insertarRec(raiz.derecha, libro);
        }

        return raiz;
    }

    // Método para buscar un libro por su ISBN en el árbol
    public boolean buscar(String isbn) {
        return buscarRec(raiz, isbn);
    }

    // Método privado de búsqueda recursiva
    private boolean buscarRec(NodoABB raiz, String isbn) {
        // Si la raíz es nula o tiene el ISBN buscado, se retorna true
        if (raiz == null || raiz.libro.getIsbn().equals(isbn)) {
            return raiz != null;
        }

        // Si el ISBN buscado es menor, se busca en el subárbol izquierdo
        if (isbn.compareTo(raiz.libro.getIsbn()) < 0) {
            return buscarRec(raiz.izquierda, isbn);
        }
        // Si el ISBN buscado es mayor, se busca en el subárbol derecho
        else {
            return buscarRec(raiz.derecha, isbn);
        }
    }

    // Método para realizar un recorrido inorden en el árbol
    public void inorden() {
        inordenRec(raiz);
    }

    // Método privado de recorrido inorden recursivo
    private void inordenRec(NodoABB raiz) {
        // Si la raíz no es nula, se realiza el recorrido inorden
        if (raiz != null) {
            inordenRec(raiz.izquierda);
            System.out.println(raiz.libro.getIsbn() + ": " + raiz.libro.getTitulo());
            inordenRec(raiz.derecha);
        }
    }

    // Método para realizar un recorrido preorden en el árbol
    public void preorden() {
        preordenRec(raiz);
    }

    // Método privado de recorrido preorden recursivo
    private void preordenRec(NodoABB raiz) {
        // Si la raíz no es nula, se realiza el recorrido preorden
        if (raiz != null) {
            System.out.println(raiz.libro.getIsbn() + ": " + raiz.libro.getTitulo());
            preordenRec(raiz.izquierda);
            preordenRec(raiz.derecha);
        }
    }

    // Método para realizar un recorrido postorden en el árbol
    public void postorden() {
        postordenRec(raiz);
    }

    // Método privado de recorrido postorden recursivo
    private void postordenRec(NodoABB raiz) {
        // Si la raíz no es nula, se realiza el recorrido postorden
        if (raiz != null) {
            postordenRec(raiz.izquierda);
            postordenRec(raiz.derecha);
            System.out.println(raiz.libro.getIsbn() + ": " + raiz.libro.getTitulo());
        }
    }

    // Método para obtener la raíz del árbol
    public NodoABB getRaiz() {
        return raiz;
    }
}
