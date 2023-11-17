package MODELO.CLASIFICACION;

import MODELO.Libro;

public class Novela extends Libro{

    private String genero;

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

    public String[] getAttributeNames() {
        return new String[]{"titulo", "autor", "genero", "anio", "isbn"};
    }

    public String getAttributeValue(String attributeName) {
        switch (attributeName) {
            case "titulo":
                return getTitulo();
            case "autor":
                return getAutor();
            case "genero":
                return getGenero();
            case "anio":
                return getAnioPublicacion()+"";
            case "isbn":
                return getISBN()+"";
            default:
                return null;
        }
    }
    public String toString() {
        return "Novela{" +
                "titulo='" + getTitulo() + '\'' +
                ", autor='" + getAutor() + '\'' +
                ", anio=" + getAnioPublicacion() +
                ", isbn=" + getISBN() +
                ", genero='" + getGenero() + '\'' +
                '}';
    }
}
