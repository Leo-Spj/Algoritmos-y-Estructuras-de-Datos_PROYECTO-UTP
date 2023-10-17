package CONTROL;

import MODELO.Persona_2;

public class PersonaColaPrioridadLinkedList {

    private Persona_2 cabeza;



    //agregar persona segun su edad al inicion de la cola, mayores al inicio, menores al ultimo
    public void insertarPersona(Persona_2 persona){
        if (cabeza == null){
            cabeza = persona;
        }else{
            if (persona.getEdad() > cabeza.getEdad()){
                persona.setSiguiente(cabeza);
                cabeza = persona;
            }else{
                Persona_2 aux = cabeza;
                while (aux.getSiguiente() != null && persona.getEdad() < aux.getSiguiente().getEdad()){
                    aux = aux.getSiguiente();
                }
                persona.setSiguiente(aux.getSiguiente());
                aux.setSiguiente(persona);
            }
        }
    }


    // atender a la persona de mayor edad, o sea a la cabeza
    public void atenderPersona(){
        if (cabeza != null){
            cabeza = cabeza.getSiguiente();
        }
    }

    // mostrar las personas de la cola
    public String mostrarPersonas(){
        Persona_2 aux = cabeza;
        String cadena = "";
        while (aux != null){
            cadena += aux.getNombre() + " " + aux.getEdad() + " años;";
            aux = aux.getSiguiente();
        }
        return cadena;
    }

}
