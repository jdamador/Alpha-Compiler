// Generated from /home/jushu/Documentos/Repositorios/Alpha-Compiler/Alpha/Parser2.g4 by ANTLR 4.7.2
package generated;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Parser2}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Parser2Visitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code programAST}
	 * labeled alternative in {@link Parser2#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramAST(Parser2.ProgramASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code commandAST}
	 * labeled alternative in {@link Parser2#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommandAST(Parser2.CommandASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignSCAST}
	 * labeled alternative in {@link Parser2#singleCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignSCAST(Parser2.AssignSCASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code callSCAST}
	 * labeled alternative in {@link Parser2#singleCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallSCAST(Parser2.CallSCASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifSCAST}
	 * labeled alternative in {@link Parser2#singleCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfSCAST(Parser2.IfSCASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whileSCAST}
	 * labeled alternative in {@link Parser2#singleCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileSCAST(Parser2.WhileSCASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code letSCAST}
	 * labeled alternative in {@link Parser2#singleCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetSCAST(Parser2.LetSCASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code beginSCAST}
	 * labeled alternative in {@link Parser2#singleCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBeginSCAST(Parser2.BeginSCASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printSCAST}
	 * labeled alternative in {@link Parser2#singleCommand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintSCAST(Parser2.PrintSCASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code declarationAST}
	 * labeled alternative in {@link Parser2#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationAST(Parser2.DeclarationASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code constSTAST}
	 * labeled alternative in {@link Parser2#singleDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstSTAST(Parser2.ConstSTASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varAST}
	 * labeled alternative in {@link Parser2#singleDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarAST(Parser2.VarASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typeDenoterAST}
	 * labeled alternative in {@link Parser2#typeDenoter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeDenoterAST(Parser2.TypeDenoterASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionAST}
	 * labeled alternative in {@link Parser2#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionAST(Parser2.ExpressionASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numPrimaryExpAST}
	 * labeled alternative in {@link Parser2#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumPrimaryExpAST(Parser2.NumPrimaryExpASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolPrimaryExpAST}
	 * labeled alternative in {@link Parser2#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolPrimaryExpAST(Parser2.BoolPrimaryExpASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idPrimaryExpAST}
	 * labeled alternative in {@link Parser2#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdPrimaryExpAST(Parser2.IdPrimaryExpASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringPrimaryExpAST}
	 * labeled alternative in {@link Parser2#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringPrimaryExpAST(Parser2.StringPrimaryExpASTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code groupPEAST}
	 * labeled alternative in {@link Parser2#primaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupPEAST(Parser2.GroupPEASTContext ctx);
	/**
	 * Visit a parse tree produced by {@link Parser2#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator(Parser2.OperatorContext ctx);
}