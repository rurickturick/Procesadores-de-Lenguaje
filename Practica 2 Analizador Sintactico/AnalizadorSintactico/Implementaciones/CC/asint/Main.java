package asint;
import java.io.FileInputStream;

import java.io.InputStreamReader;
import java.io.Reader;
public class Main{
   public static void main(String[] args) throws Exception {
	   Reader input = new InputStreamReader(new FileInputStream(
			  "C:\\hlocal\\Practicas PL PARA ENTREGA\\Practica 2 Analizador Sintactico\\AnalizadorSintactico\\Implementaciones\\CC\\asint\\pl.txt"));
      AnalizadorSintacticoTiny asint = new AnalizadorSintacticoTiny(input);
	  asint.Programa();
   }
}