package Instrucciones.logicas;
import java.util.Stack;

import excepciones.ExcepcionOperacion;
import maquinaPila.Celda;
import maquinaPila.ContadorPrograma;
import maquinaPila.GestorMemoria;
import maquinaPila.Tipo;
import Instrucciones.Instruccion;

public class Igual implements Instruccion {
	
	@Override
	public void ejecutar(Stack<Celda> pilaEvaluacion, GestorMemoria memoria,ContadorPrograma cp) throws ExcepcionOperacion {
		Celda op2 = pilaEvaluacion.pop();
		Celda op1 = pilaEvaluacion.pop();
		if((op1.getTipo()==Tipo.BOOLEAN) && op2.getTipo()==Tipo.BOOLEAN){
			boolean result = op1.getDato().equals(op2.getDato());
			Celda celda = new Celda(result,Tipo.BOOLEAN);
			pilaEvaluacion.push(celda);
		}
		else if((op1.getTipo()==Tipo.INT) && op2.getTipo()==Tipo.INT){
			boolean result = op1.getDato().equals(op2.getDato());
			Celda celda = new Celda(result,Tipo.BOOLEAN);
			pilaEvaluacion.push(celda);
		}
		else if((op1.getTipo()==Tipo.INT) && op2.getTipo()==Tipo.NULL){
			Celda celda = new Celda(false,Tipo.BOOLEAN);
			pilaEvaluacion.push(celda);

			
		}
		else if((op1.getTipo()==Tipo.NULL) && op2.getTipo()==Tipo.INT){
			Celda celda = new Celda(false,Tipo.BOOLEAN);
			pilaEvaluacion.push(celda);	
		}
		else if((op1.getTipo()==Tipo.NULL) && op2.getTipo()==Tipo.NULL){
			Celda celda = new Celda(true,Tipo.BOOLEAN);
			pilaEvaluacion.push(celda);

			
		}
		else throw new ExcepcionOperacion("Error en la operacion Igual");
		
	}
	public String toString(){
		return "Igual";
	}
}
