import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.*;

public class SimpleLangInterpreter extends AbstractParseTreeVisitor<Integer> implements SimpleLangVisitor<Integer> {

    private final Map<String, SimpleLangParser.DecContext> global_funcs = new HashMap<>();
    private final Stack<Map<String, Integer>> frames = new Stack<>();


    //searches the tree for syntax errors recursively returning true if errors are found returning false only when everything is clean
    private boolean hasSyntaxError(ParseTree node) {
        if (node instanceof ErrorNode) {        //token was skipped or invented
            return true;
        }
        if (node instanceof ParserRuleContext && ((ParserRuleContext) node).exception != null) {   //rule failed partway through
            return true;
        }
       //checks each child; if errors are found down the tree then its passed back up the tree
        for (int i = 0; i < node.getChildCount(); i++) {
            if (hasSyntaxError(node.getChild(i))) {
                return true;
            }
        }
        return false;
    }

    //enforces parameters and locals must have different names and none may share names with a function
    private void checkNames(SimpleLangParser.DecContext dec) {
        Set<String> seen = new HashSet<>();
        for (SimpleLangParser.Typed_idfrContext param : dec.vardec) {
            String name = param.Idfr().getText();
            if (global_funcs.containsKey(name) || !seen.add(name)) {  //checks if names clash with a function or if its already used by another parameter/local
                throw new RuntimeException("bad name: " + name);
            }
        }
        for (SimpleLangParser.Typed_idfrContext local : dec.body().localVar) {
            String name = local.Idfr().getText();
            if (global_funcs.containsKey(name) || !seen.add(name)) {   //same check for locals and function names
                throw new RuntimeException("bad name: " + name);
            }
        }
    }

    //visits every node recursively and rejects bad function calls as well as undelcared variables
    private void checkUses(ParseTree node, Set<String> known) {
        //when using a variable it must be declared and initialised
        if (node instanceof SimpleLangParser.IdExprContext) {
            SimpleLangParser.IdExprContext id = (SimpleLangParser.IdExprContext) node;
            if (!known.contains(id.Idfr().getText())) {
                throw new RuntimeException("Undeclared variable");
            }
        }

        //when assigning a variable it msut be declared
        if (node instanceof SimpleLangParser.AssignExprContext) {
            SimpleLangParser.AssignExprContext assign = (SimpleLangParser.AssignExprContext) node;
            if (!known.contains(assign.Idfr().getText())) {
                throw new RuntimeException("Undeclared variable");
            }
        }

        //when calling a function it must exist as well as be given the corret number of arguments
        if (node instanceof SimpleLangParser.InvokeExprContext) {
            SimpleLangParser.InvokeExprContext call = (SimpleLangParser.InvokeExprContext) node;
            SimpleLangParser.DecContext target = global_funcs.get(call.Idfr().getText());

            if (target == null) {
                throw new RuntimeException("expression is empty");
            }
            if (call.args.size() != target.vardec.size()) {
                throw new RuntimeException("Parameter count doesn't match");
            }
        }

        //recursively call for every child so the entire expression is checked for
        for (int i = 0; i < node.getChildCount(); i++) {
            checkUses(node.getChild(i), known);
        }
    }

    //decides what variables are usable at each point of the function, passing the parts into check uses
    private void checkBody(SimpleLangParser.DecContext dec) {
        //when parameters are usable everywhere in the body
        Set<String> known = new HashSet<>();
        for (SimpleLangParser.Typed_idfrContext param : dec.vardec) {
            known.add(param.Idfr().getText());
        }
        SimpleLangParser.BodyContext body = dec.body();
        //they become usable in order only one at a time as each intialiser is checked before its local is added
        for (int i = 0; i < body.localVar.size(); i++) {
            checkUses(body.localInit.get(i), known);
            known.add(body.localVar.get(i).Idfr().getText());
        }
        //it can use everything
        for (SimpleLangParser.ExpContext exp : body.ene) {
            checkUses(exp, known);
        }

    }

