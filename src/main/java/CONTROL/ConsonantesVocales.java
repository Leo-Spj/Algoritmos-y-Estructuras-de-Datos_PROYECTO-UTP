/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROL;

/**
 *
 * @author jimmy
 */
public class ConsonantesVocales{
    
        public boolean isConsonant(char c) {
        switch (c) {
            case 'b':
            case 'B':
            case 'c':
            case 'C':
            case 'd':
            case 'D':
            case 'f':
            case 'F':
            case 'g':
            case 'G':
            case 'h':
            case 'H':
            case 'j':
            case 'J':
            case 'k':
            case 'K':
            case 'l':
            case 'L':
            case 'm':
            case 'M':
            case 'n':
            case 'N':
            case 'p':
            case 'P':
            case 'q':
            case 'Q':
            case 'r':
            case 'R':
            case 's':
            case 'S':
            case 't':
            case 'T':
            case 'v':
            case 'V':
            case 'w':
            case 'W':
            case 'x':
            case 'X':
            case 'y':
            case 'Y':
            case 'z':
            case 'Z':
            case 'ñ':
            case 'Ñ':
                return true;
            default:
                return false;
        }
    }

    public boolean isVowel(char c) {
        switch (c) {
            case 'a':
            case 'A':
            case 'e':
            case 'E':
            case 'i':
            case 'I':
            case 'o':
            case 'O':
            case 'u':
            case 'U':
                return true;
            default:
                return false;
        }
    }
}
