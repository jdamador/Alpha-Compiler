import generated.Parser2;
import generated.Parser2BaseVisitor;
import org.antlr.v4.runtime.Token;

import java.util.ArrayList;

public class InterpreterVisitor extends Parser2BaseVisitor<Object> {
    // It saves all variables for each program execution.
    private TablaSimbolos miTabla;
    // It saves all errors throw in the execution.
    public ArrayList<String> errors =  new ArrayList<>();

    // Create new visitor instance.
    public InterpreterVisitor() {

        this.miTabla = new TablaSimbolos();
    }

    // Visit the program rule.
    @Override
    public Object visitProgramAST(Parser2.ProgramASTContext ctx) {

        visit(ctx.singleCommand());

        return null;
    }

    // Visit the command rule.
    @Override
    public Object visitCommandAST(Parser2.CommandASTContext ctx) {

        //  Command has one single command.
        visit(ctx.singleCommand(0));
        // Or more.
        for (int i = 1; i < ctx.singleCommand().size(); i++)
            visit(ctx.singleCommand(i));

        return null;
    }

    // Visit the Assign rule.
    @Override
    public Object visitAssignSCAST(Parser2.AssignSCASTContext ctx) {

        // Look at if the variable exist.
        var exist = miTabla.buscar(ctx.ID().getText());

        // If it doesn't exist throw an error.
        if ( exist  == null)
            printError("SEMANTIC ERROR: Undefined identifier ",ctx.ID().getSymbol());
        // But if it exist set a new value.
        else {
            exist.setValue(visit(ctx.expression()));
        }
        return null;
    }

    // FIXME: according with the instructions is not necessary implement this function.
    @Override
    public Object visitCallSCAST(Parser2.CallSCASTContext ctx) {

        visit(ctx.expression());

        return null;
    }

    // Visit a if rule.
    @Override
    public Object visitIfSCAST(Parser2.IfSCASTContext ctx) {

        // If it is true, do the first one.
        if((boolean) visit(ctx.expression()))
            visit(ctx.singleCommand(0));
        // And if it is false, do the second one.
        else
            visit(ctx.singleCommand(1));

        return null;
    }

    // Visit while rule.
    @Override
    public Object visitWhileSCAST(Parser2.WhileSCASTContext ctx) {

        // If the condition is true execute the code inside the while statement.
        Object data = visit(ctx.expression());
        if (data != null)
            while ((boolean) data){
                visit(ctx.singleCommand());

                data = visit(ctx.expression());
            }

        return null;
    }

    // Visit the let rule.
    @Override
    public Object visitLetSCAST(Parser2.LetSCASTContext ctx) {

        // Here open a new level in the storage.
        miTabla.openScope();
        // Create the variables, if it doesn't exist.
        visit(ctx.declaration());
        // Execute the instructions inside of the code block.
        visit(ctx.singleCommand());
        // Reset the level.
        miTabla.closeScope();

        return null;
    }

    // Visit the begin rule.
    @Override
    public Object visitBeginSCAST(Parser2.BeginSCASTContext ctx) {

        visit(ctx.command());

        return null;
    }

    // Visit the declaration rule.
    @Override
    public Object visitDeclarationAST(Parser2.DeclarationASTContext ctx) {

        // A declaration has one single declaration
        visit(ctx.singleDeclaration(0));
        // Ore more.
        for (int i = 1; i < ctx.singleDeclaration().size(); i++){
            visit(ctx.singleDeclaration(i));
        }

        return null;
    }

    // Visit the const rule.
    @Override
    public Object visitConstSTAST(Parser2.ConstSTASTContext ctx) {

        visit(ctx.expression());

        return null;
    }

    // Visit the rule for a new variable declaration.
    @Override
    public Object visitVarAST(Parser2.VarASTContext ctx) {

        // Visit type denoter to get the variable type.
        Object type = visit(ctx.typeDenoter());

        // If it is equal to some of these types save it into the storage.
        if(type.equals("int"))
            miTabla.insertar(ctx.ID().getSymbol(),"Integer");
        else if(type.equals("bool"))
            miTabla.insertar(ctx.ID().getSymbol(),"Boolean");
        else if(type.equals("String"))
            miTabla.insertar(ctx.ID().getSymbol(),"String");

        return null;
    }

    // Visit the type denoter rule.
    @Override
    public Object visitTypeDenoterAST(Parser2.TypeDenoterASTContext ctx){

        // Return the variable type.
        return ctx.ID().getText();
    }

