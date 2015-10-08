package Instrucciones.pila;

import Instrucciones.Instruccion;

import java.util.Stack;

import excepciones.ExcepcionAccesoMemoria;
import maquinaPila.Celda;
import maquinaPila.ContadorPrograma;
import maquinaPila.GestorMemoria;

public class DesapilaDir implements Instruccion {
	
	private int direccion;
	
	public DesapilaDir(int direccion){
		this.direccion=direccion;
	}
	@Override
	public void ejecutar(Stack<Celda> pilaEvaluacion, GestorMemoria memoria,ContadorPrograma cp) throws ExcepcionAccesoMemoria {
		Celda cima = (Celda) pilaEvaluacion.pop();
		memoria.put(this.direccion, cima);
		
	}
	public String toString(){
		return "DesapilaDir "+direccion;
	}
}
