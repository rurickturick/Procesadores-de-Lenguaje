package maquinap.Instrucciones.pila;

import maquinap.Instrucciones.Instruccion;

import java.util.Stack;

import maquinap.maquinaPila.Celda;
import maquinap.maquinaPila.ContadorPrograma;
import maquinap.maquinaPila.GestorMemoria;

public class Desapila implements Instruccion {

	@Override
	public void ejecutar(Stack<Celda> pilaEvaluacion, GestorMemoria memoria,ContadorPrograma cp) {
		try{
		pilaEvaluacion.pop();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public String toString(){
		return "Desapila";
	}
	
}
