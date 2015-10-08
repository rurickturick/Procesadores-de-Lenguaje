package asint;

import alex.UnidadLexica;
import alex.AnalizadorLexicoTiny;
import alex.ClaseLexica;
import errors.GestionErroresTiny;
import java.io.IOException;
import java.io.Reader;


public class AnalizadorSintacticoTinyO {
	
	  private UnidadLexica anticipo;
	   private AnalizadorLexicoTiny alex;
	   private GestionErroresTiny errores;
	   
	   public AnalizadorSintacticoTinyO(Reader input) throws IOException 
	   {
	      errores = new GestionErroresTiny();
	      alex = new AnalizadorLexicoTiny(input);
	      alex.fijaGestionErrores(errores);
	      sigToken();
	   }



    
    public void Programa()
    {
    	switch(anticipo.clase())
    	{
    	case INT : case BOOL:
    		Declaraciones();
    		empareja(ClaseLexica.SECCION);
    		Instrucciones();
    		empareja(ClaseLexica.EOF);
    		break;
    	default: errores.errorSintactico(anticipo.fila(),anticipo.clase(),
                ClaseLexica.INT, ClaseLexica.BOOL);
    	}
    }
    
    public void Declaraciones()
    {
    	switch(anticipo.clase())
    	{
    	case INT : case BOOL:
    		Declaracion();
        	ReDeclaraciones();
    		break;
    	default: errores.errorSintactico(anticipo.fila(),anticipo.clase(),
                ClaseLexica.INT, ClaseLexica.BOOL);
    	}
    	
    	
    }
    
    public void Instrucciones()
    {
    	switch(anticipo.clase())
    	{
    	case IDEN:
    		Instruccion();
        	ReInstrucciones();
    		break;
    	default: errores.errorSintactico(anticipo.fila(),anticipo.clase(),
                ClaseLexica.IDEN);
    	}
    }
    
    public void ReInstrucciones()
    {
    	
    	switch(anticipo.clase())
    	{
    	case PYC:
    		empareja(ClaseLexica.PYC);
        	Instruccion();
        	ReInstrucciones();
    		break;
    	case EOF: break;
    	default: errores.errorSintactico(anticipo.fila(),anticipo.clase(),
                ClaseLexica.PYC);
    	}
    }
    
    public void Instruccion()
    {
    	switch(anticipo.clase())
    	{
    	case IDEN:
    		empareja(ClaseLexica.IDEN);
            empareja(ClaseLexica.IGUALASIG);
        	Expresion();
    		break;
    	default: errores.errorSintactico(anticipo.fila(),anticipo.clase(),
                ClaseLexica.IDEN);
    	}

    }
    
    public void ReDeclaraciones()
    {
    	switch(anticipo.clase())
    	{
    	case PYC:
    		empareja(ClaseLexica.PYC);
        	Declaracion();
        	ReDeclaraciones();
    		break;
    	case SECCION: break;
    	default: errores.errorSintactico(anticipo.fila(),anticipo.clase(),
                ClaseLexica.PYC);
    	}
    	//falta implementar el epsilon
    }
    
    public void Declaracion()
    {
    	switch(anticipo.clase())
    	{
    	case INT: case BOOL:
    		Tipo();
        	empareja(ClaseLexica.IDEN);
    		break;
    	default: errores.errorSintactico(anticipo.fila(),anticipo.clase(),
                ClaseLexica.INT, ClaseLexica.BOOL);
    	}
	
    }
    
