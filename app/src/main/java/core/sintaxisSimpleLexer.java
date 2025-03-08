// $ANTLR 3.5.2 sintaxisSimple.g 2025-03-05 09:50:46
package core;
import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class sintaxisSimpleLexer extends Lexer {
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
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public sintaxisSimpleLexer() {} 
	public sintaxisSimpleLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public sintaxisSimpleLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "sintaxisSimple.g"; }

	// $ANTLR start "T__16"
	public final void mT__16() throws RecognitionException {
		try {
			int _type = T__16;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// sintaxisSimple.g:2:7: ( '(' )
			// sintaxisSimple.g:2:9: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__16"

	// $ANTLR start "T__17"
	public final void mT__17() throws RecognitionException {
		try {
			int _type = T__17;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// sintaxisSimple.g:3:7: ( ')' )
			// sintaxisSimple.g:3:9: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__17"

	// $ANTLR start "T__18"
	public final void mT__18() throws RecognitionException {
		try {
			int _type = T__18;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// sintaxisSimple.g:4:7: ( '*' )
			// sintaxisSimple.g:4:9: '*'
			{
			match('*'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__18"

	// $ANTLR start "T__19"
	public final void mT__19() throws RecognitionException {
		try {
			int _type = T__19;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// sintaxisSimple.g:5:7: ( '+' )
			// sintaxisSimple.g:5:9: '+'
			{
			match('+'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__19"

	// $ANTLR start "T__20"
	public final void mT__20() throws RecognitionException {
		try {
			int _type = T__20;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// sintaxisSimple.g:6:7: ( '-' )
			// sintaxisSimple.g:6:9: '-'
			{
			match('-'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__20"

	// $ANTLR start "T__21"
	public final void mT__21() throws RecognitionException {
		try {
			int _type = T__21;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// sintaxisSimple.g:7:7: ( '=' )
			// sintaxisSimple.g:7:9: '='
			{
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__21"

	// $ANTLR start "T__22"
	public final void mT__22() throws RecognitionException {
		try {
			int _type = T__22;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// sintaxisSimple.g:8:7: ( 'class' )
			// sintaxisSimple.g:8:9: 'class'
			{
			match("class"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__22"

	// $ANTLR start "T__23"
	public final void mT__23() throws RecognitionException {
		try {
			int _type = T__23;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// sintaxisSimple.g:9:7: ( '{' )
			// sintaxisSimple.g:9:9: '{'
			{
			match('{'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__23"

	// $ANTLR start "T__24"
	public final void mT__24() throws RecognitionException {
		try {
			int _type = T__24;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// sintaxisSimple.g:10:7: ( '}' )
			// sintaxisSimple.g:10:9: '}'
			{
			match('}'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__24"

	// $ANTLR start "INT"
	public final void mINT() throws RecognitionException {
		try {
			int _type = INT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// sintaxisSimple.g:155:4: ( 'int' )
			// sintaxisSimple.g:155:6: 'int'
			{
			match("int"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INT"

	// $ANTLR start "DOUBLE"
	public final void mDOUBLE() throws RecognitionException {
		try {
			int _type = DOUBLE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// sintaxisSimple.g:156:7: ( 'double' )
			// sintaxisSimple.g:156:9: 'double'
			{
			match("double"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DOUBLE"

	// $ANTLR start "VOID"
	public final void mVOID() throws RecognitionException {
		try {
			int _type = VOID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// sintaxisSimple.g:157:5: ( 'void' )
			// sintaxisSimple.g:157:7: 'void'
			{
			match("void"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "VOID"

	// $ANTLR start "PUBLIC"
	public final void mPUBLIC() throws RecognitionException {
		try {
			int _type = PUBLIC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// sintaxisSimple.g:158:7: ( 'public' )
			// sintaxisSimple.g:158:9: 'public'
			{
			match("public"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PUBLIC"

	// $ANTLR start "PRIVATE"
	public final void mPRIVATE() throws RecognitionException {
		try {
			int _type = PRIVATE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// sintaxisSimple.g:159:8: ( 'private' )
			// sintaxisSimple.g:159:10: 'private'
			{
			match("private"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PRIVATE"

	// $ANTLR start "PROTECTED"
	public final void mPROTECTED() throws RecognitionException {
		try {
			int _type = PROTECTED;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// sintaxisSimple.g:160:10: ( 'protected' )
			// sintaxisSimple.g:160:12: 'protected'
			{
			match("protected"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "PROTECTED"

	// $ANTLR start "ID"
	public final void mID() throws RecognitionException {
		try {
			int _type = ID;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// sintaxisSimple.g:161:3: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
			// sintaxisSimple.g:161:5: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// sintaxisSimple.g:161:29: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
			loop1:
			while (true) {
				int alt1=2;
				int LA1_0 = input.LA(1);
				if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
					alt1=1;
				}

				switch (alt1) {
				case 1 :
					// sintaxisSimple.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop1;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ID"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// sintaxisSimple.g:162:3: ( ( ' ' | '\\n' | '\\t' | '\\r' )+ )
			// sintaxisSimple.g:162:5: ( ' ' | '\\n' | '\\t' | '\\r' )+
			{
			// sintaxisSimple.g:162:5: ( ' ' | '\\n' | '\\t' | '\\r' )+
			int cnt2=0;
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= '\t' && LA2_0 <= '\n')||LA2_0=='\r'||LA2_0==' ') ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// sintaxisSimple.g:
					{
					if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt2 >= 1 ) break loop2;
					EarlyExitException eee = new EarlyExitException(2, input);
					throw eee;
				}
				cnt2++;
			}

			_channel=HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	// $ANTLR start "CDOUBLE"
	public final void mCDOUBLE() throws RecognitionException {
		try {
			int _type = CDOUBLE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// sintaxisSimple.g:163:8: ( CINT '.' CINT )
			// sintaxisSimple.g:163:10: CINT '.' CINT
			{
			mCINT(); 

			match('.'); 
			mCINT(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CDOUBLE"

	// $ANTLR start "CINT"
	public final void mCINT() throws RecognitionException {
		try {
			int _type = CINT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// sintaxisSimple.g:164:5: ( ( '0' .. '9' )+ )
			// sintaxisSimple.g:164:7: ( '0' .. '9' )+
			{
			// sintaxisSimple.g:164:7: ( '0' .. '9' )+
			int cnt3=0;
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// sintaxisSimple.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt3 >= 1 ) break loop3;
					EarlyExitException eee = new EarlyExitException(3, input);
					throw eee;
				}
				cnt3++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CINT"

	// $ANTLR start "SEMICOLON"
	public final void mSEMICOLON() throws RecognitionException {
		try {
			int _type = SEMICOLON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// sintaxisSimple.g:165:10: ( ';' )
			// sintaxisSimple.g:165:12: ';'
			{
			match(';'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SEMICOLON"

	// $ANTLR start "COMMA"
	public final void mCOMMA() throws RecognitionException {
		try {
			int _type = COMMA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// sintaxisSimple.g:166:6: ( ',' )
			// sintaxisSimple.g:166:8: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMA"

	@Override
	public void mTokens() throws RecognitionException {
		// sintaxisSimple.g:1:8: ( T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | INT | DOUBLE | VOID | PUBLIC | PRIVATE | PROTECTED | ID | WS | CDOUBLE | CINT | SEMICOLON | COMMA )
		int alt4=21;
		alt4 = dfa4.predict(input);
		switch (alt4) {
			case 1 :
				// sintaxisSimple.g:1:10: T__16
				{
				mT__16(); 

				}
				break;
			case 2 :
				// sintaxisSimple.g:1:16: T__17
				{
				mT__17(); 

				}
				break;
			case 3 :
				// sintaxisSimple.g:1:22: T__18
				{
				mT__18(); 

				}
				break;
			case 4 :
				// sintaxisSimple.g:1:28: T__19
				{
				mT__19(); 

				}
				break;
			case 5 :
				// sintaxisSimple.g:1:34: T__20
				{
				mT__20(); 

				}
				break;
			case 6 :
				// sintaxisSimple.g:1:40: T__21
				{
				mT__21(); 

				}
				break;
			case 7 :
				// sintaxisSimple.g:1:46: T__22
				{
				mT__22(); 

				}
				break;
			case 8 :
				// sintaxisSimple.g:1:52: T__23
				{
				mT__23(); 

				}
				break;
			case 9 :
				// sintaxisSimple.g:1:58: T__24
				{
				mT__24(); 

				}
				break;
			case 10 :
				// sintaxisSimple.g:1:64: INT
				{
				mINT(); 

				}
				break;
			case 11 :
				// sintaxisSimple.g:1:68: DOUBLE
				{
				mDOUBLE(); 

				}
				break;
			case 12 :
				// sintaxisSimple.g:1:75: VOID
				{
				mVOID(); 

				}
				break;
			case 13 :
				// sintaxisSimple.g:1:80: PUBLIC
				{
				mPUBLIC(); 

				}
				break;
			case 14 :
				// sintaxisSimple.g:1:87: PRIVATE
				{
				mPRIVATE(); 

				}
				break;
			case 15 :
				// sintaxisSimple.g:1:95: PROTECTED
				{
				mPROTECTED(); 

				}
				break;
			case 16 :
				// sintaxisSimple.g:1:105: ID
				{
				mID(); 

				}
				break;
			case 17 :
				// sintaxisSimple.g:1:108: WS
				{
				mWS(); 

				}
				break;
			case 18 :
				// sintaxisSimple.g:1:111: CDOUBLE
				{
				mCDOUBLE(); 

				}
				break;
			case 19 :
				// sintaxisSimple.g:1:119: CINT
				{
				mCINT(); 

				}
				break;
			case 20 :
				// sintaxisSimple.g:1:124: SEMICOLON
				{
				mSEMICOLON(); 

				}
				break;
			case 21 :
				// sintaxisSimple.g:1:134: COMMA
				{
				mCOMMA(); 

				}
				break;

		}
	}


	protected DFA4 dfa4 = new DFA4(this);
	static final String DFA4_eotS =
		"\7\uffff\1\16\2\uffff\4\16\2\uffff\1\31\2\uffff\6\16\2\uffff\1\16\1\43"+
		"\6\16\1\uffff\1\16\1\53\3\16\1\57\1\16\1\uffff\3\16\1\uffff\1\64\1\65"+
		"\2\16\2\uffff\1\70\1\16\1\uffff\1\16\1\73\1\uffff";
	static final String DFA4_eofS =
		"\74\uffff";
	static final String DFA4_minS =
		"\1\11\6\uffff\1\154\2\uffff\1\156\2\157\1\162\2\uffff\1\56\2\uffff\1\141"+
		"\1\164\1\165\1\151\1\142\1\151\2\uffff\1\163\1\60\1\142\1\144\1\154\1"+
		"\166\1\164\1\163\1\uffff\1\154\1\60\1\151\1\141\1\145\1\60\1\145\1\uffff"+
		"\1\143\1\164\1\143\1\uffff\2\60\1\145\1\164\2\uffff\1\60\1\145\1\uffff"+
		"\1\144\1\60\1\uffff";
	static final String DFA4_maxS =
		"\1\175\6\uffff\1\154\2\uffff\1\156\2\157\1\165\2\uffff\1\71\2\uffff\1"+
		"\141\1\164\1\165\1\151\1\142\1\157\2\uffff\1\163\1\172\1\142\1\144\1\154"+
		"\1\166\1\164\1\163\1\uffff\1\154\1\172\1\151\1\141\1\145\1\172\1\145\1"+
		"\uffff\1\143\1\164\1\143\1\uffff\2\172\1\145\1\164\2\uffff\1\172\1\145"+
		"\1\uffff\1\144\1\172\1\uffff";
	static final String DFA4_acceptS =
		"\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\uffff\1\10\1\11\4\uffff\1\20\1\21\1"+
		"\uffff\1\24\1\25\6\uffff\1\23\1\22\10\uffff\1\12\7\uffff\1\14\3\uffff"+
		"\1\7\4\uffff\1\13\1\15\2\uffff\1\16\2\uffff\1\17";
	static final String DFA4_specialS =
		"\74\uffff}>";
	static final String[] DFA4_transitionS = {
			"\2\17\2\uffff\1\17\22\uffff\1\17\7\uffff\1\1\1\2\1\3\1\4\1\22\1\5\2\uffff"+
			"\12\20\1\uffff\1\21\1\uffff\1\6\3\uffff\32\16\4\uffff\1\16\1\uffff\2"+
			"\16\1\7\1\13\4\16\1\12\6\16\1\15\5\16\1\14\4\16\1\10\1\uffff\1\11",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\23",
			"",
			"",
			"\1\24",
			"\1\25",
			"\1\26",
			"\1\30\2\uffff\1\27",
			"",
			"",
			"\1\32\1\uffff\12\20",
			"",
			"",
			"\1\33",
			"\1\34",
			"\1\35",
			"\1\36",
			"\1\37",
			"\1\40\5\uffff\1\41",
			"",
			"",
			"\1\42",
			"\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
			"\1\44",
			"\1\45",
			"\1\46",
			"\1\47",
			"\1\50",
			"\1\51",
			"",
			"\1\52",
			"\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
			"\1\54",
			"\1\55",
			"\1\56",
			"\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
			"\1\60",
			"",
			"\1\61",
			"\1\62",
			"\1\63",
			"",
			"\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
			"\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
			"\1\66",
			"\1\67",
			"",
			"",
			"\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
			"\1\71",
			"",
			"\1\72",
			"\12\16\7\uffff\32\16\4\uffff\1\16\1\uffff\32\16",
			""
	};

	static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
	static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
	static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
	static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
	static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
	static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
	static final short[][] DFA4_transition;

	static {
		int numStates = DFA4_transitionS.length;
		DFA4_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
		}
	}

	protected class DFA4 extends DFA {

		public DFA4(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 4;
			this.eot = DFA4_eot;
			this.eof = DFA4_eof;
			this.min = DFA4_min;
			this.max = DFA4_max;
			this.accept = DFA4_accept;
			this.special = DFA4_special;
			this.transition = DFA4_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | INT | DOUBLE | VOID | PUBLIC | PRIVATE | PROTECTED | ID | WS | CDOUBLE | CINT | SEMICOLON | COMMA );";
		}
	}

}
