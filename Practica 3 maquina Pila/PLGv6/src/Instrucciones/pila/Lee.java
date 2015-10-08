package Instrucciones.pila;
import Instrucciones.Instruccion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

import excepciones.ExcepcionOperacion;
import maquinaPila.Celda;
import maquinaPila.ContadorPrograma;
import maquinaPila.GestorMemoria;
import maquinaPila.Tipo;

public class Lee implements Instruccion {

	@Override
	public void ejecutar(Stack<Celda> pilaEvaluacion, GestorMemoria memoria,ContadorPrograma cp) throws ExcepcionOperacion {
        try {
        	//ojo si no reconoce nada, no apila nada y debería devolver error
        	//mirar que tipo de excepcion lanza
        	System.out.println("Escribe el valor:");
			String str = (new BufferedReader(new InputStreamReader(System.in))).readLine();
			String regex = "-?[0-9]+"; 
			if(str.matches(regex)){
				Celda celda = new Celda(new Integer(str),Tipo.INT);
				pilaEvaluacion.push(celda);
			}
			else
			if(str.matches("true|false")){
				Celda celda = new Celda(new Boolean(str),Tipo.BOOLEAN); //aunque esto no se usara
				pilaEvaluacion.push(celda);
			}
			else throw new ExcepcionOperacion("Valor erroneo introducido");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        

		
	}
	public String toString(){
		return "Lee";
	}
}
