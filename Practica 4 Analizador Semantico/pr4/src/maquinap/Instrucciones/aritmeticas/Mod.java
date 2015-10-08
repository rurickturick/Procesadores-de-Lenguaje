package maquinap.Instrucciones.aritmeticas;
import java.util.Stack;

import maquinap.excepciones.ExcepcionOperacion;
import maquinap.maquinaPila.Celda;
import maquinap.maquinaPila.ContadorPrograma;
import maquinap.maquinaPila.GestorMemoria;
import maquinap.maquinaPila.Tipo;
import maquinap.Instrucciones.Instruccion;

public class Mod implements Instruccion {
	
	@Override
	public void ejecutar(Stack<Celda> pilaEvaluacion, GestorMemoria memoria,ContadorPrograma cp) throws ExcepcionOperacion {
		Celda op2 = pilaEvaluacion.pop();
		Celda op1 = pilaEvaluacion.pop();
		if((op1.getTipo()==Tipo.INT) && op2.getTipo()==Tipo.INT){
			int result = (Integer)op1.getDato() % (Integer)op2.getDato();
			Celda celda = new Celda(result,Tipo.INT);
			pilaEvaluacion.push(celda);
		}
		else if((op1.getTipo()==Tipo.DOUBLE) && op2.getTipo()==Tipo.DOUBLE){
			
			double result = (double)op1.getDato() % (double)op2.getDato();
			Celda celda = new Celda(result,Tipo.DOUBLE);
			pilaEvaluacion.push(celda);
			
		}
		else if((op1.getTipo()==Tipo.INT) && op2.getTipo()==Tipo.DOUBLE){
			
			double result = (Integer)op1.getDato() % (double)op2.getDato();
			Celda celda = new Celda(result,Tipo.DOUBLE);
			pilaEvaluacion.push(celda);
			
		}
		else if((op1.getTipo()==Tipo.DOUBLE) && op2.getTipo()==Tipo.INT){
			
			double result = (double)op1.getDato() % (Integer)op2.getDato();
			Celda celda = new Celda(result,Tipo.DOUBLE);
			pilaEvaluacion.push(celda);
			
		}
		else throw new ExcepcionOperacion("Error en la operacion Mod");
		
	}
	public String toString(){
		return "Mod";
	}
}