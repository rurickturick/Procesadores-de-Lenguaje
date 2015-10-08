package maquinap.Instrucciones.pila;

import maquinap.maquinaPila.Celda;
import maquinap.maquinaPila.ContadorPrograma;
import maquinap.Instrucciones.Instruccion;

import java.util.Stack;

import maquinap.excepciones.ExcepcionAccesoMemoria;
import maquinap.maquinaPila.GestorMemoria;

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
