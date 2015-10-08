package Instrucciones.control;

import java.util.Stack;

import maquinaPila.Celda;
import maquinaPila.ContadorPrograma;
import maquinaPila.GestorMemoria;
import Instrucciones.Instruccion;

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
