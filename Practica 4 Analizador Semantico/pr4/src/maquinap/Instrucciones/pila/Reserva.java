package maquinap.Instrucciones.pila;

import java.util.Stack;

import maquinap.excepciones.ExcepcionMonton;
import maquinap.maquinaPila.Celda;
import maquinap.maquinaPila.ContadorPrograma;
import maquinap.maquinaPila.GestorMemoria;
import maquinap.maquinaPila.Tipo;
import maquinap.Instrucciones.Instruccion;

public class Reserva implements Instruccion {
	
	private int cantidad;
	
	public Reserva(int cantidad){
		this.cantidad=cantidad;
	}
	
	@Override
	public void ejecutar(Stack<Celda> pilaEvaluacion, GestorMemoria memoria,ContadorPrograma cp) {
		
		try {
			int direccionComienzo=memoria.malloc(cantidad);
			Celda celda = new Celda(direccionComienzo,Tipo.INT);
			pilaEvaluacion.push(celda);
		} catch (ExcepcionMonton e) {
			e.printStackTrace();
		}
		
		
	}
	public String toString(){
		return "Reserva" + cantidad;
	}
}
