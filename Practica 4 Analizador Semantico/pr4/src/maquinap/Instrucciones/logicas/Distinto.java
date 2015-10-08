package maquinap.Instrucciones.logicas;
import java.util.Stack;

import maquinap.excepciones.ExcepcionOperacion;
import maquinap.maquinaPila.Celda;
import maquinap.maquinaPila.ContadorPrograma;
import maquinap.maquinaPila.GestorMemoria;
import maquinap.maquinaPila.Tipo;
import maquinap.Instrucciones.Instruccion;

public class Distinto implements Instruccion {
	
	@Override
	public void ejecutar(Stack<Celda> pilaEvaluacion, GestorMemoria memoria,ContadorPrograma cp) throws ExcepcionOperacion {
		Celda op2 = pilaEvaluacion.pop();
		Celda op1 = pilaEvaluacion.pop();
		if((op1.getTipo()==Tipo.BOOLEAN) && op2.getTipo()==Tipo.BOOLEAN){
			boolean result = (Boolean)op1.getDato() != (Boolean)op2.getDato();
			Celda celda = new Celda(result,Tipo.BOOLEAN);
			pilaEvaluacion.push(celda);
		}
		else if((op1.getTipo()==Tipo.INT) && op2.getTipo()==Tipo.INT){
			boolean result = (Integer)op1.getDato() != (Integer)op2.getDato();
			Celda celda = new Celda(result,Tipo.BOOLEAN);
			pilaEvaluacion.push(celda);
		}
	
		else if((op1.getTipo()==Tipo.INT) && op2.getTipo()==Tipo.NULL){
			Celda celda = new Celda(true,Tipo.BOOLEAN);
			pilaEvaluacion.push(celda);	
		}
		else if((op1.getTipo()==Tipo.NULL) && op2.getTipo()==Tipo.INT){
			Celda celda = new Celda(true,Tipo.BOOLEAN);
			pilaEvaluacion.push(celda);	
		}

		else if((op1.getTipo()==Tipo.NULL) && op2.getTipo()==Tipo.NULL){
			Celda celda = new Celda(false,Tipo.BOOLEAN);
			pilaEvaluacion.push(celda);
		}
		else if((op1.getTipo()==Tipo.DOUBLE) && op2.getTipo()==Tipo.DOUBLE){
			boolean result = (double)op1.getDato() != (double)op2.getDato();
			Celda celda = new Celda(result,Tipo.BOOLEAN);
			pilaEvaluacion.push(celda);
		}
		else if((op1.getTipo()==Tipo.BOOLEAN) && op2.getTipo()==Tipo.NULL){
			Celda celda = new Celda(true,Tipo.BOOLEAN);
			pilaEvaluacion.push(celda);	
		}
		else if((op1.getTipo()==Tipo.DOUBLE) && op2.getTipo()==Tipo.NULL){
			Celda celda = new Celda(true,Tipo.BOOLEAN);
			pilaEvaluacion.push(celda);	
		}
		else if((op1.getTipo()==Tipo.NULL) && op2.getTipo()==Tipo.BOOLEAN){
			Celda celda = new Celda(true,Tipo.BOOLEAN);
			pilaEvaluacion.push(celda);	
		}
		else if((op1.getTipo()==Tipo.NULL) && op2.getTipo()==Tipo.DOUBLE){
			Celda celda = new Celda(true,Tipo.BOOLEAN);
			pilaEvaluacion.push(celda);	
		}
		else throw new ExcepcionOperacion("Error en la operacion Distinto");
		
	}
	public String toString(){
		return "Distinto";
	}
}