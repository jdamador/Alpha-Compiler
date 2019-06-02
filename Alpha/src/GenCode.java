import generated.Parser2;
import generated.Parser2BaseVisitor;
import java.util.ArrayList; // import the ArrayList class
public class GenCode extends Parser2BaseVisitor<Object> {
    int index = 0;
    int indexTable = 0;
    ArrayList<Table> table = new ArrayList<Table>();
    class Table{
        int idx;
        String symbol;
        public Table(String symbol){
            this.idx = indexTable;
            this.symbol = symbol;
            indexTable++;
        }
    }


    // Increase the global index one per call function
    public void increaseGlobalIndex(){
        this.index++;
    }

    public Table searchTable(String symbol){
        for (int i = 0; i < table.size(); i++) {
            if(table.get(i).symbol.equals(symbol))
                return table.get(i);
        }
        return null;
    }

    // Add symbol in index table
    public void addTable(String symbol){
        Table aux = new Table(symbol);
        table.add(aux);
    }
    public void printTable(){
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("-*-*--*-*--*-*- Tabla de Índices -*-*--*-*--*-*-");
        for (int i = 0; i < table.size(); i++) {
            System.out.println("Symbolo: "+table.get(i).symbol);
            System.out.println("Índice: "+table.get(i).idx);
            System.out.println("-----------------------------------");
        }
        System.out.println("-*-*--*-*--*-*-*-*-*-*-*-*-*-*--*-*--*-*--*-*-");
    }
    @Override
    public Object visitProgramAST(Parser2.ProgramASTContext ctx) {
        visit(ctx.singleCommand());
        printTable();
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
        visit(ctx.expression());
        // el ISTORE no debe llevar el texto sino el índice
        // por lo que hay que hacer una tabla de índices
        Table element = searchTable(ctx.ID().getText());
        if(element != null){
            System.out.println(this.index+": ISOTORE :"+element.idx);
        }else{
            System.out.println("No se encuentra el elemento: "+ctx.ID().getText());
        }
        increaseGlobalIndex();
        return null;
    }

    @Override
    public Object visitCallSCAST(Parser2.CallSCASTContext ctx) {
        visit(ctx.expression());
        return null;
    }

    @Override
    public Object visitIfSCAST(Parser2.IfSCASTContext ctx) {
        visit(ctx.expression());
        System.out.println(this.index+": IF-CMP-ALGO "+ "linea de código");
        increaseGlobalIndex();
        visit(ctx.singleCommand(0));
        System.out.println(this.index+": GOTO "+ "linea de código fuera del if");
        increaseGlobalIndex();
        visit(ctx.singleCommand(1));
        return null;
    }

    @Override
    public Object visitWhileSCAST(Parser2.WhileSCASTContext ctx) {
       visit(ctx.expression());
       System.out.println(this.index+": (While)IF-CMP-ALGO "+ "linea de código");
       visit(ctx.singleCommand());
       System.out.println(this.index+":GOTO linea de código fuera del while");
       return null;
    }

    @Override
    public Object visitLetSCAST(Parser2.LetSCASTContext ctx) {
        visit(ctx.declaration());
        visit(ctx.singleCommand());
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
        // Debe agregar el ctx.ID() a la tabla de índices
        // junto con el índice que le toca
        // los índices son secuencias
        addTable(ctx.ID().getText());
        visit(ctx.typeDenoter());
        return null;
    }

    @Override
    public Object visitExpressionAST(Parser2.ExpressionASTContext ctx) {

        visit(ctx.primaryExpression(0));
        for (int i = 1; i < ctx.primaryExpression().size(); i++) {
            visit(ctx.primaryExpression(i));
            visit(ctx.operator(i-1));
        }
        return null;
    }


    @Override
    public Object visitNumPrimaryExpAST(Parser2.NumPrimaryExpASTContext ctx) {
        System.out.println(this.index+": ICONST :"+ ctx.NUM().getText());
        increaseGlobalIndex();
        return null;
    }

    @Override
    public Object visitIdPrimaryExpAST(Parser2.IdPrimaryExpASTContext ctx)
    {
        //Deberia de ser índice en vez del nombre de la variable
        // Buscar
        Table element = searchTable(ctx.ID().getText());
        if(element != null){
            System.out.println(this.index+": ILOAD: "+element.idx);
        }else{
            System.out.println("No se encuentra el elemento: "+ctx.ID().getText());
        }

        increaseGlobalIndex();
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
        switch (ctx.getText().charAt(0)){
            case '+': System.out.println(this.index+": IADD"); break;
            case '-': System.out.println(this.index+": ISUB"); break;
            case '*': System.out.println(this.index+": IMUL"); break;
            case '/': System.out.println(this.index+": IDIV"); break;
        }
        increaseGlobalIndex();
        return null;
    }
}
