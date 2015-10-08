package alex;

import errors.GestionErroresTiny;

%%
%cup
%line
%class AnalizadorLexicoTiny
%type  UnidadLexica
%unicode

%{
  private ALexOperations ops;
  private GestionErroresTiny errores;
  public String lexema() {return yytext();}
  public int fila() {return yyline+1;}
  public void fijaGestionErrores(GestionErroresTiny errores) {
  this.errores = errores;
  }
%}

%eofval{
  return ops.unidadEof();
%eofval}

%init{
  ops = new ALexOperations(this);
%init}


int = int
bool = bool
and = and
not = not
or = or
true = true
false = false
letra  = ([A-Z]|[a-z])
digitoPositivo = [1-9]
digito = ({digitoPositivo}|0)
parteEntera = {digitoPositivo}{digito}*

separador = [ \t\r\b\n]
comentario = #[^\n]* 
subrayado = \_
identificador = {letra}({letra}|{digito}|{subrayado})*
numeroEntero = [\+,\-]?({parteEntera}|0)
operadorSuma = \+
operadorResta = \-
operadorMultiplicacion = \*
operadorDivision = /
parentesisApertura = \(
parentesisCierre = \)
igualAsig = \=
distinto = \!
pyc  = \;
operadorMayor = >
operadorMenor = <
operadorDistinto = {distinto}{igualAsig}
operadorMayorIg = {operadorMayor}{igualAsig}
operadorMenorIg = {operadorMenor}{igualAsig}
operadorComparacion = {igualAsig}{igualAsig}


seccion = &&
%%
{separador}               {}
{comentario}              {}
{int}                     {return ops.unidadInt();}
{bool}                    {return ops.unidadBool();}
{and}             	  {return ops.unidadAnd();}
{or}              	  {return ops.unidadOr();}
{not}             	  {return ops.unidadNot();}
{true}                    {return ops.unidadTrue();}
{false}                   {return ops.unidadFalse();}
{identificador}           {return ops.unidadId();}
{pyc}                     {return ops.unidadPYC();}
{numeroEntero}            {return ops.unidadEnt();}
{operadorSuma}            {return ops.unidadSuma();}
{operadorResta}           {return ops.unidadResta();}
{operadorMultiplicacion}  {return ops.unidadMul();}
{operadorDivision}        {return ops.unidadDiv();}
{parentesisApertura}      {return ops.unidadPAp();}
{parentesisCierre}        {return ops.unidadPCierre();} 
{igualAsig}               {return ops.unidadIgualAsig();} 
{operadorComparacion}     {return ops.unidadComp ();}
{operadorMayor}           {return ops.unidadMayor();}
{operadorMenor}           {return ops.unidadMenor();}
{operadorMayorIg}         {return ops.unidadMayorIg();}
{operadorMenorIg}         {return ops.unidadMenorIg();}
{operadorDistinto}        {return ops.unidadDistinto();}


{seccion}		  {return ops.unidadSeccion();}	
[^]                       {errores.errorLexico(fila(),lexema());}  

 