    private void Tipo()
    {
    	switch(anticipo.clase())
    	{
    		case INT : 
    				 empareja(ClaseLexica.INT);
    				 break;
    		case BOOL:
    				 empareja(ClaseLexica.BOOL);
    				 break;
    				 
    		default: errores.errorSintactico(anticipo.fila(),anticipo.clase(),
                                        ClaseLexica.INT, ClaseLexica.BOOL);
    
    	}
    }
  
   
   private void Expresion()
   {
     switch(anticipo.clase()) {
      case MENOS: case NOT: case ENT: case IDEN: case PAP: case TRUE: case FALSE:
          E1();
          RE0();
          break;
      default:  errores.errorSintactico(anticipo.fila(),anticipo.clase(),
      								   ClaseLexica.MENOS, ClaseLexica.NOT,
                                        ClaseLexica.IDEN,ClaseLexica.ENT,
                                        ClaseLexica.TRUE, ClaseLexica.FALSE,
                                        ClaseLexica.PAP);                                    

      }
   }
   
   
   private void RE0() {
   switch(anticipo.clase()) {
       case MENOR: case MAYOR: case MENORIGUAL: case MAYORIGUAL: case DISTINTO: case IGUALCOMP:  
          Op0();
          E1();
          break;
       case PCIERRE : case EOF : case PYC: break;
       default:
           errores.errorSintactico(anticipo.fila(),anticipo.clase(),
                                   ClaseLexica.MENOR,ClaseLexica.MAYOR,
                                   ClaseLexica.MENORIGUAL,ClaseLexica.MAYORIGUAL,
                                  ClaseLexica.DISTINTO,ClaseLexica.IGUALCOMP);                                              
   } 
  }
  
  
   
   
   private void E1()
   {
     switch(anticipo.clase()) {
      case MENOS: case NOT: case ENT: case IDEN: case PAP: case TRUE: case FALSE:
          E2();
          RE1();
          break;
      default:  errores.errorSintactico(anticipo.fila(),anticipo.clase(),
      							   ClaseLexica.MENOS, ClaseLexica.NOT,
                                     ClaseLexica.IDEN,ClaseLexica.ENT,
                                       ClaseLexica.TRUE, ClaseLexica.PAP,
                                       ClaseLexica.FALSE);                                    

     }
   }
   
   private void RE1() {
   switch(anticipo.clase()) {
       case MAS: case MENOS: case OR:  
          Op1();
          E2();
          RE1();
          break;
 
       case PCIERRE : case EOF : case PYC: break;
       case MENOR: case MAYOR: case MENORIGUAL : case MAYORIGUAL: case DISTINTO: case IGUALCOMP : break;
       default:    
           errores.errorSintactico(anticipo.fila(),anticipo.clase(),
                                   ClaseLexica.MAS,ClaseLexica.MENOS,
                                   ClaseLexica.OR);                                         
   } 
  }
  
 
   
   private void E2()
   {
     switch(anticipo.clase()) {
      case MENOS: case NOT: case ENT: case IDEN: case PAP: case TRUE: case FALSE:
          E3();
          RE2();
          break;
      default:  errores.errorSintactico(anticipo.fila(),anticipo.clase(),
      								   ClaseLexica.MENOS, ClaseLexica.NOT,
                                        ClaseLexica.IDEN,ClaseLexica.ENT,
                                        ClaseLexica.TRUE, ClaseLexica.PAP,
                                        ClaseLexica.FALSE);                                    

   }
   }
   
