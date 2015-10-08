package maquinap.maquinaPila;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import maquinap.Instrucciones.Instruccion;
import maquinap.Instrucciones.control.*;
import maquinap.Instrucciones.logicas.*;
import maquinap.Instrucciones.pila.*;
import maquinap.Instrucciones.aritmeticas.*;



public class Parser {
	
	private ArrayList<Instruccion> instrucciones;
	private BufferedReader fichero;
	
	public Parser(ArrayList<Instruccion> instrucciones){
		
		this.instrucciones=instrucciones;
		
	}
	
	
	public void leeFichero(String ruta){
	
			FileReader fr;
			try {
				fr = new FileReader(ruta);
				this.fichero = new BufferedReader(fr);
				String linea = null;
				try {
					while ((linea = this.fichero.readLine())!=null) {
						String [] comentarios = linea.split("//");
						String [] cadenas = comentarios[0].split("\\(");
						if(cadenas.length==2){ //tiene parametros
						String [] cadenas1 = cadenas[1].split("\\)");
						
						switch(cadenas[0]){
							case "Apila_dir" : this.instrucciones.add(new ApilaDir(new Integer(cadenas1[0]))); break;
							case "Desapila_dir" : this.instrucciones.add(new DesapilaDir(new Integer(cadenas1[0]))); break;
							case "Clona" : this.instrucciones.add(new Clona(new Integer(cadenas1[0]))); break;
							case "Libera" : this.instrucciones.add(new Libera(new Integer(cadenas1[0]))); break;
							case "Reserva" : this.instrucciones.add(new Reserva(new Integer(cadenas1[0]))); break;
							case "Ir_a" : this.instrucciones.add(new Ir(new Integer(cadenas1[0]))); break;
							case "Ir_v" : this.instrucciones.add(new IrV(new Integer(cadenas1[0]))); break;
							case "Ir_f" : this.instrucciones.add(new IrF(new Integer(cadenas1[0]))); break;
							case "Apila" : this.instrucciones.add(new Apila(new String(cadenas1[0]))); break;								
							default :  System.out.println("Error Lectura"); break;
							
						
						}
						
						
						
						}
						else if(cadenas.length==1){ // no tiene parametros
							switch(cadenas[0]){
								case "Ir_ind" : this.instrucciones.add(new IrInd()); break;
								case "Desapila" : this.instrucciones.add(new Desapila()); break;
								case "Apila_ind" : this.instrucciones.add(new ApilaInd()); break;
								case "Desapila_ind" : this.instrucciones.add(new DesapilaInd()); break;
								case "Suma" : this.instrucciones.add(new Suma()); break;
								case "Dup" : this.instrucciones.add(new Dup()); break;
								case "Resta": this.instrucciones.add(new Resta()); break;
								case "Mul" : this.instrucciones.add(new Mul()); break;
								case "Div" : this.instrucciones.add(new Div()); break;
								case "Mod" : this.instrucciones.add(new Mod()); break;
								case "Neg" : this.instrucciones.add(new Neg()); break;
								case "No" : this.instrucciones.add(new No()); break;
								case "Y" : this.instrucciones.add(new Y()); break;
								case "O" : this.instrucciones.add(new O()); break;
								case "Igual" : this.instrucciones.add(new Igual()); break;
								case "Menor" : this.instrucciones.add(new Menor()); break;
								case "Distinto" : this.instrucciones.add(new Distinto()); break;
								case "Mayor" : this.instrucciones.add(new Mayor()); break;
								case "Mayoroigual" : this.instrucciones.add(new MayorOIgual()); break;
								case "Menoroigual" : this.instrucciones.add(new MenorOIgual()); break;
								case "Escribe" : this.instrucciones.add(new Escribe()); break;
								case "Lee" : this.instrucciones.add(new Lee()); break;
								
								default : System.out.println("Error Lectura"); break;
						
						}
							
						}
						else System.err.println("Error de lectura");
						
						
						
						}
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
		
	}

}


 