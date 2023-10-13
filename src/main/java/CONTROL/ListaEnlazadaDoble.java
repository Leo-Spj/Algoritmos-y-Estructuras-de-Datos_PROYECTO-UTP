/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROL;

import VISTA.Avance2Form;
import CONTROL.Nodo;
import MODELO.CLASIFICACION.Novela;
import MODELO.Libro;

/**
 *
 * @author brandonluismenesessolorzano
 
 */
public class ListaEnlazadaDoble<L extends Libro> {
    
    private Libro listaLibros[] = new Libro[1];

    public L obtenerUnLibro(long isbn) {
        for (Libro libro : getListaLibros()) {
            if (libro.getISBN() == isbn) {
                return (L) libro;
            }
        }
        return null;
    }

    public Libro[] getListaLibros() { //obtener libros en modo array de objetos, usar para mostrar en JTable
        return listaLibros;
    }

    public void listarLibros() { // Este listado es para mostrar en consola, no usar, solo pruebas
        for (Libro libro : getListaLibros()) {
            System.out.println(libro.getTitulo());
        }
    }

    public void agregarLibro(L libro) {
        if (getListaLibros()[getListaLibros().length - 1] == null) {
            getListaLibros()[getListaLibros().length - 1] = libro;
        } else {
            Libro listaLibrosAux[] = new Libro[getListaLibros().length + 1];
            for (int i = 0; i < getListaLibros().length; i++) {
                listaLibrosAux[i] = getListaLibros()[i];
            }
            setListaLibros(listaLibrosAux);
            getListaLibros()[getListaLibros().length - 1] = libro;
        }
    }

    public void removerLibro(L libro) {
        for (int i = 0; i < getListaLibros().length; i++) {
            if (getListaLibros()[i] == libro) {
                getListaLibros()[i] = null;

                Libro AuxIzquierda[] = new Libro[i];
                Libro AuxDerecha[] = new Libro[getListaLibros().length - i - 1];

                for (int j = 0; j < AuxIzquierda.length; j++) {
                    AuxIzquierda[j] = getListaLibros()[j];
                }
                for (int j = 0; j < AuxDerecha.length; j++) {
                    AuxDerecha[j] = getListaLibros()[j + i + 1];
                }

                setListaLibros(new Libro[getListaLibros().length - 1]);

                for (int j = 0; j < AuxIzquierda.length; j++) {
                    getListaLibros()[j] = AuxIzquierda[j];
                }
                for (int j = 0; j < AuxDerecha.length; j++) {
                    getListaLibros()[j + AuxIzquierda.length] = AuxDerecha[j];
                }

                break;
            }
        }
    }
    
    private Nodo cabeza;
    private Nodo cola;

    public ListaEnlazadaDoble() {
        cabeza = null;
        cola = null;
    }
    public boolean contieneNovela(Novela novela) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.getNovela().getTitulo().equals(novela.getTitulo())) {
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    public void insertarOrdenado(Novela novela) {
        Nodo nuevoNodo = new Nodo(novela);
        if (getCabeza() == null) {
            setCabeza(nuevoNodo);
            setCola(nuevoNodo);
        } else if (novela.getTitulo().compareToIgnoreCase(getCabeza().getNovela().getTitulo()) <= 0) {
            nuevoNodo.setSiguiente(getCabeza());
            cabeza.setAnterior(nuevoNodo);
            setCabeza(nuevoNodo);
        } else {
            Nodo actual = getCabeza();
            while (actual != null && novela.getTitulo().compareToIgnoreCase(actual.getNovela().getTitulo()) > 0) {
                actual = actual.getSiguiente();
            }

            if (actual == null) {
                nuevoNodo.setAnterior(getCola());
                cola.setSiguiente(nuevoNodo);
                setCola(nuevoNodo);
            } else {
                // Insertar en el medio de la lista
                nuevoNodo.setSiguiente(actual);
                nuevoNodo.setAnterior(actual.getAnterior());
                if (actual.getAnterior() != null) {
                    actual.getAnterior().setSiguiente(nuevoNodo);
                }
                actual.setAnterior(nuevoNodo);
            }
        }
    }
    public void borrarPorTitulo(String titulo) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.getNovela().getTitulo().equalsIgnoreCase(titulo)) {
                if (actual.getAnterior() == null) { // Si es el primer nodo
                    cabeza = actual.getSiguiente();
                    if (cabeza != null) {
                        cabeza.setAnterior(null);
                    }
                } else if (actual.getSiguiente() == null) { // Si es el último nodo
                    cola = actual.getAnterior();
                    if (cola != null) {
                        cola.setSiguiente(null);
                    }
                } else { // Si es un nodo intermedio
                    actual.getAnterior().setSiguiente(actual.getSiguiente());
                    actual.getSiguiente().setAnterior(actual.getAnterior());
                }
                // Liberar el nodo eliminado
                actual = null;
                return;
            }
            actual = actual.getSiguiente();
        }
    }




    public void borrarNodo(Novela novela) {
        Nodo actual = getCabeza();
        while (actual != null) {
            if (actual.getNovela().equals(novela)) {
                if (actual == getCabeza()) {
                    setCabeza(actual.getSiguiente());
                    if (getCabeza() != null) {
                        cabeza.setAnterior(null);
                    }
                } else if (actual == getCola()) {
                    setCola(actual.getAnterior());
                    if (getCola() != null) {
                        cola.setSiguiente(null);
                    }
                } else {
                    actual.getAnterior().setSiguiente(actual.getSiguiente());
                    actual.getSiguiente().setAnterior(actual.getAnterior());
                }
                return;
            }
            actual = actual.getSiguiente();
        }
    }

    public void setListaLibros(Libro[] listaLibros) {
        this.listaLibros = listaLibros;
    }

    public Nodo getCabeza() {
        return cabeza;
    }

    public void setCabeza(Nodo cabeza) {
        this.cabeza = cabeza;
    }

    public Nodo getCola() {
        return cola;
    }

    public void setCola(Nodo cola) {
        this.cola = cola;
    }
}