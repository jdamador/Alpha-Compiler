// Generated from /home/jushu/Documentos/Repositorios/Alpha-Compiler/Alpha/Parser2.g4 by ANTLR 4.7.2
package generated;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Parser2 extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PyCOMA=1, ASSIGN=2, PIZQ=3, PDER=4, VIR=5, DOSPUN=6, SUM=7, SUB=8, MUL=9, 
		DIV=10, SMALLER=11, BIGGER=12, SMALEQ=13, BIGEQ=14, EQUAL=15, AND=16, 
		OR=17, IF=18, WHILE=19, LET=20, THEN=21, ELSE=22, IN=23, DO=24, BEGIN=25, 
		END=26, CONST=27, VAR=28, PRINT=29, BOOL=30, ID=31, NUM=32, STRING=33, 
		SPECIAL_STRING=34, WS=35;
	public static final int
		RULE_program = 0, RULE_command = 1, RULE_singleCommand = 2, RULE_declaration = 3, 
		RULE_singleDeclaration = 4, RULE_typeDenoter = 5, RULE_expression = 6, 
		RULE_primaryExpression = 7, RULE_operator = 8;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "command", "singleCommand", "declaration", "singleDeclaration", 
			"typeDenoter", "expression", "primaryExpression", "operator"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "':='", "'('", "')'", "'~'", "':'", "'+'", "'-'", "'*'", 
			"'/'", "'<'", "'>'", "'>='", "'<='", "'=='", "'&&'", "'||'", "'if'", 
			"'while'", "'let'", "'then'", "'else'", "'in'", "'do'", "'begin'", "'end'", 
			"'const'", "'var'", "'print'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PyCOMA", "ASSIGN", "PIZQ", "PDER", "VIR", "DOSPUN", "SUM", "SUB", 
			"MUL", "DIV", "SMALLER", "BIGGER", "SMALEQ", "BIGEQ", "EQUAL", "AND", 
			"OR", "IF", "WHILE", "LET", "THEN", "ELSE", "IN", "DO", "BEGIN", "END", 
			"CONST", "VAR", "PRINT", "BOOL", "ID", "NUM", "STRING", "SPECIAL_STRING", 
			"WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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

	@Override
	public String getGrammarFileName() { return "Parser2.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public Parser2(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	 
		public ProgramContext() { }
		public void copyFrom(ProgramContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ProgramASTContext extends ProgramContext {
		public SingleCommandContext singleCommand() {
			return getRuleContext(SingleCommandContext.class,0);
		}
		public TerminalNode EOF() { return getToken(Parser2.EOF, 0); }
		public ProgramASTContext(ProgramContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Parser2Visitor ) return ((Parser2Visitor<? extends T>)visitor).visitProgramAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			_localctx = new ProgramASTContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			singleCommand();
			setState(19);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CommandContext extends ParserRuleContext {
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
	 
		public CommandContext() { }
		public void copyFrom(CommandContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class CommandASTContext extends CommandContext {
		public List<SingleCommandContext> singleCommand() {
			return getRuleContexts(SingleCommandContext.class);
		}
		public SingleCommandContext singleCommand(int i) {
			return getRuleContext(SingleCommandContext.class,i);
		}
		public List<TerminalNode> PyCOMA() { return getTokens(Parser2.PyCOMA); }
		public TerminalNode PyCOMA(int i) {
			return getToken(Parser2.PyCOMA, i);
		}
		public CommandASTContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Parser2Visitor ) return ((Parser2Visitor<? extends T>)visitor).visitCommandAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_command);
		int _la;
		try {
			_localctx = new CommandASTContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			singleCommand();
			setState(26);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PyCOMA) {
				{
				{
				setState(22);
				match(PyCOMA);
				setState(23);
				singleCommand();
				}
				}
				setState(28);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleCommandContext extends ParserRuleContext {
		public SingleCommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleCommand; }
	 
		public SingleCommandContext() { }
		public void copyFrom(SingleCommandContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class LetSCASTContext extends SingleCommandContext {
		public TerminalNode LET() { return getToken(Parser2.LET, 0); }
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public TerminalNode IN() { return getToken(Parser2.IN, 0); }
		public SingleCommandContext singleCommand() {
			return getRuleContext(SingleCommandContext.class,0);
		}
		public LetSCASTContext(SingleCommandContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Parser2Visitor ) return ((Parser2Visitor<? extends T>)visitor).visitLetSCAST(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CallSCASTContext extends SingleCommandContext {
		public TerminalNode ID() { return getToken(Parser2.ID, 0); }
		public TerminalNode PIZQ() { return getToken(Parser2.PIZQ, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode PDER() { return getToken(Parser2.PDER, 0); }
		public CallSCASTContext(SingleCommandContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Parser2Visitor ) return ((Parser2Visitor<? extends T>)visitor).visitCallSCAST(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrintSCASTContext extends SingleCommandContext {
		public TerminalNode PRINT() { return getToken(Parser2.PRINT, 0); }
		public TerminalNode PIZQ() { return getToken(Parser2.PIZQ, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode PDER() { return getToken(Parser2.PDER, 0); }
		public PrintSCASTContext(SingleCommandContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Parser2Visitor ) return ((Parser2Visitor<? extends T>)visitor).visitPrintSCAST(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BeginSCASTContext extends SingleCommandContext {
		public TerminalNode BEGIN() { return getToken(Parser2.BEGIN, 0); }
		public CommandContext command() {
			return getRuleContext(CommandContext.class,0);
		}
		public TerminalNode END() { return getToken(Parser2.END, 0); }
		public BeginSCASTContext(SingleCommandContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Parser2Visitor ) return ((Parser2Visitor<? extends T>)visitor).visitBeginSCAST(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignSCASTContext extends SingleCommandContext {
		public TerminalNode ID() { return getToken(Parser2.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(Parser2.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignSCASTContext(SingleCommandContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Parser2Visitor ) return ((Parser2Visitor<? extends T>)visitor).visitAssignSCAST(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileSCASTContext extends SingleCommandContext {
		public TerminalNode WHILE() { return getToken(Parser2.WHILE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DO() { return getToken(Parser2.DO, 0); }
		public SingleCommandContext singleCommand() {
			return getRuleContext(SingleCommandContext.class,0);
		}
		public WhileSCASTContext(SingleCommandContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Parser2Visitor ) return ((Parser2Visitor<? extends T>)visitor).visitWhileSCAST(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfSCASTContext extends SingleCommandContext {
		public TerminalNode IF() { return getToken(Parser2.IF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode THEN() { return getToken(Parser2.THEN, 0); }
		public List<SingleCommandContext> singleCommand() {
			return getRuleContexts(SingleCommandContext.class);
		}
		public SingleCommandContext singleCommand(int i) {
			return getRuleContext(SingleCommandContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(Parser2.ELSE, 0); }
		public IfSCASTContext(SingleCommandContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Parser2Visitor ) return ((Parser2Visitor<? extends T>)visitor).visitIfSCAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleCommandContext singleCommand() throws RecognitionException {
		SingleCommandContext _localctx = new SingleCommandContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_singleCommand);
		try {
			setState(63);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new AssignSCASTContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(29);
				match(ID);
				setState(30);
				match(ASSIGN);
				setState(31);
				expression();
				}
				break;
			case 2:
				_localctx = new CallSCASTContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(32);
				match(ID);
				setState(33);
				match(PIZQ);
				setState(34);
				expression();
				setState(35);
				match(PDER);
				}
				break;
			case 3:
				_localctx = new IfSCASTContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(37);
				match(IF);
				setState(38);
				expression();
				setState(39);
				match(THEN);
				setState(40);
				singleCommand();
				setState(41);
				match(ELSE);
				setState(42);
				singleCommand();
				}
				break;
			case 4:
				_localctx = new WhileSCASTContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(44);
				match(WHILE);
				setState(45);
				expression();
				setState(46);
				match(DO);
				setState(47);
				singleCommand();
				}
				break;
			case 5:
				_localctx = new LetSCASTContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(49);
				match(LET);
				setState(50);
				declaration();
				setState(51);
				match(IN);
				setState(52);
				singleCommand();
				}
				break;
			case 6:
				_localctx = new BeginSCASTContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(54);
				match(BEGIN);
				setState(55);
				command();
				setState(56);
				match(END);
				}
				break;
			case 7:
				_localctx = new PrintSCASTContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(58);
				match(PRINT);
				setState(59);
				match(PIZQ);
				setState(60);
				expression();
				setState(61);
				match(PDER);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
	 
		public DeclarationContext() { }
		public void copyFrom(DeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DeclarationASTContext extends DeclarationContext {
		public List<SingleDeclarationContext> singleDeclaration() {
			return getRuleContexts(SingleDeclarationContext.class);
		}
		public SingleDeclarationContext singleDeclaration(int i) {
			return getRuleContext(SingleDeclarationContext.class,i);
		}
		public List<TerminalNode> PyCOMA() { return getTokens(Parser2.PyCOMA); }
		public TerminalNode PyCOMA(int i) {
			return getToken(Parser2.PyCOMA, i);
		}
		public DeclarationASTContext(DeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Parser2Visitor ) return ((Parser2Visitor<? extends T>)visitor).visitDeclarationAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_declaration);
		int _la;
		try {
			_localctx = new DeclarationASTContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			singleDeclaration();
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PyCOMA) {
				{
				{
				setState(66);
				match(PyCOMA);
				setState(67);
				singleDeclaration();
				}
				}
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleDeclarationContext extends ParserRuleContext {
		public SingleDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleDeclaration; }
	 
		public SingleDeclarationContext() { }
		public void copyFrom(SingleDeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ConstSTASTContext extends SingleDeclarationContext {
		public TerminalNode CONST() { return getToken(Parser2.CONST, 0); }
		public TerminalNode ID() { return getToken(Parser2.ID, 0); }
		public TerminalNode VIR() { return getToken(Parser2.VIR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ConstSTASTContext(SingleDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Parser2Visitor ) return ((Parser2Visitor<? extends T>)visitor).visitConstSTAST(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarASTContext extends SingleDeclarationContext {
		public TerminalNode VAR() { return getToken(Parser2.VAR, 0); }
		public TerminalNode ID() { return getToken(Parser2.ID, 0); }
		public TerminalNode DOSPUN() { return getToken(Parser2.DOSPUN, 0); }
		public TypeDenoterContext typeDenoter() {
			return getRuleContext(TypeDenoterContext.class,0);
		}
		public VarASTContext(SingleDeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Parser2Visitor ) return ((Parser2Visitor<? extends T>)visitor).visitVarAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleDeclarationContext singleDeclaration() throws RecognitionException {
		SingleDeclarationContext _localctx = new SingleDeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_singleDeclaration);
		try {
			setState(81);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONST:
				_localctx = new ConstSTASTContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(73);
				match(CONST);
				setState(74);
				match(ID);
				setState(75);
				match(VIR);
				setState(76);
				expression();
				}
				break;
			case VAR:
				_localctx = new VarASTContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(77);
				match(VAR);
				setState(78);
				match(ID);
				setState(79);
				match(DOSPUN);
				setState(80);
				typeDenoter();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeDenoterContext extends ParserRuleContext {
		public TypeDenoterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDenoter; }
	 
		public TypeDenoterContext() { }
		public void copyFrom(TypeDenoterContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TypeDenoterASTContext extends TypeDenoterContext {
		public TerminalNode ID() { return getToken(Parser2.ID, 0); }
		public TypeDenoterASTContext(TypeDenoterContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Parser2Visitor ) return ((Parser2Visitor<? extends T>)visitor).visitTypeDenoterAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeDenoterContext typeDenoter() throws RecognitionException {
		TypeDenoterContext _localctx = new TypeDenoterContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_typeDenoter);
		try {
			_localctx = new TypeDenoterASTContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExpressionASTContext extends ExpressionContext {
		public List<PrimaryExpressionContext> primaryExpression() {
			return getRuleContexts(PrimaryExpressionContext.class);
		}
		public PrimaryExpressionContext primaryExpression(int i) {
			return getRuleContext(PrimaryExpressionContext.class,i);
		}
		public List<OperatorContext> operator() {
			return getRuleContexts(OperatorContext.class);
		}
		public OperatorContext operator(int i) {
			return getRuleContext(OperatorContext.class,i);
		}
		public ExpressionASTContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Parser2Visitor ) return ((Parser2Visitor<? extends T>)visitor).visitExpressionAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_expression);
		int _la;
		try {
			_localctx = new ExpressionASTContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			primaryExpression();
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SUM) | (1L << SUB) | (1L << MUL) | (1L << DIV) | (1L << SMALLER) | (1L << BIGGER) | (1L << SMALEQ) | (1L << BIGEQ) | (1L << EQUAL) | (1L << AND) | (1L << OR))) != 0)) {
				{
				{
				setState(86);
				operator();
				setState(87);
				primaryExpression();
				}
				}
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryExpressionContext extends ParserRuleContext {
		public PrimaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpression; }
	 
		public PrimaryExpressionContext() { }
		public void copyFrom(PrimaryExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class BoolPrimaryExpASTContext extends PrimaryExpressionContext {
		public TerminalNode BOOL() { return getToken(Parser2.BOOL, 0); }
		public BoolPrimaryExpASTContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Parser2Visitor ) return ((Parser2Visitor<? extends T>)visitor).visitBoolPrimaryExpAST(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringPrimaryExpASTContext extends PrimaryExpressionContext {
		public TerminalNode STRING() { return getToken(Parser2.STRING, 0); }
		public TerminalNode SPECIAL_STRING() { return getToken(Parser2.SPECIAL_STRING, 0); }
		public StringPrimaryExpASTContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Parser2Visitor ) return ((Parser2Visitor<? extends T>)visitor).visitStringPrimaryExpAST(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NumPrimaryExpASTContext extends PrimaryExpressionContext {
		public TerminalNode NUM() { return getToken(Parser2.NUM, 0); }
		public NumPrimaryExpASTContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Parser2Visitor ) return ((Parser2Visitor<? extends T>)visitor).visitNumPrimaryExpAST(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdPrimaryExpASTContext extends PrimaryExpressionContext {
		public TerminalNode ID() { return getToken(Parser2.ID, 0); }
		public IdPrimaryExpASTContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Parser2Visitor ) return ((Parser2Visitor<? extends T>)visitor).visitIdPrimaryExpAST(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GroupPEASTContext extends PrimaryExpressionContext {
		public TerminalNode PIZQ() { return getToken(Parser2.PIZQ, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode PDER() { return getToken(Parser2.PDER, 0); }
		public GroupPEASTContext(PrimaryExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Parser2Visitor ) return ((Parser2Visitor<? extends T>)visitor).visitGroupPEAST(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryExpressionContext primaryExpression() throws RecognitionException {
		PrimaryExpressionContext _localctx = new PrimaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_primaryExpression);
		int _la;
		try {
			setState(102);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUM:
				_localctx = new NumPrimaryExpASTContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(94);
				match(NUM);
				}
				break;
			case BOOL:
				_localctx = new BoolPrimaryExpASTContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(95);
				match(BOOL);
				}
				break;
			case ID:
				_localctx = new IdPrimaryExpASTContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(96);
				match(ID);
				}
				break;
			case STRING:
			case SPECIAL_STRING:
				_localctx = new StringPrimaryExpASTContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(97);
				_la = _input.LA(1);
				if ( !(_la==STRING || _la==SPECIAL_STRING) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case PIZQ:
				_localctx = new GroupPEASTContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(98);
				match(PIZQ);
				setState(99);
				expression();
				setState(100);
				match(PDER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperatorContext extends ParserRuleContext {
		public TerminalNode SUM() { return getToken(Parser2.SUM, 0); }
		public TerminalNode SUB() { return getToken(Parser2.SUB, 0); }
		public TerminalNode MUL() { return getToken(Parser2.MUL, 0); }
		public TerminalNode DIV() { return getToken(Parser2.DIV, 0); }
		public TerminalNode SMALLER() { return getToken(Parser2.SMALLER, 0); }
		public TerminalNode BIGGER() { return getToken(Parser2.BIGGER, 0); }
		public TerminalNode SMALEQ() { return getToken(Parser2.SMALEQ, 0); }
		public TerminalNode BIGEQ() { return getToken(Parser2.BIGEQ, 0); }
		public TerminalNode EQUAL() { return getToken(Parser2.EQUAL, 0); }
		public TerminalNode AND() { return getToken(Parser2.AND, 0); }
		public TerminalNode OR() { return getToken(Parser2.OR, 0); }
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof Parser2Visitor ) return ((Parser2Visitor<? extends T>)visitor).visitOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SUM) | (1L << SUB) | (1L << MUL) | (1L << DIV) | (1L << SMALLER) | (1L << BIGGER) | (1L << SMALEQ) | (1L << BIGEQ) | (1L << EQUAL) | (1L << AND) | (1L << OR))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3%m\4\2\t\2\4\3\t\3"+
		"\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\3\2\3\2\3"+
		"\3\3\3\3\3\7\3\33\n\3\f\3\16\3\36\13\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4B\n\4\3\5\3\5\3\5\7\5G\n\5\f\5\16"+
		"\5J\13\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6T\n\6\3\7\3\7\3\b\3\b\3\b"+
		"\3\b\7\b\\\n\b\f\b\16\b_\13\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\ti\n\t"+
		"\3\n\3\n\3\n\2\2\13\2\4\6\b\n\f\16\20\22\2\4\3\2#$\3\2\t\23\2q\2\24\3"+
		"\2\2\2\4\27\3\2\2\2\6A\3\2\2\2\bC\3\2\2\2\nS\3\2\2\2\fU\3\2\2\2\16W\3"+
		"\2\2\2\20h\3\2\2\2\22j\3\2\2\2\24\25\5\6\4\2\25\26\7\2\2\3\26\3\3\2\2"+
		"\2\27\34\5\6\4\2\30\31\7\3\2\2\31\33\5\6\4\2\32\30\3\2\2\2\33\36\3\2\2"+
		"\2\34\32\3\2\2\2\34\35\3\2\2\2\35\5\3\2\2\2\36\34\3\2\2\2\37 \7!\2\2 "+
		"!\7\4\2\2!B\5\16\b\2\"#\7!\2\2#$\7\5\2\2$%\5\16\b\2%&\7\6\2\2&B\3\2\2"+
		"\2\'(\7\24\2\2()\5\16\b\2)*\7\27\2\2*+\5\6\4\2+,\7\30\2\2,-\5\6\4\2-B"+
		"\3\2\2\2./\7\25\2\2/\60\5\16\b\2\60\61\7\32\2\2\61\62\5\6\4\2\62B\3\2"+
		"\2\2\63\64\7\26\2\2\64\65\5\b\5\2\65\66\7\31\2\2\66\67\5\6\4\2\67B\3\2"+
		"\2\289\7\33\2\29:\5\4\3\2:;\7\34\2\2;B\3\2\2\2<=\7\37\2\2=>\7\5\2\2>?"+
		"\5\16\b\2?@\7\6\2\2@B\3\2\2\2A\37\3\2\2\2A\"\3\2\2\2A\'\3\2\2\2A.\3\2"+
		"\2\2A\63\3\2\2\2A8\3\2\2\2A<\3\2\2\2B\7\3\2\2\2CH\5\n\6\2DE\7\3\2\2EG"+
		"\5\n\6\2FD\3\2\2\2GJ\3\2\2\2HF\3\2\2\2HI\3\2\2\2I\t\3\2\2\2JH\3\2\2\2"+
		"KL\7\35\2\2LM\7!\2\2MN\7\7\2\2NT\5\16\b\2OP\7\36\2\2PQ\7!\2\2QR\7\b\2"+
		"\2RT\5\f\7\2SK\3\2\2\2SO\3\2\2\2T\13\3\2\2\2UV\7!\2\2V\r\3\2\2\2W]\5\20"+
		"\t\2XY\5\22\n\2YZ\5\20\t\2Z\\\3\2\2\2[X\3\2\2\2\\_\3\2\2\2][\3\2\2\2]"+
		"^\3\2\2\2^\17\3\2\2\2_]\3\2\2\2`i\7\"\2\2ai\7 \2\2bi\7!\2\2ci\t\2\2\2"+
		"de\7\5\2\2ef\5\16\b\2fg\7\6\2\2gi\3\2\2\2h`\3\2\2\2ha\3\2\2\2hb\3\2\2"+
		"\2hc\3\2\2\2hd\3\2\2\2i\21\3\2\2\2jk\t\3\2\2k\23\3\2\2\2\b\34AHS]h";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}