package alex;

%%
%line
%class AnalizadorLexicoTiny
%type  UnidadLexica
%unicode

%{
  private ALexOperations ops;
  public String lexema() {return yytext();}
  public int fila() {return yyline+1;}
%}

%eofval{
  return ops.unidadEof();
%eofval}

%init{
  ops = new ALexOperations(this);
%init}

letra  = ([A-Z]|[a-z])
digitoPositivo = [1-9]
digito = ({digitoPositivo}|0)
parteEntera = {digitoPositivo}{digito}*

separador = [ \t\r\b\n]
comentario = #[^\n]* 
int = int
bool = bool
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
operadorAnd = and
operadorNot = not
operadorOr = or
true = true
false = false
seccion = &&
%%
{separador}               {}
{comentario}              {}
{int}                     {return ops.unidadInt();}
{bool}                    {return ops.unidadBool();}
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
{true}                    {return ops.unidadTrue();}
{false}                   {return ops.unidadFalse();}
{operadorAnd}             {return ops.unidadAnd();}
{operadorOr}              {return ops.unidadOr();}
{operadorNot}             {return ops.unidadNot();}
{seccion}		          {return ops.unidadSeccion();}	
{identificador}           {return ops.unidadId();}
[^]                       {ops.error();} 

 