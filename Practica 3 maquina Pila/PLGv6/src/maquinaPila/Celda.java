package maquinaPila;


public class Celda {


    private Object data;
    private Tipo tipo;

    public Celda(Object data, Tipo tipo) {
        this.data=data;
        this.tipo =tipo;
    }
    
    public int boolToInt(){
    	if(this.tipo == Tipo.BOOLEAN){
    		if((Boolean)data == true){
    			return 1;
    		}
    		else{
    			return 0;
    		}
    	}
    	return -1;
    }
    
    public Tipo getTipo(){
    	return this.tipo;
    }
    public Object getDato(){
    	return this.data;
    }

    @Override
    public String toString(){
        return "( " + data.toString() +" )";

    }
    
    public Celda clona(){
    	return new Celda(this.data,this.tipo);
    }


}