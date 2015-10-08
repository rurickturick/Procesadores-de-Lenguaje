package Instrucciones.pila;

import java.util.Stack;

import excepciones.ExcepcionMonton;
import maquinaPila.Celda;
import maquinaPila.ContadorPrograma;
import maquinaPila.GestorMemoria;
import maquinaPila.Tipo;
import Instrucciones.Instruccion;

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
