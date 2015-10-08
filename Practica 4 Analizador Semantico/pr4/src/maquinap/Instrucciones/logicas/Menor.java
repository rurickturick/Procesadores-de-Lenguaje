package maquinap.Instrucciones.logicas;
import java.util.Stack;

import maquinap.excepciones.ExcepcionOperacion;
import maquinap.maquinaPila.Celda;
import maquinap.maquinaPila.ContadorPrograma;
import maquinap.maquinaPila.GestorMemoria;
import maquinap.maquinaPila.Tipo;
import maquinap.Instrucciones.Instruccion;
public class Menor implements Instruccion {
	
	@Override
	public void ejecutar(Stack<Celda> pilaEvaluacion, GestorMemoria memoria,ContadorPrograma cp) throws ExcepcionOperacion {
		Celda op2 = pilaEvaluacion.pop();
		Celda op1 = pilaEvaluacion.pop();
		if((op1.getTipo()==Tipo.BOOLEAN) && op2.getTipo()==Tipo.BOOLEAN){
			boolean result = op1.boolToInt() < op2.boolToInt();
			Celda celda = new Celda(result,Tipo.BOOLEAN);
			pilaEvaluacion.push(celda);
		}
		else if((op1.getTipo()==Tipo.INT) && op2.getTipo()==Tipo.INT){
			boolean result = (Integer)op1.getDato() < (Integer)op2.getDato();
			Celda celda = new Celda(result,Tipo.BOOLEAN);
			pilaEvaluacion.push(celda);
		}
		else if((op1.getTipo()==Tipo.DOUBLE) && op2.getTipo()==Tipo.DOUBLE){
			boolean result = (double)op1.getDato() < (double)op2.getDato();
			Celda celda = new Celda(result,Tipo.BOOLEAN);
			pilaEvaluacion.push(celda);
		}//nuevos casos
		else if((op1.getTipo()==Tipo.DOUBLE) && op2.getTipo()==Tipo.DOUBLE){
			boolean result = (double)op1.getDato() < (double)op2.getDato();
			Celda celda = new Celda(result,Tipo.BOOLEAN);
			pilaEvaluacion.push(celda);
		}
		else if((op1.getTipo()==Tipo.DOUBLE) && op2.getTipo()==Tipo.INT){
			boolean result = (double)op1.getDato() < (Integer)op2.getDato();
			Celda celda = new Celda(result,Tipo.BOOLEAN);
			pilaEvaluacion.push(celda);
		}
		else if((op1.getTipo()==Tipo.INT) && op2.getTipo()==Tipo.DOUBLE){
			boolean result = (Integer)op1.getDato() < (double)op2.getDato();
			Celda celda = new Celda(result,Tipo.BOOLEAN);
			pilaEvaluacion.push(celda);
		}
		else throw new ExcepcionOperacion("Error en la operacion Menor");
		
	}
	
	public String toString(){
		return "Menor";
	}
}
