package maquinap.Instrucciones.pila;

import maquinap.Instrucciones.Instruccion;

import java.util.Stack;

import maquinap.excepciones.ExcepcionAccesoMemoria;
import maquinap.maquinaPila.Celda;
import maquinap.maquinaPila.ContadorPrograma;
import maquinap.maquinaPila.GestorMemoria;

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