    private enum Type {INT, BOOL, UNIT} //list of languages three types

    //converts types into Type
    private Type toType(SimpleLangParser.TypeContext t) {
        if (t.IntType() != null) return Type.INT;
        if (t.BoolType() != null) return Type.BOOL;
        return Type.UNIT;
    }

    //returns the expression type given any expression (env = symbol table, p = expression to check)
    private Type check(HashMap<String, Type> env, ParseTree p) {

        if (p instanceof SimpleLangParser.IntExprContext) {  // integer itsefl
            return Type.INT;
        } else if (p instanceof SimpleLangParser.TrueExprContext) {    //true type bool
            return Type.BOOL;
        } else if (p instanceof SimpleLangParser.FalseExprContext) {  //false type bool
            return Type.BOOL;
        } else if (p instanceof SimpleLangParser.SkipExprContext) {   //skip type unit
            return Type.UNIT;
        } else if (p instanceof SimpleLangParser.SpaceExprContext) {  //space type unit
            return Type.UNIT;
        } else if (p instanceof SimpleLangParser.NewLineExprContext) {  //newline type unit
            return Type.UNIT;
        } else if (p instanceof SimpleLangParser.IdExprContext) {     //variable, its declared type from env
            SimpleLangParser.IdExprContext id = (SimpleLangParser.IdExprContext) p;
            return env.get(id.Idfr().getText());
        } else if (p instanceof SimpleLangParser.BinOpExprContext) {    //a binary operator, checks both operands and do neccessary rule for whichever group its in
            SimpleLangParser.BinOpExprContext b = (SimpleLangParser.BinOpExprContext) p;
            Type lhsType = check(env, b.exp(0));
            Type rhsType = check(env, b.exp(1));
            int op = ((TerminalNode) b.binop().getChild(0)).getSymbol().getType();


            //& | ^ both are bool and gives bool
            if (op == SimpleLangParser.And || op == SimpleLangParser.Or || op == SimpleLangParser.Xor) {
                if (lhsType != Type.BOOL || rhsType != Type.BOOL) {
                    throw new RuntimeException("type error");
                }
                return Type.BOOL;
            }

            //==, <,>, <= >= both are int and give bool
            if (op == SimpleLangParser.Eq || op == SimpleLangParser.Less || op == SimpleLangParser.LessEq || op == SimpleLangParser.Greater || op == SimpleLangParser.GreaterEq) {
                if (lhsType != Type.INT || rhsType != Type.INT) {
                    throw new RuntimeException("Type check error");
                }
                return Type.BOOL;
            }
            //standard arithmatic funtions all int and give int
            if (op == SimpleLangParser.Plus || op == SimpleLangParser.Minus || op == SimpleLangParser.Times || op == SimpleLangParser.Divide) {
                if (lhsType != Type.INT || rhsType != Type.INT) {
                    throw new RuntimeException("Type check error");
                }
                return  Type.INT;
            }
        }
        else if (p instanceof SimpleLangParser.WhileExprContext){    //a while so condition must be bool, and body must be unit and gives a unit
            SimpleLangParser.WhileExprContext w = (SimpleLangParser.WhileExprContext) p;
            Type condType = check(env, w.exp());
            Type bodyType = check(env, w.block());
            if (condType != Type.BOOL || bodyType != Type.UNIT) {
                throw new RuntimeException("type error");
            }
            return Type.UNIT;
        }
        else if (p instanceof SimpleLangParser.BlockContext){   //a block so checks every expression giving the last ones type
            SimpleLangParser.BlockContext blk = (SimpleLangParser.BlockContext) p;
            Type last = null;
            for (SimpleLangParser.ExpContext e : blk.ene) {
                last = check(env, e);
            }
            return last;
        }
        else if (p instanceof SimpleLangParser.RepeatExprContext) {    //a repeat so condition must be bool, and body must be unit and gives a unit
            SimpleLangParser.RepeatExprContext r = (SimpleLangParser.RepeatExprContext) p;
            Type condType = check(env, r.exp());
            Type bodyType = check(env, r.block());
            if (condType != Type.BOOL || bodyType != Type.UNIT) {
                throw new RuntimeException("type error");
            }
            return Type.UNIT;
        }
        else if (p instanceof SimpleLangParser.BlockExprContext) {   //block but used as an expression giving the blocks type
            SimpleLangParser.BlockExprContext be = (SimpleLangParser.BlockExprContext) p;
            return check(env, be.block());
        }
        else if (p instanceof SimpleLangParser.UnOpExprContext) {   //a unary so - needs an int and ~ needs a bool and both give the same type
            SimpleLangParser.UnOpExprContext u = (SimpleLangParser.UnOpExprContext) p;
            Type operandType = check(env, u.exp());
            int op = ((TerminalNode) u.unop().getChild(0)).getSymbol().getType();
            Type needed = (op == SimpleLangParser.Minus) ? Type.INT : Type.BOOL;
            if (operandType != needed) {
                throw new RuntimeException("type error");
            }
            return needed;
        }
        else if (p instanceof SimpleLangParser.AssignExprContext) {  //an assignment so the variable and value have the same type and gives a unit
            SimpleLangParser.AssignExprContext a = (SimpleLangParser.AssignExprContext) p;
            Type lhsType = env.get(a.Idfr().getText());
            Type rhsType = check(env,a.exp());
            if (rhsType != lhsType) {
                throw new RuntimeException("type error");
            }
            return Type.UNIT;
        }
        else if (p instanceof SimpleLangParser.IfExprContext) {   //an if statement so condition is bool, both blocks must be the same type and gives that type
            SimpleLangParser.IfExprContext i = (SimpleLangParser.IfExprContext) p;
            Type condType = check(env, i.exp());
            Type thenType = check(env,i.block(0));
            Type elseType = check(env,i.block(1));
            if (condType != Type.BOOL   || thenType != elseType) {
                throw new RuntimeException("type error");
            }
            return thenType;
        }
        else if (p instanceof SimpleLangParser.PrintExprContext){   //a print so it can be a space, newline or int and gives a unit
            SimpleLangParser.PrintExprContext pr = (SimpleLangParser.PrintExprContext) p;
            SimpleLangParser.ExpContext e = pr.exp();
            if(!(e instanceof SimpleLangParser.SpaceExprContext)        //isnt a space
               && !(e instanceof SimpleLangParser.NewLineExprContext)   //AND isnt a newline
            && check(env, e) != Type.INT) {                             //AND isnt an int
                throw new RuntimeException("type error");
            }
            return Type.UNIT;
        }
        else if (p instanceof SimpleLangParser.InvokeExprContext) {  //a call so each argument must match the parameters type and gives the functions return type
            SimpleLangParser.InvokeExprContext call = (SimpleLangParser.InvokeExprContext) p;
            SimpleLangParser.DecContext target = global_funcs.get(call.Idfr().getText());

            for (int i = 0; i < call.args.size(); i++) {
                Type argType = check(env, call.args.get(i));
                Type paramType = toType(target.vardec.get(i).type());
                if (argType != paramType) {
                    throw new RuntimeException("type error");
                }
            }

            return toType(target.typed_idfr(0).type());
        }
        //any expression that isnt handled is rejected
        throw new RuntimeException("type error");
    }






