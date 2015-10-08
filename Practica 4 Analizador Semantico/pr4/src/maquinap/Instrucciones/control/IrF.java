package maquinap.Instrucciones.control;

import java.util.Stack;

import maquinap.excepciones.ExcepcionOperacion;
import maquinap.maquinaPila.Celda;
import maquinap.maquinaPila.ContadorPrograma;
import maquinap.maquinaPila.GestorMemoria;
import maquinap.maquinaPila.Tipo;
import maquinap.Instrucciones.Instruccion;

public class IrF implements Instruccion {
	
	private int direccion;
	public IrF(int direccion){
		this.direccion=direccion;
	}
	//Controlar las excepciones
	@Override
	public void ejecutar(Stack<Celda> pilaEvaluacion, GestorMemoria memoria,ContadorPrograma cp) throws ExcepcionOperacion {
		Celda cima = pilaEvaluacion.pop();
		if(cima.getTipo().equals(Tipo.BOOLEAN)){
			boolean t = new Boolean((Boolean)cima.getDato());
			if(!t){
			cp.setContadorPrograma(this.direccion);
			}
		}
		else throw new ExcepcionOperacion("Error irF");
		
	}
	public String toString(){
		return "IrF "+direccion;
	}
}
