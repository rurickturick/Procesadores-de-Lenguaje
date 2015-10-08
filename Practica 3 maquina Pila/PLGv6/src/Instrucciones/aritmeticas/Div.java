package Instrucciones.aritmeticas;
import java.util.Stack;

import excepciones.ExcepcionDivCero;
import excepciones.ExcepcionOperacion;
import maquinaPila.Celda;
import maquinaPila.ContadorPrograma;
import maquinaPila.GestorMemoria;
import maquinaPila.Tipo;
import Instrucciones.Instruccion;

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
		
	}
	public String toString(){
		return "Div ";
	}

}