    public Integer visitProgram(SimpleLangParser.ProgContext ctx, String[] args)
    {
        if (hasSyntaxError(ctx)){                       //checks if parser hits syntax error
            throw new RuntimeException("Syntax error");
        }
        for (int i = 0; i < ctx.dec().size(); ++i) {       //builds the name to function table rejecting duplicate names

            SimpleLangParser.DecContext dec = ctx.dec(i);
            SimpleLangParser.Typed_idfrContext typedIdfr = dec.typed_idfr(0);
            if (global_funcs.containsKey(typedIdfr.Idfr().getText())) {
                throw new RuntimeException("Duplicate function");
            }
            global_funcs.put(typedIdfr.Idfr().getText(), dec);
        }
        SimpleLangParser.DecContext main = global_funcs.get("main");
        if (main == null){                  //makes sure there is a main
            throw new RuntimeException("There's no main function");
        }

        if (args.length != main.vardec.size()){                   //main must receive correct number of arguments
            throw new RuntimeException("Parameter count doesn't match");
        }
            //carries out semantic checks for every function before any code runs
        for (int i = 0; i < ctx.dec().size(); ++i) {
            checkNames(ctx.dec(i));
            checkBody(ctx.dec(i));
        }


         //converts arguments into values ready for mains parameters (TRUE/FALSE becomes --> 1/0 etc)
        Map<String, Integer> newFrame = new HashMap<>();
        for (int i = 0; i < args.length; ++i) {
            if (args[i].equals("true")) {
                newFrame.put(main.vardec.get(i).Idfr().getText(), 1);
            } else if (args[i].equals("false")) {
                newFrame.put(main.vardec.get(i).Idfr().getText(), 0);
            } else {
                newFrame.put(main.vardec.get(i).Idfr().getText(), Integer.parseInt(args[i]));
            }
        }

        frames.push(newFrame);   //push mains frame and runs it, the result goes to task1
        return visit(main);

    }

