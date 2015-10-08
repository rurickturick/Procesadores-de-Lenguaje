package maquinap.Instrucciones.pila;

import maquinap.Instrucciones.Instruccion;

import java.util.Stack;
import java.util.regex.Pattern;

import maquinap.excepciones.ExcepcionOperacion;
import maquinap.maquinaPila.*;

public class Apila implements Instruccion {
	
	//Para saber si un String es un double
	private static Pattern doublePattern = Pattern.compile("-?\\d+(\\.\\d*)?");
	//Para saber si un String es un int
	private static Pattern intPattern = Pattern.compile("-?\\d+");
	private String dato;
	
	public Apila(String dato){
		this.dato=dato;
	}
	
	@Override
	public void ejecutar(Stack<Celda> pilaEvaluacion,GestorMemoria memoria,ContadorPrograma cp) {
		try{
			if(this.dato.equals("true") || this.dato.equals("false")){
				Celda celda = new Celda(new Boolean(dato),Tipo.BOOLEAN);
				pilaEvaluacion.push(celda) ;
			}
			 else if(this.dato.equals("null")) {
				 Celda celda = new Celda(new String(dato),Tipo.NULL);
				 pilaEvaluacion.push(celda) ;
				
			}
			 else if (intPattern.matcher(this.dato).matches())
			 {
				 Celda celda = new Celda(new Integer(dato),Tipo.INT);
				 pilaEvaluacion.push(celda) ;
			 }
			 else if (doublePattern.matcher(this.dato).matches())
			 {
				 Celda celda = new Celda(new Double(dato),Tipo.DOUBLE);
				 pilaEvaluacion.push(celda) ; 
			 }
			 
			 else throw new ExcepcionOperacion("Error en la operacion Apila");
			
         }
			catch(Exception ex){
             System.out.println(ex.getMessage());
         }
		
		}
	public String toString(){
		return "Apila "+dato;
	}

}
