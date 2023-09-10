package MODELO.CLASIFICACION;

import MODELO.Libro;

public class LibroDeTexto extends Libro{

    String asignatura;

    public LibroDeTexto(String titulo, String autor, int anioPublicacion, long ISBN, String asignatura) {
        super(titulo, autor, anioPublicacion, ISBN);
        this.asignatura = asignatura;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    @Override
    public Libro getLibro() {
        return null;
    }
}
