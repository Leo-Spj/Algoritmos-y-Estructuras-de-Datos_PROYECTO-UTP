package MODELO;

public class Persona_2 {
    private String nombre;
    private int edad;

    private Persona_2 anterior;
    private Persona_2 siguiente;

    public Persona_2(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Persona_2 getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Persona_2 siguiente) {
        this.siguiente = siguiente;
    }

    public Persona_2 getAnterior() {
        return anterior;
    }

    public void setAnterior(Persona_2 anterior) {
        this.anterior = anterior;
    }
}
