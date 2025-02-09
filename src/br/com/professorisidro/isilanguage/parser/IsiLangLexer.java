// Generated from IsiLang.g4 by ANTLR 4.7.1
package br.com.professorisidro.isilanguage.parser;

	import br.com.professorisidro.isilanguage.datastructures.IsiSymbol;
	import br.com.professorisidro.isilanguage.datastructures.IsiVariable;
	import br.com.professorisidro.isilanguage.datastructures.IsiSymbolTable;
	import br.com.professorisidro.isilanguage.exceptions.IsiSemanticException;
	import br.com.professorisidro.isilanguage.ast.IsiProgram;
	import br.com.professorisidro.isilanguage.ast.AbstractCommand;
	import br.com.professorisidro.isilanguage.ast.CommandLeitura;
	import br.com.professorisidro.isilanguage.ast.CommandEscrita;
	import br.com.professorisidro.isilanguage.ast.CommandAtribuicao;
	import br.com.professorisidro.isilanguage.ast.CommandDecisao;
	import br.com.professorisidro.isilanguage.ast.CommandEnquanto;
	import java.util.ArrayList;
	import java.util.Stack;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class IsiLangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, AP=11, FP=12, SC=13, OP=14, ATTR=15, VIR=16, ACH=17, FCH=18, 
		OPREL=19, ID=20, NUMBER=21, TEXT=22, WS=23, COMMENT=24, AD=25, P=26;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "AP", "FP", "SC", "OP", "ATTR", "VIR", "ACH", "FCH", "OPREL", 
		"ID", "NUMBER", "TEXT", "WS", "COMMENT", "AD", "P"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'programa'", "'fimprog.'", "'numero'", "'texto'", "'leia'", "'escreva'", 
		"'se'", "'entao'", "'senao'", "'enquanto'", "'('", "')'", "';'", null, 
		"':='", "','", "'{'", "'}'", null, null, null, null, null, null, "'\"'", 
		"'.'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, "AP", 
		"FP", "SC", "OP", "ATTR", "VIR", "ACH", "FCH", "OPREL", "ID", "NUMBER", 
		"TEXT", "WS", "COMMENT", "AD", "P"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


		private int _tipo;
		private String _varName;
		private String _varValue;
		private IsiSymbolTable symbolTable = new IsiSymbolTable();
		private IsiSymbol symbol;
		private IsiProgram program = new IsiProgram();
		private ArrayList<AbstractCommand> curThread;
		private Stack<ArrayList<AbstractCommand>> stack = new Stack<ArrayList<AbstractCommand>>();
		private String _readID;
		private String _writeID;
		private String _exprID;
		private String _exprContent;
		private String _exprDecision;
		private ArrayList<AbstractCommand> listaTrue;
		private ArrayList<AbstractCommand> listaFalse;
		private ArrayList<AbstractCommand> listaWhile;
		
		public void verificaID(String id){
			if (!symbolTable.exists(id)){
				throw new IsiSemanticException("Symbol "+id+" not declared");
			}
			useVar(id);
		}

		public void useVar(String id) {
			IsiVariable var = (IsiVariable) symbolTable.get(id);
			var.setUsedVar(true);
		}
		
		public void exibeComandos(){
			for (AbstractCommand c: program.getComandos()){
				System.out.println(c);
			}
		}
		
		public void generateCode(){
			program.generateTarget();
		}
		
		public void checkIfVarIsUsed(String id) {
			IsiVariable var = (IsiVariable) symbolTable.get(id);
			if (!var.isUsedVar()) {
		       	System.out.println("Warning - Variable " + id + " was declared but not used."); 
			}	
		}
		
		public void compareType(String id, int type){
			IsiVariable var = (IsiVariable) symbolTable.get(id);
			if (var.getType() != type) {
		       	throw new IsiSemanticException("Error: incompatible type for variable " + id + "."); 
			}
		}		


	public IsiLangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "IsiLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\34\u00ca\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b"+
		"\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20"+
		"\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\5\24\u0096\n\24\3\25\3\25\7\25\u009a\n\25\f\25\16\25\u009d"+
		"\13\25\3\26\6\26\u00a0\n\26\r\26\16\26\u00a1\3\26\3\26\6\26\u00a6\n\26"+
		"\r\26\16\26\u00a7\5\26\u00aa\n\26\3\27\3\27\7\27\u00ae\n\27\f\27\16\27"+
		"\u00b1\13\27\3\27\3\27\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\7\31\u00bd"+
		"\n\31\f\31\16\31\u00c0\13\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\33\3"+
		"\33\4\u00af\u00be\2\34\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
		"\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33"+
		"\65\34\3\2\b\5\2,-//\61\61\4\2>>@@\3\2c|\5\2\62;C\\c|\3\2\62;\5\2\13\f"+
		"\17\17\"\"\2\u00d3\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3"+
		"\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\3\67\3\2\2\2"+
		"\5@\3\2\2\2\7I\3\2\2\2\tP\3\2\2\2\13V\3\2\2\2\r[\3\2\2\2\17c\3\2\2\2\21"+
		"f\3\2\2\2\23l\3\2\2\2\25r\3\2\2\2\27{\3\2\2\2\31}\3\2\2\2\33\177\3\2\2"+
		"\2\35\u0081\3\2\2\2\37\u0083\3\2\2\2!\u0086\3\2\2\2#\u0088\3\2\2\2%\u008a"+
		"\3\2\2\2\'\u0095\3\2\2\2)\u0097\3\2\2\2+\u009f\3\2\2\2-\u00ab\3\2\2\2"+
		"/\u00b4\3\2\2\2\61\u00b8\3\2\2\2\63\u00c6\3\2\2\2\65\u00c8\3\2\2\2\67"+
		"8\7r\2\289\7t\2\29:\7q\2\2:;\7i\2\2;<\7t\2\2<=\7c\2\2=>\7o\2\2>?\7c\2"+
		"\2?\4\3\2\2\2@A\7h\2\2AB\7k\2\2BC\7o\2\2CD\7r\2\2DE\7t\2\2EF\7q\2\2FG"+
		"\7i\2\2GH\7\60\2\2H\6\3\2\2\2IJ\7p\2\2JK\7w\2\2KL\7o\2\2LM\7g\2\2MN\7"+
		"t\2\2NO\7q\2\2O\b\3\2\2\2PQ\7v\2\2QR\7g\2\2RS\7z\2\2ST\7v\2\2TU\7q\2\2"+
		"U\n\3\2\2\2VW\7n\2\2WX\7g\2\2XY\7k\2\2YZ\7c\2\2Z\f\3\2\2\2[\\\7g\2\2\\"+
		"]\7u\2\2]^\7e\2\2^_\7t\2\2_`\7g\2\2`a\7x\2\2ab\7c\2\2b\16\3\2\2\2cd\7"+
		"u\2\2de\7g\2\2e\20\3\2\2\2fg\7g\2\2gh\7p\2\2hi\7v\2\2ij\7c\2\2jk\7q\2"+
		"\2k\22\3\2\2\2lm\7u\2\2mn\7g\2\2no\7p\2\2op\7c\2\2pq\7q\2\2q\24\3\2\2"+
		"\2rs\7g\2\2st\7p\2\2tu\7s\2\2uv\7w\2\2vw\7c\2\2wx\7p\2\2xy\7v\2\2yz\7"+
		"q\2\2z\26\3\2\2\2{|\7*\2\2|\30\3\2\2\2}~\7+\2\2~\32\3\2\2\2\177\u0080"+
		"\7=\2\2\u0080\34\3\2\2\2\u0081\u0082\t\2\2\2\u0082\36\3\2\2\2\u0083\u0084"+
		"\7<\2\2\u0084\u0085\7?\2\2\u0085 \3\2\2\2\u0086\u0087\7.\2\2\u0087\"\3"+
		"\2\2\2\u0088\u0089\7}\2\2\u0089$\3\2\2\2\u008a\u008b\7\177\2\2\u008b&"+
		"\3\2\2\2\u008c\u0096\t\3\2\2\u008d\u008e\7@\2\2\u008e\u0096\7?\2\2\u008f"+
		"\u0090\7>\2\2\u0090\u0096\7?\2\2\u0091\u0092\7?\2\2\u0092\u0096\7?\2\2"+
		"\u0093\u0094\7#\2\2\u0094\u0096\7?\2\2\u0095\u008c\3\2\2\2\u0095\u008d"+
		"\3\2\2\2\u0095\u008f\3\2\2\2\u0095\u0091\3\2\2\2\u0095\u0093\3\2\2\2\u0096"+
		"(\3\2\2\2\u0097\u009b\t\4\2\2\u0098\u009a\t\5\2\2\u0099\u0098\3\2\2\2"+
		"\u009a\u009d\3\2\2\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c*\3"+
		"\2\2\2\u009d\u009b\3\2\2\2\u009e\u00a0\t\6\2\2\u009f\u009e\3\2\2\2\u00a0"+
		"\u00a1\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a9\3\2"+
		"\2\2\u00a3\u00a5\7\60\2\2\u00a4\u00a6\t\6\2\2\u00a5\u00a4\3\2\2\2\u00a6"+
		"\u00a7\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00aa\3\2"+
		"\2\2\u00a9\u00a3\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa,\3\2\2\2\u00ab\u00af"+
		"\5\63\32\2\u00ac\u00ae\13\2\2\2\u00ad\u00ac\3\2\2\2\u00ae\u00b1\3\2\2"+
		"\2\u00af\u00b0\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0\u00b2\3\2\2\2\u00b1\u00af"+
		"\3\2\2\2\u00b2\u00b3\5\63\32\2\u00b3.\3\2\2\2\u00b4\u00b5\t\7\2\2\u00b5"+
		"\u00b6\3\2\2\2\u00b6\u00b7\b\30\2\2\u00b7\60\3\2\2\2\u00b8\u00b9\7\61"+
		"\2\2\u00b9\u00ba\7,\2\2\u00ba\u00be\3\2\2\2\u00bb\u00bd\13\2\2\2\u00bc"+
		"\u00bb\3\2\2\2\u00bd\u00c0\3\2\2\2\u00be\u00bf\3\2\2\2\u00be\u00bc\3\2"+
		"\2\2\u00bf\u00c1\3\2\2\2\u00c0\u00be\3\2\2\2\u00c1\u00c2\7,\2\2\u00c2"+
		"\u00c3\7\61\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c5\b\31\2\2\u00c5\62\3\2"+
		"\2\2\u00c6\u00c7\7$\2\2\u00c7\64\3\2\2\2\u00c8\u00c9\7\60\2\2\u00c9\66"+
		"\3\2\2\2\13\2\u0095\u0099\u009b\u00a1\u00a7\u00a9\u00af\u00be\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}