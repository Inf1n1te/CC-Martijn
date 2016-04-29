// Generated from Grammar.g4 by ANTLR 4.4
package project;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarParser}.
 */
public interface GrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarParser#boolOp}.
	 * @param ctx the parse tree
	 */
	void enterBoolOp(@NotNull GrammarParser.BoolOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#boolOp}.
	 * @param ctx the parse tree
	 */
	void exitBoolOp(@NotNull GrammarParser.BoolOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#cmpOp}.
	 * @param ctx the parse tree
	 */
	void enterCmpOp(@NotNull GrammarParser.CmpOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#cmpOp}.
	 * @param ctx the parse tree
	 */
	void exitCmpOp(@NotNull GrammarParser.CmpOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(@NotNull GrammarParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(@NotNull GrammarParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#multOp}.
	 * @param ctx the parse tree
	 */
	void enterMultOp(@NotNull GrammarParser.MultOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#multOp}.
	 * @param ctx the parse tree
	 */
	void exitMultOp(@NotNull GrammarParser.MultOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#expOp}.
	 * @param ctx the parse tree
	 */
	void enterExpOp(@NotNull GrammarParser.ExpOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#expOp}.
	 * @param ctx the parse tree
	 */
	void exitExpOp(@NotNull GrammarParser.ExpOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(@NotNull GrammarParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(@NotNull GrammarParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#prfOp}.
	 * @param ctx the parse tree
	 */
	void enterPrfOp(@NotNull GrammarParser.PrfOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#prfOp}.
	 * @param ctx the parse tree
	 */
	void exitPrfOp(@NotNull GrammarParser.PrfOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(@NotNull GrammarParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(@NotNull GrammarParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(@NotNull GrammarParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(@NotNull GrammarParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#plusOp}.
	 * @param ctx the parse tree
	 */
	void enterPlusOp(@NotNull GrammarParser.PlusOpContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#plusOp}.
	 * @param ctx the parse tree
	 */
	void exitPlusOp(@NotNull GrammarParser.PlusOpContext ctx);
}