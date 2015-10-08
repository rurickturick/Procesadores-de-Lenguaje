package Instrucciones.pila;

import Instrucciones.Instruccion;

import java.util.Stack;

import maquinaPila.Celda;
import maquinaPila.ContadorPrograma;
import maquinaPila.GestorMemoria;
import maquinaPila.Tipo;

public class Apila implements Instruccion {
	
	
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
			 else{
				 Celda celda = new Celda(new Integer(dato),Tipo.INT);
				 pilaEvaluacion.push(celda) ;
			 }
			
         }
			catch(Exception ex){
             System.out.println(ex.getMessage());
         }
		
		}
	public String toString(){
		return "Apila "+dato;
	}

}
