package maquinap.Instrucciones.aritmeticas;
import java.util.Stack;

import maquinap.excepciones.ExcepcionDivCero;
import maquinap.excepciones.ExcepcionOperacion;
import maquinap.maquinaPila.Celda;
import maquinap.maquinaPila.ContadorPrograma;
import maquinap.maquinaPila.GestorMemoria;
import maquinap.maquinaPila.Tipo;
import maquinap.Instrucciones.Instruccion;

public class Div implements Instruccion {
	
	@Override
	public void ejecutar(Stack<Celda> pilaEvaluacion, GestorMemoria memoria,ContadorPrograma cp) throws ExcepcionDivCero, ExcepcionOperacion {
		Celda op2 = pilaEvaluacion.pop();
		Celda op1 = pilaEvaluacion.pop();
		if((op1.getTipo()==Tipo.INT) && op2.getTipo()==Tipo.INT){
			if((Integer)op2.getDato()==0) throw new ExcepcionDivCero();
			else{
			int result = (Integer)op1.getDato() / (Integer)op2.getDato();
			Celda celda = new Celda(result,Tipo.INT);
			pilaEvaluacion.push(celda);
			}
			
		}
		else if((op1.getTipo()==Tipo.DOUBLE) && op2.getTipo()==Tipo.DOUBLE){
			if((double)op2.getDato()==0.0) throw new ExcepcionDivCero();
			else{
			double result = (double)op1.getDato() / (double)op2.getDato();
			Celda celda = new Celda(result,Tipo.DOUBLE);
			pilaEvaluacion.push(celda);
			}
		}
		else if((op1.getTipo()==Tipo.INT) && op2.getTipo()==Tipo.DOUBLE){
			if((Integer)op2.getDato()==0) throw new ExcepcionDivCero();
			else{
			double result = (Integer)op1.getDato() / (double)op2.getDato();
			Celda celda = new Celda(result,Tipo.DOUBLE);
			pilaEvaluacion.push(celda);
			}
		}
		else if((op1.getTipo()==Tipo.DOUBLE) && op2.getTipo()==Tipo.INT){
			if((Integer)op2.getDato()==0) throw new ExcepcionDivCero();
			else{
			double result = (double)op1.getDato() / (Integer)op2.getDato();
			Celda celda = new Celda(result,Tipo.DOUBLE);
			pilaEvaluacion.push(celda);
			}
		}
		else throw new ExcepcionOperacion("Error en la operacion Div");
		
	
		
	}
	public String toString(){
		return "Div ";
	}

}
