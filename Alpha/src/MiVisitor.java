import generated.Parser2;
import generated.Parser2BaseVisitor;
import org.antlr.v4.runtime.Token;
import org.omg.CORBA.INTERNAL;

public class MiVisitor extends Parser2BaseVisitor<Object> {

    private TablaSimbolos miTabla;

    public MiVisitor() {
        this.miTabla = new TablaSimbolos();
    }

    @Override
    public Object visitProgramAST(Parser2.ProgramASTContext ctx) {
        try {
            visit(ctx.singleCommand());
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }

    @Override
    public Object visitCommandAST(Parser2.CommandASTContext ctx) {
        visit(ctx.singleCommand(0));
        for (int i = 1; i < ctx.singleCommand().size(); i++){
            visit(ctx.singleCommand(i));
        }
        return null;
    }

    @Override
    public Object visitAssignSCAST(Parser2.AssignSCASTContext ctx) {
        TablaSimbolos.Ident exist = miTabla.buscar(ctx.ID().getText());
        if ( exist  == null)
            printError("SEMANTIC ERROR: Undefined identifier ",ctx.ID().getSymbol());
        else
            exist.setValue((Object) visit(ctx.expression()));

        return null;
    }

    @Override
    public Object visitCallSCAST(Parser2.CallSCASTContext ctx) {
        if(ctx.ID().getText().equals("print")){
            System.out.println(visit(ctx.expression()));
        }else
            visit(ctx.expression());
        return null;
    }

    @Override
    public Object visitIfSCAST(Parser2.IfSCASTContext ctx) {
        visit(ctx.expression());
        visit(ctx.singleCommand(0));
        visit(ctx.singleCommand(1));
        return null;
    }

    @Override
    public Object visitWhileSCAST(Parser2.WhileSCASTContext ctx) {
        try{
            Integer iter = (Integer) visit(ctx.expression());
            for (int i=0; i < iter; i++)
                visit(ctx.singleCommand());
        }catch (Exception e){
            System.out.println("No se puede realizar el While ya que "+ (Object) visit(ctx.expression()) + " no es numerica");
        }
        return null;
    }

    @Override
    public Object visitLetSCAST(Parser2.LetSCASTContext ctx) {
        miTabla.openScope();
        visit(ctx.declaration());
        //miTabla.imprimir();
        visit(ctx.singleCommand());
        miTabla.imprimir();
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
        miTabla.insertar(ctx.ID().getSymbol(),"");
        visit(ctx.typeDenoter());
        return null;
    }

    @Override
    public Object visitExpressionAST(Parser2.ExpressionASTContext ctx) {
        Object value = new Object();
        value = visit(ctx.primaryExpression(0));
        for (int i = 1; i < ctx.primaryExpression().size() ; i++){
            char oper = (Character) visit(ctx.operator(i-1));
            Object value2 = visit(ctx.primaryExpression(i));
            if(value instanceof String && value2 instanceof String && oper == '+') {
                value = String.valueOf(value).concat(String.valueOf(value2));
            }else if(value instanceof Integer && value2 instanceof Integer){ // Numerico
                value = operar(Integer.parseInt(String.valueOf(value)),Integer.parseInt(String.valueOf(value2)),oper);
            }else{ // Error
                System.out.println("!!! Error de tipos !!!");
            }
        }
        return value;
    }

    public Integer operar(Integer val1, Integer val2, char operation){
        switch (operation){
            case '+': return val1 + val2;
            case '-': return val1 - val2;
            case '*': return val1 * val2;
            case '/': return val1 / val2;
            default:break;
        }
        return 0;
    }

    @Override
    public Object visitNumPrimaryExpAST(Parser2.NumPrimaryExpASTContext ctx) {
        return Integer.parseInt(ctx.NUM().getText());
    }

    @Override
    public Object visitIdPrimaryExpAST(Parser2.IdPrimaryExpASTContext ctx)
    {
        TablaSimbolos.Ident exist = miTabla.buscar(ctx.ID().getText());
        if ( exist  == null)
            printError("SEMANTIC ERROR: Undefined identifier ",ctx.ID().getSymbol());
        else
            return exist.valor;
        return null;
    }

    @Override
    public Object visitStringPrimaryExpAST(Parser2.StringPrimaryExpASTContext ctx) {
        return ctx.STRING().getText().substring(1,ctx.STRING().getText().length()-1);
    }

    @Override
    public Object visitGroupPEAST(Parser2.GroupPEASTContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public Object visitOperator(Parser2.OperatorContext ctx) {
        return ctx.getText().charAt(0);
    }

    private void printError(String msg, Token t){
        System.out.println(msg +
                t.getText() + "(" +
                t.getLine() +
                ":" +
                t.getCharPositionInLine()+")");
    }
}
