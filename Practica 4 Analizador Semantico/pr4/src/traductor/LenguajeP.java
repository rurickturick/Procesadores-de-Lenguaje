package traductor;


public class LenguajeP {


	//Instrucciones que tienen un parametro
	public static String IR_A = "Ir_aPARAMETRO\n";
	public static String IR_F = "Ir_fPARAMETRO\n";
	public static String IR_V = "Ir_vPARAMETRO\n";
	public static String APILA_DIR = "Apila_dirPARAMETRO\n";
	public static String DESAPILA_DIR = "Desapila_dirPARAMETRO\n";
	public static String APILA = "ApilaPARAMETRO\n";
	public static String CLONA = "ClonaPARAMETRO\n";
	public static String LIBERA = "LiberaPARAMETRO\n";
	public static String RESERVA = "ReservaPARAMETRO\n";

	
	//Instrucciones que no tienen parametro.
	public static String READ = "Lee\n";
	public static String WRITE = "Escribe\n";
	public static String TRUE = "True";
	public static String FALSE = "False";
	public static String SUMA = "Suma\n";
	public static String RESTA = "Resta\n";
	public static String MUL = "Mul\n";
	public static String DIV = "Div\n";
	public static String MOD = "Mod\n";
	public static String AND = "Y\n";
	public static String OR = "O\n";
	public static String DUP = "Dup\n";
	public static String NOT = "No\n";
	public static String NEG = "Neg\n";
	public static String TOINT = "ToInt\n";
	public static String TODOUBLE = "ToDouble\n";	
	public static String MAYOR = "Mayor\n";
	public static String MAYOR_IGUAL = "Mayoroigual\n";
	public static String MENOR = "Menor\n";
	public static String MENOR_IGUAL = "Menoroigual\n";
	public static String IGUAL = "Igual\n";
	public static String DISTINTO = "Distinto\n";
	public static String IR_IND = "Ir_ind\n";
	public static String DESAPILA = "Desapila\n";
	public static String APILA_IND = "Apila_ind\n";
	public static String DESAPILA_IND = "Desapila_ind\n";
	

	

	public static String generaInicio(int tamDatos, int dirMain){
		return firstProgInst(APILA, tamDatos) +
				instrConParametro(DESAPILA_DIR, 0) +
			   instrConParametro(IR_A, dirMain);
	}
	
	//GENERAMOS EL PROLOGO PARA LOS PROCEDIMIENTOS
	public static String generaPrologo(int nivel, int tamDatos){

		StringBuilder sb = new StringBuilder();
		sb.append(firstProlInstr(APILA_DIR, 0));
		sb.append(instrConParametro(APILA, 2));
		sb.append(SUMA);
		sb.append(instrConParametro(APILA_DIR, nivel));
		sb.append(DESAPILA_IND);
		sb.append(instrConParametro(DESAPILA_DIR, nivel));
		sb.append(instrConParametro(APILA_DIR, 0));
		sb.append(instrConParametro(APILA, tamDatos+2));
		sb.append(SUMA);
		sb.append(lastProlInstr(DESAPILA_DIR, 0));		
		
		return sb.toString();		
	}
	
	

	//GENERAMOS EL CODIGO PARA LOS EPILOGOS DE LOS PROCEDIMIENTOS
	public static String generaEpilogo(int nivel, int tamDatos){
		StringBuilder sb = new StringBuilder();
		
		sb.append(firstEpiInst(APILA_DIR, 0));
		sb.append(instrConParametro(APILA, tamDatos+2));
		sb.append(RESTA);
		sb.append(instrConParametro(DESAPILA_DIR, 0));
		sb.append(instrConParametro(APILA_DIR, 0));
		sb.append(instrConParametro(APILA, 2));
		sb.append(SUMA);
		sb.append(APILA_IND);
		sb.append(instrConParametro(DESAPILA_DIR, nivel));
		sb.append(instrConParametro(APILA_DIR, 0));
		sb.append(instrConParametro(APILA, 1));
		sb.append(SUMA);
		sb.append(APILA_IND);
		sb.append(lastEpiInst());
		
		return sb.toString();		
	}
	

	
	

	//CODIGO REUTILIZABLE PARA LAS PRELLAMAS DE TODOS LOS PROCEDIMIENTOS.
	
	public static String PRELLAMADA_INICIO = 
			firstInstPreCall(APILA_DIR, 0) +
				instrConParametro(APILA, 3) +
				SUMA;	
	
	public static String PRELLAMADA_FINAL =
			instrConParametro(APILA_DIR, 0) +
				instrConParametro(APILA, 1) +
				SUMA;
	
	
	
	//TRATAMIENTO DE LAS DIFERENTES INSTRUCCIONES DE LA MAQUINA PILA.
	
	private static String firstProgInst(String inst, int value) {
		return inst.replace("PARAMETRO", String.valueOf("("+value+")//--------------Generacion Inicio del Programa"));
	}
	
	
	private static String lastProlInstr(String inst, int value) {
		return inst.replace("PARAMETRO", String.valueOf("("+value+")//--------Fin del Prologo"));
	}

	private static String firstProlInstr(String inst, int value) {
		return inst.replace("PARAMETRO", String.valueOf("("+value+")//----------Inicio del Prologo"));
	}
	
	private static String firstEpiInst(String inst, int value) {
		return inst.replace("PARAMETRO", String.valueOf("("+value+")//------------Inicio del Epilogo"));
		
	}
	
	public static String lastEpiInst()
	{
		return "Ir_ind"+"//------------------Fin del Epilogo\n";
	}
	
	

	
	public static String instrConParametro(String inst, boolean parametro){
		return inst.replace("PARAMETRO", String.valueOf("("+parametro+")"));
	}
	
	public static String instrConParametro(String inst, int parametro){
		return inst.replace("PARAMETRO", String.valueOf("("+parametro+")"));
	}
	
	public static String firstInstPreCall(String inst, int value)
	{
		return inst.replace("PARAMETRO", String.valueOf("("+value+")//------------Inicio de Prellamada"));
	}
	
	public static String lastInstrPreCall(String inst, int value)
	{
		return inst.replace("PARAMETRO", String.valueOf("("+value+")//---------------- Fin de Prellamada"));
	}
	
	
	
	public static String instrConParametro(String inst, double parametro){
		return inst.replace("PARAMETRO", String.valueOf("("+parametro+")"));
	}
	
	public static String instrConParametro(String inst, String parametro){
		return inst.replace("PARAMETRO", "("+parametro+")");
	}
	
}
