package maquinap.Instrucciones.pila;

import maquinap.Instrucciones.Instruccion;

import java.util.Stack;

import maquinap.maquinaPila.Celda;
import maquinap.maquinaPila.ContadorPrograma;
import maquinap.maquinaPila.GestorMemoria;

public class Escribe implements Instruccion {

	@Override
	public void ejecutar(Stack<Celda> pilaEvaluacion, GestorMemoria memoria,ContadorPrograma cp) {
		
		Celda celda = pilaEvaluacion.pop();
		System.out.println(celda.toString());
			
	}
	
	
	public String toString(){
		return "Escribe";
	}
}
