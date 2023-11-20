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

class ArbolABB {
    private NodoABB raiz;

    // Constructor
    public ArbolABB() {
        this.raiz = null;
    }

    // Método para insertar un libro en el árbol
    public void insertar(Arreglo libro) {
        raiz = insertarRec(raiz, libro);
    }

    // Método auxiliar para la inserción recursiva
    private NodoABB insertarRec(NodoABB raiz, Arreglo libro) {
        if (raiz == null) {
            return new NodoABB(libro);
        }

        if (libro.getIsbn().compareTo(raiz.libro.getIsbn()) < 0) {
            raiz.izquierda = insertarRec(raiz.izquierda, libro);
        } else if (libro.getIsbn().compareTo(raiz.libro.getIsbn()) > 0) {
            raiz.derecha = insertarRec(raiz.derecha, libro);
        }

        return raiz;
    }

    // Método para buscar un libro por ISBN en el árbol
    public boolean buscar(String isbn) {
        return buscarRec(raiz, isbn);
    }

    // Método auxiliar para la búsqueda recursiva
    private boolean buscarRec(NodoABB raiz, String isbn) {
        if (raiz == null || raiz.libro.getIsbn().equals(isbn)) {
            return raiz != null;
        }

        if (isbn.compareTo(raiz.libro.getIsbn()) < 0) {
            return buscarRec(raiz.izquierda, isbn);
        } else {
            return buscarRec(raiz.derecha, isbn);
        }
    }

    // Método para eliminar un libro por ISBN del árbol
    public void eliminar(String isbn) {
        raiz = eliminarRec(raiz, isbn);
    }

    // Método auxiliar para la eliminación recursiva
    private NodoABB eliminarRec(NodoABB raiz, String isbn) {
        if (raiz == null) {
            return raiz;
        }

        if (isbn.compareTo(raiz.libro.getIsbn()) < 0) {
            raiz.izquierda = eliminarRec(raiz.izquierda, isbn);
        } else if (isbn.compareTo(raiz.libro.getIsbn()) > 0) {
            raiz.derecha = eliminarRec(raiz.derecha, isbn);
        } else {
            if (raiz.izquierda == null) {
                return raiz.derecha;
            } else if (raiz.derecha == null) {
                return raiz.izquierda;
            }

            raiz.libro = obtenerSucesorInorden(raiz.derecha);
            raiz.derecha = eliminarRec(raiz.derecha, raiz.libro.getIsbn());
        }

        return raiz;
    }

    // Método auxiliar para obtener el sucesor inorden
    private Arreglo obtenerSucesorInorden(NodoABB raiz) {
        while (raiz.izquierda != null) {
            raiz = raiz.izquierda;
        }
        return raiz.libro;
    }

    // Método para realizar el recorrido inorden y obtener solo los ISBN como cadena
    public String obtenerRecorridoInordenSoloISBN() {
        return inordenRecSoloISBN(raiz);
    }

    // Método auxiliar para el recorrido inorden
    private String inordenRecSoloISBN(NodoABB raiz) {
        StringBuilder resultado = new StringBuilder();
        if (raiz != null) {
            resultado.append(inordenRecSoloISBN(raiz.izquierda));
            resultado.append(raiz.libro.getIsbn()).append("\n");
            resultado.append(inordenRecSoloISBN(raiz.derecha));
        }
        return resultado.toString();
    }

    // Método para realizar el recorrido preorden y obtener solo los ISBN como cadena
    public String obtenerRecorridoPreordenSoloISBN() {
        return preordenRecSoloISBN(raiz);
    }

    // Método auxiliar para el recorrido preorden
    private String preordenRecSoloISBN(NodoABB raiz) {
        StringBuilder resultado = new StringBuilder();
        if (raiz != null) {
            resultado.append(raiz.libro.getIsbn()).append("\n");
            resultado.append(preordenRecSoloISBN(raiz.izquierda));
            resultado.append(preordenRecSoloISBN(raiz.derecha));
        }
        return resultado.toString();
    }

    // Método para realizar el recorrido postorden y obtener solo los ISBN como cadena
    public String obtenerRecorridoPostordenSoloISBN() {
        return postordenRecSoloISBN(raiz);
    }

    // Método auxiliar para el recorrido postorden
    private String postordenRecSoloISBN(NodoABB raiz) {
        StringBuilder resultado = new StringBuilder();
        if (raiz != null) {
            resultado.append(postordenRecSoloISBN(raiz.izquierda));
            resultado.append(postordenRecSoloISBN(raiz.derecha));
            resultado.append(raiz.libro.getIsbn()).append("\n");
        }
        return resultado.toString();
    }

    // Método para obtener la raíz del árbol
    public NodoABB getRaiz() {
        return raiz;
    }
}