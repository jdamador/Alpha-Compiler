import generated.Scanner;
import org.antlr.v4.runtime.Token;

/**
 * Created by oviquez on 21/8/2018.
 */
public class ParserManual {

    private Scanner e;
    private Token actualToken;

    public void ParserManual(Scanner e){
        this.e = e;
        actualToken=this.e.nextToken();
    }

    private void accept(int expected){
        if (expected != actualToken.getType())
            System.out.println("Error Sintáctico");
        actualToken = this.e.nextToken();
    }

    public void program(){
        singleCommand();
    }

    public void command(){
        singleCommand();
        while(actualToken.getType()==Scanner.PyCOMA){
            accept(Scanner.PyCOMA);
            singleCommand();
        }
    }

    public void singleCommand(){
        if (actualToken.getType() == Scanner.ID){
            accept(Scanner.ID);
            if (actualToken.getType()==Scanner.ASSIGN){
                accept(Scanner.ASSIGN);
                expression();
            }
            else if (actualToken.getType() == Scanner.PIZQ){
                accept(Scanner.PIZQ);
                expression();
                accept(Scanner.PDER);
            }
            else
                System.out.println("Error Sintáctico");
        }
        else if(actualToken.getType() == Scanner.IF){
            accept(Scanner.IF);
            expression();
            accept(Scanner.THEN);
            singleCommand();
            accept(Scanner.ELSE);
            singleCommand();
        }
        else if(actualToken.getType() == Scanner.WHILE){
            accept(Scanner.WHILE);
            expression();
            accept(Scanner.DO);
            singleCommand();
        }
        // y todos los demás
        else{
            System.out.println("Error Sintáctico");
        }
    }

    public void expression(){}
}
