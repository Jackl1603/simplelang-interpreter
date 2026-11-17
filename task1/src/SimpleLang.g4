//where the interpreter gets its lexer and praser from, rejecting programs that dont follow the rules stated
grammar SimpleLang;

prog : dec+ EOF; //the whole program: one or more function followed by end of function


//a function: return type(typed_idfr), parameters(vardec+=) and the functions body
dec
    : typed_idfr LParen (vardec+=typed_idfr (Comma vardec+=typed_idfr)*)? RParen body
;

//a type and name
typed_idfr
    : type Idfr
;

//bool, int or unit
type
    : IntType | BoolType | UnitType
;

//Function body: local variables and then expressions(ene)
body
    : LBrace (localVar+=typed_idfr Assign localInit+=exp Semicolon )* ene+=exp (Semicolon ene+=exp)* RBrace
;

//one or more expresions in {}, without locals
block
    : LBrace ene+=exp (Semicolon ene+=exp)* RBrace
;


//every kind of exp
exp
    : Idfr Assign exp                                       #AssignExpr
    | LParen exp binop exp RParen                           #BinOpExpr
    | Idfr LParen (args+=exp (Comma args+=exp)*)? RParen    #InvokeExpr
    | block                                                 #BlockExpr
    | If exp Then block Else block                          #IfExpr
    | Print exp                                             #PrintExpr
    | Space                                                 #SpaceExpr
    | Idfr                                                  #IdExpr
    | IntLit                                                #IntExpr
    | NewLine                                               #NewLineExpr
    | Skip                                                  #SkipExpr
    | True                                                  #TrueExpr
    | False                                                 #FalseExpr
    | unop exp                                              #UnOpExpr
    | While exp Do block                                    #WhileExpr
    | Repeat block Until exp                                #RepeatExpr
;

//unary operators: '~' negates a bool and '-' negates an int.
unop
    : Minus           #MinusUnop
    | Not             #NotUnop
;
binop
    : Eq              #EqBinop
    | Less            #LessBinop
    | LessEq          #LessEqBinop
    | Plus            #PlusBinop
    | Minus           #MinusBinop
    | Times           #TimesBinop
    | Greater         #GreaterBinop
    | GreaterEq       #GreaterEqBinop
    | Divide          #DivideBinop
    | And             #AndBinop
    | Or              #OrBinop
    | Xor             #XorBinop;

//lexer rules that split up the input text into tokens, longest match winning, if its a tie then the earlier rule wins
LParen : '(' ;
Comma : ',' ;
RParen : ')' ;
LBrace : '{' ;
Semicolon : ';' ;
RBrace : '}' ;

Eq : '==' ;
Less : '<' ;
LessEq : '<=' ;

Plus : '+' ;
Times : '*' ;
Minus : '-' ;

Assign : ':=' ;

Print : 'print' ;
Space : 'space' ;
NewLine : 'newline' ;
If : 'if' ;
Then : 'then' ;
Else : 'else' ;

IntType : 'int' ;
BoolType : 'bool' ;
UnitType : 'unit' ;

Greater : '>' ;
GreaterEq : '>=' ;
Divide : '/' ;
And : '&' ;
Or : '|' ;
Xor : '^' ;
Not : '~' ;
While: 'while' ;
Do : 'do' ;
Repeat : 'repeat' ;
Until : 'until' ;
Skip : 'skip' ;
True: 'true' ;
False: 'false' ;


IntLit : '0' | ('-'? [1-9][0-9]*) ;
Idfr : [a-z][A-Za-z0-9_]* ;
WS : [ \n\r\t]+ -> skip ; //whitespace is used to seperate tokens however its thrown away

Invalid: . ; //if any character isnt matched then it becomes invalid token so the parser will flag an error