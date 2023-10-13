package MODELO;

public class Proceso {

    private int nombre; // en la interfaz le pongo un nombre como "Proceso 1", "Proceso 2"
    private int tiempoTotal;
    private int tiempoRestante;
    private Proceso siguiente; // lo hago de tipo nodo para que pueda apuntar a otro proceso


    public Proceso(int tiempoTotal) {
        this.tiempoTotal = tiempoTotal;
        this.tiempoRestante = tiempoTotal;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre=nombre;
    }

    public int getTiempoTotal() {
        return tiempoTotal;
    }

    public void setTiempoTotal(int tiempoTotal) {
        this.tiempoTotal=tiempoTotal;
    }

    public int getTiempoRestante() {
        return tiempoRestante;
    }

    public void setTiempoRestante(int tiempoRestante) {
        this.tiempoRestante=tiempoRestante;
    }

    public Proceso getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Proceso siguiente) {
        this.siguiente=siguiente;
    }

}
