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
//class ArbolABB {
//     private NodoABB raiz;
//
//    public ArbolABB() {
//        this.raiz = null;
//    }
//
//    public void insertar(Arreglo libro) {
//        raiz = insertarRec(raiz, libro);
//    }
//
//    private NodoABB insertarRec(NodoABB raiz, Arreglo libro) {
//        if (raiz == null) {
//            raiz = new NodoABB(libro);
//            return raiz;
//        }
//
//        if (libro.getIsbn().compareTo(raiz.libro.getIsbn()) < 0) {
//            raiz.izquierda = insertarRec(raiz.izquierda, libro);
//        } else if (libro.getIsbn().compareTo(raiz.libro.getIsbn()) > 0) {
//            raiz.derecha = insertarRec(raiz.derecha, libro);
//        }
//
//        return raiz;
//    }
//
//    public boolean buscar(String isbn) {
//        return buscarRec(raiz, isbn);
//    }
//
//    private boolean buscarRec(NodoABB raiz, String isbn) {
//        if (raiz == null || raiz.libro.getIsbn().equals(isbn)) {
//            return raiz != null;
//        }
//
//        if (isbn.compareTo(raiz.libro.getIsbn()) < 0) {
//            return buscarRec(raiz.izquierda, isbn);
//        } else {
//            return buscarRec(raiz.derecha, isbn);
//        }
//    }
//
//    public void inordenSoloISBN() {
//        inordenRecSoloISBN(raiz);
//    }
//
//    private void inordenRecSoloISBN(NodoABB raiz) {
//        if (raiz != null) {
//            inordenRecSoloISBN(raiz.izquierda);
//            System.out.println(raiz.libro.getIsbn());
//            inordenRecSoloISBN(raiz.derecha);
//        }
//    }
//
//    public void preordenSoloISBN() {
//        preordenRecSoloISBN(raiz);
//    }
//
//    private void preordenRecSoloISBN(NodoABB raiz) {
//        if (raiz != null) {
//            System.out.println(raiz.libro.getIsbn());
//            preordenRecSoloISBN(raiz.izquierda);
//            preordenRecSoloISBN(raiz.derecha);
//        }
//    }
//
//    public void postordenSoloISBN() {
//        postordenRecSoloISBN(raiz);
//    }
//
//    private void postordenRecSoloISBN(NodoABB raiz) {
//        if (raiz != null) {
//            postordenRecSoloISBN(raiz.izquierda);
//            postordenRecSoloISBN(raiz.derecha);
//            System.out.println(raiz.libro.getIsbn());
//        }
//    }
//
//    public NodoABB getRaiz() {
//        return raiz;
//    }
//}
//////////////////////////////////////////////////////////////////////////////VRSION 2
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

    // Método para realizar el recorrido inorden y mostrar solo los ISBN
    public void inordenSoloISBN() {
        inordenRecSoloISBN(raiz);
    }

    // Método auxiliar para el recorrido inorden
    private void inordenRecSoloISBN(NodoABB raiz) {
        if (raiz != null) {
            inordenRecSoloISBN(raiz.izquierda);
            System.out.println(raiz.libro.getIsbn());
            inordenRecSoloISBN(raiz.derecha);
        }
    }

    // Método para realizar el recorrido preorden y mostrar solo los ISBN
    public void preordenSoloISBN() {
        preordenRecSoloISBN(raiz);
    }

    // Método auxiliar para el recorrido preorden
    private void preordenRecSoloISBN(NodoABB raiz) {
        if (raiz != null) {
            System.out.println(raiz.libro.getIsbn());
            preordenRecSoloISBN(raiz.izquierda);
            preordenRecSoloISBN(raiz.derecha);
        }
    }

    // Método para realizar el recorrido postorden y mostrar solo los ISBN
    public void postordenSoloISBN() {
        postordenRecSoloISBN(raiz);
    }

    // Método auxiliar para el recorrido postorden
    private void postordenRecSoloISBN(NodoABB raiz) {
        if (raiz != null) {
            postordenRecSoloISBN(raiz.izquierda);
            postordenRecSoloISBN(raiz.derecha);
            System.out.println(raiz.libro.getIsbn());
        }
    }

    // Método para obtener la raíz del árbol
    public NodoABB getRaiz() {
        return raiz;
    }
}
