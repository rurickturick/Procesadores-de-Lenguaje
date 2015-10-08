package Instrucciones.aritmeticas;
import java.util.Stack;

import excepciones.ExcepcionOperacion;
import maquinaPila.Celda;
import maquinaPila.ContadorPrograma;
import maquinaPila.GestorMemoria;
import maquinaPila.Tipo;
import Instrucciones.Instruccion;

public class Neg implements Instruccion {
	
	@Override
	public void ejecutar(Stack<Celda> pilaEvaluacion, GestorMemoria memoria,ContadorPrograma cp) throws ExcepcionOperacion {
		Celda op1 = pilaEvaluacion.pop();
		if((op1.getTipo()==Tipo.INT)){
			int result = (Integer)op1.getDato();
			result*=-1;//para cambiar de signo
			Celda celda = new Celda(result,Tipo.INT);
			pilaEvaluacion.push(celda);
		}
		else throw new ExcepcionOperacion("Error en la operacion Neg");
		
	}
	public String toString(){
		return "Neg";
	}
}
