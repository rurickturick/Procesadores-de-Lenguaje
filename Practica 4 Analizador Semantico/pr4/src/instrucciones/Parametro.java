package instrucciones;
import tipos.Tipo;



public class Parametro {

    private boolean porValor;
    private String identificador;
    private Tipo tipo;


    public Parametro(boolean valor, String id, Tipo tipo2) {
		this.porValor = valor;
		this.identificador = id;
		this.tipo = tipo2;
	}


	public boolean isPorValor() {
		return porValor;
	}


	public void setPorValor(boolean porValor) {
		this.porValor = porValor;
	}


	public String getIdentificador() {
		return identificador;
	}


	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}


	public Tipo getTipo() {
		return tipo;
	}


	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

    
	

}
