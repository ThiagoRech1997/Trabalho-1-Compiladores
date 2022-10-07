# BeerCompiler
Autores: Eduardo Gasparin, Mateus Pauli e Thiago Rech

Este projeto de compilador foi desenvolvido para o primeiro bimestre da disciplina de Construção de Compiladores.

## Forma de Backus-Naur da linguagem desenvolvida

```
<principal> ::= <INICIOPROGRAMA> <INICIOBLOCO> (<comandos>)* <FIMBLOCO> <FIMPROGRAMA>
<INICIOPROGRAMA> ::= "geladeiraAberta"
<FIMPROGRAMA> ::= "geladeiraVazia" 		
<comandos> ::= <declaracaoVariavel>
	|  <condicional>  
	|  <repeticao>
	|  <funcao>
	|  <operacao>
	|  <expressao>
<condicional> ::= <IF> <PARESQ> <expressao> <PARDIR> <INICIOBLOCO> (<bool> | <declaracaoVariavel> | <repeticao>)* <FIMBLOCO>(<ELSE><INICIOBLOCO> (<declaracaoVariavel> | <repeticao>)* <FIMBLOCO>)?
<repeticao> ::= (<FOR> <PARESQ> ((<ID> <ATRIBUICAO> <numero> <PONTOVIRGULA> ) (<ID> (<MENOR>|<MAIOR>|<MENOR_IGUAL>|<MAIOR_IGUAL>) <numero> <PONTOVIRGULA>)(<ID> (<INCREMENTO>|<DECREMENTO>))) <PARDIR> (<INICIOBLOCO>(<comandos>)* <FIMBLOCO>)?) 
  | (<WHILE> <PARESQ> (<expressao>)? <PARDIR> <INICIOBLOCO> (<comandos>)*<FIMBLOCO>)
<funcao> ::= <FUNC> <PARESQ> ((<ID> |<dado>) (<SEPARADOR> (<ID> | <dado>))+) <PARDIR> <PONTOVIRGULA>
<declaracaoVariavel> ::= <tipoDado> <ID> (<ATRIBUICAO> ( <CARACTERE>| <numero> ) )? (<SEPARADOR> <ID> (<ATRIBUICAO> ( <CARACTERE>| <numero>))?)* <PONTOVIRGULA>
<expressao> ::= ((<numero> | <ID>) (<OPERADOR_LOGICO> | <OPERADOR_ARITMETICO> ) (<numero> | <ID>))
<operacao> ::= (<ID>) ( <ATRIBUICAO> ) (<ID>|<numero>) <PONTOVIRGULA>
  | <ID> <ATRIBUICAO> ( <ID> | <numero>) <OPERADOR_ARITMETICO> ( <ID> | <numero>)<PONTOVIRGULA>
  | <ID> <ATRIBUICAO> <PARESQ> 	( <ID> | <numero>) <OPERADOR_ARITMETICO> ( <ID> | <numero>) <PARDIR> <PONTOVIRGULA>
<tipoDado> ::= <REAL> | <INTEIRO> | <LETRA> | <STRING> | <BOOLEAN>
<bool> ::= <TRUE> | <FALSE>
<dado> ::= <numero> | <string> | <bool>

<string> ::= (<ISTRING>)(<CARACTERE> | <DIGITO>)*(<ISTRING>)
<numero> ::= (<DIGITO>)+ (<CASADECIMAL> (<DIGITO>)+ )?
<ID> ::= "breja_"(<CARACTERE>|<DIGITO>)+					
<INICIOBLOCO> ::= "{" 
<FIMBLOCO> ::= "}"
<PONTOVIRGULA> ::= ";" 			
<INTEIRO> ::= "pilsen" 			
<REAL> ::= 	"malzbier" 			
<BOOLEAN> ::= "lager" 			
<LETRA> ::= "ipa" 				
<STRING> ::= "helles"				
<ATRIBUICAO> ::= "=" 			
<SEPARADOR> ::= "," 			
<IF> ::= "garrafa" 				 
<ELSE> ::=	"lata" 				
<FOR> ::= "rodizio" 				
<FUNC> ::= "chop_"(<CARACTERE>|<DIGITO>)*		
<WHILE> ::= "rodada"		
<DIGITO> ::=	["0"-"9"] 			
<CARACTERE> ::= (["A"-"Z"] | ["a"-"z"]) 			
<INTERRUPCAO> ::= "chegaPorHoje"		
<TRUE> ::= "cervejaGelada" 			 
<FALSE> ::=	"cervejaQuente" 		 
<PARESQ> ::= "(" 				
<ISTRING> ::= "'" 				
<PARDIR> ::= ")" 				
<CASADECIMAL> ::= "." 			 
<OPERADOR_LOGICO> ::= ">" | "<" | "<=" | ">=" | "<>" | "==" | "&" | "|" | "++" | "--"
<OPERADOR_ARITMETICO> ::= "+" | "-" | "*" | "/" 
```
