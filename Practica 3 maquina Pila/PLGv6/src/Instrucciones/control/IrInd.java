package Instrucciones.control;

import java.util.Stack;

import maquinaPila.Celda;
import maquinaPila.ContadorPrograma;
import maquinaPila.GestorMemoria;
import Instrucciones.Instruccion;

public class IrInd implements Instruccion {

	@Override
	public void ejecutar(Stack<Celda> pilaEvaluacion, GestorMemoria memoria,ContadorPrograma cp) {
		
		Celda cima = pilaEvaluacion.pop();
		int direccion = (Integer)cima.getDato();
		cp.setContadorPrograma(direccion);
		
	}
	// Salta a la direccion indicada en la cima de la pila.
	public String toString(){
		return "IrInd";
	}
}
