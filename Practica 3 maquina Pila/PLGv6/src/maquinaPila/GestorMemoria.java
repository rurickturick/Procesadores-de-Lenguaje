package maquinaPila;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import excepciones.*;



public class GestorMemoria {

	private class HuecoLibre implements Comparable<HuecoLibre>{
		private int dirComienzo;
		private int tama�o;
	
		public HuecoLibre(int add, int size){
			this.dirComienzo = add;
			this.tama�o = size;
	    }
		@Override
		public int compareTo(HuecoLibre	 o) {
			
			if(this.dirComienzo<o.dirComienzo) return -1;
			else if(this.dirComienzo>this.dirComienzo) return 1;
			else return 0;
			
		}
		
	}

		private int tama�oMonton;
		private  Celda[] memoria;
		private int tama�oEstatico;
		private int tama�oMemoria;
		private ArrayList<HuecoLibre> libres;
		
		GestorMemoria(int tama�oMemoria,int tama�oEstatico){
		
		    this.memoria = new Celda[tama�oMemoria];
		    this.tama�oEstatico = tama�oEstatico;
		    this.tama�oMonton = tama�oMemoria-tama�oEstatico;
		    this.tama�oMemoria=tama�oMemoria;
		    this.libres = new ArrayList<HuecoLibre>();
		    //insertamos en la lista de memoria libre toda la memoria.
		    libres.add(new HuecoLibre(tama�oEstatico,tama�oMonton));
		
		
		}

	    public String toString(){

	            String result="[";

	            for (int i=0;i<tama�oMemoria;i++)
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

	        public int malloc(int tama�o) throws ExcepcionMonton{
	        	Iterator<HuecoLibre> it = libres.iterator();
	        	int dirComienzo=-1;
	        	while(it.hasNext()){
	        		HuecoLibre hueco = it.next();
	        		//compruebo si en ese hueco hay espacio suficiente
	        		if(hueco.tama�o>=tama�o){
	        			dirComienzo=hueco.dirComienzo; // la direccion de comienzo ser� la direcci�n de ese hueco encontrado
	        			hueco.dirComienzo+=tama�o; //Incremento la nueva direcci�n de comienzo del hueco
	        			hueco.tama�o -= tama�o; //Decremento el tama�o del bloque libre
	        			Collections.sort(libres);
	        		}
	        	}
	        	if(dirComienzo==-1) throw new ExcepcionMonton("No hay huecos libres");
	        	else return dirComienzo; //retorna la direccion de comienzo del bloque reservado
	          

	       }
	       

	        public void free(int tama�o, int direccion) throws ExcepcionAccesoMemoria{
	        	 //comprobamos que la direccion es valida:
	            if( direccion >= this.tama�oMemoria)
	                throw new ExcepcionAccesoMemoria("Acceso a posicion de memoria no disponible ");

	            else if (direccion < (this.tama�oEstatico))
	                throw new ExcepcionAccesoMemoria("Acceso fuera del area de heap");

	            HuecoLibre hl = new HuecoLibre(direccion,tama�o);
	            Iterator<HuecoLibre> it = this.libres.iterator();
	            while(it.hasNext()){
	            	HuecoLibre hueco = it.next();
	            	if((hueco.dirComienzo<tama�o+direccion) && (hueco.dirComienzo+hueco.tama�o > tama�o+direccion)){
	            		throw new ExcepcionAccesoMemoria("Se esta intentado liberar un hueco ya liberado");
	            	}
	            }
	            //se puede a�adir
	            
	            this.libres.add(hl);
	            Collections.sort(libres);
	            fusionarHuecos();
	            
	        }
	        
	        private void fusionarHuecos(){
	        	
	        	for(int i = 1; i<this.libres.size();i++){
	        		HuecoLibre anterior = this.libres.get(i-1);
	        		HuecoLibre siguiente = this.libres.get(i);
	        		if(anterior.dirComienzo+anterior.tama�o == siguiente.dirComienzo){
	        			this.libres.remove(anterior);
	        			this.libres.remove(siguiente);
	        			this.libres.add(new HuecoLibre(anterior.dirComienzo,siguiente.tama�o+anterior.tama�o));
	        			Collections.sort(this.libres);
	        			i = 0;//Esto solo se hace si solo se fusiona
	        		}
	        		
	        	}	
	        		
	        	
	        	
	        }
	        		

	        }

	  
	    


