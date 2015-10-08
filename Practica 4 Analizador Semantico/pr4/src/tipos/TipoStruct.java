package tipos;
import java.util.List;

import instrucciones.DecTipo;



public class TipoStruct extends Tipo {

    private List<DecTipo> tipos;

    public TipoStruct(List<DecTipo> tipos) {
		super(Tipos.STRUCT);
		this.tipos = tipos;
	}

    
    public List<DecTipo> getTipos() {
		return tipos;
	}

}
