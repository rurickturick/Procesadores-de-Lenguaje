package tiny;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Map;

import maquinap.maquinaPila.MainMP;
import instrucciones.Programa;
import traductor.Chequeo;
import traductor.Decoracion;
import traductor.EscribeCodigoEnArchivo;
import traductor.GeneraCodigo;
import traductor.Vinculador;

public class Main {
	
	//En fuente ponemos el nombre del archivo, para el que se generara el codigo.
	//Los codigos de prueba, los obtenemos de la carpeta casos de prueba.
	static final String fuente = "VarNoArray.txt";
	
	//En salida obtendremos el CODIGO P generado.
	static final String salida = "output.txt";
	
	//output.txt se escribira en la carpeta, caso de prueba generado.
	//Para q funcione, tienes que poner la ruta de output.txt en la clase MainMP del paquete
	//maquinap.maquinaPila
	
	public static void main(String[] args) throws Exception {
		
		File f = new File("");
		String carpetaCasosDePrueba = 
					f.getAbsolutePath()+File.separator+"casosdeprueba"+File.separator;
		
		
		String carpetaSalidaCasosDePrueba = 
					f.getAbsolutePath()+File.separator+"salidaGenerada"+File.separator;
		
		//Realizamos el analisis sintactico y el analisis Lexico del codigo
		Reader input = new InputStreamReader(new FileInputStream(carpetaCasosDePrueba+fuente));
		AnalizadorLexicoTiny alex = new AnalizadorLexicoTiny(input);
		AnalizadorSintacticoTiny asint = new AnalizadorSintacticoTiny(alex);		
		asint.parse();
		System.out.println("**Análisis Lexico y Sintactico completados **");
		
		
		//Ahora realizamos la vinculacion.
		Programa p = AnalizadorSintacticoTiny.root;	
		Map<Object, Integer> numLineas = AnalizadorSintacticoTiny.constructora.getNumeroLinea();

		Vinculador vinculador = new Vinculador(numLineas);
		Map<Object, Object> vinculos = vinculador.vincula(p);
		System.out.println("***********Vinculación completada************");
		
		
		//Aplicamos los chequea.
		Chequeo ch = new Chequeo(numLineas, vinculos);
		ch.chequea(p);
		System.out.println("*************Chequeo completado *************");
		
		Decoracion d = new Decoracion();
		GeneraCodigo gc = new GeneraCodigo(vinculos, d);
		gc.generaCodigo(p);
		System.out.println("**************Codigo Generado****************");
		
		EscribeCodigoEnArchivo ea = new EscribeCodigoEnArchivo(gc.getCodigo());
		ea.escribeCodigo(carpetaSalidaCasosDePrueba+salida);
		System.out.println("***********Archivo Fuente Procesado**********");
		

		System.out.println("***********Ejecutando el programa************");
		String a[] = null;
		MainMP.main(a);

		System.out.println("************Programa Ejecutado***************");
		
	}
}