    // Visit the expression rule.
    @Override
    public Object visitExpressionAST(Parser2.ExpressionASTContext ctx) {
        ArrayList<Object> result = new ArrayList<>();
        // TODO: here build the expression and apply the operations.
        result.add(visit(ctx.primaryExpression(0)));
        for (int i = 1; i < ctx.primaryExpression().size() ; i++) {
            result.add(visit(ctx.operator(i-1)));
            result.add(visit(ctx.primaryExpression(i)));
        }
        return  buildExpression(result);
    }
    // Check the all sections from the expression and apply the operations.
    private Object buildExpression(ArrayList<Object> result) {

        // If in only one value return it.
        if(result.size() == 1)
            return  result.get(0);
        else{

            // Check if is a string union.
            checkConcat(result);
            // If the result is only a value return it.
            if(result.size() == 1)
                return  result.get(0);

            // Do all multiplications or division.
            checkMul(result);
            // Do all sums or rest.
            checkSum(result);
            // If the result is only a value return it.
            if(result.size() == 1)
                return  result.get(0);

            // Check if there are some comparision.
            checkComp(result);
            // If the value is only a value return it.
            if(result.size() == 1)
                return  result.get(0);

            // Check if there are some connector expression.
            checkMoreComp(result);
        }
        return result.get(0);
    }
    // Check if there are connector expression like || or &&.
    private void checkMoreComp(ArrayList<Object> result){

        // Go through the list and check the operators.
        int index = 1;
        while(index < result.size()){

            // Apply [ OR ]  connector.
            if(result.get(index).equals("||")){
                applyOperation(result, index, "||");
            }

            // Apply [ AND ] connector.
            else if(result.get(index).equals("&&")){
                applyOperation(result, index, "&&");
            }

            // Go to next operator.
            else{
                index++;
            }
        }
    }
    // Check if there are some comparision.
    private void checkComp(ArrayList<Object> result) {


        // Go through the list and check the operators.
        int index = 1;
        while(index < result.size()){

            // Apply smaller operator.
            if(result.get(index).equals("<")){
                applyOperation(result, index, "<");
            }

            // Apply bigger operator.
            else if(result.get(index).equals(">")){
                applyOperation(result, index, ">");
            }

            // Apply smaller or equal operator.
            else if(result.get(index).equals("<=")){
                applyOperation(result, index, "<=");
            }

            // Apply bigger or equal operator.
            else if(result.get(index).equals(">=")){
                applyOperation(result, index, ">=");
            }

            // Apply equal operator.
            else if(result.get(index).equals("==")){
                applyOperation(result, index, "==");
            }

            // Got to next operator.
            else{
                index++;
            }
        }
    }

    // Check if there are some multiplication or division.
    private void checkMul(ArrayList<Object> result) {

        // Go through the list and check the operators.
        int index = 1;
        while(index < result.size()){

            // Apply multiplication operator.
            if(result.get(index).equals("*")) {
                applyOperation(result, index, "*");
            }

            // Apply division operator.
            else if(result.get(index).equals("/")){
                applyOperation(result, index, "/");
            }

            // Go to next operator.
            else{
                index++;
            }
        }
    }

    // Apply all operator for each pair of values.
    private void applyOperation(ArrayList<Object> result, int index, String c) {
        switch (c) {
            case ">":
                result.set(index - 1, Integer.parseInt(result.get(index - 1).toString()) > Integer.parseInt(result.get(index + 1).toString()));
                // Remove the values after the result.
                result.remove(index);
                result.remove(index);
                return ;
            case "<":
                result.set(index -1, Integer.parseInt(result.get(index - 1).toString()) < Integer.parseInt(result.get(index + 1).toString()));
                result.remove(index);
                result.remove(index);
                return ;
            case ">=":
                result.set(index -1, Integer.parseInt(result.get(index - 1).toString()) >= Integer.parseInt(result.get(index + 1).toString()));
                result.remove(index);
                result.remove(index);
                return ;
            case "<=":
                result.set(index -1, Integer.parseInt(result.get(index - 1).toString()) <= Integer.parseInt(result.get(index + 1).toString()));
                result.remove(index);
                result.remove(index);
                return ;
            case "==":
                result.set(index -1, Integer.parseInt(result.get(index - 1).toString()) == Integer.parseInt(result.get(index + 1).toString()));
                result.remove(index);
                result.remove(index);
                return ;
            case "+":
                result.set(index -1, Integer.parseInt(result.get(index - 1).toString()) + Integer.parseInt(result.get(index + 1).toString()));
                result.remove(index);
                result.remove(index);

                return ;
            case "-":
                result.set(index -1, Integer.parseInt(result.get(index - 1).toString()) - Integer.parseInt(result.get(index + 1).toString()));
                result.remove(index);
                result.remove(index);
                return ;
            case "*":
                result.set(index -1, Integer.parseInt(result.get(index - 1).toString()) * Integer.parseInt(result.get(index + 1).toString()));
                result.remove(index);
                result.remove(index);
                return ;
            case "/":
                result.set(index -1, Integer.parseInt(result.get(index - 1).toString()) / Integer.parseInt(result.get(index + 1).toString()));
                result.remove(index);
                result.remove(index);
                return;
            case "&&":
                if(Boolean.parseBoolean(result.get(index - 1).toString()) &&  Boolean.parseBoolean(result.get(index + 1).toString()))
                    result.set(index -1, true);
                else
                    result.set(index - 1, false);
                result.remove(index);
                result.remove(index);
                return;
            case "||":
                if(Boolean.parseBoolean(result.get(index - 1).toString()) ||  Boolean.parseBoolean(result.get(index + 1).toString()))
                    result.set(index -1, true);
                else
                    result.set(index - 1, false);
                result.remove(index);
                result.remove(index);
                return;
            default:
                return ;
        }
    }

