package Instrucciones.pila;

import Instrucciones.Instruccion;

import java.util.Stack;

import maquinaPila.Celda;
import maquinaPila.ContadorPrograma;
import maquinaPila.GestorMemoria;

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
