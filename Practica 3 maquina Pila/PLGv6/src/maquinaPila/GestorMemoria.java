package maquinaPila;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import excepciones.*;



public class GestorMemoria {

	private class HuecoLibre implements Comparable<HuecoLibre>{
		private int dirComienzo;
		private int tamaño;
	
		public HuecoLibre(int add, int size){
			this.dirComienzo = add;
			this.tamaño = size;
	    }
		@Override
		public int compareTo(HuecoLibre	 o) {
			
			if(this.dirComienzo<o.dirComienzo) return -1;
			else if(this.dirComienzo>this.dirComienzo) return 1;
			else return 0;
			
		}
		
	}

		private int tamañoMonton;
		private  Celda[] memoria;
		private int tamañoEstatico;
		private int tamañoMemoria;
		private ArrayList<HuecoLibre> libres;
		
		GestorMemoria(int tamañoMemoria,int tamañoEstatico){
		
		    this.memoria = new Celda[tamañoMemoria];
		    this.tamañoEstatico = tamañoEstatico;
		    this.tamañoMonton = tamañoMemoria-tamañoEstatico;
		    this.tamañoMemoria=tamañoMemoria;
		    this.libres = new ArrayList<HuecoLibre>();
		    //insertamos en la lista de memoria libre toda la memoria.
		    libres.add(new HuecoLibre(tamañoEstatico,tamañoMonton));
		
		
		}

	    public String toString(){

	            String result="[";

	            for (int i=0;i<tamañoMemoria;i++)
	                if(memoria[i]!=null)
	                    result+="{"+i+" = "+memoria[i].getDato()+" }";
	            result+="]";
	            return result;

	        }

	        public Celda get(int pos) throws ExcepcionAccesoMemoria{
	        	try{
	            return memoria[pos];
	        	}
	        	catch (Exception e){
	        		throw new ExcepcionAccesoMemoria("Error en el get");
	        	}
	        }
	        
	        public void put(int pos, Celda dato) throws ExcepcionAccesoMemoria{
	        	try{
	            memoria[pos]=dato;
	        	}
	        	catch (Exception e){
	        		throw new ExcepcionAccesoMemoria("Error en el put");
	        	}
	        }

	        public int malloc(int tamaño) throws ExcepcionMonton{
	        	Iterator<HuecoLibre> it = libres.iterator();
	        	int dirComienzo=-1;
	        	while(it.hasNext()){
	        		HuecoLibre hueco = it.next();
	        		//compruebo si en ese hueco hay espacio suficiente
	        		if(hueco.tamaño>=tamaño){
	        			dirComienzo=hueco.dirComienzo; // la direccion de comienzo será la dirección de ese hueco encontrado
	        			hueco.dirComienzo+=tamaño; //Incremento la nueva dirección de comienzo del hueco
	        			hueco.tamaño -= tamaño; //Decremento el tamaño del bloque libre
	        			Collections.sort(libres);
	        		}
	        	}
	        	if(dirComienzo==-1) throw new ExcepcionMonton("No hay huecos libres");
	        	else return dirComienzo; //retorna la direccion de comienzo del bloque reservado
	          

	       }
	       

	        public void free(int tamaño, int direccion) throws ExcepcionAccesoMemoria{
	        	 //comprobamos que la direccion es valida:
	            if( direccion >= this.tamañoMemoria)
	                throw new ExcepcionAccesoMemoria("Acceso a posicion de memoria no disponible ");

	            else if (direccion < (this.tamañoEstatico))
	                throw new ExcepcionAccesoMemoria("Acceso fuera del area de heap");

	            HuecoLibre hl = new HuecoLibre(direccion,tamaño);
	            Iterator<HuecoLibre> it = this.libres.iterator();
	            while(it.hasNext()){
	            	HuecoLibre hueco = it.next();
	            	if((hueco.dirComienzo<tamaño+direccion) && (hueco.dirComienzo+hueco.tamaño > tamaño+direccion)){
	            		throw new ExcepcionAccesoMemoria("Se esta intentado liberar un hueco ya liberado");
	            	}
	            }
	            //se puede añadir
	            
	            this.libres.add(hl);
	            Collections.sort(libres);
	            fusionarHuecos();
	            
	        }
	        
	        private void fusionarHuecos(){
	        	
	        	for(int i = 1; i<this.libres.size();i++){
	        		HuecoLibre anterior = this.libres.get(i-1);
	        		HuecoLibre siguiente = this.libres.get(i);
	        		if(anterior.dirComienzo+anterior.tamaño == siguiente.dirComienzo){
	        			this.libres.remove(anterior);
	        			this.libres.remove(siguiente);
	        			this.libres.add(new HuecoLibre(anterior.dirComienzo,siguiente.tamaño+anterior.tamaño));
	        			Collections.sort(this.libres);
	        			i = 0;//Esto solo se hace si solo se fusiona
	        		}
	        		
	        	}	
	        		
	        	
	        	
	        }
	        		

	        }

	  
	    


