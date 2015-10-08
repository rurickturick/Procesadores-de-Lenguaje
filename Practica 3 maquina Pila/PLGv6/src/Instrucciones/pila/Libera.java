package Instrucciones.pila;
import java.util.Stack;

import excepciones.ExcepcionMonton;
import maquinaPila.Celda;
import maquinaPila.ContadorPrograma;
import maquinaPila.GestorMemoria;
import Instrucciones.Instruccion;

public class Libera implements Instruccion {
	
	private int cantidad;
	
	public Libera(int cantidad){
		this.cantidad=cantidad;
	}
	
	@Override
	public void ejecutar(Stack<Celda> pilaEvaluacion, GestorMemoria memoria,ContadorPrograma cp) {
		
		try {
			int dirInicio = (Integer) pilaEvaluacion.pop().getDato();
			memoria.free(this.cantidad,dirInicio);
			
		} catch (ExcepcionMonton e) {
			e.printStackTrace();
		}
		
		
	}
	public String toString(){
		return "Libera" + cantidad;
	}
}
