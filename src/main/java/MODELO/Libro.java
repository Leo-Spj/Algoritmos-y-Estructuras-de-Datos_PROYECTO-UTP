package MODELO;

public abstract class Libro {
    private String titulo;
    private String autor;
    private int anioPublicacion;

    private int ISBN;
    private boolean prestado = false;
    private double precio;


    public Libro(String titulo, String autor, int anioPublicacion, int ISBN) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.ISBN = ISBN;
    }

    public String getTitulo(){
        return this.titulo + " (" + this.anioPublicacion + ")" + " - " + this.autor;
    }

    public abstract Libro getLibro();

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
