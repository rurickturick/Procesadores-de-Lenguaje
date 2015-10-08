package maquinap.Instrucciones.logicas;
import java.util.Stack;

import maquinap.excepciones.ExcepcionOperacion;
import maquinap.maquinaPila.Celda;
import maquinap.maquinaPila.ContadorPrograma;
import maquinap.maquinaPila.GestorMemoria;
import maquinap.maquinaPila.Tipo;
import maquinap.Instrucciones.Instruccion;

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