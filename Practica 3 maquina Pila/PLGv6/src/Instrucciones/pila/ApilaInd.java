package Instrucciones.pila;

import Instrucciones.Instruccion;

import java.util.Stack;

import excepciones.ExcepcionAccesoMemoria;
import maquinaPila.Celda;
import maquinaPila.ContadorPrograma;
import maquinaPila.GestorMemoria;

public class ApilaInd implements Instruccion {
		
	
	@Override
	public void ejecutar(Stack<Celda> pilaEvaluacion,GestorMemoria memoria,ContadorPrograma cp) throws ExcepcionAccesoMemoria {
		
		Celda cima = pilaEvaluacion.pop();
		int posicion = (Integer) cima.getDato();
		Celda dato = memoria.get(posicion);
		pilaEvaluacion.push(dato.clona());
		
	}
	public String toString(){
		return "ApilaInd";
	}
}
