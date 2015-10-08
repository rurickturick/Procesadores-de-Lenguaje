package maquinap.Instrucciones;
import java.util.Stack;

import maquinap.excepciones.ExcepcionAccesoMemoria;
import maquinap.excepciones.ExcepcionOperacion;
import maquinap.maquinaPila.Celda;
import maquinap.maquinaPila.ContadorPrograma;
import maquinap.maquinaPila.GestorMemoria;
public interface Instruccion {

	public void ejecutar(Stack<Celda> pilaEvaluacion, GestorMemoria memoria,ContadorPrograma cp) throws ExcepcionOperacion,ExcepcionAccesoMemoria; /*Mirar si se hace así*/
	public String toString();

}
