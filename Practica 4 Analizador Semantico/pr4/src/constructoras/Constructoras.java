package constructoras;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import expresiones.Expresion;
import expresiones.ExpresionBinaria;
import expresiones.ExpresionBoolean;
import expresiones.ExpresionDesignador;
import expresiones.ExpresionDouble;
import expresiones.ExpresionInteger;
import expresiones.ExpresionUnaria;
import instrucciones.Asignacion;
import instrucciones.Bloque;
import instrucciones.Bucle;
import instrucciones.Caso;
import instrucciones.Condicional;
import instrucciones.DecSubprograma;
import instrucciones.DecTipo;
import instrucciones.DecVariable;
import instrucciones.Delete;
import instrucciones.Designador;
import instrucciones.Instruccion;
import instrucciones.Llamada;
import instrucciones.New;
import instrucciones.Parametro;
import instrucciones.Programa;
import instrucciones.Read;
import instrucciones.Write;
import operadores.OpBinario;
import operadores.OpUnario;
import operadores.TipoOperador;
import tipos.Tipo;
import tipos.TipoArray;
import tipos.TipoBool;
import tipos.TipoDouble;
import tipos.TipoEntero;
import tipos.TipoID;
import tipos.TipoPuntero;
import tipos.TipoStruct;


public class Constructoras implements IConstructoras {
	
	private Map<Object, Integer> numeroLinea;
	
	public Constructoras() {
		numeroLinea = new HashMap<Object, Integer>();
	}

	public void ponNumeroLinea(Object obj, Integer numLinea){
		numeroLinea.put(obj, numLinea);
	}
	
	@Override
	public Programa prog(List<DecTipo> dts, List<DecVariable> dvs,
			List<DecSubprograma> dss, Bloque b) {
		return new Programa(dts, dvs, dss, b);
	}

	@Override
	public Tipo crearBoolean() {
		return new TipoBool();
	}

	@Override
	public Tipo crearInteger() {
		return new TipoEntero();
	}

	@Override
	public Tipo crearDouble() {
		return new TipoDouble();
	}

	@Override
	public Tipo crearID(String id) {
		return new TipoID(id);
	}

	@Override
	public Tipo crearArray(Tipo tipo, Integer size) {
		return new TipoArray(size, tipo);
	}

	@Override
	public Tipo crearReg(List<DecTipo> dts) {
		return new TipoStruct(dts);
	}

	@Override
	public Tipo crearPointer(Tipo tipo) {
		return new TipoPuntero(tipo);
	}

	@Override
	public List<DecTipo> HazListaDecTipos(List<DecTipo> dts, DecTipo dt) {
		dts.add(dt);
		return dts;
	}

	@Override
	public List<DecTipo> HazListaDecTipos(DecTipo dt) {
		List<DecTipo> dts = new ArrayList<DecTipo>();
		dts.add(dt);
		return dts;
	}
	
	public List<DecTipo> HazListaCampos(List<DecTipo> dts, DecTipo dt) {
		dts.add(dt);
		return dts;
	}

	@Override
	public List<DecTipo> HazListaCampos(DecTipo dt) {
		List<DecTipo> dts = new ArrayList<DecTipo>();
		dts.add(dt);
		return dts;
	}

	
	
	@Override
	public DecTipo HazCampo(String id, Tipo tipo) {
		return new DecTipo(id, tipo);
	}

	


	@Override
	public DecTipo crearDecTipo(String id, Tipo tipo) {
		return new DecTipo(id, tipo);
	}

	@Override
	public List<DecVariable> HazListaDecVariables(List<DecVariable> dvs,
			DecVariable dv) {
		dvs.add(dv);
		return dvs;
	}

	@Override
	public List<DecVariable> HazListaDecVariables(DecVariable dv) {
		List<DecVariable> dts = new ArrayList<DecVariable>();
		dts.add(dv);
		return dts;
	}

	@Override
	public DecVariable crearDecVariable(String id, Tipo tipo) {
		return new DecVariable(id, tipo);
	}

	@Override
	public List<DecSubprograma> HazListaProcs(
			List<DecSubprograma> dss, DecSubprograma ds) {
		dss.add(ds);
		return dss;
	}

	@Override
	public List<DecSubprograma> HazListaProcs(DecSubprograma ds) {
		List<DecSubprograma> dts = new ArrayList<DecSubprograma>();
		dts.add(ds);
		return dts;
	}

	@Override
	public DecSubprograma crearDecSubprograma(String id, List<Parametro> params,
			Programa subprograma) {
		return new DecSubprograma(id, params, subprograma);
	}

	@Override
	public List<Parametro> HazListaParametros(List<Parametro> params,
			Parametro p) {
		params.add(p);
		return params;
	}

	@Override
	public List<Parametro> HazListaParametros(Parametro p) {
		List<Parametro> dts = new ArrayList<Parametro>();
		dts.add(p);
		return dts;
	}

	@Override
	public Parametro HazParametroValor(String id, Tipo tipo) {
		return new Parametro(true, id, tipo);
	}

	@Override
	public Parametro HazParametroVariable(String id, Tipo tipo) {
		return new Parametro(false, id, tipo);
	}

	@Override
	public Instruccion crearAsignacion(Designador ds, Expresion exp) {
		return new Asignacion(ds, exp);
	}

	@Override
	public Instruccion crearBloque(List<Instruccion> insts) {
		return new Bloque(insts);
	}