    @Override public Integer visitProg(SimpleLangParser.ProgContext ctx)
    {

        throw new RuntimeException("Should not be here!");

    }


    //pops its frame so the stack can return to the caller's after running the functino body, it returns the bodys value
    @Override public Integer visitDec(SimpleLangParser.DecContext ctx)
    {

        Integer returnValue = visit(ctx.body());
        frames.pop();
        return returnValue;

    }

    @Override public Integer visitTyped_idfr(SimpleLangParser.Typed_idfrContext ctx)
    {
        throw new RuntimeException("Should not be here!");
    }

    @Override public Integer visitType(SimpleLangParser.TypeContext ctx)
    {
        throw new RuntimeException("Should not be here!");
    }

       //adds all the locals in order to the current frame and then runs each expression returning the last expression value
    @Override public Integer visitBody(SimpleLangParser.BodyContext ctx) {

        for (int i =0; i < ctx.localVar.size(); i++) {
            SimpleLangParser.Typed_idfrContext var = ctx.localVar.get(i);
            SimpleLangParser.ExpContext init = ctx.localInit.get(i);
            frames.peek().put(var.Idfr().getText(), visit(init));
        }

        Integer returnValue = null;
        for (int i = 0; i < ctx.ene.size(); ++i) {
            SimpleLangParser.ExpContext exp = ctx.ene.get(i);
            returnValue = visit(exp);
        }
        return returnValue;

    }

    //in order runs all expressions in the block and then returns the last ones value
    @Override public Integer visitBlock(SimpleLangParser.BlockContext ctx)
    {
        Integer returnValue = null;
        for (int i = 0; i < ctx.ene.size(); ++i) {
            SimpleLangParser.ExpContext exp = ctx.ene.get(i);
            returnValue = visit(exp);
        }
        return returnValue;
    }

    @Override public Integer visitAssignExpr(SimpleLangParser.AssignExprContext ctx)
    {

        SimpleLangParser.ExpContext rhs = ctx.exp();
        frames.peek().replace(ctx.Idfr().getText(), visit(rhs));
        return null;

    }

