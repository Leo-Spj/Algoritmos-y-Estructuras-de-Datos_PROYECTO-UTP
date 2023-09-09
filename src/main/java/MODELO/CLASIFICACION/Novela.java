package MODELO.CLASIFICACION;

import MODELO.Libro;
import MODELO.Prestable;
import MODELO.Vendible;

public class Novela extends Libro implements Prestable, Vendible {

    String genero;
    public Novela(String titulo, String autor, int anioPublicacion, int ISBN, String genero) {
        super(titulo, autor, anioPublicacion, ISBN);
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
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
        return this.isPrestado();
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
