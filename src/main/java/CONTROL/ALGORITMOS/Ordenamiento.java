package CONTROL.ALGORITMOS;

import CONTROL.ControlEstanteria;
import MODELO.Libro;

public class Ordenamiento extends ControlEstanteria<Libro> {

    Libro listaLibros[];
    public Ordenamiento(Libro[] listaLibros) {
        this.listaLibros = listaLibros;
    }

    public void imprimirListaLibros() {
        for (int i = 0; i < this.getListaLibros().length; i++) {
            System.out.println(this.getListaLibros()[i]);
        }
    }
}
