package maquinap.Instrucciones.pila;
import java.util.Stack;

import maquinap.excepciones.ExcepcionAccesoMemoria;
import maquinap.maquinaPila.Celda;
import maquinap.maquinaPila.ContadorPrograma;
import maquinap.maquinaPila.GestorMemoria;
import maquinap.Instrucciones.Instruccion;

public class Clona implements Instruccion {
	
	private int cantidad;
	
	public Clona(int cantidad){
		this.cantidad=cantidad;
	}
	
	@Override
	public void ejecutar(Stack<Celda> pilaEvaluacion, GestorMemoria memoria,ContadorPrograma cp) throws ExcepcionAccesoMemoria {
		
		Celda cima = pilaEvaluacion.pop();
		Celda subcima= pilaEvaluacion.pop();
		int dirCima = (Integer) cima.getDato();
		int dirSubcima = (Integer) subcima.getDato();
		//copia de celdas que empiezan en dirCima
		for(int i=0;i<this.cantidad;i++){
			Celda dato = memoria.get(dirCima).clona();
			memoria.put(dirSubcima, dato);	
			dirCima++;
			dirSubcima++;
		}
		
		
	}
	public String toString(){
		return "Clona "+cantidad;
	}
}
