package maquinap.Instrucciones.control;

import java.util.Stack;

import maquinap.maquinaPila.Celda;
import maquinap.maquinaPila.ContadorPrograma;
import maquinap.maquinaPila.GestorMemoria;
import maquinap.Instrucciones.Instruccion;

public class Ir implements Instruccion {
	
	private int direccion;
	
	public Ir(int direccion){
		this.direccion=direccion;
	}
	
	@Override
	public void ejecutar(Stack<Celda> pilaEvaluacion, GestorMemoria memoria,ContadorPrograma cp) {

		cp.setContadorPrograma(this.direccion);
		
	}
	public String toString(){
		return "Ir a "+direccion;
	}
}
