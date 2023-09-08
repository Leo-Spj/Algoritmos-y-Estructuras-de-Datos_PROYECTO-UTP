/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADOR;

/**
 *
 * @author brandonluismenesessolorzano
 */
public class Personas {
    private String nombre;
    private String apellido;
    private int dni;
    private int telefono;
    private String sexo;
    private String estadoCivil;
    private int edad;

    public Personas() {
    }
    
    public Personas(String nombre, String apellido, int dni, int telefono, String sexo, String estadoCivil, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.sexo = sexo;
        this.estadoCivil = estadoCivil;
        this.edad = edad;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public void datosPersonales(){
        Personas[] persona = new Personas[30];
        persona[0] = new Personas("Juan", "Perez", 12345678, 5551234, "Masculino", "Soltero", 25);
        persona[1] = new Personas("Maria", "Lopez", 87654321, 5555678, "Femenino", "Casado", 30);
        persona[2] = new Personas("Carlos", "Gonzalez", 98765432, 5559876, "Masculino", "Divorciado", 40);
        persona[3] = new Personas("Ana", "Martinez", 34567890, 5554321, "Femenino", "Casado", 35);
        persona[4] = new Personas("Pedro", "Rodriguez", 23456789, 5558765, "Masculino", "Soltero", 28);
        persona[5] = new Personas("Laura", "Fernandez", 45678901, 5553456, "Femenino", "Soltero", 22);
        persona[6] = new Personas("Javier", "Lopez", 56789012, 5556543, "Masculino", "Viudo", 50);
        persona[7] = new Personas("Sara", "Gomez", 67890123, 5552345, "Femenino", "Casado", 45);
        persona[8] = new Personas("Luis", "Sanchez", 78901234, 5555432, "Masculino", "Soltero", 29);
        persona[9] = new Personas("Elena", "Mendoza", 89012345, 5557890, "Femenino", "Casado", 38);
        persona[10] = new Personas("Fernando", "Hernandez", 90123456, 5554567, "Masculino", "Divorciado", 42);
        persona[11] = new Personas("Carmen", "Gutierrez", 12345667, 5558901, "Femenino", "Soltero", 27);
        persona[12] = new Personas("Diego", "Ramirez", 23456778, 5555678, "Masculino", "Soltero", 26);
        persona[13] = new Personas("Marta", "Diaz", 34567890, 5551234, "Femenino", "Casado", 33);
        persona[14] = new Personas("Antonio", "Perez", 45678901, 5552345, "Masculino", "Viudo", 55);
        persona[15] = new Personas("Isabel", "Garcia", 56789012, 5553456, "Femenino", "Casado", 36);
        persona[16] = new Personas("Eduardo", "Lopez", 67890123, 5554321, "Masculino", "Soltero", 31);
        persona[17] = new Personas("Rosa", "Fernandez", 78901234, 5556543, "Femenino", "Casado", 37);
        persona[18] = new Personas("Mario", "Torres", 89012345, 5558765, "Masculino", "Soltero", 24);
        persona[19] = new Personas("Silvia", "Morales", 90123456, 5559876, "Femenino", "Divorciado", 41);

    }
}
