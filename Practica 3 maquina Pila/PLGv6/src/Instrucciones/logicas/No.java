package Instrucciones.logicas;
import java.util.Stack;

import excepciones.ExcepcionOperacion;
import maquinaPila.Celda;
import maquinaPila.ContadorPrograma;
import maquinaPila.GestorMemoria;
import maquinaPila.Tipo;
import Instrucciones.Instruccion;

public class No implements Instruccion {
	
	@Override
	public void ejecutar(Stack<Celda> pilaEvaluacion, GestorMemoria memoria,ContadorPrograma cp) throws ExcepcionOperacion {
		Celda op1 = pilaEvaluacion.pop();
		if((op1.getTipo()==Tipo.BOOLEAN)){
			boolean result = (Boolean)op1.getDato();
			result= !result;//para cambiar de signo
			Celda celda = new Celda(result,Tipo.BOOLEAN);
			pilaEvaluacion.push(celda);
		}
		else throw new ExcepcionOperacion("Error en la operacion NO");
		
	}
	public String toString(){
		return "No";
	}
}