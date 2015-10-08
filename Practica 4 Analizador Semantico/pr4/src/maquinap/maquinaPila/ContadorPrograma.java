package maquinap.maquinaPila;

public class ContadorPrograma {
	
	private int cp;
	
	public ContadorPrograma(){
		this.cp=0;
	}
	
	public int getContadorPrograma(){
		return this.cp;
	}
	
	public void setContadorPrograma(int cp){
		this.cp=cp-1; //porque al ejecutar las instrucciones de salto, en el main se incrementa el cp
	}
	public void incrementarCP(){
		this.cp=this.cp+1;
	}

}
