package constructoras;

import java.util.List;
import java.util.Map;

import expresiones.Expresion;
import instrucciones.Bloque;
import instrucciones.Caso;
import instrucciones.DecSubprograma;
import instrucciones.DecTipo;
import instrucciones.DecVariable;
import instrucciones.Designador;
import instrucciones.Instruccion;
import instrucciones.Parametro;
import instrucciones.Programa;
import operadores.OpBinario;
import operadores.OpUnario;
import tipos.Tipo;

public interface IConstructoras {
	
	public void ponNumeroLinea(Object obj, Integer numLinea);
	public Map<Object, Integer> getNumeroLinea();
	
    Programa prog(List<DecTipo> dts, List<DecVariable> dvs, List<DecSubprograma> dss, Bloque b);
    
    Tipo crearBoolean();
    Tipo crearInteger();
    Tipo crearDouble();
    Tipo crearID(String id);
    Tipo crearArray(Tipo tipo, Integer size);
    Tipo crearReg(List<DecTipo> dts);
    Tipo crearPointer(Tipo tipo);
   
    List<DecTipo> HazListaDecTipos(List<DecTipo> dts, DecTipo dt);
    List<DecTipo> HazListaDecTipos(DecTipo dt);
    DecTipo crearDecTipo(String id, Tipo tipo);
    
    List<DecVariable> HazListaDecVariables(List<DecVariable> dvs, DecVariable dv);
    List<DecVariable> HazListaDecVariables(DecVariable dv);
    DecVariable crearDecVariable(String id, Tipo tipo);
    
    List<DecSubprograma> HazListaProcs(List<DecSubprograma> dss, DecSubprograma ds);
    List<DecSubprograma> HazListaProcs(DecSubprograma ds);
    DecSubprograma crearDecSubprograma(String id, List<Parametro> params, Programa subprograma);

    List<Parametro> HazListaParametros(List<Parametro> params, Parametro p);
    List<Parametro> HazListaParametros(Parametro p);

    Parametro HazParametroValor(String id, Tipo tipo);
    Parametro HazParametroVariable(String id, Tipo tipo);

    Instruccion crearAsignacion(Designador ds, Expresion exp);
    Instruccion crearBloque(List<Instruccion> insts);
    Instruccion crearBloqueVacio();
    Instruccion crearIf(List<Caso> casos);
    List<Caso> HazListaCasos(List<Caso> casos, Caso caso);
    List<Caso> HazListaCasos(Caso caso);
    Instruccion HazCaso(Expresion exp, Bloque bloque);
    Instruccion crearBucle(List<Caso> casos);
    Instruccion crearLlamada(String id, List<Expresion> params);
    Instruccion crearLlamada(String id);
    Instruccion crearLee(Designador ds);
    Instruccion crearEscribe(Expresion exp);
    Instruccion crearNuevo(Designador ds);
    Instruccion crearDelete(Designador ds);

    Designador creaDesignador(String id);
    Designador creaDesignador(Designador designador, Expresion exp);  
    Designador creaDesignador(Designador designador, String id);
    Designador creaDesignador(Designador designador);
    
    Expresion creaExpresionBinaria(Expresion exp0, OpBinario op, Expresion exp1);
    Expresion creaExpUnaria(OpUnario op, Expresion exp);

    Expresion creaExpBoolean(boolean val);
    Expresion creaExpInteger(Integer val);
    Expresion creaExpDouble(Double val);
    Expresion creaExpDesig(Designador ds);
    
    OpBinario crearOperadorComp();
    OpBinario crearOpDistinto();
    OpBinario crearOpMenor();
    OpBinario crearOpMayor();
    OpBinario crearOpMenorOIgual();
    OpBinario crearOpMayorOIgual();
    OpBinario crearOpMult();
    OpBinario crearOpDiv();
    OpBinario crearOpMod();
    OpBinario crearOpAnd();
    OpBinario crearOpMas();
    OpBinario crearOpMenos();
    OpBinario crearOpOr();
    
    OpUnario crearOpMenosUna();
    OpUnario crearOpNot();
    OpUnario crearOpToInt();
    OpUnario crearOpToDouble();
	List<DecTipo> HazListaCampos(DecTipo dt);
	List<DecTipo> HazListaCampos(List<DecTipo> dts, DecTipo dt);
	DecTipo HazCampo(String id, Tipo tipo);
	List<Instruccion> HazListaInstrucciones(List<Instruccion> inst, Instruccion i);
	List<Instruccion> HazListaInstrucciones(Instruccion i);
	List<Expresion> HazListaArgumentos(List<Expresion> la, Expresion e);
	List<Expresion> HazListaArgumentos(Expresion e);


}
