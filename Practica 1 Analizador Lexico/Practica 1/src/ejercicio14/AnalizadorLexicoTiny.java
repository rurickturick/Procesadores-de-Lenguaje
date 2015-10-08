package ejercicio14;

import java.io.FileInputStream;
import java.io.Reader;
import java.io.InputStreamReader;
import java.io.IOException;



public class AnalizadorLexicoTiny {

   private Reader input;
   private StringBuffer lex;
   private int sigCar;
   private int filaInicio;
   private int columnaInicio;
   private int filaActual;
   private int columnaActual;
   private static String NL = System.getProperty("line.separator");
   
   private static enum Estado {
    INICIO, REC_POR, REC_DIV, REC_PAP, REC_PCIERR, REC_PYC, REC_IGUALAS,REC_IGUALCOMP,
    REC_BOOL,REC_INT,REC_TRUE,REC_FALSE,REC_AND,REC_OR,REC_NOT,REC_SECC,REC_AMPERS,
    REC_MENORIG,REC_MAYORIG,REC_MENOR,REC_MAYOR,REC_DISTIN,REC_0,
    REC_MAS, REC_MENOS, REC_ID, REC_ENT, REC_IDEC, REC_COM, REC_EOF, REC_AMPERS2
   }

   private Estado estado;

   public AnalizadorLexicoTiny(Reader input) throws IOException {
    this.input = input;
    lex = new StringBuffer();
    sigCar = input.read();
    filaActual=1;
    columnaActual=1;
   }
   
   public UnidadLexica sigToken() throws IOException {
     estado = Estado.INICIO;
     filaInicio = filaActual;
     columnaInicio = columnaActual;
     lex.delete(0,lex.length());
     while(true) {
         switch(estado) {
           case INICIO: 
              if(hayLetra())  transita(Estado.REC_ID);
              else if (hayDigitoPos()) transita(Estado.REC_ENT);
              else if (hayCero()) transita(Estado.REC_0);
              else if (haySuma()) transita(Estado.REC_MAS);
              else if (hayResta()) transita(Estado.REC_MENOS);
              else if (hayMul()) transita(Estado.REC_POR);
              else if (hayDiv()) transita(Estado.REC_DIV);
              else if (hayPAp()) transita(Estado.REC_PAP);
              else if (hayPCierre()) transita(Estado.REC_PCIERR);
              else if (hayIgual()) transita(Estado.REC_IGUALAS);
              else if (hayPYC()) transita(Estado.REC_PYC);
              else if (hayAlmohadilla()) transitaIgnorando(Estado.REC_COM);
              else if (haySep()) transitaIgnorando(Estado.INICIO);
              else if (hayEOF()) transita(Estado.REC_EOF);
              else if (hayMayor()) transita(Estado.REC_MAYOR);
              else if (hayMenor()) transita(Estado.REC_MENOR);
              else if (hayExc()) transita (Estado.REC_DISTIN);
              else if (hayAmpers()) transita (Estado.REC_AMPERS);
              else error();
              break;
             
           case REC_ID: 
        	  
              if (hayLetra() || hayDigito() || haySub()) transita(Estado.REC_ID);
              else return unidadId();               
              break;
           case REC_ENT:
               if (hayDigito()) transita(Estado.REC_ENT);

               else return unidadEnt();
               break;
           case REC_0:return unidadEnt();

           case REC_MAYOR:
        	   if(hayIgual()) return unidadMayorIg();
        	   else return unidadMayor();
           case REC_MENOR:
        	   if(hayIgual()) return unidadMenorIg();
        	   else return unidadMenor();
           case REC_DISTIN:
        	   if(hayIgual()) return unidadDistinto();
        	   break;
           case REC_MAS:
               if (hayDigitoPos()) transita(Estado.REC_ENT);
               else if(hayCero()) transita(Estado.REC_0);
               else return unidadMas();
               break;
           case REC_AMPERS:
        	   if (hayAmpers()) transita (Estado.REC_AMPERS2); 
  
           case REC_MENOS: 
               if (hayDigitoPos()) transita(Estado.REC_ENT);
               else if(hayCero()) transita(Estado.REC_0);
               else return unidadMenos();
               break;
           case REC_AMPERS2: return unidadSecc();
           case REC_POR: return unidadPor();
           case REC_DIV: return unidadDiv();              
           case REC_PAP: return unidadPAp();
           case REC_PCIERR: return unidadPCierre();
           case REC_IGUALAS:
        	   if(hayIgual()) return unidadIgualComp();
        	   else  return unidadIgualAs();
           case REC_PYC: return unidadPYC();
           case REC_EOF: return unidadEof();
           case REC_COM: 
               if (hayNL()) transitaIgnorando(Estado.INICIO);
               else if (hayEOF()) transita(Estado.REC_EOF);
               else transitaIgnorando(Estado.REC_COM);
               break;

		default:
			break;
         }
     }    
   }
   private void transita(Estado sig) throws IOException {
     lex.append((char)sigCar);
     sigCar();         
     estado = sig;
   }
   private void transitaIgnorando(Estado sig) throws IOException {
     sigCar();         
     filaInicio = filaActual;
     columnaInicio = columnaActual;
     estado = sig;
   }
   private void sigCar() throws IOException {
     sigCar = input.read();
     if (sigCar == NL.charAt(0)) saltaFinDeLinea();
     if (sigCar == '\n') {
        filaActual++;
        columnaActual=0;
     }
     else {
       columnaActual++;  
     }
   }
   private void saltaFinDeLinea() throws IOException {
      for (int i=1; i < NL.length(); i++) {
          sigCar = input.read();
          if (sigCar != NL.charAt(i)) error();
      }
      sigCar = '\n';
   }
   
