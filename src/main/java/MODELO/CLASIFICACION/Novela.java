package MODELO.CLASIFICACION;

import MODELO.Libro;

public class Novela extends Libro{

    String genero;

    public Novela(String titulo, String autor, int anioPublicacion, long ISBN, String genero) {
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
    public Libro getLibro() {
        return this;
    }
}