    // Check if there are some rest or sum.
    private void checkSum(ArrayList<Object> result) {

        // Go through the list and check the operators.
        int index = 1;
        while(index < result.size()){

            // Apply sum operator.
            if(result.get(index).equals("-")) {
                applyOperation(result, index, "-");
            }

            // Apply rest operator.
            else if(result.get(index).equals("+")){
                applyOperation(result, index, "+");
            }

            // Go to next operator.
            else{
                index++;
            }
        }
    }

    //Check if it is a concat between a string with some element.
    private void checkConcat(ArrayList<Object> result) {
        Boolean allow = false;
        // Check if there are some string.
        for(int i = 0; i< result.size(); i+=2)
            if(result.get(i) instanceof  String)
                allow =  true;
        // Checks if there are some operation different to sum.
        for(int i = 1; i< result.size(); i+=2) {
            if (!result.get(i).equals("+")){
                allow = false;
            }
        }
        // Concat all elements in the list.
        if(allow){
            String value = "";
            for(int i = 0; i< result.size(); i+=2)
                value += result.get(i);
            result.clear();
            result.add(value);
        }
    }


    // Visit a primitive rule NUM.
    @Override
    public Object visitNumPrimaryExpAST(Parser2.NumPrimaryExpASTContext ctx) {

        // Return the value from the token.
        return Integer.parseInt(ctx.NUM().getText());
    }

    // Visit a primitive rule ID.
    @Override
    public Object visitIdPrimaryExpAST(Parser2.IdPrimaryExpASTContext ctx)
    {
        // Loot for the variable inside of the storage.

        TablaSimbolos.Ident exist = miTabla.buscar(ctx.ID().getText());
        // If it doesn't exist throw and error.
        if ( exist  == null)
            printError("SEMANTIC ERROR: Undefined identifier ", ctx.ID().getSymbol());
        else {

            //If it exist return its value.
            //System.out.println("Value from some variable: name >{"+ctx.ID().getText()+ "} value>{"+exist.valor+ "}");
            return exist.valor;
        }

        return null;
    }

    // Visit the primitive rule String.
    @Override
    public Object visitStringPrimaryExpAST(Parser2.StringPrimaryExpASTContext ctx) {

        // Return string content.
        return ctx.STRING().getText().substring(1,ctx.STRING().getText().length()-1);
    }

    // Visit group rule.
    @Override
    public Object visitGroupPEAST(Parser2.GroupPEASTContext ctx) {

        // Return the result from the expression.
        return visit(ctx.expression());
    }

    // Visit operation rule.
    @Override
    public Object visitOperator(Parser2.OperatorContext ctx) {

        // Return the operator.
        return ctx.getText();
    }

    // Visit print rule.
    @Override public Object visitPrintSCAST(Parser2.PrintSCASTContext ctx) {

        System.out.println(visit(ctx.expression()));
        return null;
    }

    // Visit boolean rule.
    @Override
    public Object visitBoolPrimaryExpAST(Parser2.BoolPrimaryExpASTContext ctx){

        return Boolean.parseBoolean(ctx.BOOL().getText());
    }

    // Add errors to list Errors.
    private void printError(String msg, Token t){
        errors.add(msg +
                t.getText() + "(" +
                t.getLine() +
                ":" +
                t.getCharPositionInLine()+")");
    }
}
