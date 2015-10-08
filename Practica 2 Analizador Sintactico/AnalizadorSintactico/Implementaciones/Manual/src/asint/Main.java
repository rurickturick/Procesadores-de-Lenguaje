package asint;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main {
   public static void main(String[] args) throws FileNotFoundException, IOException {
     Reader input = new InputStreamReader(new FileInputStream("C:\\hlocal\\Practicas PL PARA ENTREGA\\Practica 2 Analizador Sintactico\\AnalizadorSintactico\\Implementaciones\\Manual\\src\\asint\\pl.txt"));
     AnalizadorSintacticoTinyO asint = new AnalizadorSintacticoTinyO(input);
     asint.Programa();
 }
}   
   
