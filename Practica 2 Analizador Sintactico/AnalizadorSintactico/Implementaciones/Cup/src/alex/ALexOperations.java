package alex;

import asint.ClaseSimbolos;



public class ALexOperations {
  private AnalizadorLexicoTiny alex;
  public ALexOperations(AnalizadorLexicoTiny alex) {
   this.alex = alex;   
  }
  public UnidadLexica unidadId() {
     return new UnidadLexica(alex.fila(),ClaseSimbolos.IDEN,
                                         alex.lexema()); 
  } 
 public UnidadLexica unidadEnt() {
	     return new UnidadLexica(alex.fila(),ClaseSimbolos.ENT,alex.lexema());     
	   }    
	//   public UnidadLexica unidadReal() {
//	     return new UnidadLexicaMultivaluada(alex.fila(),ClaseLexica.REAL,lex.toString());     
	//   }    
	   public UnidadLexica unidadSuma() {
	     return new UnidadLexica(alex.fila(),ClaseSimbolos.MAS,"+");     
	   }    
	   public UnidadLexica unidadResta() {
	     return new UnidadLexica(alex.fila(),ClaseSimbolos.MENOS,"-");     
	   }    
	   public UnidadLexica unidadInt() {
		     return new UnidadLexica(alex.fila(),ClaseSimbolos.INT,"int");     
		   }    
	   public UnidadLexica unidadBool() {
		     return new UnidadLexica(alex.fila(),ClaseSimbolos.BOOL,"bool");     
		   }    
	   public UnidadLexica unidadMul() {
	     return new UnidadLexica(alex.fila(),ClaseSimbolos.POR,"*");     
	   }    
	   public UnidadLexica unidadDiv() {
	     return new UnidadLexica(alex.fila(),ClaseSimbolos.DIV,"/");     
	   }    
	   public UnidadLexica unidadPAp() {
	     return new UnidadLexica(alex.fila(),ClaseSimbolos.PAP,"(");     
	   }    
	   public UnidadLexica unidadPCierre() {
	     return new UnidadLexica(alex.fila(),ClaseSimbolos.PCIERRE,")");     
	   }    
	   public UnidadLexica unidadIgualAsig() {
	     return new UnidadLexica(alex.fila(),ClaseSimbolos.IGUALASIG,"=");     
	   }    
	   public UnidadLexica unidadComp() {
		     return new UnidadLexica(alex.fila(),ClaseSimbolos.IGUALCOMP,"==");     
		   }   
	   public UnidadLexica unidadPYC() {
	     return new UnidadLexica(alex.fila(),ClaseSimbolos.PYC,";");     
	   }    
	   public UnidadLexica unidadSeccion() {
		     return new UnidadLexica(alex.fila(),ClaseSimbolos.SECCION,"&&");     
		   } 
	   public UnidadLexica unidadMayor() {
		     return new UnidadLexica(alex.fila(),ClaseSimbolos.MAYOR,">");     
		   }    
	   public UnidadLexica unidadMenor() {
		     return new UnidadLexica(alex.fila(),ClaseSimbolos.MENOR,"<");     
		   }    
	   public UnidadLexica unidadDistinto() {
		     return new UnidadLexica(alex.fila(),ClaseSimbolos.DISTINTO,"!=");     
		   }    
	   public UnidadLexica unidadMayorIg() {
		     return new UnidadLexica(alex.fila(),ClaseSimbolos.MAYORIGUAL,">=");     
		   }    
	   public UnidadLexica unidadMenorIg() {
		     return new UnidadLexica(alex.fila(),ClaseSimbolos.MENORIGUAL,"<=");     
		   }    
	   public UnidadLexica unidadAnd() {
		     return new UnidadLexica(alex.fila(),ClaseSimbolos.AND,"and");     
		   }    
	   public UnidadLexica unidadOr() {
		     return new UnidadLexica(alex.fila(),ClaseSimbolos.OR,"or");     
		   }    
	   public UnidadLexica unidadNot() {
		     return new UnidadLexica(alex.fila(),ClaseSimbolos.NOT,"not");     
		   } 
	   public UnidadLexica unidadTrue() {
		     return new UnidadLexica(alex.fila(),ClaseSimbolos.TRUE,"true");     
		   }    
	   public UnidadLexica unidadFalse() {
		     return new UnidadLexica(alex.fila(),ClaseSimbolos.FALSE,"false");     
		   }    
	   public UnidadLexica unidadEof() {
	     return new UnidadLexica(alex.fila(),ClaseSimbolos.EOF,"<EOF>");     
	   }    
	  
	   public void error() {
	     System.err.println("("+alex.fila()+"):Caracter inexperado");  
	     System.exit(1);
	   }

}
