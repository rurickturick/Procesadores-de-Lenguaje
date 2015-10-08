package Instrucciones.pila;

import Instrucciones.Instruccion;

import java.util.Stack;

import excepciones.ExcepcionAccesoMemoria;
import maquinaPila.Celda;
import maquinaPila.ContadorPrograma;
import maquinaPila.GestorMemoria;

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

