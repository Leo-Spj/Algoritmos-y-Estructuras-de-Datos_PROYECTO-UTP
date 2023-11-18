/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package APF3.P3;

/**
 *
 * @author Leo
 */
public class Persona {
    private String nombre;
    private String genero;
    private int edad;
    private String ipv4;

    public Persona(String nombre, String genero, int edad, String ipv4) {
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.ipv4 = ipv4;
    }

    @Override
    public String toString() {
        return "Persona {" + "\n" +
                "\t nombre = '" + getNombre() + "',\n" +
                "\t genero = '" + getGenero() + "',\n" +
                "\t edad = " + getEdad() + ",\n" +
                "\t ipv4 = '" + getIpv4() + "'\n" +
                " }";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getIpv4() {
        return ipv4;
    }

    public void setIpv4(String ipv4) {
        this.ipv4 = ipv4;
    }
    
    
}