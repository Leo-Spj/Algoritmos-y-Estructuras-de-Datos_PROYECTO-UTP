package MODELO.CLASIFICACION;

import MODELO.Libro;
import MODELO.Prestable;
import MODELO.Vendible;

public class LibroDeTexto extends Libro implements Prestable, Vendible {

    String asignatura;

    public LibroDeTexto(String titulo, String autor, int anioPublicacion, int ISBN, String asignatura) {
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
    public void prestar() {
        if (this.isPrestado()){
            System.out.println("No se puede prestar el libro porque ya está prestado");
        } else {
            this.setPrestado(true);
            System.out.println("El libro se prestó correctamente");
        }
    }

    @Override
    public void devolver() {
        if (this.isPrestado()){
            this.setPrestado(false);
            System.out.println("El libro se devolvió correctamente");
        } else {
            System.out.println("No se puede devolver el libro porque no está prestado");
        }
    }

    @Override
    public boolean estaPrestado() {
        return false;
    }

    @Override
    public double precio() {
        return this.getPrecio();
    }

    @Override
    public void establecerPrecio(double precio) {
        this.setPrecio(precio);
    }

    @Override
    public Libro getLibro() {
        return this;
    }
}
