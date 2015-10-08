package Instrucciones.pila;

import Instrucciones.Instruccion;

import java.util.Stack;

import maquinaPila.Celda;
import maquinaPila.ContadorPrograma;
import maquinaPila.GestorMemoria;

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

