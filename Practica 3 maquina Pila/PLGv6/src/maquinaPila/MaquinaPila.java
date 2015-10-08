package maquinaPila;

import Instrucciones.Instruccion; 

import java.util.ArrayList;
import java.util.Stack;

import excepciones.ExcepcionAccesoMemoria;




public class MaquinaPila {

	private Stack<Celda> pilaEvaluacion;
	private ArrayList<Instruccion> programa; //Crear la clase instrucciones y con el parser crear objetos de ese tipo
	private ContadorPrograma contadorPrograma;
	private GestorMemoria memoria;
	
	public MaquinaPila(){
		this.pilaEvaluacion = new Stack<Celda>();
		this.programa = new ArrayList<Instruccion>();
		this.memoria = new GestorMemoria(2500,500);
		this.contadorPrograma = new ContadorPrograma();		
	}
	
	public void arrancar(String ruta){
		Parser parser = new Parser(this.programa);
		parser.leeFichero(ruta);
		//Se ejecuta hasta que accede con el pc a una posicion de programa inválida
		//Es decir hasta que recorre todas las instrucciones del programa
		try{
		while(this.contadorPrograma.getContadorPrograma()<programa.size()){
			Instruccion i = programa.get(this.contadorPrograma.getContadorPrograma());
			//Muestra instrucciones para depurar
			//System.out.println("CP: "+this.contadorPrograma.getContadorPrograma() + " Ins: "+ this.programa.get(this.contadorPrograma.getContadorPrograma()).toString());
			i.ejecutar(pilaEvaluacion,memoria,contadorPrograma);
			this.contadorPrograma.incrementarCP();
			if(this.contadorPrograma.getContadorPrograma() > programa.size()) 
				throw new ExcepcionAccesoMemoria("Contador de programa erróneo (Error de instruccion de salto)");
		}
		System.out.println("Fin de programa");
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
	}
	
}

	
	
	
	
	
	
	
	
	
	