    //all binary operators evaluating both operands and appliying the neccessary operation
    @Override public Integer visitBinOpExpr(SimpleLangParser.BinOpExprContext ctx) {

        //checks both operands
        SimpleLangParser.ExpContext operand1 = ctx.exp(0);
        Integer oprnd1 = visit(operand1);
        SimpleLangParser.ExpContext operand2 = ctx.exp(1);
        Integer oprnd2 = visit(operand2);


        //reads what operator it is straight from the binop token
        switch (((TerminalNode) (ctx.binop().getChild(0))).getSymbol().getType()) {


            //gives true/false converted to 1/0
            case SimpleLangParser.Eq ->  {
                return ((Objects.equals(oprnd1, oprnd2)) ? 1 : 0);
            }
            case SimpleLangParser.Less -> {
                return ((oprnd1 < oprnd2) ? 1 : 0);
            }
            case SimpleLangParser.LessEq -> {
                return ((oprnd1 <= oprnd2) ? 1 : 0);

            }
            //arithmatic gives int
            case SimpleLangParser.Plus -> {
                return oprnd1 + oprnd2;
            }
            case SimpleLangParser.Minus -> {
                return oprnd1 - oprnd2;
            }
            case SimpleLangParser.Times -> {
                return oprnd1 * oprnd2;
            }
            //more comparisons
            case SimpleLangParser.Greater -> {
                return ((oprnd1 > oprnd2) ? 1 : 0);
            }
            case SimpleLangParser.GreaterEq -> {
                return ((oprnd1 >= oprnd2) ? 1 : 0);
            }
            //division
            case SimpleLangParser.Divide -> {
                return oprnd1 / oprnd2;
            }
            //boolean operators
            case SimpleLangParser.And -> {
                return oprnd1 & oprnd2;
            }
            case SimpleLangParser.Or -> {
                return oprnd1 | oprnd2;
            }
            case SimpleLangParser.Xor -> {
                return oprnd1 ^ oprnd2;
            }
            //doesnt match grammar
            default -> {
                throw new RuntimeException("Shouldn't be here - wrong binary operator.");
            }

        }

    }

    //calls a function, then evluates its arguments matching it to the parameter names in a new frame then pushing it and running the function
    @Override public Integer visitInvokeExpr(SimpleLangParser.InvokeExprContext ctx) {
        SimpleLangParser.DecContext dec = global_funcs.get(ctx.Idfr().getText());
        Map<String, Integer> newFrame = new HashMap<>();
        for (int i = 0; i < dec.vardec.size(); i++) {         //arguments get checked before they are pushed, so their variables are looked up in the callers frame
            SimpleLangParser.Typed_idfrContext param = dec.vardec.get(i);
            SimpleLangParser.ExpContext exp = ctx.args.get(i);
            newFrame.put(param.Idfr().getText(), visit(exp));
        }
        frames.push(newFrame);
        return visit(dec);
    }

    @Override public Integer visitBlockExpr(SimpleLangParser.BlockExprContext ctx) {
        return visit(ctx.block());
    }

    @Override public Integer visitIfExpr(SimpleLangParser.IfExprContext ctx)
    {

        SimpleLangParser.ExpContext cond = ctx.exp();
        Integer condValue = visit(cond);
        if (condValue > 0) {

            SimpleLangParser.BlockContext thenBlock = ctx.block(0);
            return visit(thenBlock);

        } else {

            SimpleLangParser.BlockContext elseBlock = ctx.block(1);
            return visit(elseBlock);

        }

    }

    //if its a space output a space, linebreak for newline, otherwise just he exp value, returns null
    @Override public Integer visitPrintExpr(SimpleLangParser.PrintExprContext ctx) {

        SimpleLangParser.ExpContext exp = ctx.exp();

        if (exp instanceof SimpleLangParser.SpaceExprContext) {

            System.out.print(" ");

        } else if (exp instanceof SimpleLangParser.NewLineExprContext) {

            System.out.println();

        } else {

            System.out.print(visit(exp));

        }

        return null;

    }

    @Override public Integer visitSpaceExpr(SimpleLangParser.SpaceExprContext ctx) {
        return null;
    }

    @Override public Integer visitIdExpr(SimpleLangParser.IdExprContext ctx)
    {
        return frames.peek().get(ctx.Idfr().getText());
    }

    @Override public Integer visitIntExpr(SimpleLangParser.IntExprContext ctx)
    {

        return Integer.parseInt(ctx.IntLit().getText());

    }


