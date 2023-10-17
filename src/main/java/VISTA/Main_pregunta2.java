/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VISTA;

import CONTROL.Persona;
import CONTROL.PersonaColaPrioridadLinkedList;
import MODELO.Persona_2;


/**
 *
 * @author LAB-USR-PT116-E406
 */

public class Main_pregunta2{
  
    public static void main(String[] args) {

        PersonaColaPrioridadLinkedList colaPersonas = new PersonaColaPrioridadLinkedList();

        // insertando en la lista enlazada a las personas de prueba desde niños a adultos mayores aleatoriamente
        colaPersonas.incertarPersona(new Persona_2("Juan", 10));
        colaPersonas.incertarPersona(new Persona_2("Pedro", 20));
        colaPersonas.incertarPersona(new Persona_2("Luis", 50));
        colaPersonas.incertarPersona(new Persona_2("Ana", 60));
        colaPersonas.incertarPersona(new Persona_2("Maria", 30));
        colaPersonas.incertarPersona(new Persona_2("Carlos", 80));
        colaPersonas.incertarPersona(new Persona_2("Luis", 90));
        colaPersonas.incertarPersona(new Persona_2("Luisa", 100));
        colaPersonas.incertarPersona(new Persona_2("Carlos", 110));
        colaPersonas.incertarPersona(new Persona_2("Jose", 40));
        colaPersonas.incertarPersona(new Persona_2("Luisa", 70));

        // mostrando las personas de la lista enlazada
        System.out.println(colaPersonas.mostrarPersonas());

        // atendiendo a las personas de la lista enlazada
        colaPersonas.atenderPersona();
        System.out.println(colaPersonas.mostrarPersonas());

        colaPersonas.atenderPersona();
        System.out.println(colaPersonas.mostrarPersonas());

        colaPersonas.atenderPersona();
        System.out.println(colaPersonas.mostrarPersonas());

    }
}
   