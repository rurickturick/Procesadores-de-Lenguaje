package maquinap.Instrucciones.pila;
import maquinap.Instrucciones.Instruccion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.regex.Pattern;

import maquinap.excepciones.ExcepcionOperacion;
import maquinap.maquinaPila.Celda;
import maquinap.maquinaPila.ContadorPrograma;
import maquinap.maquinaPila.GestorMemoria;
import maquinap.maquinaPila.Tipo;

public class Lee implements Instruccion {

	@Override
	public void ejecutar(Stack<Celda> pilaEvaluacion, GestorMemoria memoria,ContadorPrograma cp) throws ExcepcionOperacion {
        try {
        	
        	
        	
        	System.out.println("Escribe el valor:");
			String str = (new BufferedReader(new InputStreamReader(System.in))).readLine();
			String regex = "-?[0-9]+"; 
			Pattern doublePattern = Pattern.compile("-?\\d+(\\.\\d*)?");
			
			if(str.matches(regex)){
				Celda celda = new Celda(new Integer(str),Tipo.INT);
				pilaEvaluacion.push(celda);
			}
			else if(str.matches("true|false")){
				Celda celda = new Celda(new Boolean(str),Tipo.BOOLEAN); //aunque esto no se usara
				pilaEvaluacion.push(celda);
			}
			else if (doublePattern.matcher(str).matches())
			{
				Celda celda = new Celda(new Double(str),Tipo.DOUBLE);
				pilaEvaluacion.push(celda);
			}
			
			else throw new ExcepcionOperacion("Valor erroneo introducido");
		} catch (IOException e) {
			e.printStackTrace();
		}
        

		
	}
	public String toString(){
		return "Lee";
	}
}
