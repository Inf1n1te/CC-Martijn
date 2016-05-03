package pp.block2.cc.antlr.arithmetic;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.math.BigInteger;

public class Calculator extends ArithmeticBaseListener {

    ParseTreeProperty<BigInteger> valueMap = new ParseTreeProperty<>();
    BigInteger result;

    public BigInteger parse(Lexer lexer) {
        ArithmeticParser parser = new ArithmeticParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.expr();
        new ParseTreeWalker().walk(this, tree);
        return result;
    }

    @Override
    public void exitExprPar(@NotNull ArithmeticParser.ExprParContext ctx) {
        valueMap.put(ctx, valueMap.get(ctx.expr()));
        result = valueMap.get(ctx);
    }

    @Override
    public void exitExprNum(@NotNull ArithmeticParser.ExprNumContext ctx) {
        valueMap.put(ctx, valueMap.get(ctx.num()));
        result = valueMap.get(ctx);
    }

    @Override
    public void exitExprOpL1(@NotNull ArithmeticParser.ExprOpL1Context ctx) {
        switch (ctx.OPERATORL1().getText()) {
            case "/":
                valueMap.put(ctx, valueMap.get(ctx.expr(0)).divide(valueMap.get(ctx.expr(1))));
                break;
            case "*":
                valueMap.put(ctx, valueMap.get(ctx.expr(0)).multiply(valueMap.get(ctx.expr(1))));
                break;
        }
        result = valueMap.get(ctx);
    }

    @Override
    public void exitExprOpL2(@NotNull ArithmeticParser.ExprOpL2Context ctx) {
        if (ctx.OPERATORL2() == null) {
            valueMap.put(ctx, valueMap.get(ctx.expr(0)).subtract(valueMap.get(ctx.expr(1))));
        } else {
            valueMap.put(ctx, valueMap.get(ctx.expr(0)).add(valueMap.get(ctx.expr(1))));

        }

        result = valueMap.get(ctx);
    }

	/*@Override
    public void exitExprMin(@NotNull ArithmeticParser.ExprMinContext ctx) {
		valueMap.put(ctx, valueMap.get(ctx.expr(0)).subtract(valueMap.get(ctx.expr(1))));
		result = valueMap.get(ctx);
	}*/

    @Override
    public void exitExprOpR(@NotNull ArithmeticParser.ExprOpRContext ctx) {
        valueMap.put(ctx, valueMap.get(ctx.expr(0)).pow(valueMap.get(ctx.expr(1)).intValue()));
        result = valueMap.get(ctx);
    }

    @Override
    public void exitNumNeg(@NotNull ArithmeticParser.NumNegContext ctx) {
        valueMap.put(ctx, valueMap.get(ctx.num()).negate());
    }

    @Override
    public void exitNumPos(@NotNull ArithmeticParser.NumPosContext ctx) {
        valueMap.put(ctx, valueMap.get(ctx.NUMBER()));
    }

    @Override
    public void visitTerminal(@NotNull TerminalNode node) {
        if (!"+-*/^()".contains(node.getText())) {
            valueMap.put(node, new BigInteger(node.getText()));
        }
    }
}
