package Instrucciones.pila;

import Instrucciones.Instruccion;

import java.util.Stack;

import maquinaPila.Celda;
import maquinaPila.ContadorPrograma;
import maquinaPila.GestorMemoria;

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
