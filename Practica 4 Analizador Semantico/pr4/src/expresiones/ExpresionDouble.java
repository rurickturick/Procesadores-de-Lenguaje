package expresiones;



public class ExpresionDouble extends Expresion {

    private double valor;


    public ExpresionDouble(Double val) {
    	super(TipoExpresion.DOUBLE);
		this.valor = val;
	}


    public double getValor() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.valor;
    }


    public void setValor(double value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.valor = value;
    }

}