   //Error aqui, la regla es RE2-> op2 E3 RE2 | epsilon
    private void RE2() {
   switch(anticipo.clase()) {
       case POR: case DIV: case AND: 
          Op2();
          E3();
          RE2(); //Faltaba llamarse a si mismo
          break;
       case PCIERRE : case EOF : case PYC: break;
       case MAS: case MENOS: case OR: break;
       case MENOR: case MAYOR: case MENORIGUAL : case MAYORIGUAL: case DISTINTO: case IGUALCOMP : break;
       default:    
           errores.errorSintactico(anticipo.fila(),anticipo.clase(),
                                   ClaseLexica.POR,ClaseLexica.DIV,
                                   ClaseLexica.AND);                                             
   } 
  }
   //Error aqui, son los cases que estan comentados, porque los directores de E3->op3 E3 | E4
   // Son los primeros de op3 que son menos y not y los prim de E4 que son int,id,(,true,false 
    // Lo curioso es que el tratamiento de errores estaba bien
   private void E3()
   {
     switch(anticipo.clase()) {
      case MENOS: case NOT: 
    	  Op3();
          E3();
          break;
      case ENT: case IDEN: case PAP: case TRUE: case FALSE:
          E4();
          break;
     //  case MAS: case OR: break;
     // case MENOR: case MAYOR: case MENORIGUAL : case MAYORIGUAL: case DISTINTO: case IGUALCOMP : break;
      default:  errores.errorSintactico(anticipo.fila(),anticipo.clase(),
      								   ClaseLexica.MENOS, ClaseLexica.NOT,
                                        ClaseLexica.IDEN,ClaseLexica.ENT,
                                        ClaseLexica.TRUE, ClaseLexica.FALSE,
                                        ClaseLexica.PAP);                                    

    }
   }
   
   
   private void E4() {
   switch(anticipo.clase()) {
       case IDEN: empareja(ClaseLexica.IDEN); break;
       case ENT: empareja(ClaseLexica.ENT); break; 
       case TRUE: empareja(ClaseLexica.TRUE); break;
       case FALSE: empareja(ClaseLexica.FALSE); break;
       case PAP: 
            empareja(ClaseLexica.PAP); 
            Expresion(); 
            empareja(ClaseLexica.PCIERRE); 
            break;
       default:     
           errores.errorSintactico(anticipo.fila(),anticipo.clase(),
                                   ClaseLexica.IDEN,ClaseLexica.ENT,
                                   ClaseLexica.PAP, ClaseLexica.TRUE,
                                   ClaseLexica.FALSE);
   		} 
  
  }
  



  private void Op0()
  {
  		switch(anticipo.clase())
  		{
  			case MENOR : empareja(ClaseLexica.MENOR); break;
  			case MAYOR : empareja(ClaseLexica.MAYOR); break;
  			case MENORIGUAL : empareja(ClaseLexica.MENORIGUAL); sigToken(); break;
  			case MAYORIGUAL : empareja(ClaseLexica.MAYORIGUAL); sigToken();break;
  			case DISTINTO : empareja(ClaseLexica.DISTINTO);sigToken(); break;
  			case IGUALCOMP : empareja(ClaseLexica.IGUALCOMP); sigToken();break;
  			default:
  				errores.errorSintactico(anticipo.fila(),anticipo.clase(),
  										ClaseLexica.MAS,ClaseLexica.MENOS,
  										ClaseLexica.MENORIGUAL, ClaseLexica.MAYORIGUAL,
  										ClaseLexica.DISTINTO, ClaseLexica.IGUALCOMP);
  		}

  }
  

  private void Op1() 
  {
    	switch(anticipo.clase()) 
       {
        	case MAS:   empareja(ClaseLexica.MAS); break;  
        	case MENOS: empareja(ClaseLexica.MENOS); break;
        	case OR:    empareja(ClaseLexica.OR); break;  
        	default:    
             	errores.errorSintactico(anticipo.fila(),anticipo.clase(),
                                     	ClaseLexica.MAS,ClaseLexica.MENOS, ClaseLexica.OR);
    	}  
  }
   
   private void Op2()
   {
   	switch(anticipo.clase())
   	{
   		case POR: empareja(ClaseLexica.POR); break;
   		case DIV: empareja(ClaseLexica.DIV); break;
   		case AND: empareja(ClaseLexica.AND); break;
   		default:
   			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
   									ClaseLexica.POR,ClaseLexica.DIV,ClaseLexica.AND);
   	}
   }
   
   private void Op3()
   {
   	switch(anticipo.clase())
   	{
   		case MENOS: empareja(ClaseLexica.MENOS); break;
   		case NOT: empareja(ClaseLexica.NOT); break;
   		default:
   			errores.errorSintactico(anticipo.fila(), anticipo.clase(),
   									ClaseLexica.MENOS,ClaseLexica.NOT);
   	}
   }
   
   
   
   
  
  private void empareja(ClaseLexica claseEsperada) {
     if (anticipo.clase() == claseEsperada)
         sigToken();
     else errores.errorSintactico(anticipo.fila(),anticipo.clase(),claseEsperada);
  }
  private void sigToken() {
     try {
       anticipo = alex.sigToken();
     }
     catch(IOException e) {
       errores.errorFatal(e);
     }
  }
}
