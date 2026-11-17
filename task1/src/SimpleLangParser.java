// Generated from C:/Users/Jack/Documents/coursework/coursework/task1/src/SimpleLang.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class SimpleLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LParen=1, Comma=2, RParen=3, LBrace=4, Semicolon=5, RBrace=6, Eq=7, Less=8, 
		LessEq=9, Plus=10, Times=11, Minus=12, Assign=13, Print=14, Space=15, 
		NewLine=16, If=17, Then=18, Else=19, IntType=20, BoolType=21, UnitType=22, 
		Greater=23, GreaterEq=24, Divide=25, And=26, Or=27, Xor=28, Not=29, While=30, 
		Do=31, Repeat=32, Until=33, Skip=34, True=35, False=36, IntLit=37, Idfr=38, 
		WS=39, Invalid=40;
	public static final int
		RULE_prog = 0, RULE_dec = 1, RULE_typed_idfr = 2, RULE_type = 3, RULE_body = 4, 
		RULE_block = 5, RULE_exp = 6, RULE_unop = 7, RULE_binop = 8;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "dec", "typed_idfr", "type", "body", "block", "exp", "unop", 
			"binop"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "','", "')'", "'{'", "';'", "'}'", "'=='", "'<'", "'<='", 
			"'+'", "'*'", "'-'", "':='", "'print'", "'space'", "'newline'", "'if'", 
			"'then'", "'else'", "'int'", "'bool'", "'unit'", "'>'", "'>='", "'/'", 
			"'&'", "'|'", "'^'", "'~'", "'while'", "'do'", "'repeat'", "'until'", 
			"'skip'", "'true'", "'false'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LParen", "Comma", "RParen", "LBrace", "Semicolon", "RBrace", "Eq", 
			"Less", "LessEq", "Plus", "Times", "Minus", "Assign", "Print", "Space", 
			"NewLine", "If", "Then", "Else", "IntType", "BoolType", "UnitType", "Greater", 
			"GreaterEq", "Divide", "And", "Or", "Xor", "Not", "While", "Do", "Repeat", 
			"Until", "Skip", "True", "False", "IntLit", "Idfr", "WS", "Invalid"
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
	public String getGrammarFileName() { return "SimpleLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SimpleLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(SimpleLangParser.EOF, 0); }
		public List<DecContext> dec() {
			return getRuleContexts(DecContext.class);
		}
		public DecContext dec(int i) {
			return getRuleContext(DecContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(19); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(18);
				dec();
				}
				}
				setState(21); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 7340032L) != 0) );
			setState(23);
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

	@SuppressWarnings("CheckReturnValue")
	public static class DecContext extends ParserRuleContext {
		public Typed_idfrContext typed_idfr;
		public List<Typed_idfrContext> vardec = new ArrayList<Typed_idfrContext>();
		public List<Typed_idfrContext> typed_idfr() {
			return getRuleContexts(Typed_idfrContext.class);
		}
		public Typed_idfrContext typed_idfr(int i) {
			return getRuleContext(Typed_idfrContext.class,i);
		}
		public TerminalNode LParen() { return getToken(SimpleLangParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(SimpleLangParser.RParen, 0); }
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public List<TerminalNode> Comma() { return getTokens(SimpleLangParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SimpleLangParser.Comma, i);
		}
		public DecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dec; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitDec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecContext dec() throws RecognitionException {
		DecContext _localctx = new DecContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_dec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(25);
			typed_idfr();
			setState(26);
			match(LParen);
			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 7340032L) != 0)) {
				{
				setState(27);
				((DecContext)_localctx).typed_idfr = typed_idfr();
				((DecContext)_localctx).vardec.add(((DecContext)_localctx).typed_idfr);
				setState(32);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(28);
					match(Comma);
					setState(29);
					((DecContext)_localctx).typed_idfr = typed_idfr();
					((DecContext)_localctx).vardec.add(((DecContext)_localctx).typed_idfr);
					}
					}
					setState(34);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(37);
			match(RParen);
			setState(38);
			body();
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

	@SuppressWarnings("CheckReturnValue")
	public static class Typed_idfrContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode Idfr() { return getToken(SimpleLangParser.Idfr, 0); }
		public Typed_idfrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typed_idfr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitTyped_idfr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Typed_idfrContext typed_idfr() throws RecognitionException {
		Typed_idfrContext _localctx = new Typed_idfrContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_typed_idfr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			type();
			setState(41);
			match(Idfr);
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TerminalNode IntType() { return getToken(SimpleLangParser.IntType, 0); }
		public TerminalNode BoolType() { return getToken(SimpleLangParser.BoolType, 0); }
		public TerminalNode UnitType() { return getToken(SimpleLangParser.UnitType, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 7340032L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class BodyContext extends ParserRuleContext {
		public Typed_idfrContext typed_idfr;
		public List<Typed_idfrContext> localVar = new ArrayList<Typed_idfrContext>();
		public ExpContext exp;
		public List<ExpContext> localInit = new ArrayList<ExpContext>();
		public List<ExpContext> ene = new ArrayList<ExpContext>();
		public TerminalNode LBrace() { return getToken(SimpleLangParser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(SimpleLangParser.RBrace, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public List<TerminalNode> Assign() { return getTokens(SimpleLangParser.Assign); }
		public TerminalNode Assign(int i) {
			return getToken(SimpleLangParser.Assign, i);
		}
		public List<TerminalNode> Semicolon() { return getTokens(SimpleLangParser.Semicolon); }
		public TerminalNode Semicolon(int i) {
			return getToken(SimpleLangParser.Semicolon, i);
		}
		public List<Typed_idfrContext> typed_idfr() {
			return getRuleContexts(Typed_idfrContext.class);
		}
		public Typed_idfrContext typed_idfr(int i) {
			return getRuleContext(Typed_idfrContext.class,i);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			match(LBrace);
			setState(53);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 7340032L) != 0)) {
				{
				{
				setState(46);
				((BodyContext)_localctx).typed_idfr = typed_idfr();
				((BodyContext)_localctx).localVar.add(((BodyContext)_localctx).typed_idfr);
				setState(47);
				match(Assign);
				setState(48);
				((BodyContext)_localctx).exp = exp();
				((BodyContext)_localctx).localInit.add(((BodyContext)_localctx).exp);
				setState(49);
				match(Semicolon);
				}
				}
				setState(55);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(56);
			((BodyContext)_localctx).exp = exp();
			((BodyContext)_localctx).ene.add(((BodyContext)_localctx).exp);
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Semicolon) {
				{
				{
				setState(57);
				match(Semicolon);
				setState(58);
				((BodyContext)_localctx).exp = exp();
				((BodyContext)_localctx).ene.add(((BodyContext)_localctx).exp);
				}
				}
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(64);
			match(RBrace);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public ExpContext exp;
		public List<ExpContext> ene = new ArrayList<ExpContext>();
		public TerminalNode LBrace() { return getToken(SimpleLangParser.LBrace, 0); }
		public TerminalNode RBrace() { return getToken(SimpleLangParser.RBrace, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public List<TerminalNode> Semicolon() { return getTokens(SimpleLangParser.Semicolon); }
		public TerminalNode Semicolon(int i) {
			return getToken(SimpleLangParser.Semicolon, i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(LBrace);
			setState(67);
			((BlockContext)_localctx).exp = exp();
			((BlockContext)_localctx).ene.add(((BlockContext)_localctx).exp);
			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Semicolon) {
				{
				{
				setState(68);
				match(Semicolon);
				setState(69);
				((BlockContext)_localctx).exp = exp();
				((BlockContext)_localctx).ene.add(((BlockContext)_localctx).exp);
				}
				}
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(75);
			match(RBrace);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ExpContext extends ParserRuleContext {
		public ExpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp; }
	 
		public ExpContext() { }
		public void copyFrom(ExpContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SkipExprContext extends ExpContext {
		public TerminalNode Skip() { return getToken(SimpleLangParser.Skip, 0); }
		public SkipExprContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitSkipExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WhileExprContext extends ExpContext {
		public TerminalNode While() { return getToken(SimpleLangParser.While, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode Do() { return getToken(SimpleLangParser.Do, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public WhileExprContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitWhileExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfExprContext extends ExpContext {
		public TerminalNode If() { return getToken(SimpleLangParser.If, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public TerminalNode Then() { return getToken(SimpleLangParser.Then, 0); }
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public TerminalNode Else() { return getToken(SimpleLangParser.Else, 0); }
		public IfExprContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitIfExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TrueExprContext extends ExpContext {
		public TerminalNode True() { return getToken(SimpleLangParser.True, 0); }
		public TrueExprContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitTrueExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdExprContext extends ExpContext {
		public TerminalNode Idfr() { return getToken(SimpleLangParser.Idfr, 0); }
		public IdExprContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitIdExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnOpExprContext extends ExpContext {
		public UnopContext unop() {
			return getRuleContext(UnopContext.class,0);
		}
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public UnOpExprContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitUnOpExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SpaceExprContext extends ExpContext {
		public TerminalNode Space() { return getToken(SimpleLangParser.Space, 0); }
		public SpaceExprContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitSpaceExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrintExprContext extends ExpContext {
		public TerminalNode Print() { return getToken(SimpleLangParser.Print, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public PrintExprContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitPrintExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NewLineExprContext extends ExpContext {
		public TerminalNode NewLine() { return getToken(SimpleLangParser.NewLine, 0); }
		public NewLineExprContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitNewLineExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BlockExprContext extends ExpContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public BlockExprContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitBlockExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignExprContext extends ExpContext {
		public TerminalNode Idfr() { return getToken(SimpleLangParser.Idfr, 0); }
		public TerminalNode Assign() { return getToken(SimpleLangParser.Assign, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public AssignExprContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitAssignExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FalseExprContext extends ExpContext {
		public TerminalNode False() { return getToken(SimpleLangParser.False, 0); }
		public FalseExprContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitFalseExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InvokeExprContext extends ExpContext {
		public ExpContext exp;
		public List<ExpContext> args = new ArrayList<ExpContext>();
		public TerminalNode Idfr() { return getToken(SimpleLangParser.Idfr, 0); }
		public TerminalNode LParen() { return getToken(SimpleLangParser.LParen, 0); }
		public TerminalNode RParen() { return getToken(SimpleLangParser.RParen, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(SimpleLangParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(SimpleLangParser.Comma, i);
		}
		public InvokeExprContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitInvokeExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RepeatExprContext extends ExpContext {
		public TerminalNode Repeat() { return getToken(SimpleLangParser.Repeat, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode Until() { return getToken(SimpleLangParser.Until, 0); }
		public ExpContext exp() {
			return getRuleContext(ExpContext.class,0);
		}
		public RepeatExprContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitRepeatExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BinOpExprContext extends ExpContext {
		public TerminalNode LParen() { return getToken(SimpleLangParser.LParen, 0); }
		public List<ExpContext> exp() {
			return getRuleContexts(ExpContext.class);
		}
		public ExpContext exp(int i) {
			return getRuleContext(ExpContext.class,i);
		}
		public BinopContext binop() {
			return getRuleContext(BinopContext.class,0);
		}
		public TerminalNode RParen() { return getToken(SimpleLangParser.RParen, 0); }
		public BinOpExprContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitBinOpExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntExprContext extends ExpContext {
		public TerminalNode IntLit() { return getToken(SimpleLangParser.IntLit, 0); }
		public IntExprContext(ExpContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitIntExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpContext exp() throws RecognitionException {
		ExpContext _localctx = new ExpContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_exp);
		int _la;
		try {
			setState(129);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new AssignExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				match(Idfr);
				setState(78);
				match(Assign);
				setState(79);
				exp();
				}
				break;
			case 2:
				_localctx = new BinOpExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(80);
				match(LParen);
				setState(81);
				exp();
				setState(82);
				binop();
				setState(83);
				exp();
				setState(84);
				match(RParen);
				}
				break;
			case 3:
				_localctx = new InvokeExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(86);
				match(Idfr);
				setState(87);
				match(LParen);
				setState(96);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 538481774610L) != 0)) {
					{
					setState(88);
					((InvokeExprContext)_localctx).exp = exp();
					((InvokeExprContext)_localctx).args.add(((InvokeExprContext)_localctx).exp);
					setState(93);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==Comma) {
						{
						{
						setState(89);
						match(Comma);
						setState(90);
						((InvokeExprContext)_localctx).exp = exp();
						((InvokeExprContext)_localctx).args.add(((InvokeExprContext)_localctx).exp);
						}
						}
						setState(95);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(98);
				match(RParen);
				}
				break;
			case 4:
				_localctx = new BlockExprContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(99);
				block();
				}
				break;
			case 5:
				_localctx = new IfExprContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(100);
				match(If);
				setState(101);
				exp();
				setState(102);
				match(Then);
				setState(103);
				block();
				setState(104);
				match(Else);
				setState(105);
				block();
				}
				break;
			case 6:
				_localctx = new PrintExprContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(107);
				match(Print);
				setState(108);
				exp();
				}
				break;
			case 7:
				_localctx = new SpaceExprContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(109);
				match(Space);
				}
				break;
			case 8:
				_localctx = new IdExprContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(110);
				match(Idfr);
				}
				break;
			case 9:
				_localctx = new IntExprContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(111);
				match(IntLit);
				}
				break;
			case 10:
				_localctx = new NewLineExprContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(112);
				match(NewLine);
				}
				break;
			case 11:
				_localctx = new SkipExprContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(113);
				match(Skip);
				}
				break;
			case 12:
				_localctx = new TrueExprContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(114);
				match(True);
				}
				break;
			case 13:
				_localctx = new FalseExprContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(115);
				match(False);
				}
				break;
			case 14:
				_localctx = new UnOpExprContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(116);
				unop();
				setState(117);
				exp();
				}
				break;
			case 15:
				_localctx = new WhileExprContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(119);
				match(While);
				setState(120);
				exp();
				setState(121);
				match(Do);
				setState(122);
				block();
				}
				break;
			case 16:
				_localctx = new RepeatExprContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(124);
				match(Repeat);
				setState(125);
				block();
				setState(126);
				match(Until);
				setState(127);
				exp();
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

	@SuppressWarnings("CheckReturnValue")
	public static class UnopContext extends ParserRuleContext {
		public UnopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unop; }
	 
		public UnopContext() { }
		public void copyFrom(UnopContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotUnopContext extends UnopContext {
		public TerminalNode Not() { return getToken(SimpleLangParser.Not, 0); }
		public NotUnopContext(UnopContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitNotUnop(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MinusUnopContext extends UnopContext {
		public TerminalNode Minus() { return getToken(SimpleLangParser.Minus, 0); }
		public MinusUnopContext(UnopContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitMinusUnop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnopContext unop() throws RecognitionException {
		UnopContext _localctx = new UnopContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_unop);
		try {
			setState(133);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Minus:
				_localctx = new MinusUnopContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(131);
				match(Minus);
				}
				break;
			case Not:
				_localctx = new NotUnopContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(132);
				match(Not);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BinopContext extends ParserRuleContext {
		public BinopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binop; }
	 
		public BinopContext() { }
		public void copyFrom(BinopContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndBinopContext extends BinopContext {
		public TerminalNode And() { return getToken(SimpleLangParser.And, 0); }
		public AndBinopContext(BinopContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitAndBinop(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TimesBinopContext extends BinopContext {
		public TerminalNode Times() { return getToken(SimpleLangParser.Times, 0); }
		public TimesBinopContext(BinopContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitTimesBinop(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GreaterBinopContext extends BinopContext {
		public TerminalNode Greater() { return getToken(SimpleLangParser.Greater, 0); }
		public GreaterBinopContext(BinopContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitGreaterBinop(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PlusBinopContext extends BinopContext {
		public TerminalNode Plus() { return getToken(SimpleLangParser.Plus, 0); }
		public PlusBinopContext(BinopContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitPlusBinop(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqBinopContext extends BinopContext {
		public TerminalNode Eq() { return getToken(SimpleLangParser.Eq, 0); }
		public EqBinopContext(BinopContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitEqBinop(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GreaterEqBinopContext extends BinopContext {
		public TerminalNode GreaterEq() { return getToken(SimpleLangParser.GreaterEq, 0); }
		public GreaterEqBinopContext(BinopContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitGreaterEqBinop(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LessBinopContext extends BinopContext {
		public TerminalNode Less() { return getToken(SimpleLangParser.Less, 0); }
		public LessBinopContext(BinopContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitLessBinop(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class XorBinopContext extends BinopContext {
		public TerminalNode Xor() { return getToken(SimpleLangParser.Xor, 0); }
		public XorBinopContext(BinopContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitXorBinop(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LessEqBinopContext extends BinopContext {
		public TerminalNode LessEq() { return getToken(SimpleLangParser.LessEq, 0); }
		public LessEqBinopContext(BinopContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitLessEqBinop(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MinusBinopContext extends BinopContext {
		public TerminalNode Minus() { return getToken(SimpleLangParser.Minus, 0); }
		public MinusBinopContext(BinopContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitMinusBinop(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrBinopContext extends BinopContext {
		public TerminalNode Or() { return getToken(SimpleLangParser.Or, 0); }
		public OrBinopContext(BinopContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitOrBinop(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DivideBinopContext extends BinopContext {
		public TerminalNode Divide() { return getToken(SimpleLangParser.Divide, 0); }
		public DivideBinopContext(BinopContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitDivideBinop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinopContext binop() throws RecognitionException {
		BinopContext _localctx = new BinopContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_binop);
		try {
			setState(147);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Eq:
				_localctx = new EqBinopContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(135);
				match(Eq);
				}
				break;
			case Less:
				_localctx = new LessBinopContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(136);
				match(Less);
				}
				break;
			case LessEq:
				_localctx = new LessEqBinopContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(137);
				match(LessEq);
				}
				break;
			case Plus:
				_localctx = new PlusBinopContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(138);
				match(Plus);
				}
				break;
			case Minus:
				_localctx = new MinusBinopContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(139);
				match(Minus);
				}
				break;
			case Times:
				_localctx = new TimesBinopContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(140);
				match(Times);
				}
				break;
			case Greater:
				_localctx = new GreaterBinopContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(141);
				match(Greater);
				}
				break;
			case GreaterEq:
				_localctx = new GreaterEqBinopContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(142);
				match(GreaterEq);
				}
				break;
			case Divide:
				_localctx = new DivideBinopContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(143);
				match(Divide);
				}
				break;
			case And:
				_localctx = new AndBinopContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(144);
				match(And);
				}
				break;
			case Or:
				_localctx = new OrBinopContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(145);
				match(Or);
				}
				break;
			case Xor:
				_localctx = new XorBinopContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(146);
				match(Xor);
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

	public static final String _serializedATN =
		"\u0004\u0001(\u0096\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0001\u0000\u0004\u0000\u0014\b\u0000\u000b\u0000\f\u0000\u0015"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0005\u0001\u001f\b\u0001\n\u0001\f\u0001\"\t\u0001\u0003"+
		"\u0001$\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u00044\b\u0004\n\u0004"+
		"\f\u00047\t\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0005\u0004<\b\u0004"+
		"\n\u0004\f\u0004?\t\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0005\u0005G\b\u0005\n\u0005\f\u0005J\t\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006\\\b\u0006"+
		"\n\u0006\f\u0006_\t\u0006\u0003\u0006a\b\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006"+
		"\u0082\b\u0006\u0001\u0007\u0001\u0007\u0003\u0007\u0086\b\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0003\b\u0094\b\b\u0001\b\u0000\u0000\t\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0000\u0001\u0001\u0000\u0014\u0016\u00af"+
		"\u0000\u0013\u0001\u0000\u0000\u0000\u0002\u0019\u0001\u0000\u0000\u0000"+
		"\u0004(\u0001\u0000\u0000\u0000\u0006+\u0001\u0000\u0000\u0000\b-\u0001"+
		"\u0000\u0000\u0000\nB\u0001\u0000\u0000\u0000\f\u0081\u0001\u0000\u0000"+
		"\u0000\u000e\u0085\u0001\u0000\u0000\u0000\u0010\u0093\u0001\u0000\u0000"+
		"\u0000\u0012\u0014\u0003\u0002\u0001\u0000\u0013\u0012\u0001\u0000\u0000"+
		"\u0000\u0014\u0015\u0001\u0000\u0000\u0000\u0015\u0013\u0001\u0000\u0000"+
		"\u0000\u0015\u0016\u0001\u0000\u0000\u0000\u0016\u0017\u0001\u0000\u0000"+
		"\u0000\u0017\u0018\u0005\u0000\u0000\u0001\u0018\u0001\u0001\u0000\u0000"+
		"\u0000\u0019\u001a\u0003\u0004\u0002\u0000\u001a#\u0005\u0001\u0000\u0000"+
		"\u001b \u0003\u0004\u0002\u0000\u001c\u001d\u0005\u0002\u0000\u0000\u001d"+
		"\u001f\u0003\u0004\u0002\u0000\u001e\u001c\u0001\u0000\u0000\u0000\u001f"+
		"\"\u0001\u0000\u0000\u0000 \u001e\u0001\u0000\u0000\u0000 !\u0001\u0000"+
		"\u0000\u0000!$\u0001\u0000\u0000\u0000\" \u0001\u0000\u0000\u0000#\u001b"+
		"\u0001\u0000\u0000\u0000#$\u0001\u0000\u0000\u0000$%\u0001\u0000\u0000"+
		"\u0000%&\u0005\u0003\u0000\u0000&\'\u0003\b\u0004\u0000\'\u0003\u0001"+
		"\u0000\u0000\u0000()\u0003\u0006\u0003\u0000)*\u0005&\u0000\u0000*\u0005"+
		"\u0001\u0000\u0000\u0000+,\u0007\u0000\u0000\u0000,\u0007\u0001\u0000"+
		"\u0000\u0000-5\u0005\u0004\u0000\u0000./\u0003\u0004\u0002\u0000/0\u0005"+
		"\r\u0000\u000001\u0003\f\u0006\u000012\u0005\u0005\u0000\u000024\u0001"+
		"\u0000\u0000\u00003.\u0001\u0000\u0000\u000047\u0001\u0000\u0000\u0000"+
		"53\u0001\u0000\u0000\u000056\u0001\u0000\u0000\u000068\u0001\u0000\u0000"+
		"\u000075\u0001\u0000\u0000\u00008=\u0003\f\u0006\u00009:\u0005\u0005\u0000"+
		"\u0000:<\u0003\f\u0006\u0000;9\u0001\u0000\u0000\u0000<?\u0001\u0000\u0000"+
		"\u0000=;\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000\u0000>@\u0001\u0000"+
		"\u0000\u0000?=\u0001\u0000\u0000\u0000@A\u0005\u0006\u0000\u0000A\t\u0001"+
		"\u0000\u0000\u0000BC\u0005\u0004\u0000\u0000CH\u0003\f\u0006\u0000DE\u0005"+
		"\u0005\u0000\u0000EG\u0003\f\u0006\u0000FD\u0001\u0000\u0000\u0000GJ\u0001"+
		"\u0000\u0000\u0000HF\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000"+
		"IK\u0001\u0000\u0000\u0000JH\u0001\u0000\u0000\u0000KL\u0005\u0006\u0000"+
		"\u0000L\u000b\u0001\u0000\u0000\u0000MN\u0005&\u0000\u0000NO\u0005\r\u0000"+
		"\u0000O\u0082\u0003\f\u0006\u0000PQ\u0005\u0001\u0000\u0000QR\u0003\f"+
		"\u0006\u0000RS\u0003\u0010\b\u0000ST\u0003\f\u0006\u0000TU\u0005\u0003"+
		"\u0000\u0000U\u0082\u0001\u0000\u0000\u0000VW\u0005&\u0000\u0000W`\u0005"+
		"\u0001\u0000\u0000X]\u0003\f\u0006\u0000YZ\u0005\u0002\u0000\u0000Z\\"+
		"\u0003\f\u0006\u0000[Y\u0001\u0000\u0000\u0000\\_\u0001\u0000\u0000\u0000"+
		"][\u0001\u0000\u0000\u0000]^\u0001\u0000\u0000\u0000^a\u0001\u0000\u0000"+
		"\u0000_]\u0001\u0000\u0000\u0000`X\u0001\u0000\u0000\u0000`a\u0001\u0000"+
		"\u0000\u0000ab\u0001\u0000\u0000\u0000b\u0082\u0005\u0003\u0000\u0000"+
		"c\u0082\u0003\n\u0005\u0000de\u0005\u0011\u0000\u0000ef\u0003\f\u0006"+
		"\u0000fg\u0005\u0012\u0000\u0000gh\u0003\n\u0005\u0000hi\u0005\u0013\u0000"+
		"\u0000ij\u0003\n\u0005\u0000j\u0082\u0001\u0000\u0000\u0000kl\u0005\u000e"+
		"\u0000\u0000l\u0082\u0003\f\u0006\u0000m\u0082\u0005\u000f\u0000\u0000"+
		"n\u0082\u0005&\u0000\u0000o\u0082\u0005%\u0000\u0000p\u0082\u0005\u0010"+
		"\u0000\u0000q\u0082\u0005\"\u0000\u0000r\u0082\u0005#\u0000\u0000s\u0082"+
		"\u0005$\u0000\u0000tu\u0003\u000e\u0007\u0000uv\u0003\f\u0006\u0000v\u0082"+
		"\u0001\u0000\u0000\u0000wx\u0005\u001e\u0000\u0000xy\u0003\f\u0006\u0000"+
		"yz\u0005\u001f\u0000\u0000z{\u0003\n\u0005\u0000{\u0082\u0001\u0000\u0000"+
		"\u0000|}\u0005 \u0000\u0000}~\u0003\n\u0005\u0000~\u007f\u0005!\u0000"+
		"\u0000\u007f\u0080\u0003\f\u0006\u0000\u0080\u0082\u0001\u0000\u0000\u0000"+
		"\u0081M\u0001\u0000\u0000\u0000\u0081P\u0001\u0000\u0000\u0000\u0081V"+
		"\u0001\u0000\u0000\u0000\u0081c\u0001\u0000\u0000\u0000\u0081d\u0001\u0000"+
		"\u0000\u0000\u0081k\u0001\u0000\u0000\u0000\u0081m\u0001\u0000\u0000\u0000"+
		"\u0081n\u0001\u0000\u0000\u0000\u0081o\u0001\u0000\u0000\u0000\u0081p"+
		"\u0001\u0000\u0000\u0000\u0081q\u0001\u0000\u0000\u0000\u0081r\u0001\u0000"+
		"\u0000\u0000\u0081s\u0001\u0000\u0000\u0000\u0081t\u0001\u0000\u0000\u0000"+
		"\u0081w\u0001\u0000\u0000\u0000\u0081|\u0001\u0000\u0000\u0000\u0082\r"+
		"\u0001\u0000\u0000\u0000\u0083\u0086\u0005\f\u0000\u0000\u0084\u0086\u0005"+
		"\u001d\u0000\u0000\u0085\u0083\u0001\u0000\u0000\u0000\u0085\u0084\u0001"+
		"\u0000\u0000\u0000\u0086\u000f\u0001\u0000\u0000\u0000\u0087\u0094\u0005"+
		"\u0007\u0000\u0000\u0088\u0094\u0005\b\u0000\u0000\u0089\u0094\u0005\t"+
		"\u0000\u0000\u008a\u0094\u0005\n\u0000\u0000\u008b\u0094\u0005\f\u0000"+
		"\u0000\u008c\u0094\u0005\u000b\u0000\u0000\u008d\u0094\u0005\u0017\u0000"+
		"\u0000\u008e\u0094\u0005\u0018\u0000\u0000\u008f\u0094\u0005\u0019\u0000"+
		"\u0000\u0090\u0094\u0005\u001a\u0000\u0000\u0091\u0094\u0005\u001b\u0000"+
		"\u0000\u0092\u0094\u0005\u001c\u0000\u0000\u0093\u0087\u0001\u0000\u0000"+
		"\u0000\u0093\u0088\u0001\u0000\u0000\u0000\u0093\u0089\u0001\u0000\u0000"+
		"\u0000\u0093\u008a\u0001\u0000\u0000\u0000\u0093\u008b\u0001\u0000\u0000"+
		"\u0000\u0093\u008c\u0001\u0000\u0000\u0000\u0093\u008d\u0001\u0000\u0000"+
		"\u0000\u0093\u008e\u0001\u0000\u0000\u0000\u0093\u008f\u0001\u0000\u0000"+
		"\u0000\u0093\u0090\u0001\u0000\u0000\u0000\u0093\u0091\u0001\u0000\u0000"+
		"\u0000\u0093\u0092\u0001\u0000\u0000\u0000\u0094\u0011\u0001\u0000\u0000"+
		"\u0000\u000b\u0015 #5=H]`\u0081\u0085\u0093";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}