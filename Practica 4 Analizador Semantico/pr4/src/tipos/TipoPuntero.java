package tipos;



public class TipoPuntero extends Tipo {

    private Tipo tipo;

    public TipoPuntero(Tipo tipo) {
    	super(Tipos.POINTER);
		this.tipo = tipo;
	}
    
    public Tipo getTipoPuntero() {
		return tipo;
	}


    public void setTipo(Tipo value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.tipo = value;
    }

}
