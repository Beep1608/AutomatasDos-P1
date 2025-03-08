// $ANTLR 3.5.2 sintaxisSimple.g 2025-03-05 09:50:46
package core;

    import java.util.HashMap;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class sintaxisSimpleParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "CDOUBLE", "CINT", "COMMA", "DOUBLE", 
		"ID", "INT", "PRIVATE", "PROTECTED", "PUBLIC", "SEMICOLON", "VOID", "WS", 
		"'('", "')'", "'*'", "'+'", "'-'", "'='", "'class'", "'{'", "'}'"
	};
	public static final int EOF=-1;
	public static final int T__16=16;
	public static final int T__17=17;
	public static final int T__18=18;
	public static final int T__19=19;
	public static final int T__20=20;
	public static final int T__21=21;
	public static final int T__22=22;
	public static final int T__23=23;
	public static final int T__24=24;
	public static final int CDOUBLE=4;
	public static final int CINT=5;
	public static final int COMMA=6;
	public static final int DOUBLE=7;
	public static final int ID=8;
	public static final int INT=9;
	public static final int PRIVATE=10;
	public static final int PROTECTED=11;
	public static final int PUBLIC=12;
	public static final int SEMICOLON=13;
	public static final int VOID=14;
	public static final int WS=15;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public sintaxisSimpleParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public sintaxisSimpleParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return sintaxisSimpleParser.tokenNames; }
	@Override public String getGrammarFileName() { return "sintaxisSimple.g"; }


	    @Override
	    public void displayRecognitionError(String[] tokenNames, RecognitionException e){
	        String hdr = getErrorHeader(e);
	        String msg = getErrorMessage(e,tokenNames);
	        System.out.println(">> My compiler >>"+hdr + " " + msg );

	    }

	    HashMap TSG = new HashMap();
	    HashMap TSL = new HashMap();

	    public void pushTSG(String id, String tipo){
	        Integer se_encuentra = (Integer) TSG.get(id);
	        if(se_encuentra==null){
	            if(tipo.compareTo("int")==0) TSG.put(id,1);
	            else if(tipo.compareTo("double")==0) TSG.put(id,2);
	            else if(tipo.compareTo("class")==0) TSG.put(id,3);
	            else if(tipo.compareTo("method")==0) TSG.put(id,4);
	            else if(tipo.compareTo("void")==0) TSG.put(id,5);
	        }
	        else System.out.println("Error redeclarando :"+id);
	    }
	    public void pushTSL(String id, String tipo){
	        Integer se_encuentra = (Integer) TSL.get(id);
	        if(se_encuentra==null){
	            if(tipo.compareTo("int")==0) TSL.put(id,1);
	            else if(tipo.compareTo("double")==0) TSL.put(id,2);
	            else System.out.println("Tipo desconocido...");
	        }
	        else System.out.println("Error redeclarando :"+id);
	    }
	     public void mostrarTSL() {
	        System.out.println("Contenido de TSL:");
	        for (Object key : TSL.keySet()) {
	            System.out.println("ID: " + key + ", Tipo: " + TSL.get(key));
	        }
	    }
	     public void mostrarTSG() {
	        System.out.println("Contenido de TSG:");
	        for (Object key : TSG.keySet()) {
	            System.out.println("ID: " + key + ", Tipo: " + TSG.get(key));
	        }
	    }
	    public void mostrarObjetoTSG(String id) {
	        Integer tipo = (Integer) TSG.get(id);
	        if (tipo != null) {
	            System.out.println("ID: " + id + ", Tipo: " + tipo);
	        } else {
	            System.out.println("Error: ID no encontrado en TSG " + id);
	        }
	    }

	    public boolean existeIdentificador(String id) {
	        Integer tipoTsg = (Integer) TSG.get(id);
	        if (tipoTsg != null) {
	            System.out.println("Variable " + id + " encontrada en TSG con tipo: " + tipoTsg);
	            return true;
	        }
	        
	        Integer tipoTsl = (Integer) TSL.get(id);
	        if (tipoTsl != null) {
	            System.out.println("Variable " + id + " encontrada en TSL con tipo: " + tipoTsl);
	            return true;
	        }
	        
	        System.out.println("Error: La variable " + id + " no existe en ninguna tabla de símbolos");
	        return false;
	    }
	    
	    public int obtenerTipo(String id) {
	        Integer tipoTsl = (Integer) TSL.get(id);
	        if(tipoTsl != null) return tipoTsl;
	        Integer tipoTsg = (Integer) TSG.get(id);
	        if(tipoTsg != null) return tipoTsg;
	        return 3; // tipo error
	    }

	    public boolean verificarTipos(String id1, int tipo2) {
	        int tipo1 = obtenerTipo(id1);
	        if(tipo1 != tipo2) {
	            System.out.println("Error: tipos no coinciden en asignación - Variable " + id1 + 
	                             " (tipo " + tipo1 + ") = expresión (tipo " + tipo2 + ")");
	            return false;
	        }
	        return true;
	    }




	// $ANTLR start "inicio"
	// sintaxisSimple.g:95:1: inicio : ( clase )+ ;
	public final void inicio() throws RecognitionException {
		try {
			// sintaxisSimple.g:95:7: ( ( clase )+ )
			// sintaxisSimple.g:95:9: ( clase )+
			{
			// sintaxisSimple.g:95:9: ( clase )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= PRIVATE && LA1_0 <= PUBLIC)) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// sintaxisSimple.g:95:9: clase
					{
					pushFollow(FOLLOW_clase_in_inicio17);
					clase();
					state._fsp--;

					}
					break;

				default :
					if ( cnt1 >= 1 ) break loop1;
					EarlyExitException eee = new EarlyExitException(1, input);
					throw eee;
				}
				cnt1++;
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "inicio"



	// $ANTLR start "clase"
	// sintaxisSimple.g:97:1: clase : modificAcceso 'class' ID '{' ( miembro )* '}' ;
	public final void clase() throws RecognitionException {
		Token ID1=null;

		try {
			// sintaxisSimple.g:97:6: ( modificAcceso 'class' ID '{' ( miembro )* '}' )
			// sintaxisSimple.g:97:8: modificAcceso 'class' ID '{' ( miembro )* '}'
			{
			pushFollow(FOLLOW_modificAcceso_in_clase26);
			modificAcceso();
			state._fsp--;

			match(input,22,FOLLOW_22_in_clase28); 
			ID1=(Token)match(input,ID,FOLLOW_ID_in_clase30); 
			pushTSG((ID1!=null?ID1.getText():null), "class");
			match(input,23,FOLLOW_23_in_clase33); 
			// sintaxisSimple.g:97:66: ( miembro )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==DOUBLE||(LA2_0 >= INT && LA2_0 <= PUBLIC)||LA2_0==VOID) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// sintaxisSimple.g:97:66: miembro
					{
					pushFollow(FOLLOW_miembro_in_clase35);
					miembro();
					state._fsp--;

					}
					break;

				default :
					break loop2;
				}
			}

			match(input,24,FOLLOW_24_in_clase38); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "clase"



	// $ANTLR start "miembro"
	// sintaxisSimple.g:99:1: miembro : ( metodo | atributo );
	public final void miembro() throws RecognitionException {
		try {
			// sintaxisSimple.g:99:8: ( metodo | atributo )
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( ((LA3_0 >= PRIVATE && LA3_0 <= PUBLIC)) ) {
				int LA3_1 = input.LA(2);
				if ( (LA3_1==DOUBLE||LA3_1==INT||LA3_1==VOID) ) {
					int LA3_2 = input.LA(3);
					if ( (LA3_2==ID) ) {
						int LA3_3 = input.LA(4);
						if ( (LA3_3==16) ) {
							alt3=1;
						}
						else if ( (LA3_3==COMMA||LA3_3==SEMICOLON) ) {
							alt3=2;
						}

						else {
							int nvaeMark = input.mark();
							try {
								for (int nvaeConsume = 0; nvaeConsume < 4 - 1; nvaeConsume++) {
									input.consume();
								}
								NoViableAltException nvae =
									new NoViableAltException("", 3, 3, input);
								throw nvae;
							} finally {
								input.rewind(nvaeMark);
							}
						}

					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 3, 2, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 3, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}
			else if ( (LA3_0==DOUBLE||LA3_0==INT||LA3_0==VOID) ) {
				int LA3_2 = input.LA(2);
				if ( (LA3_2==ID) ) {
					int LA3_3 = input.LA(3);
					if ( (LA3_3==16) ) {
						alt3=1;
					}
					else if ( (LA3_3==COMMA||LA3_3==SEMICOLON) ) {
						alt3=2;
					}

					else {
						int nvaeMark = input.mark();
						try {
							for (int nvaeConsume = 0; nvaeConsume < 3 - 1; nvaeConsume++) {
								input.consume();
							}
							NoViableAltException nvae =
								new NoViableAltException("", 3, 3, input);
							throw nvae;
						} finally {
							input.rewind(nvaeMark);
						}
					}

				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 3, 2, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 3, 0, input);
				throw nvae;
			}

			switch (alt3) {
				case 1 :
					// sintaxisSimple.g:99:10: metodo
					{
					pushFollow(FOLLOW_metodo_in_miembro47);
					metodo();
					state._fsp--;

					}
					break;
				case 2 :
					// sintaxisSimple.g:99:19: atributo
					{
					pushFollow(FOLLOW_atributo_in_miembro51);
					atributo();
					state._fsp--;

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "miembro"



	// $ANTLR start "atributo"
	// sintaxisSimple.g:101:1: atributo : ( modificAcceso )? tipo id1= ID ( COMMA id2= ID )* SEMICOLON ;
	public final void atributo() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		ParserRuleReturnScope tipo2 =null;

		try {
			// sintaxisSimple.g:101:10: ( ( modificAcceso )? tipo id1= ID ( COMMA id2= ID )* SEMICOLON )
			// sintaxisSimple.g:101:12: ( modificAcceso )? tipo id1= ID ( COMMA id2= ID )* SEMICOLON
			{
			// sintaxisSimple.g:101:12: ( modificAcceso )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( ((LA4_0 >= PRIVATE && LA4_0 <= PUBLIC)) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// sintaxisSimple.g:101:13: modificAcceso
					{
					pushFollow(FOLLOW_modificAcceso_in_atributo62);
					modificAcceso();
					state._fsp--;

					}
					break;

			}

			pushFollow(FOLLOW_tipo_in_atributo66);
			tipo2=tipo();
			state._fsp--;

			id1=(Token)match(input,ID,FOLLOW_ID_in_atributo71); 
			pushTSG((id1!=null?id1.getText():null), (tipo2!=null?input.toString(tipo2.start,tipo2.stop):null));
			// sintaxisSimple.g:101:77: ( COMMA id2= ID )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==COMMA) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// sintaxisSimple.g:101:78: COMMA id2= ID
					{
					match(input,COMMA,FOLLOW_COMMA_in_atributo77); 
					id2=(Token)match(input,ID,FOLLOW_ID_in_atributo81); 
					pushTSG((id2!=null?id2.getText():null), (tipo2!=null?input.toString(tipo2.start,tipo2.stop):null));
					}
					break;

				default :
					break loop5;
				}
			}

			match(input,SEMICOLON,FOLLOW_SEMICOLON_in_atributo88); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "atributo"



	// $ANTLR start "metodo"
	// sintaxisSimple.g:103:1: metodo : ( modificAcceso )? tipo ID '(' ( decl_args )? ')' '{' ( instruccion )* '}' ;
	public final void metodo() throws RecognitionException {
		Token ID4=null;
		ParserRuleReturnScope modificAcceso3 =null;

		try {
			// sintaxisSimple.g:103:7: ( ( modificAcceso )? tipo ID '(' ( decl_args )? ')' '{' ( instruccion )* '}' )
			// sintaxisSimple.g:103:9: ( modificAcceso )? tipo ID '(' ( decl_args )? ')' '{' ( instruccion )* '}'
			{
			// sintaxisSimple.g:103:9: ( modificAcceso )?
			int alt6=2;
			int LA6_0 = input.LA(1);
			if ( ((LA6_0 >= PRIVATE && LA6_0 <= PUBLIC)) ) {
				alt6=1;
			}
			switch (alt6) {
				case 1 :
					// sintaxisSimple.g:103:10: modificAcceso
					{
					pushFollow(FOLLOW_modificAcceso_in_metodo96);
					modificAcceso3=modificAcceso();
					state._fsp--;

					}
					break;

			}

			pushFollow(FOLLOW_tipo_in_metodo100);
			tipo();
			state._fsp--;

			ID4=(Token)match(input,ID,FOLLOW_ID_in_metodo102); 
			match(input,16,FOLLOW_16_in_metodo106); 
			// sintaxisSimple.g:103:40: ( decl_args )?
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==DOUBLE||LA7_0==INT||LA7_0==VOID) ) {
				alt7=1;
			}
			switch (alt7) {
				case 1 :
					// sintaxisSimple.g:103:40: decl_args
					{
					pushFollow(FOLLOW_decl_args_in_metodo108);
					decl_args();
					state._fsp--;

					}
					break;

			}

			match(input,17,FOLLOW_17_in_metodo111); 

			            // Si no hay modificador de acceso, tratarlo como protected
			            if ((modificAcceso3!=null?input.toString(modificAcceso3.start,modificAcceso3.stop):null) == null) {
			                System.out.println("Usando protected por defecto para método: " + (ID4!=null?ID4.getText():null));
			            }
			        
			match(input,23,FOLLOW_23_in_metodo131); 
			// sintaxisSimple.g:111:17: ( instruccion )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( ((LA8_0 >= DOUBLE && LA8_0 <= INT)||LA8_0==VOID) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// sintaxisSimple.g:111:17: instruccion
					{
					pushFollow(FOLLOW_instruccion_in_metodo149);
					instruccion();
					state._fsp--;

					}
					break;

				default :
					break loop8;
				}
			}

			match(input,24,FOLLOW_24_in_metodo160); 
			pushTSG((ID4!=null?ID4.getText():null), "method");  TSL.clear();
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "metodo"



	// $ANTLR start "instruccion"
	// sintaxisSimple.g:113:1: instruccion : ( asignacion | decl_local );
	public final void instruccion() throws RecognitionException {
		try {
			// sintaxisSimple.g:113:12: ( asignacion | decl_local )
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==ID) ) {
				alt9=1;
			}
			else if ( (LA9_0==DOUBLE||LA9_0==INT||LA9_0==VOID) ) {
				alt9=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 9, 0, input);
				throw nvae;
			}

			switch (alt9) {
				case 1 :
					// sintaxisSimple.g:113:14: asignacion
					{
					pushFollow(FOLLOW_asignacion_in_instruccion169);
					asignacion();
					state._fsp--;

					}
					break;
				case 2 :
					// sintaxisSimple.g:113:27: decl_local
					{
					pushFollow(FOLLOW_decl_local_in_instruccion173);
					decl_local();
					state._fsp--;

					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "instruccion"



	// $ANTLR start "asignacion"
	// sintaxisSimple.g:115:1: asignacion : ID '=' expr ';' ;
	public final void asignacion() throws RecognitionException {
		Token ID5=null;
		int expr6 =0;

		try {
			// sintaxisSimple.g:115:11: ( ID '=' expr ';' )
			// sintaxisSimple.g:115:13: ID '=' expr ';'
			{
			ID5=(Token)match(input,ID,FOLLOW_ID_in_asignacion181); 
			match(input,21,FOLLOW_21_in_asignacion183); 
			pushFollow(FOLLOW_expr_in_asignacion184);
			expr6=expr();
			state._fsp--;

			 
			    if(existeIdentificador((ID5!=null?ID5.getText():null))) {
			        verificarTipos((ID5!=null?ID5.getText():null), expr6);
			    }

			match(input,SEMICOLON,FOLLOW_SEMICOLON_in_asignacion188); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "asignacion"



	// $ANTLR start "decl_args"
	// sintaxisSimple.g:121:1: decl_args : t1= tipo id1= ID ( COMMA t2= tipo id2= ID )* ;
	public final void decl_args() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		ParserRuleReturnScope t1 =null;
		ParserRuleReturnScope t2 =null;

		try {
			// sintaxisSimple.g:121:10: (t1= tipo id1= ID ( COMMA t2= tipo id2= ID )* )
			// sintaxisSimple.g:121:12: t1= tipo id1= ID ( COMMA t2= tipo id2= ID )*
			{
			pushFollow(FOLLOW_tipo_in_decl_args197);
			t1=tipo();
			state._fsp--;

			id1=(Token)match(input,ID,FOLLOW_ID_in_decl_args201); 
			pushTSL((id1!=null?id1.getText():null), (t1!=null?input.toString(t1.start,t1.stop):null));
			// sintaxisSimple.g:121:59: ( COMMA t2= tipo id2= ID )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==COMMA) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// sintaxisSimple.g:121:60: COMMA t2= tipo id2= ID
					{
					match(input,COMMA,FOLLOW_COMMA_in_decl_args206); 
					pushFollow(FOLLOW_tipo_in_decl_args210);
					t2=tipo();
					state._fsp--;

					id2=(Token)match(input,ID,FOLLOW_ID_in_decl_args214); 
					pushTSL((id2!=null?id2.getText():null), (t2!=null?input.toString(t2.start,t2.stop):null));
					}
					break;

				default :
					break loop10;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "decl_args"



	// $ANTLR start "decl_local"
	// sintaxisSimple.g:123:1: decl_local : tipo id1= ID ( ',' id2= ID )* SEMICOLON ;
	public final void decl_local() throws RecognitionException {
		Token id1=null;
		Token id2=null;
		ParserRuleReturnScope tipo7 =null;

		try {
			// sintaxisSimple.g:123:11: ( tipo id1= ID ( ',' id2= ID )* SEMICOLON )
			// sintaxisSimple.g:123:13: tipo id1= ID ( ',' id2= ID )* SEMICOLON
			{
			pushFollow(FOLLOW_tipo_in_decl_local226);
			tipo7=tipo();
			state._fsp--;

			id1=(Token)match(input,ID,FOLLOW_ID_in_decl_local231); 
			pushTSL((id1!=null?id1.getText():null), (tipo7!=null?input.toString(tipo7.start,tipo7.stop):null));
			// sintaxisSimple.g:123:60: ( ',' id2= ID )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==COMMA) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// sintaxisSimple.g:123:61: ',' id2= ID
					{
					match(input,COMMA,FOLLOW_COMMA_in_decl_local236); 
					id2=(Token)match(input,ID,FOLLOW_ID_in_decl_local240); 
					pushTSL((id2!=null?id2.getText():null), (tipo7!=null?input.toString(tipo7.start,tipo7.stop):null));
					}
					break;

				default :
					break loop11;
				}
			}

			match(input,SEMICOLON,FOLLOW_SEMICOLON_in_decl_local246); 
			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "decl_local"



	// $ANTLR start "expr"
	// sintaxisSimple.g:125:1: expr returns [int tipo] : m1= multExpr ( ( '+' | '-' ) m2= multExpr )* ;
	public final int expr() throws RecognitionException {
		int tipo = 0;


		int m1 =0;
		int m2 =0;

		try {
			// sintaxisSimple.g:125:24: (m1= multExpr ( ( '+' | '-' ) m2= multExpr )* )
			// sintaxisSimple.g:125:26: m1= multExpr ( ( '+' | '-' ) m2= multExpr )*
			{
			pushFollow(FOLLOW_multExpr_in_expr260);
			m1=multExpr();
			state._fsp--;

			tipo =m1;
			// sintaxisSimple.g:125:56: ( ( '+' | '-' ) m2= multExpr )*
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( ((LA12_0 >= 19 && LA12_0 <= 20)) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// sintaxisSimple.g:125:57: ( '+' | '-' ) m2= multExpr
					{
					if ( (input.LA(1) >= 19 && input.LA(1) <= 20) ) {
						input.consume();
						state.errorRecovery=false;
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						throw mse;
					}
					pushFollow(FOLLOW_multExpr_in_expr273);
					m2=multExpr();
					state._fsp--;


					    if(tipo != 3 && m1 != m2) tipo = 3;
					    else if(tipo != 3) tipo = m1;

					}
					break;

				default :
					break loop12;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return tipo;
	}
	// $ANTLR end "expr"



	// $ANTLR start "multExpr"
	// sintaxisSimple.g:130:1: multExpr returns [int tipo] : a1= atom ( '*' a2= atom )* ;
	public final int multExpr() throws RecognitionException {
		int tipo = 0;


		int a1 =0;
		int a2 =0;

		try {
			// sintaxisSimple.g:130:28: (a1= atom ( '*' a2= atom )* )
			// sintaxisSimple.g:130:30: a1= atom ( '*' a2= atom )*
			{
			pushFollow(FOLLOW_atom_in_multExpr289);
			a1=atom();
			state._fsp--;

			tipo = a1;
			// sintaxisSimple.g:130:59: ( '*' a2= atom )*
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==18) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// sintaxisSimple.g:130:60: '*' a2= atom
					{
					match(input,18,FOLLOW_18_in_multExpr295); 
					pushFollow(FOLLOW_atom_in_multExpr299);
					a2=atom();
					state._fsp--;


					    if(tipo != 3 && a1 != a2) tipo = 3;
					    else if(tipo != 3) tipo = a1;

					}
					break;

				default :
					break loop13;
				}
			}

			}

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return tipo;
	}
	// $ANTLR end "multExpr"



	// $ANTLR start "atom"
	// sintaxisSimple.g:135:1: atom returns [int tipo] : ( CINT | CDOUBLE | ID | '(' expr ')' );
	public final int atom() throws RecognitionException {
		int tipo = 0;


		Token ID8=null;
		int expr9 =0;

		try {
			// sintaxisSimple.g:135:24: ( CINT | CDOUBLE | ID | '(' expr ')' )
			int alt14=4;
			switch ( input.LA(1) ) {
			case CINT:
				{
				alt14=1;
				}
				break;
			case CDOUBLE:
				{
				alt14=2;
				}
				break;
			case ID:
				{
				alt14=3;
				}
				break;
			case 16:
				{
				alt14=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 14, 0, input);
				throw nvae;
			}
			switch (alt14) {
				case 1 :
					// sintaxisSimple.g:135:26: CINT
					{
					match(input,CINT,FOLLOW_CINT_in_atom315); 
					tipo =1;
					}
					break;
				case 2 :
					// sintaxisSimple.g:136:27: CDOUBLE
					{
					match(input,CDOUBLE,FOLLOW_CDOUBLE_in_atom345); 
					tipo =2;
					}
					break;
				case 3 :
					// sintaxisSimple.g:137:27: ID
					{
					ID8=(Token)match(input,ID,FOLLOW_ID_in_atom376); 
					 
					                              Integer tipoTsl = (Integer) TSL.get((ID8!=null?ID8.getText():null));
					                              if (tipoTsl != null) {
					                                  tipo = tipoTsl;
					                              } else {
					                                  Integer tipoTsg = (Integer) TSG.get((ID8!=null?ID8.getText():null));
					                                  if(tipoTsg != null){
					                                    tipo = tipoTsg;
					                                    mostrarObjetoTSG((ID8!=null?ID8.getText():null));
					                                  }else{
					                                    System.out.println("No existe la variable "+(ID8!=null?ID8.getText():null));
					                                    tipo = 3;
					                                  }
					                              }
					                            
					}
					break;
				case 4 :
					// sintaxisSimple.g:152:27: '(' expr ')'
					{
					match(input,16,FOLLOW_16_in_atom409); 
					pushFollow(FOLLOW_expr_in_atom411);
					expr9=expr();
					state._fsp--;

					match(input,17,FOLLOW_17_in_atom413); 
					tipo = expr9;
					}
					break;

			}
		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return tipo;
	}
	// $ANTLR end "atom"


	public static class modificAcceso_return extends ParserRuleReturnScope {
	};


	// $ANTLR start "modificAcceso"
	// sintaxisSimple.g:153:1: modificAcceso : ( PUBLIC | PRIVATE | PROTECTED );
	public final sintaxisSimpleParser.modificAcceso_return modificAcceso() throws RecognitionException {
		sintaxisSimpleParser.modificAcceso_return retval = new sintaxisSimpleParser.modificAcceso_return();
		retval.start = input.LT(1);

		try {
			// sintaxisSimple.g:153:14: ( PUBLIC | PRIVATE | PROTECTED )
			// sintaxisSimple.g:
			{
			if ( (input.LA(1) >= PRIVATE && input.LA(1) <= PUBLIC) ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "modificAcceso"


	public static class tipo_return extends ParserRuleReturnScope {
	};


	// $ANTLR start "tipo"
	// sintaxisSimple.g:154:1: tipo : ( INT | DOUBLE | VOID );
	public final sintaxisSimpleParser.tipo_return tipo() throws RecognitionException {
		sintaxisSimpleParser.tipo_return retval = new sintaxisSimpleParser.tipo_return();
		retval.start = input.LT(1);

		try {
			// sintaxisSimple.g:154:5: ( INT | DOUBLE | VOID )
			// sintaxisSimple.g:
			{
			if ( input.LA(1)==DOUBLE||input.LA(1)==INT||input.LA(1)==VOID ) {
				input.consume();
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "tipo"

	// Delegated rules



	public static final BitSet FOLLOW_clase_in_inicio17 = new BitSet(new long[]{0x0000000000001C02L});
	public static final BitSet FOLLOW_modificAcceso_in_clase26 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_clase28 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_ID_in_clase30 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_23_in_clase33 = new BitSet(new long[]{0x0000000001005E80L});
	public static final BitSet FOLLOW_miembro_in_clase35 = new BitSet(new long[]{0x0000000001005E80L});
	public static final BitSet FOLLOW_24_in_clase38 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_metodo_in_miembro47 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_atributo_in_miembro51 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_modificAcceso_in_atributo62 = new BitSet(new long[]{0x0000000000004280L});
	public static final BitSet FOLLOW_tipo_in_atributo66 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_ID_in_atributo71 = new BitSet(new long[]{0x0000000000002040L});
	public static final BitSet FOLLOW_COMMA_in_atributo77 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_ID_in_atributo81 = new BitSet(new long[]{0x0000000000002040L});
	public static final BitSet FOLLOW_SEMICOLON_in_atributo88 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_modificAcceso_in_metodo96 = new BitSet(new long[]{0x0000000000004280L});
	public static final BitSet FOLLOW_tipo_in_metodo100 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_ID_in_metodo102 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_16_in_metodo106 = new BitSet(new long[]{0x0000000000024280L});
	public static final BitSet FOLLOW_decl_args_in_metodo108 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_metodo111 = new BitSet(new long[]{0x0000000000800000L});
	public static final BitSet FOLLOW_23_in_metodo131 = new BitSet(new long[]{0x0000000001004380L});
	public static final BitSet FOLLOW_instruccion_in_metodo149 = new BitSet(new long[]{0x0000000001004380L});
	public static final BitSet FOLLOW_24_in_metodo160 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_asignacion_in_instruccion169 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_decl_local_in_instruccion173 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_asignacion181 = new BitSet(new long[]{0x0000000000200000L});
	public static final BitSet FOLLOW_21_in_asignacion183 = new BitSet(new long[]{0x0000000000010130L});
	public static final BitSet FOLLOW_expr_in_asignacion184 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_SEMICOLON_in_asignacion188 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_tipo_in_decl_args197 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_ID_in_decl_args201 = new BitSet(new long[]{0x0000000000000042L});
	public static final BitSet FOLLOW_COMMA_in_decl_args206 = new BitSet(new long[]{0x0000000000004280L});
	public static final BitSet FOLLOW_tipo_in_decl_args210 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_ID_in_decl_args214 = new BitSet(new long[]{0x0000000000000042L});
	public static final BitSet FOLLOW_tipo_in_decl_local226 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_ID_in_decl_local231 = new BitSet(new long[]{0x0000000000002040L});
	public static final BitSet FOLLOW_COMMA_in_decl_local236 = new BitSet(new long[]{0x0000000000000100L});
	public static final BitSet FOLLOW_ID_in_decl_local240 = new BitSet(new long[]{0x0000000000002040L});
	public static final BitSet FOLLOW_SEMICOLON_in_decl_local246 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_multExpr_in_expr260 = new BitSet(new long[]{0x0000000000180002L});
	public static final BitSet FOLLOW_set_in_expr264 = new BitSet(new long[]{0x0000000000010130L});
	public static final BitSet FOLLOW_multExpr_in_expr273 = new BitSet(new long[]{0x0000000000180002L});
	public static final BitSet FOLLOW_atom_in_multExpr289 = new BitSet(new long[]{0x0000000000040002L});
	public static final BitSet FOLLOW_18_in_multExpr295 = new BitSet(new long[]{0x0000000000010130L});
	public static final BitSet FOLLOW_atom_in_multExpr299 = new BitSet(new long[]{0x0000000000040002L});
	public static final BitSet FOLLOW_CINT_in_atom315 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CDOUBLE_in_atom345 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_atom376 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_16_in_atom409 = new BitSet(new long[]{0x0000000000010130L});
	public static final BitSet FOLLOW_expr_in_atom411 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_17_in_atom413 = new BitSet(new long[]{0x0000000000000002L});
}
