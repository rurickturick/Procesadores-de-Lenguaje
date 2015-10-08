package maquinap.Instrucciones.pila;
import java.util.Stack;

import maquinap.excepciones.ExcepcionMonton;
import maquinap.maquinaPila.Celda;
import maquinap.maquinaPila.ContadorPrograma;
import maquinap.maquinaPila.GestorMemoria;
import maquinap.Instrucciones.Instruccion;

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
