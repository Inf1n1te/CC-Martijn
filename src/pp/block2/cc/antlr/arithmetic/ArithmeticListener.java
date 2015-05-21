// Generated from Arithmetic.g4 by ANTLR 4.4
package pp.block2.cc.antlr.arithmetic;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ArithmeticParser}.
 */
public interface ArithmeticListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code exprOpL2}
	 * labeled alternative in {@link ArithmeticParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprOpL2(@NotNull ArithmeticParser.ExprOpL2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code exprOpL2}
	 * labeled alternative in {@link ArithmeticParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprOpL2(@NotNull ArithmeticParser.ExprOpL2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code numPos}
	 * labeled alternative in {@link ArithmeticParser#num}.
	 * @param ctx the parse tree
	 */
	void enterNumPos(@NotNull ArithmeticParser.NumPosContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numPos}
	 * labeled alternative in {@link ArithmeticParser#num}.
	 * @param ctx the parse tree
	 */
	void exitNumPos(@NotNull ArithmeticParser.NumPosContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprOpL1}
	 * labeled alternative in {@link ArithmeticParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprOpL1(@NotNull ArithmeticParser.ExprOpL1Context ctx);
	/**
	 * Exit a parse tree produced by the {@code exprOpL1}
	 * labeled alternative in {@link ArithmeticParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprOpL1(@NotNull ArithmeticParser.ExprOpL1Context ctx);
	/**
	 * Enter a parse tree produced by the {@code exprPar}
	 * labeled alternative in {@link ArithmeticParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprPar(@NotNull ArithmeticParser.ExprParContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprPar}
	 * labeled alternative in {@link ArithmeticParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprPar(@NotNull ArithmeticParser.ExprParContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprNum}
	 * labeled alternative in {@link ArithmeticParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprNum(@NotNull ArithmeticParser.ExprNumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprNum}
	 * labeled alternative in {@link ArithmeticParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprNum(@NotNull ArithmeticParser.ExprNumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprMin}
	 * labeled alternative in {@link ArithmeticParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprMin(@NotNull ArithmeticParser.ExprMinContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprMin}
	 * labeled alternative in {@link ArithmeticParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprMin(@NotNull ArithmeticParser.ExprMinContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numNeg}
	 * labeled alternative in {@link ArithmeticParser#num}.
	 * @param ctx the parse tree
	 */
	void enterNumNeg(@NotNull ArithmeticParser.NumNegContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numNeg}
	 * labeled alternative in {@link ArithmeticParser#num}.
	 * @param ctx the parse tree
	 */
	void exitNumNeg(@NotNull ArithmeticParser.NumNegContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprOpR}
	 * labeled alternative in {@link ArithmeticParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprOpR(@NotNull ArithmeticParser.ExprOpRContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprOpR}
	 * labeled alternative in {@link ArithmeticParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprOpR(@NotNull ArithmeticParser.ExprOpRContext ctx);
}