    @Override public Integer visitNewLineExpr(SimpleLangParser.NewLineExprContext ctx) {
        return null;
    }

    @Override public Integer visitSkipExpr(SimpleLangParser.SkipExprContext ctx) {
        return null;
    }

    @Override public Integer visitTrueExpr(SimpleLangParser.TrueExprContext ctx) {
        return 1;
    }

    @Override public Integer visitFalseExpr(SimpleLangParser.FalseExprContext ctx) {
        return 0;
    }

    @Override public Integer visitMinusUnop(SimpleLangParser.MinusUnopContext ctx) {
        throw new RuntimeException("Should not be here!");
    }

    @Override public Integer visitNotUnop(SimpleLangParser.NotUnopContext ctx) {
        throw new RuntimeException("Should not be here!");
    }
    //checks the condition before each run stopping when its false, unit so returns null
    @Override public Integer visitWhileExpr(SimpleLangParser.WhileExprContext ctx) {
        SimpleLangParser.ExpContext cond = ctx.exp();
        SimpleLangParser.BlockContext block = ctx.block();
        while (visit(cond) > 0){
            visitBlock(block);
        }
        return null;
    }
    //first runs the block, then repeats the loop whilst the condition is false then returns null as its unit
    @Override public Integer visitRepeatExpr(SimpleLangParser.RepeatExprContext ctx) {
        SimpleLangParser.ExpContext cond = ctx.exp();
        SimpleLangParser.BlockContext block = ctx.block();
        do {
            visitBlock(block);
        } while(visit(cond) == 0);
        return null;
    }

    // ~ flips a bool & - negates an int
    @Override public Integer visitUnOpExpr(SimpleLangParser.UnOpExprContext ctx){
        Integer operand = visit(ctx.exp());
        switch (((TerminalNode) (ctx.unop().getChild(0))).getSymbol().getType()) {
            case SimpleLangParser.Minus -> {
                return -operand;
            }
            case SimpleLangParser.Not -> {

                return (operand != 1) ? 1 : 0;

            }
            default -> {
                throw new RuntimeException("Shouldn't be here - wrong unary operator.");
            }

        }

    }

    @Override public Integer visitEqBinop(SimpleLangParser.EqBinopContext ctx) {
        throw new RuntimeException("Should not be here!");
    }
    @Override public Integer visitLessBinop(SimpleLangParser.LessBinopContext ctx) {
        throw new RuntimeException("Should not be here!");
    }
    @Override public Integer visitLessEqBinop(SimpleLangParser.LessEqBinopContext ctx) {
        throw new RuntimeException("Should not be here!");
    }
    @Override public Integer visitPlusBinop(SimpleLangParser.PlusBinopContext ctx) {
        throw new RuntimeException("Should not be here!");
    }
    @Override public Integer visitMinusBinop(SimpleLangParser.MinusBinopContext ctx) {
        throw new RuntimeException("Should not be here!");
    }
    @Override public Integer visitTimesBinop(SimpleLangParser.TimesBinopContext ctx) {
        throw new RuntimeException("Should not be here!");
    }
    @Override public Integer visitGreaterBinop(SimpleLangParser.GreaterBinopContext ctx) {
        throw new RuntimeException("Should not be here!");
    }
    @Override public Integer visitGreaterEqBinop(SimpleLangParser.GreaterEqBinopContext ctx) {
        throw new RuntimeException("Should not be here!");
    }
    @Override public Integer visitDivideBinop(SimpleLangParser.DivideBinopContext ctx) {
        throw new RuntimeException("Should not be here!");
    }
    @Override public Integer visitAndBinop(SimpleLangParser.AndBinopContext ctx) {
        throw new RuntimeException("Should not be here!");
    }
    @Override public Integer visitOrBinop(SimpleLangParser.OrBinopContext ctx) {
        throw new RuntimeException("Should not be here!");
    }
    @Override public Integer visitXorBinop(SimpleLangParser.XorBinopContext ctx) {
        throw new RuntimeException("Should not be here!");
    }
}
