package recovery;

import parser.*;

public class Follow { //implementa os conjuntos follow p/ alguns n.terminais

    static public final RecoverySet main = new RecoverySet();
    static public final RecoverySet tipo = new RecoverySet();
    static public final RecoverySet declaracaoVariaveis = tipo;
    static public final RecoverySet identificador_variaveis = new RecoverySet();
    static public final RecoverySet atribuicao = new RecoverySet();
    static public final RecoverySet id = new RecoverySet();

    static {
    	main.add(new Integer(BeerCompilerConstants.INICIOPROGRAMA));
    	
    }
}
