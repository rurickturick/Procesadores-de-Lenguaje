package instrucciones;
import expresiones.Expresion;



public class Write extends Instruccion {

	private Expresion expresion;
	
    public Write(Expresion exp) {
    	super(TiposInstruccion.WRITE);
		this.expresion = exp;
	}

	public Expresion getExpresion() {
		return expresion;
	}

	public void setExpresion(Expresion expresion) {
		this.expresion = expresion;
	}

    

}
