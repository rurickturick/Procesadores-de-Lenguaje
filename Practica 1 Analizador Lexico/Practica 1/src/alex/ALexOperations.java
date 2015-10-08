package alex;



public class ALexOperations {
  private AnalizadorLexicoTiny alex;
  public ALexOperations(AnalizadorLexicoTiny alex) {
   this.alex = alex;   
  }
  public UnidadLexica unidadId() {
     return new UnidadLexicaMultivaluada(alex.fila(),ClaseLexica.IDEN,
                                         alex.lexema()); 
  } 
 public UnidadLexica unidadEnt() {
	     return new UnidadLexicaMultivaluada(alex.fila(),ClaseLexica.ENT,alex.lexema());     
	   }    
	//   public UnidadLexica unidadReal() {
//	     return new UnidadLexicaMultivaluada(alex.fila(),ClaseLexica.REAL,lex.toString());     
	//   }    
	   public UnidadLexica unidadSuma() {
	     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.MAS);     
	   }    
	   public UnidadLexica unidadResta() {
	     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.MENOS);     
	   }    
	   public UnidadLexica unidadInt() {
		     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.INT);     
		   }    
	   public UnidadLexica unidadBool() {
		     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.BOOL);     
		   }    
	   public UnidadLexica unidadMul() {
	     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.POR);     
	   }    
	   public UnidadLexica unidadDiv() {
	     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.DIV);     
	   }    
	   public UnidadLexica unidadPAp() {
	     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.PAP);     
	   }    
	   public UnidadLexica unidadPCierre() {
	     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.PCIERRE);     
	   }    
	   public UnidadLexica unidadIgualAsig() {
	     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.IGUALASIG);     
	   }    
	   public UnidadLexica unidadComp() {
		     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.IGUALCOMP);     
		   }   
	   public UnidadLexica unidadPYC() {
	     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.PYC);     
	   }    
	   public UnidadLexica unidadSeccion() {
		     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.SECCION);     
		   } 
	   public UnidadLexica unidadMayor() {
		     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.MAYOR);     
		   }    
	   public UnidadLexica unidadMenor() {
		     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.MENOR);     
		   }    
	   public UnidadLexica unidadDistinto() {
		     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.DISTINTO);     
		   }    
	   public UnidadLexica unidadMayorIg() {
		     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.MAYORIGUAL);     
		   }    
	   public UnidadLexica unidadMenorIg() {
		     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.MENORIGUAL);     
		   }    
	   public UnidadLexica unidadEof() {
	     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.EOF);     
	   }    
	   public UnidadLexica unidadOr() {
		     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.OR);     
		   }   
	   public UnidadLexica unidadAnd() {
		     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.AND);     
		   }  
	   public UnidadLexica unidadNot() {
		     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.NOT);     
		   }  
	   public UnidadLexica unidadTrue() {
		     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.TRUE);     
		   }  
	   public UnidadLexica unidadFalse() {
		     return new UnidadLexicaUnivaluada(alex.fila(),ClaseLexica.FALSE);     
		   }  
	   public void error() {
	     System.err.println("("+alex.fila()+"):Caracter inexperado");  
	     System.exit(1);
	   }

}
