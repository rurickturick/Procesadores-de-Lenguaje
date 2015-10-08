package alex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import asint.AnalizadorSintacticoTiny;

public class Main {
public static void main(String[] args) throws Exception {
Reader input = new InputStreamReader(new FileInputStream(
"C:\\hlocal\\Practicas PL PARA ENTREGA\\Practica 2 Analizador Sintactico\\AnalizadorSintactico\\Implementaciones\\Cup\\src\\alex\\pl.txt"));
AnalizadorLexicoTiny alex = new AnalizadorLexicoTiny(input);
AnalizadorSintacticoTiny asint = new AnalizadorSintacticoTiny(alex);
asint.parse();
} 
}


