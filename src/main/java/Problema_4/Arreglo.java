/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Problema_4;

public class Arreglo {
    private String autor;
    private int año;
    private String genero;
    private String titulo;
    private String isbn;  // Nuevo atributo ISBN

    // Constructor
    public Arreglo(String autor, int año, String genero, String titulo, String isbn) {
        this.autor = autor;
        this.año = año;
        this.genero = genero;
        this.titulo = titulo;
        this.isbn = isbn;
    }

    // Métodos de acceso
    public String getAutor() {
        return autor;
    }

    public int getAño() {
        return año;
    }

    public String getGenero() {
        return genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public static void main(String[] args) {
        // Crear más instancias de libros con ISBN
        Arreglo libro1 = new Arreglo("Gabriel García Márquez", 1967, "Realismo mágico", "Cien años de soledad", "9783161484100");
        Arreglo libro2 = new Arreglo("J.K. Rowling", 1997, "Fantasía", "Harry Potter y la piedra filosofal", "9780747532696");
        Arreglo libro3 = new Arreglo("George Orwell", 1949, "Distopía", "1984", "9780452284234");
        Arreglo libro4 = new Arreglo("Jane Austen", 1813, "Novela romántica", "Orgullo y prejuicio", "9781853260001");
        Arreglo libro5 = new Arreglo("Harper Lee", 1960, "Novela", "Matar a un ruiseñor", "9780061120084");
        Arreglo libro6 = new Arreglo("J.R.R. Tolkien", 1954, "Fantasía", "El Señor de los Anillos", "9780618346255");
        Arreglo libro7 = new Arreglo("Agatha Christie", 1934, "Misterio", "Asesinato en el Orient Express", "9780062073488");
        Arreglo libro8 = new Arreglo("Leo Tolstoy", 1869, "Novela", "Guerra y paz", "9780192833983");
        Arreglo libro9 = new Arreglo("F. Scott Fitzgerald", 1925, "Ficción", "El gran Gatsby", "9780743273565");
        Arreglo libro10 = new Arreglo("Jules Verne", 1873, "Aventura", "La vuelta al mundo en 80 días", "9781853260049");

        // Puedes acceder a la información de cada libro incluyendo el ISBN así:
        System.out.println("Autor del primer libro: " + libro1.getAutor() + ", ISBN: " + libro1.getIsbn());
        System.out.println("Año del segundo libro: " + libro2.getAño() + ", ISBN: " + libro2.getIsbn());
        System.out.println("Género del tercer libro: " + libro3.getGenero() + ", ISBN: " + libro3.getIsbn());
        System.out.println("Título del cuarto libro: " + libro4.getTitulo() + ", ISBN: " + libro4.getIsbn());
        System.out.println("Autor del quinto libro: " + libro5.getAutor() + ", ISBN: " + libro5.getIsbn());
        System.out.println("Año del sexto libro: " + libro6.getAño() + ", ISBN: " + libro6.getIsbn());
        System.out.println("Género del séptimo libro: " + libro7.getGenero() + ", ISBN: " + libro7.getIsbn());
        System.out.println("Título del octavo libro: " + libro8.getTitulo() + ", ISBN: " + libro8.getIsbn());
        System.out.println("Autor del noveno libro: " + libro9.getAutor() + ", ISBN: " + libro9.getIsbn());
        System.out.println("Año del décimo libro: " + libro10.getAño() + ", ISBN: " + libro10.getIsbn());
    }
}
