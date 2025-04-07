// $ANTLR 3.5.2 T.g 2025-04-03 09:26:19
package core;
import java.util.ArrayList;
import java.util.List;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class TParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "ALFABETICO", "CERRAR", "CREAR", 
		"DEPENDE", "FECHA", "FIN", "ID", "INICIO", "NUMERICO", "TABLA", "USAR", 
		"WS"
	};
	public static final int EOF=-1;
	public static final int ALFABETICO=4;
	public static final int CERRAR=5;
	public static final int CREAR=6;
	public static final int DEPENDE=7;
	public static final int FECHA=8;
	public static final int FIN=9;
	public static final int ID=10;
	public static final int INICIO=11;
	public static final int NUMERICO=12;
	public static final int TABLA=13;
	public static final int USAR=14;
	public static final int WS=15;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public TParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public TParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	@Override public String[] getTokenNames() { return TParser.tokenNames; }
	@Override public String getGrammarFileName() { return "T.g"; }

	   
	       @Override
	    public void displayRecognitionError(String[] tokenNames, RecognitionException e){
	        String hdr = getErrorHeader(e);
	        String msg = getErrorMessage(e,tokenNames);
	      System.err.println(">> My compiler >>"+hdr + " " + msg );

	    }
	   
	   List <Tabla> tablas = new ArrayList<Tabla>();  
	             Tabla tablaActual = null;



	// $ANTLR start "inicio"
	// T.g:21:1: inicio : creacion usar ( tabla )+ cerrar ;
	public final void inicio() throws RecognitionException {
		try {
			// T.g:21:8: ( creacion usar ( tabla )+ cerrar )
			// T.g:21:11: creacion usar ( tabla )+ cerrar
			{
			pushFollow(FOLLOW_creacion_in_inicio22);
			creacion();
			state._fsp--;

			pushFollow(FOLLOW_usar_in_inicio24);
			usar();
			state._fsp--;

			// T.g:21:25: ( tabla )+
			int cnt1=0;
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( (LA1_0==TABLA) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// T.g:21:25: tabla
					{
					pushFollow(FOLLOW_tabla_in_inicio26);
					tabla();
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

			pushFollow(FOLLOW_cerrar_in_inicio29);
			cerrar();
			state._fsp--;

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



	// $ANTLR start "creacion"
	// T.g:23:1: creacion : CREAR ID ;
	public final void creacion() throws RecognitionException {
		Token ID1=null;

		try {
			// T.g:23:10: ( CREAR ID )
			// T.g:23:12: CREAR ID
			{
			match(input,CREAR,FOLLOW_CREAR_in_creacion37); 
			ID1=(Token)match(input,ID,FOLLOW_ID_in_creacion39); 
			System.out.println("CREATE DATABASE "+(ID1!=null?ID1.getText():null)+";"); 
			                    
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
	// $ANTLR end "creacion"



	// $ANTLR start "usar"
	// T.g:26:1: usar : USAR ID ;
	public final void usar() throws RecognitionException {
		Token ID2=null;

		try {
			// T.g:26:10: ( USAR ID )
			// T.g:26:12: USAR ID
			{
			match(input,USAR,FOLLOW_USAR_in_usar54); 
			ID2=(Token)match(input,ID,FOLLOW_ID_in_usar57); 
			System.out.println("USE  "+(ID2!=null?ID2.getText():null)+";"); 
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
	// $ANTLR end "usar"



	// $ANTLR start "tabla"
	// T.g:32:1: tabla : TABLA ID INICIO ( campo )+ FIN ;
	public final void tabla() throws RecognitionException {
		Token ID3=null;

		try {
			// T.g:32:10: ( TABLA ID INICIO ( campo )+ FIN )
			// T.g:32:12: TABLA ID INICIO ( campo )+ FIN
			{
			match(input,TABLA,FOLLOW_TABLA_in_tabla74); 
			ID3=(Token)match(input,ID,FOLLOW_ID_in_tabla76); 
			match(input,INICIO,FOLLOW_INICIO_in_tabla78); 
			 
			                    //código para generar SQL
			      System.out.println("CREATE TABLE "+(ID3!=null?ID3.getText():null) ); 
			      System.out.println(" ("+(ID3!=null?ID3.getText():null)+"_key INTEGER AUTO_INCREMENT PRIMARY KEY NOT NULL"); 
			                     //código para crear estructura de datos
			                        Tabla t = new Tabla();
			                        t.nombre =(ID3!=null?ID3.getText():null);
			                        tablas.add(t);
			                        tablaActual = t;
			                     //
			                   
			// T.g:44:14: ( campo )+
			int cnt2=0;
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( (LA2_0==DEPENDE||LA2_0==ID) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// T.g:44:14: campo
					{
					pushFollow(FOLLOW_campo_in_tabla114);
					campo();
					state._fsp--;

					}
					break;

				default :
					if ( cnt2 >= 1 ) break loop2;
					EarlyExitException eee = new EarlyExitException(2, input);
					throw eee;
				}
				cnt2++;
			}

			match(input,FIN,FOLLOW_FIN_in_tabla131); 

			                     System.out.println("   );   "); 
			                  
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
	// $ANTLR end "tabla"



	// $ANTLR start "campo"
	// T.g:49:1: campo : ( ID (t= NUMERICO |t= ALFABETICO |t= FECHA ) |t= DEPENDE ID );
	public final void campo() throws RecognitionException {
		Token t=null;
		Token ID4=null;
		Token ID5=null;

		try {
			// T.g:49:9: ( ID (t= NUMERICO |t= ALFABETICO |t= FECHA ) |t= DEPENDE ID )
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==ID) ) {
				alt4=1;
			}
			else if ( (LA4_0==DEPENDE) ) {
				alt4=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 4, 0, input);
				throw nvae;
			}

			switch (alt4) {
				case 1 :
					// T.g:49:11: ID (t= NUMERICO |t= ALFABETICO |t= FECHA )
					{
					ID4=(Token)match(input,ID,FOLLOW_ID_in_campo144); 
					// T.g:49:14: (t= NUMERICO |t= ALFABETICO |t= FECHA )
					int alt3=3;
					switch ( input.LA(1) ) {
					case NUMERICO:
						{
						alt3=1;
						}
						break;
					case ALFABETICO:
						{
						alt3=2;
						}
						break;
					case FECHA:
						{
						alt3=3;
						}
						break;
					default:
						NoViableAltException nvae =
							new NoViableAltException("", 3, 0, input);
						throw nvae;
					}
					switch (alt3) {
						case 1 :
							// T.g:49:15: t= NUMERICO
							{
							t=(Token)match(input,NUMERICO,FOLLOW_NUMERICO_in_campo149); 
							}
							break;
						case 2 :
							// T.g:49:28: t= ALFABETICO
							{
							t=(Token)match(input,ALFABETICO,FOLLOW_ALFABETICO_in_campo155); 
							}
							break;
						case 3 :
							// T.g:49:43: t= FECHA
							{
							t=(Token)match(input,FECHA,FOLLOW_FECHA_in_campo161); 
							}
							break;

					}

					 //aquí hay que agregar código para generar SQL
					                    if(((t!=null?t.getText():null)).compareTo("letras")==0) 
					                       System.out.println(", "+(ID4!=null?ID4.getText():null) + " VARCHAR(300)" );
					                    else if(((t!=null?t.getText():null)).compareTo("fecha")==0)
					                       System.out.println(", "+(ID4!=null?ID4.getText():null) + " DATE" ); 
					                    else if(((t!=null?t.getText():null)).compareTo("numeros")==0)
					                       System.out.println(", "+(ID4!=null?ID4.getText():null) + " INT"  );    

					                 //el que sigue es código para crear estructura de datos
					                  Atributo a  = new Atributo();
					                      a.nombreAtributo = (ID4!=null?ID4.getText():null);
					                      a.tipoAtributo = (t!=null?t.getText():null);
					                  tablaActual.atributos.add(a);
					          
					}
					break;
				case 2 :
					// T.g:64:11: t= DEPENDE ID
					{
					t=(Token)match(input,DEPENDE,FOLLOW_DEPENDE_in_campo188); 
					ID5=(Token)match(input,ID,FOLLOW_ID_in_campo190); 

					                  boolean tablaEncontrada = false;
					                  for(int i=0; i<tablas.size(); i++) {
					                     if(tablas.get(i).nombre.equals((ID5!=null?ID5.getText():null))) {
					                        tablaEncontrada = true;
					                        // Aquí puedes agregar la lógica para manejar la llave foránea
					                        System.out.print(", "+(ID5!=null?ID5.getText():null) + "_id INT");
					                        System.out.println(", FOREIGN KEY ("+(ID5!=null?ID5.getText():null) + "_id)  REFERENCES " + (ID5!=null?ID5.getText():null) + "(" + (ID5!=null?ID5.getText():null) + "_key) ON DELETE CASCADE");
					                          Atributo a  = new Atributo();
					                           a.nombreAtributo = (ID5!=null?ID5.getText():null);
					                           a.tipoAtributo = (t!=null?t.getText():null);
					                  tablaActual.atributos.add(a);
					                        break;
					                     }
					                  }
					                  if(!tablaEncontrada) {
					                     System.err.println("Error: La tabla '" + (ID5!=null?ID5.getText():null) + "' no existe.");
					                  }
					          
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
	// $ANTLR end "campo"



	// $ANTLR start "cerrar"
	// T.g:87:1: cerrar : CERRAR ;
	public final void cerrar() throws RecognitionException {
		try {
			// T.g:87:10: ( CERRAR )
			// T.g:87:12: CERRAR
			{
			match(input,CERRAR,FOLLOW_CERRAR_in_cerrar223); 

			              /*for (int i=0; i<tablas.size(); i++){ 
			                 System.out.println("\nTabla: "+tablas.get(i).nombre);
			                 List <Atributo> atribs= tablas.get(i).atributos;
			                 for (int j=0; j<atribs.size(); j++){  
			                   System.out.print("<Atributo>  "+atribs.get(j).nombreAtributo);
			                   System.out.println(" \t<TipoAtrib> "+atribs.get(j).tipoAtributo);
			                 }
			             }*/

			           
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
	// $ANTLR end "cerrar"

	// Delegated rules



	public static final BitSet FOLLOW_creacion_in_inicio22 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_usar_in_inicio24 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_tabla_in_inicio26 = new BitSet(new long[]{0x0000000000002020L});
	public static final BitSet FOLLOW_cerrar_in_inicio29 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CREAR_in_creacion37 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_ID_in_creacion39 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_USAR_in_usar54 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_ID_in_usar57 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_TABLA_in_tabla74 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_ID_in_tabla76 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_INICIO_in_tabla78 = new BitSet(new long[]{0x0000000000000480L});
	public static final BitSet FOLLOW_campo_in_tabla114 = new BitSet(new long[]{0x0000000000000680L});
	public static final BitSet FOLLOW_FIN_in_tabla131 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ID_in_campo144 = new BitSet(new long[]{0x0000000000001110L});
	public static final BitSet FOLLOW_NUMERICO_in_campo149 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ALFABETICO_in_campo155 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FECHA_in_campo161 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DEPENDE_in_campo188 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_ID_in_campo190 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CERRAR_in_cerrar223 = new BitSet(new long[]{0x0000000000000002L});
}
