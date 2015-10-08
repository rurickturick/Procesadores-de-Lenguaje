package maquinap.Instrucciones.pila;

import maquinap.Instrucciones.Instruccion;

import java.util.Stack;

import maquinap.excepciones.ExcepcionAccesoMemoria;
import maquinap.maquinaPila.Celda;
import maquinap. maquinaPila.ContadorPrograma;
import maquinap.maquinaPila.GestorMemoria;

public class DesapilaInd implements Instruccion {
		
	
	@Override
	public void ejecutar(Stack<Celda> pilaEvaluacion,GestorMemoria memoria,ContadorPrograma cp) throws ExcepcionAccesoMemoria {
		
		Celda cima = pilaEvaluacion.pop();
		Celda subcima = pilaEvaluacion.pop();
		int posicion = (Integer) subcima.getDato();
		memoria.put(posicion, cima);
		
		
	}
	public String toString(){
		return "DesapilaInd";
	}
}

