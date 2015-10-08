package Instrucciones;
import java.util.Stack;

import excepciones.ExcepcionAccesoMemoria;
import excepciones.ExcepcionOperacion;
import maquinaPila.Celda;
import maquinaPila.ContadorPrograma;
import maquinaPila.GestorMemoria;
public interface Instruccion {

	public void ejecutar(Stack<Celda> pilaEvaluacion, GestorMemoria memoria,ContadorPrograma cp) throws ExcepcionOperacion,ExcepcionAccesoMemoria; /*Mirar si se hace así*/
	public String toString();

}
