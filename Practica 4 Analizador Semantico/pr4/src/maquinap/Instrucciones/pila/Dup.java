package maquinap.Instrucciones.pila;

import maquinap.Instrucciones.Instruccion;

import java.util.Stack;

import maquinap.maquinaPila.Celda;
import maquinap.maquinaPila.ContadorPrograma;
import maquinap.maquinaPila.GestorMemoria;

public class Dup implements Instruccion {
	
	
	@Override
	public void ejecutar(Stack<Celda> pilaEvaluacion,GestorMemoria memoria,ContadorPrograma cp) {
		
		Celda dup = pilaEvaluacion.peek().clona();
		pilaEvaluacion.push(dup);
		
	}
	public String toString(){
		return "Dup";
	}
}

