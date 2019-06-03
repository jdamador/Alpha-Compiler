import generated.Parser2;
import generated.Parser2BaseVisitor;
import org.antlr.v4.runtime.Token;

import java.util.ArrayList;

public class MiVisitor extends Parser2BaseVisitor<Object> {

    private TablaSimbolos miTabla;
    public ArrayList<String> errors =  new ArrayList<>();

    public MiVisitor() {
        this.miTabla = new TablaSimbolos();
    }

    @Override
    public Object visitProgramAST(Parser2.ProgramASTContext ctx) {
        visit(ctx.singleCommand());
        return null;
    }

    @Override
    public Object visitCommandAST(Parser2.CommandASTContext ctx) {
        visit(ctx.singleCommand(0));
        for (int i = 1; i < ctx.singleCommand().size(); i++)
            visit(ctx.singleCommand(i));
        return null;
    }

    @Override
    public Object visitAssignSCAST(Parser2.AssignSCASTContext ctx) {
        TablaSimbolos.Ident exist = miTabla.buscar(ctx.ID().getText());
        if ( exist  == null){
            printError("SEMANTIC ERROR: Undefined identifier Assign",ctx.ID().getSymbol());
        } else {
            // It method use a function to save into symbols table but in this process check the types.
            boolean get = exist.setValue((Object) visit(ctx.expression()));
            if(!get)
                printError("CONTEXTUAL ERROR: bad types in the assign ",ctx.ID().getSymbol());
        }
        return null;
    }

    // TODO: preguntar si este es una llamada al metodo y si hay que implementarlo.
    @Override
    public Object visitCallSCAST(Parser2.CallSCASTContext ctx) {
            visit(ctx.expression());
        return null;
    }

    @Override
    public Object visitIfSCAST(Parser2.IfSCASTContext ctx) {
        // Here visit a condition after that
        visit(ctx.expression());
        visit(ctx.singleCommand(0));
        visit(ctx.singleCommand(1));
        return null;
    }

    @Override
    public Object visitWhileSCAST(Parser2.WhileSCASTContext ctx) {
        visit(ctx.expression());
        visit(ctx.singleCommand());
        return null;
    }

    @Override
    public Object visitLetSCAST(Parser2.LetSCASTContext ctx) {
        miTabla.openScope();
        visit(ctx.declaration());
        visit(ctx.singleCommand());
        miTabla.closeScope();

        return null;
    }

    @Override
    public Object visitBeginSCAST(Parser2.BeginSCASTContext ctx) {
        visit(ctx.command());
        return null;
    }

    @Override
    public Object visitDeclarationAST(Parser2.DeclarationASTContext ctx) {
        visit(ctx.singleDeclaration(0));
        for (int i = 1; i < ctx.singleDeclaration().size(); i++){
            visit(ctx.singleDeclaration(i));
        }
        return null;
    }

    @Override
    public Object visitConstSTAST(Parser2.ConstSTASTContext ctx) {
        visit(ctx.expression());
        return null;
    }

    @Override
    public Object visitVarAST(Parser2.VarASTContext ctx) {
        Object type = visit(ctx.typeDenoter());
        if(type.equals("int"))
            miTabla.insertar(ctx.ID().getSymbol(),"Integer");
        else if(type.equals("bool"))
            miTabla.insertar(ctx.ID().getSymbol(),"Boolean");
        else if(type.equals("String"))
            miTabla.insertar(ctx.ID().getSymbol(),"String");
            else
                printError("CONTEXTUAL ERROR: type not accepted ", ctx.ID().getSymbol());
        return null;
    }

    // Return value to set type.
    @Override
    public Object visitTypeDenoterAST(Parser2.TypeDenoterASTContext ctx){
        return ctx.ID().getSymbol().getText() ;
    }

    @Override
    public Object visitExpressionAST(Parser2.ExpressionASTContext ctx) {
        Object value;
        value = visit(ctx.primaryExpression(0));
        for (int i = 1; i < ctx.primaryExpression().size() ; i++){
            visit(ctx.operator(i-1));
            visit(ctx.primaryExpression(i));
        }
        return value;
    }
    @Override
    public Object visitNumPrimaryExpAST(Parser2.NumPrimaryExpASTContext ctx) {
        return Integer.parseInt(ctx.NUM().getText());
    }

    @Override
    public Object visitIdPrimaryExpAST(Parser2.IdPrimaryExpASTContext ctx)
    {
        TablaSimbolos.Ident exist = miTabla.buscar(ctx.ID().getText());
        if ( exist  == null){
            printError("SEMANTIC ERROR: Undefined identifier ID ",ctx.ID().getSymbol());
        }
        else
            return exist.valor;
        return null;
    }

    @Override
    public Object visitStringPrimaryExpAST(Parser2.StringPrimaryExpASTContext ctx) {
        return ctx.STRING().getText().substring(1,ctx.STRING().getText().length()-1);
    }

    @Override
    public Object visitBoolPrimaryExpAST(Parser2.BoolPrimaryExpASTContext ctx){
        return Boolean.parseBoolean(ctx.BOOL().getText());
    }
    @Override
    public Object visitGroupPEAST(Parser2.GroupPEASTContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public Object visitOperator(Parser2.OperatorContext ctx) {
        return ctx.getText().charAt(0);
    }
    @Override public Object visitPrintSCAST(Parser2.PrintSCASTContext ctx) {
        visit(ctx.expression());
        return null;
    }

    private void printError(String msg, Token t){
        errors.add(msg +
                t.getText() + "(" +
                t.getLine() +
                ":" +
                t.getCharPositionInLine()+")");
    }
}
