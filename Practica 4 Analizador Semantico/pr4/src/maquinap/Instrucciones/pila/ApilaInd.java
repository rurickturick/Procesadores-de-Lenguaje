package maquinap.Instrucciones.pila;

import maquinap.Instrucciones.Instruccion;

import java.util.Stack;

import maquinap.excepciones.ExcepcionAccesoMemoria;
import maquinap.maquinaPila.Celda;
import maquinap. maquinaPila.ContadorPrograma;
import maquinap.maquinaPila.GestorMemoria;

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
