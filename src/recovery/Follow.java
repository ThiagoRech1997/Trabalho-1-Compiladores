package recovery;

import parser.*;

public class Follow { //implementa os conjuntos follow p/ os n.terminais

	static public final RecoverySet main = new RecoverySet();
	
	static public final RecoverySet comandos = new RecoverySet();
	static public final RecoverySet declaracaoVariavel = comandos;
	static public final RecoverySet condicional = comandos; 
	static public final RecoverySet repeticao = comandos;
	static public final RecoverySet funcao = comandos;
	static public final RecoverySet operacao = comandos;
	
	static public final RecoverySet expressao = new RecoverySet();
	static public final RecoverySet tipoDado = new RecoverySet();
	
	static public final RecoverySet dado = new RecoverySet();
	static public final RecoverySet numero = dado;
	static public final RecoverySet string = dado;
	static public final RecoverySet booleano = dado;

    static {
    	
    	/* CONJUNTO DOS FOLLOWS 
    	 
    	 	main = EOF
			comandos = first(fimBloco, comandos)
			declaracaoVariavel = follow(comandos)
			condicional =  follow(comandos)
			repeticao = follow(comandos)
			funcao = follow(comandos)
			operacao = follow(comandos)
			expressao = first(pontoVirgula, pardir)
			tipoDado = first(id) 
			dado = first(separador, pardir, operadorLogico, operadorAritmetico, pontoVirgula), follow(expressao)
			numero = follow(dado) 
			string = follow(dado) 
			booleano = follow(dado) 
			
			REALIZANDO AS SUBSTITUIÇÕES
			
			main = EOF
			
				comandos = FIMBLOCO, first(declaracaoVariavel,condicional, repeticao,funcao,operacao)
				comandos = FIMBLOCO, first(tipoDado,condicionalIf, repFor, repWhile,func,id)
				comandos = FIMBLOCO, first(tipoInteiro,tipoReal,tipoChar, tipoString,tipoBooleano, IF, FOR, WHILE, FUNC, ID)
			Comandos = FIMBLOCO, INTEIRO, REAL, CHAR, STRING, BOOLEAN, IF, FOR, WHILE, FUNC, ID
			     
			declaracaoVariavel = FIMBLOCO, INTEIRO, REAL, CHAR, STRING, BOOLEAN, IF, FOR, WHILE, FUNC, ID
			condicional =  FIMBLOCO, INTEIRO, REAL, CHAR, STRING, BOOLEAN, IF, FOR, WHILE, FUNC, ID
			repeticao = FIMBLOCO, INTEIRO, REAL, CHAR, STRING, BOOLEAN, IF, FOR, WHILE, FUNC, ID
			funcao = FIMBLOCO, INTEIRO, REAL, CHAR, STRING, BOOLEAN, IF, FOR, WHILE, FUNC, ID
			operacao = FIMBLOCO, INTEIRO, REAL, CHAR, STRING, BOOLEAN, IF, FOR, WHILE, FUNC, ID
			
			expressao = PONTOVIRGULA, PARDIR
			
			tipoDado = ID
			dado = SEPARADOR, PARDIR, OPERADOR_LOGICO, OPERADOR_ARITMETICO, PONTOVIRGULA
			numero = SEPARADOR, PARDIR, OPERADOR_LOGICO, OPERADOR_ARITMETICO, PONTOVIRGULA
			string = SEPARADOR, PARDIR, OPERADOR_LOGICO, OPERADOR_ARITMETICO, PONTOVIRGULA 
			booleano = SEPARADOR, PARDIR, OPERADOR_LOGICO, OPERADOR_ARITMETICO, PONTOVIRGULA
    	 
    	 */
    	
    	main.add(new Integer(BeerCompilerConstants.EOF));

    	comandos.add(new Integer(BeerCompilerConstants.FIMBLOCO));
    	comandos.add(new Integer(BeerCompilerConstants.INTEIRO));
    	comandos.add(new Integer(BeerCompilerConstants.REAL));
    	comandos.add(new Integer(BeerCompilerConstants.CHAR));
    	comandos.add(new Integer(BeerCompilerConstants.STRING));
    	comandos.add(new Integer(BeerCompilerConstants.BOOLEAN));
    	comandos.add(new Integer(BeerCompilerConstants.IF));
    	comandos.add(new Integer(BeerCompilerConstants.FOR));
    	comandos.add(new Integer(BeerCompilerConstants.WHILE));
    	comandos.add(new Integer(BeerCompilerConstants.FUNC));
    	comandos.add(new Integer(BeerCompilerConstants.ID));

    	expressao.add(new Integer(BeerCompilerConstants.PONTOVIRGULA));
    	expressao.add(new Integer(BeerCompilerConstants.PARDIR));

    	tipoDado.add(new Integer(BeerCompilerConstants.ID));

    	dado.add(new Integer(BeerCompilerConstants.SEPARADOR));
    	dado.add(new Integer(BeerCompilerConstants.PARDIR));
    	dado.add(new Integer(BeerCompilerConstants.OPERADOR_LOGICO));
    	dado.add(new Integer(BeerCompilerConstants.OPERADOR_ARITMETICO));
    	dado.add(new Integer(BeerCompilerConstants.PONTOVIRGULA));
    }
}
