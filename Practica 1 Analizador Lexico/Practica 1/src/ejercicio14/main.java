package ejercicio14;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
public class main{
public static void main(String arg[]) throws IOException {
    Reader input = new InputStreamReader(new FileInputStream("C:\\hlocal\\Practicas PL PARA ENTREGA\\Practica 1 Analizador Lexico\\Practica 1\\src\\alex\\pl.txt"));
    AnalizadorLexicoTiny al = new AnalizadorLexicoTiny(input);
    UnidadLexica unidad;
    do {
      unidad = al.sigToken();
      System.out.println(unidad);
    }
    while (unidad.clase() != ClaseLexica.EOF);
   }
}