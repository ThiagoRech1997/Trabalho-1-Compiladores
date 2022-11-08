/* Generated By:JJTree&JavaCC: Do not edit this line. BeerCompiler.java */
package parser;
import recovery.*;

public class BeerCompiler/*@bgen(jjtree)*/implements BeerCompilerTreeConstants, BeerCompilerConstants {/*@bgen(jjtree)*/
  protected static JJTBeerCompilerState jjtree = new JJTBeerCompilerState();public static void main(String args []) throws ParseException
  {
    BeerCompiler parser = new BeerCompiler(System.in);
    System.out.println("A cervejaria esta aberta!");
    while (true)
    {
      System.out.println("Vamos beber:");
      try
      {
        parser.main();
      }
      catch (Exception e)
      {
        System.out.println("\u005cn");
        System.out.println(e.getMessage());
        BeerCompiler.ReInit(System.in);
      }
      catch (Error e)
      {
        System.out.println("Parando de beber...");
        System.out.println(e.getMessage());
        break;
      }
    }
  }

  static public String im(int x)
  {
    int k;
        String s;
    s = tokenImage[x];
    k = s.lastIndexOf("\u005c"");
    try {
      s = s.substring(1,k);
    }
   catch (StringIndexOutOfBoundsException e)
           {}
   return s;
  }

  static Token lastError = null;
  static boolean eof;    // variável que indica se EOF foi alcançado

  // o método abaixo consome tokens até alcançar um que pertença ao conjunto
  // de sincronização
  static void consumeUntil(RecoverySet g,
                         ParseException e,
                         String met) throws ParseEOFException,
                                            ParseException
  {
        Token tok;
        System.out.println();
        System.out.println("*** " + met + " ***");
        System.out.println("     Conjunto de sincroniza\u00e7\u00e3o: " + g);

        if (g == null) throw e; // se o conjunto é null, propaga a exceção 

        tok = getToken(1); // pega token corrente
        while ( ! eof ) { // se não chegou ao fim do arquivo
          if ( g.contains(tok.kind)) {//achou um token no conjunto
            System.out.println("     Encontrado token de sincroniza\u00e7\u00e3o: " +
                               im(tok.kind));
            break;
          }
          System.out.println("     Ignorando o token: " + im(tok.kind));
          getNextToken();     // pega próximo token       
      tok = getToken(1);
          if (tok.kind == EOF && ! g.contains(EOF) ) // fim da entrada?   
              eof = true;
        }
    if ( tok != lastError)  {
          System.out.println(e.getMessage());
          lastError = tok;

        }
        if ( eof )
          throw new ParseEOFException("Encontrei EOF onde n\u00e3o deveria.");
  }

  static final public void main() throws ParseException {
 /*@bgen(jjtree) main */
  SimpleNode jjtn000 = new SimpleNode(JJTMAIN);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(INICIOPROGRAMA);
      jj_consume_token(INICIOBLOCO);
      label_1:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case INTEIRO:
        case REAL:
        case BOOLEAN:
        case CHAR:
        case STRING:
        case IF:
        case FOR:
        case WHILE:
        case FUNC:
        case ID:
          ;
          break;
        default:
          jj_la1[0] = jj_gen;
          break label_1;
        }
        comandos();
      }
      jj_consume_token(FIMBLOCO);
      jj_consume_token(FIMPROGRAMA);
    } catch (Throwable jjte000) {
  if (jjtc000) {
    jjtree.clearNodeScope(jjtn000);
    jjtc000 = false;
  } else {
    jjtree.popNode();
  }
  if (jjte000 instanceof RuntimeException) {
    {if (true) throw (RuntimeException)jjte000;}
  }
  if (jjte000 instanceof ParseException) {
    {if (true) throw (ParseException)jjte000;}
  }
  {if (true) throw (Error)jjte000;}
    } finally {
  if (jjtc000) {
    jjtree.closeNodeScope(jjtn000, true);
  }
    }
  }

  static final public void comandos() throws ParseException {
 /*@bgen(jjtree) comandos */
  SimpleNode jjtn000 = new SimpleNode(JJTCOMANDOS);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INTEIRO:
      case REAL:
      case BOOLEAN:
      case CHAR:
      case STRING:
        declaracaoVariavel();
        break;
      case IF:
        condicional();
        break;
      case FOR:
      case WHILE:
        repeticao();
        break;
      case FUNC:
        funcao();
        break;
      case ID:
        operacao();
        break;
      default:
        jj_la1[1] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } catch (Throwable jjte000) {
          if (jjtc000) {
            jjtree.clearNodeScope(jjtn000);
            jjtc000 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte000 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte000;}
          }
          if (jjte000 instanceof ParseException) {
            {if (true) throw (ParseException)jjte000;}
          }
          {if (true) throw (Error)jjte000;}
    } finally {
          if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
          }
    }
  }

  static final public void condicional() throws ParseException {
 /*@bgen(jjtree) condicional */
  SimpleNode jjtn000 = new SimpleNode(JJTCONDICIONAL);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(IF);
      jj_consume_token(PARESQ);
      expressao();
      jj_consume_token(PARDIR);
      jj_consume_token(INICIOBLOCO);
      label_2:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case INTEIRO:
        case REAL:
        case BOOLEAN:
        case CHAR:
        case STRING:
        case IF:
        case FOR:
        case WHILE:
        case FUNC:
        case ID:
          ;
          break;
        default:
          jj_la1[2] = jj_gen;
          break label_2;
        }
        comandos();
      }
      jj_consume_token(FIMBLOCO);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ELSE:
        jj_consume_token(ELSE);
        jj_consume_token(INICIOBLOCO);
        label_3:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case INTEIRO:
          case REAL:
          case BOOLEAN:
          case CHAR:
          case STRING:
          case IF:
          case FOR:
          case WHILE:
          case FUNC:
          case ID:
            ;
            break;
          default:
            jj_la1[3] = jj_gen;
            break label_3;
          }
          comandos();
        }
        jj_consume_token(FIMBLOCO);
        break;
      default:
        jj_la1[4] = jj_gen;
        ;
      }
    } catch (Throwable jjte000) {
          if (jjtc000) {
            jjtree.clearNodeScope(jjtn000);
            jjtc000 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte000 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte000;}
          }
          if (jjte000 instanceof ParseException) {
            {if (true) throw (ParseException)jjte000;}
          }
          {if (true) throw (Error)jjte000;}
    } finally {
          if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
          }
    }
  }

  static final public void repeticao() throws ParseException {
 /*@bgen(jjtree) repeticao */
  SimpleNode jjtn000 = new SimpleNode(JJTREPETICAO);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case FOR:
        jj_consume_token(FOR);
        jj_consume_token(PARESQ);
        jj_consume_token(ID);
        label_4:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case ATRIBUICAO:
            ;
            break;
          default:
            jj_la1[5] = jj_gen;
            break label_4;
          }
          jj_consume_token(ATRIBUICAO);
          jj_consume_token(DIGITO);
          label_5:
          while (true) {
            switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
            case DIGITO:
              ;
              break;
            default:
              jj_la1[6] = jj_gen;
              break label_5;
            }
            jj_consume_token(DIGITO);
          }
        }
        jj_consume_token(PONTOVIRGULA);
        jj_consume_token(ID);
        jj_consume_token(OPERADOR_LOGICO);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case ID:
          jj_consume_token(ID);
          break;
        case DIGITO:
          jj_consume_token(DIGITO);
          label_6:
          while (true) {
            switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
            case DIGITO:
              ;
              break;
            default:
              jj_la1[7] = jj_gen;
              break label_6;
            }
            jj_consume_token(DIGITO);
          }
          break;
        default:
          jj_la1[8] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        jj_consume_token(PONTOVIRGULA);
        jj_consume_token(ID);
        jj_consume_token(ATRIBUICAO);
        jj_consume_token(ID);
        jj_consume_token(OPERADOR_ARITMETICO);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case ID:
          jj_consume_token(ID);
          break;
        case DIGITO:
          jj_consume_token(DIGITO);
          label_7:
          while (true) {
            switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
            case DIGITO:
              ;
              break;
            default:
              jj_la1[9] = jj_gen;
              break label_7;
            }
            jj_consume_token(DIGITO);
          }
          break;
        default:
          jj_la1[10] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        jj_consume_token(PARDIR);
        jj_consume_token(INICIOBLOCO);
        label_8:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case INTEIRO:
          case REAL:
          case BOOLEAN:
          case CHAR:
          case STRING:
          case IF:
          case FOR:
          case WHILE:
          case FUNC:
          case ID:
            ;
            break;
          default:
            jj_la1[11] = jj_gen;
            break label_8;
          }
          comandos();
        }
        jj_consume_token(FIMBLOCO);
        break;
      case WHILE:
        jj_consume_token(WHILE);
        jj_consume_token(PARESQ);
        expressao();
        jj_consume_token(PARDIR);
        jj_consume_token(INICIOBLOCO);
        label_9:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case INTEIRO:
          case REAL:
          case BOOLEAN:
          case CHAR:
          case STRING:
          case IF:
          case FOR:
          case WHILE:
          case FUNC:
          case ID:
            ;
            break;
          default:
            jj_la1[12] = jj_gen;
            break label_9;
          }
          comandos();
        }
        jj_consume_token(FIMBLOCO);
        break;
      default:
        jj_la1[13] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } catch (Throwable jjte000) {
          if (jjtc000) {
            jjtree.clearNodeScope(jjtn000);
            jjtc000 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte000 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte000;}
          }
          if (jjte000 instanceof ParseException) {
            {if (true) throw (ParseException)jjte000;}
          }
          {if (true) throw (Error)jjte000;}
    } finally {
          if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
          }
    }
  }

  static final public void funcao() throws ParseException {
 /*@bgen(jjtree) funcao */
  SimpleNode jjtn000 = new SimpleNode(JJTFUNCAO);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(FUNC);
      jj_consume_token(PARESQ);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ID:
        jj_consume_token(ID);
        break;
      case ISTRING:
      case VERDADEIRO:
      case FALSO:
      case DIGITO:
        dado();
        break;
      default:
        jj_la1[14] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      label_10:
      while (true) {
        jj_consume_token(SEPARADOR);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case ID:
          jj_consume_token(ID);
          break;
        case ISTRING:
        case VERDADEIRO:
        case FALSO:
        case DIGITO:
          dado();
          break;
        default:
          jj_la1[15] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case SEPARADOR:
          ;
          break;
        default:
          jj_la1[16] = jj_gen;
          break label_10;
        }
      }
      jj_consume_token(PARDIR);
      jj_consume_token(PONTOVIRGULA);
    } catch (Throwable jjte000) {
          if (jjtc000) {
            jjtree.clearNodeScope(jjtn000);
            jjtc000 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte000 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte000;}
          }
          if (jjte000 instanceof ParseException) {
            {if (true) throw (ParseException)jjte000;}
          }
          {if (true) throw (Error)jjte000;}
    } finally {
          if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
          }
    }
  }

  static final public void operacao() throws ParseException {
 /*@bgen(jjtree) operacao */
  SimpleNode jjtn000 = new SimpleNode(JJTOPERACAO);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(ID);
      jj_consume_token(ATRIBUICAO);
      expressao();
      jj_consume_token(PONTOVIRGULA);
    } catch (Throwable jjte000) {
          if (jjtc000) {
            jjtree.clearNodeScope(jjtn000);
            jjtc000 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte000 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte000;}
          }
          if (jjte000 instanceof ParseException) {
            {if (true) throw (ParseException)jjte000;}
          }
          {if (true) throw (Error)jjte000;}
    } finally {
          if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
          }
    }
  }

  static final public void expressao() throws ParseException {
 /*@bgen(jjtree) expressao */
  SimpleNode jjtn000 = new SimpleNode(JJTEXPRESSAO);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ISTRING:
      case VERDADEIRO:
      case FALSO:
      case ID:
      case DIGITO:
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case ID:
          jj_consume_token(ID);
          break;
        case ISTRING:
        case VERDADEIRO:
        case FALSO:
        case DIGITO:
          dado();
          break;
        default:
          jj_la1[17] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        label_11:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case OPERADOR_ARITMETICO:
          case OPERADOR_LOGICO:
            ;
            break;
          default:
            jj_la1[18] = jj_gen;
            break label_11;
          }
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case OPERADOR_LOGICO:
            jj_consume_token(OPERADOR_LOGICO);
            break;
          case OPERADOR_ARITMETICO:
            jj_consume_token(OPERADOR_ARITMETICO);
            break;
          default:
            jj_la1[19] = jj_gen;
            jj_consume_token(-1);
            throw new ParseException();
          }
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case ID:
            jj_consume_token(ID);
            break;
          case ISTRING:
          case VERDADEIRO:
          case FALSO:
          case DIGITO:
            dado();
            break;
          default:
            jj_la1[20] = jj_gen;
            jj_consume_token(-1);
            throw new ParseException();
          }
        }
        break;
      case PARESQ:
        jj_consume_token(PARESQ);
        expressao();
        jj_consume_token(PARDIR);
        break;
      default:
        jj_la1[21] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } catch (Throwable jjte000) {
          if (jjtc000) {
            jjtree.clearNodeScope(jjtn000);
            jjtc000 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte000 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte000;}
          }
          if (jjte000 instanceof ParseException) {
            {if (true) throw (ParseException)jjte000;}
          }
          {if (true) throw (Error)jjte000;}
    } finally {
          if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
          }
    }
  }

  static final public void declaracaoVariavel() throws ParseException {
 /*@bgen(jjtree) declaracaoVariavel */
  SimpleNode jjtn000 = new SimpleNode(JJTDECLARACAOVARIAVEL);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      tipoDado();
      jj_consume_token(ID);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case ATRIBUICAO:
        jj_consume_token(ATRIBUICAO);
        dado();
        break;
      default:
        jj_la1[22] = jj_gen;
        ;
      }
      label_12:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case SEPARADOR:
          ;
          break;
        default:
          jj_la1[23] = jj_gen;
          break label_12;
        }
        jj_consume_token(SEPARADOR);
        jj_consume_token(ATRIBUICAO);
        dado();
      }
      jj_consume_token(PONTOVIRGULA);
    } catch (Throwable jjte000) {
          if (jjtc000) {
            jjtree.clearNodeScope(jjtn000);
            jjtc000 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte000 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte000;}
          }
          if (jjte000 instanceof ParseException) {
            {if (true) throw (ParseException)jjte000;}
          }
          {if (true) throw (Error)jjte000;}
    } finally {
          if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
          }
    }
  }

  static final public void tipoDado() throws ParseException {
 /*@bgen(jjtree) tipoDado */
  SimpleNode jjtn000 = new SimpleNode(JJTTIPODADO);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INTEIRO:
        jj_consume_token(INTEIRO);
        break;
      case REAL:
        jj_consume_token(REAL);
        break;
      case CHAR:
        jj_consume_token(CHAR);
        break;
      case STRING:
        jj_consume_token(STRING);
        break;
      case BOOLEAN:
        jj_consume_token(BOOLEAN);
        break;
      default:
        jj_la1[24] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } finally {
          if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
          }
    }
  }

  static final public void dado() throws ParseException {
 /*@bgen(jjtree) dado */
  SimpleNode jjtn000 = new SimpleNode(JJTDADO);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case DIGITO:
        numero();
        break;
      case ISTRING:
        string();
        break;
      case VERDADEIRO:
      case FALSO:
        booleano();
        break;
      default:
        jj_la1[25] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } catch (Throwable jjte000) {
          if (jjtc000) {
            jjtree.clearNodeScope(jjtn000);
            jjtc000 = false;
          } else {
            jjtree.popNode();
          }
          if (jjte000 instanceof RuntimeException) {
            {if (true) throw (RuntimeException)jjte000;}
          }
          if (jjte000 instanceof ParseException) {
            {if (true) throw (ParseException)jjte000;}
          }
          {if (true) throw (Error)jjte000;}
    } finally {
          if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
          }
    }
  }

  static final public void numero() throws ParseException {
 /*@bgen(jjtree) numero */
  SimpleNode jjtn000 = new SimpleNode(JJTNUMERO);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      label_13:
      while (true) {
        jj_consume_token(DIGITO);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case DIGITO:
          ;
          break;
        default:
          jj_la1[26] = jj_gen;
          break label_13;
        }
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case CASADECIMAL:
        jj_consume_token(CASADECIMAL);
        label_14:
        while (true) {
          jj_consume_token(DIGITO);
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case DIGITO:
            ;
            break;
          default:
            jj_la1[27] = jj_gen;
            break label_14;
          }
        }
        break;
      default:
        jj_la1[28] = jj_gen;
        ;
      }
    } finally {
          if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
          }
    }
  }

  static final public void string() throws ParseException {
 /*@bgen(jjtree) string */
  SimpleNode jjtn000 = new SimpleNode(JJTSTRING);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      jj_consume_token(ISTRING);
      label_15:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case DIGITO:
        case CARACTERE:
          ;
          break;
        default:
          jj_la1[29] = jj_gen;
          break label_15;
        }
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case CARACTERE:
          jj_consume_token(CARACTERE);
          break;
        case DIGITO:
          jj_consume_token(DIGITO);
          break;
        default:
          jj_la1[30] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
      jj_consume_token(ISTRING);
    } finally {
          if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
          }
    }
  }

  static final public void booleano() throws ParseException {
 /*@bgen(jjtree) booleano */
  SimpleNode jjtn000 = new SimpleNode(JJTBOOLEANO);
  boolean jjtc000 = true;
  jjtree.openNodeScope(jjtn000);
    try {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case VERDADEIRO:
        jj_consume_token(VERDADEIRO);
        break;
      case FALSO:
        jj_consume_token(FALSO);
        break;
      default:
        jj_la1[31] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } finally {
          if (jjtc000) {
            jjtree.closeNodeScope(jjtn000, true);
          }
    }
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public BeerCompilerTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[32];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x1a027c00,0x1a027c00,0x1a027c00,0x1a027c00,0x40000,0x8000,0x0,0x0,0x0,0x0,0x0,0x1a027c00,0x1a027c00,0xa000000,0x60100000,0x60100000,0x10000,0x60100000,0x1800000,0x1800000,0x60100000,0x60180000,0x8000,0x10000,0x7c00,0x60100000,0x0,0x0,0x400000,0x0,0x0,0x60000000,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x1,0x1,0x1,0x1,0x0,0x0,0x2,0x2,0x3,0x2,0x3,0x1,0x1,0x0,0x3,0x3,0x0,0x3,0x0,0x0,0x3,0x3,0x0,0x0,0x0,0x2,0x2,0x2,0x0,0x6,0x6,0x0,};
   }

  /** Constructor with InputStream. */
  public BeerCompiler(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public BeerCompiler(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new BeerCompilerTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 32; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 32; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public BeerCompiler(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new BeerCompilerTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 32; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 32; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public BeerCompiler(BeerCompilerTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 32; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(BeerCompilerTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jjtree.reset();
    jj_gen = 0;
    for (int i = 0; i < 32; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[35];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 32; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 35; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