	@Override
	public Instruccion crearBloqueVacio() {
		return new Bloque(new ArrayList<Instruccion>());
	}

	@Override
	public Instruccion crearIf(List<Caso> casos) {
		return new Condicional(casos);
	}

	@Override
	public List<Caso> HazListaCasos(List<Caso> casos, Caso caso) {
		casos.add(caso);
		return casos;
	}

	@Override
	public List<Caso> HazListaCasos(Caso caso) {
		List<Caso> casos = new ArrayList<Caso>();
		casos.add(caso);
		return casos;
	}

	@Override
	public Caso HazCaso(Expresion exp, Bloque bloque) {
		return new Caso(exp, bloque);
	}

	@Override
	public Instruccion crearBucle(List<Caso> casos) {
		return new Bucle(casos);
	}

	@Override
	public Instruccion crearLlamada(String id,
			List<Expresion> params) {
		return new Llamada(id, params);
	}

	@Override
	public Instruccion crearLlamada(String id) {
		return new Llamada(id);
	}

	@Override
	public Instruccion crearLee(Designador ds) {
		return new Read(ds);
	}

	@Override
	public Instruccion crearEscribe(Expresion exp) {
		return new Write(exp);
	}

	@Override
	public Instruccion crearNuevo(Designador ds) {
		return new New(ds);
	}

	@Override
	public Instruccion crearDelete(Designador ds) {
		return new Delete(ds);
	}

	@Override
	public Expresion creaExpresionBinaria(Expresion exp0, OpBinario op, Expresion exp1) {
		return new ExpresionBinaria(exp0, op, exp1);
	}

	@Override
	public Expresion creaExpUnaria(OpUnario op, Expresion exp) {
		return new ExpresionUnaria(op, exp);
	}

	@Override
	public Expresion creaExpBoolean(boolean val) {
		return new ExpresionBoolean(val);
	}

	@Override
	public Expresion creaExpInteger(Integer val) {
		return new ExpresionInteger(val);
	}

	@Override
	public Expresion creaExpDouble(Double val) {
		return new ExpresionDouble(val);
	}

	@Override
	public Expresion creaExpDesig(Designador ds) {
		return new ExpresionDesignador(ds);
	}

	@Override
	public OpBinario crearOperadorComp() {
		return new OpBinario(TipoOperador.IGUAL);
	}

	@Override
	public OpBinario crearOpDistinto() {
		return new OpBinario(TipoOperador.DISTINTO);
	}

	@Override
	public OpBinario crearOpMenor() {
		return new OpBinario(TipoOperador.MENOR);
	}

	@Override
	public OpBinario crearOpMayor() {
		return new OpBinario(TipoOperador.MAYOR);
	}

	@Override
	public OpBinario crearOpMenorOIgual() {
		return new OpBinario(TipoOperador.MAYOROIGUAL);
	}

	@Override
	public OpBinario crearOpMayorOIgual() {
		return new OpBinario(TipoOperador.MAYOROIGUAL);
	}

	@Override
	public OpBinario crearOpMult() {
		return new OpBinario(TipoOperador.POR);
	}

	@Override
	public OpBinario crearOpDiv() {
		return new OpBinario(TipoOperador.DIV);
	}

	@Override
	public OpBinario crearOpMod() {
		return new OpBinario(TipoOperador.MOD);
	}

	@Override
	public OpBinario crearOpAnd() {
		return new OpBinario(TipoOperador.AND);
	}

	@Override
	public OpBinario crearOpMas() {
		return new OpBinario(TipoOperador.MAS);
	}

	@Override
	public OpBinario crearOpMenos() {
		return new OpBinario(TipoOperador.MENOS);
	}

	@Override
	public OpBinario crearOpOr() {
		return new OpBinario(TipoOperador.OR);
	}

	@Override
	public OpUnario crearOpMenosUna() {
		return new OpUnario(TipoOperador.MENOS);
	}

	@Override
	public OpUnario crearOpNot() {
		return new OpUnario(TipoOperador.NOT);
	}

	@Override
	public OpUnario crearOpToInt() {
		return new OpUnario(TipoOperador.TOINT);
	}

	@Override
	public OpUnario crearOpToDouble() {
		return new OpUnario(TipoOperador.TODOUBLE);
	}

	@Override
	public Designador creaDesignador(String id) {
		return new Designador(id);
	}

	@Override
	public Designador creaDesignador(Designador designador, Expresion exp) {
		return new Designador(designador, exp);
	}

	@Override
	public Designador creaDesignador(Designador designador, String id) {
		Designador d = new Designador(designador, id);
		return d;
	}

	@Override
	public Designador creaDesignador(Designador designador) {
		return new Designador(designador);
	}

	@Override
	public Map<Object, Integer> getNumeroLinea() {
		return numeroLinea;
	}

	@Override
	public List<Instruccion> HazListaInstrucciones(List<Instruccion> inst,
			Instruccion i) {
		
		inst.add(i);
		return inst;
		
	}

	@Override
	public List<Instruccion> HazListaInstrucciones(Instruccion i) {
		List<Instruccion> lista = new ArrayList<Instruccion>();
		lista.add(i);
		return lista;
	}

	@Override
	public List<Expresion> HazListaArgumentos(List<Expresion> la, Expresion e) {
	   la.add(e);
	   return la;
	}

	@Override
	public List<Expresion> HazListaArgumentos(Expresion e) {
		List<Expresion> lista = new ArrayList<Expresion>();
		lista.add(e);
		return lista;
	}



}
