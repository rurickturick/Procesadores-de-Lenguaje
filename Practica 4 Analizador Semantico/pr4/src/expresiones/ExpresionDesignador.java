package expresiones;

import instrucciones.Designador;



public class ExpresionDesignador extends Expresion {

    private Designador valor;


    public ExpresionDesignador(Designador ds) {
    	super(TipoExpresion.DESIGNADOR);
		this.valor = ds;
	}


    public Designador getValor() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.valor;
    }


    public void setValor(Designador value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.valor = value;
    }

}