   private boolean hayLetra() {return sigCar >= 'a' && sigCar <= 'z' ||
                                      sigCar >= 'A' && sigCar <= 'z';}
   private boolean hayDigitoPos() {return sigCar >= '1' && sigCar <= '9';}
   private boolean hayCero() {return sigCar == '0';}
   private boolean hayDigito() {return hayDigitoPos() || hayCero();}
   private boolean haySuma() {return sigCar == '+';}
   private boolean hayResta() {return sigCar == '-';}
   private boolean hayMul() {return sigCar == '*';}
   private boolean hayDiv() {return sigCar == '/';}
   private boolean hayPAp() {return sigCar == '(';}
   private boolean hayPCierre() {return sigCar == ')';}
   private boolean hayIgual() {return sigCar == '=';}
   private boolean hayPYC() {return sigCar == ';';}

   private boolean hayAlmohadilla() {return sigCar == '#';}
   private boolean haySep() {return sigCar == ' ' || sigCar == '\t' || sigCar=='\n';}
   private boolean hayNL() {return sigCar == '\r' || sigCar == '\b' || sigCar == '\n';}
   private boolean hayEOF() {return sigCar == -1;}
   private boolean hayMayor(){return sigCar == '>';}
   private boolean hayMenor(){return sigCar == '<';}
   private boolean hayAmpers(){return sigCar == '&';}
   private boolean hayExc(){return sigCar == '!';}
   private boolean haySub() {return sigCar == '_';}
   private UnidadLexica unidadId() {
     switch(lex.toString()) {
         case "bool":  
            return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.BOOL);
         case "int":    
            return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.INT);
         case "true":    
             return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.TRUE);
         case "false":    
             return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.FALSE);
         case "and":    
             return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.AND);
         case "or":    
             return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.OR);
         case "not":    
             return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.NOT);
         default:    
            return new UnidadLexicaMultivaluada(filaInicio,columnaInicio,ClaseLexica.IDEN,lex.toString());     
      }
   }  
   private UnidadLexica unidadEnt() {
     return new UnidadLexicaMultivaluada(filaInicio,columnaInicio,ClaseLexica.ENT,lex.toString());     
   }    

   private UnidadLexica unidadMas() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.MAS);     
   }    
   private UnidadLexica unidadMenos() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.MENOS);     
   }    
   private UnidadLexica unidadPor() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.POR);     
   }    
   private UnidadLexica unidadDiv() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.DIV);     
   }    
   private UnidadLexica unidadPAp() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.PAP);     
   }    
   private UnidadLexica unidadPCierre() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.PCIERRE);     
   }    
   private UnidadLexica unidadIgualAs() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.IGUALASIG);     
   }    
   private UnidadLexica unidadIgualComp() {
	     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.IGUALCOMP);     
	   }   
   private UnidadLexica unidadPYC() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.PYC);     
   }    
   private UnidadLexica unidadSecc() {
	     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.SECCION);     
	   } 
   private UnidadLexica unidadMayor() {
	     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.MAYOR);     
	   }    
   private UnidadLexica unidadMenor() {
	     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.MENOR);     
	   }    
   private UnidadLexica unidadDistinto() {
	     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.DISTINTO);     
	   }    
   private UnidadLexica unidadMayorIg() {
	     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.MAYORIGUAL);     
	   }    
   private UnidadLexica unidadMenorIg() {
	     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.MENORIGUAL);     
	   }    
   private UnidadLexica unidadEof() {
     return new UnidadLexicaUnivaluada(filaInicio,columnaInicio,ClaseLexica.EOF);     
   }    
   private void error() {
     System.err.println("("+filaActual+','+columnaActual+"):Caracter inexperado");  
     System.exit(1);
   }

  
}