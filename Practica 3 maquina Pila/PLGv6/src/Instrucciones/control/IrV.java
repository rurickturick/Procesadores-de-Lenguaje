package Instrucciones.control;

import java.util.Stack;

import excepciones.ExcepcionOperacion;
import maquinaPila.Celda;
import maquinaPila.ContadorPrograma;
import maquinaPila.GestorMemoria;
import maquinaPila.Tipo;
import Instrucciones.Instruccion;

public class IrV implements Instruccion {
	
	private int direccion;
	public IrV(int direccion){
		this.direccion=direccion;
	}
	//Controlar las excepciones
	@Override
	public void ejecutar(Stack<Celda> pilaEvaluacion, GestorMemoria memoria,ContadorPrograma cp) throws ExcepcionOperacion {
		Celda cima = pilaEvaluacion.pop();
		if(cima.getTipo()==Tipo.BOOLEAN){
			boolean result = new Boolean((Boolean)cima.getDato());
			if(result){
			cp.setContadorPrograma(this.direccion);
			}
		}
		else throw new ExcepcionOperacion("Error irV");

		
	}
	public String toString(){
		return "IrV "+direccion;
	}
}
