package Instrucciones.pila;

import maquinaPila.Celda;
import maquinaPila.ContadorPrograma;
import Instrucciones.Instruccion;

import java.util.Stack;

import excepciones.ExcepcionAccesoMemoria;
import maquinaPila.GestorMemoria;

public class ApilaDir implements Instruccion {
	
	private int direccion;
	
	public ApilaDir(int direccion){
		this.direccion=direccion;
	}
	@Override
	public void ejecutar(Stack<Celda> pilaEvaluacion, GestorMemoria memoria,ContadorPrograma cp) throws ExcepcionAccesoMemoria {
		
			Celda celda;
			celda = memoria.get(direccion);
			pilaEvaluacion.push(celda.clona());
		
		
			
	}
	public String toString(){
		return "ApilaDir "+direccion;
	}
}
