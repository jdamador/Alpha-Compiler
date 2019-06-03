import generated.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import javax.swing.*;
import java.io.FileReader;
import java.util.List;

/**
 * Created by oviquez on 28/2/2018.
 */

public class Main {
    public static void main(String[] args){
        Scanner inst;
        Parser2 parser;
        ParseTree tree=null;

        //ANTLRInputStream input=null;
        CharStream input;
        CommonTokenStream tokens;
        MyErrorListener errorListener;

        try {
            //input = new ANTLRInputStream(new FileReader("test.txt"));
            input = CharStreams.fromFileName("test.txt");
            inst = new Scanner(input);
            tokens = new CommonTokenStream(inst);
            parser = new Parser2(tokens);

            errorListener = new MyErrorListener();

            inst.removeErrorListeners();
            inst.addErrorListener( errorListener );

            parser.removeErrorListeners();
            parser.addErrorListener ( errorListener );

            try {
                tree = parser.program();

                // Create a contextual visitor.
                MiVisitor mv = new MiVisitor();

                // Visit the tree.
                mv.visit(tree);

                // Check for syntactic errors
                if(errorListener.hasErrors())
                    System.out.println(errorListener.toString());
                else
                // Check for contextual errors.
                    if(mv.errors.size()>0)
                        for (String i: mv.errors)
                            System.out.println(i);
                // If all is correct, execute the interpreter.
                    else{
                        InterpreterVisitor iv = new InterpreterVisitor();
                        iv.visit(tree);
                    }
                System.out.println("Compilation successful!!!");
            }
            catch(RecognitionException e) {
                System.out.println("Error!!!");
                e.printStackTrace();
            }

            if(errorListener.hasErrors()) {
                System.out.println("Compilation fail!!\n");
                System.out.println(errorListener.toString());
            }

        }
        catch(Exception e){
            System.out.println("Error> There isn't a test file or there is a syntactic error into the test file");
            e.printStackTrace();
        }
    }

}
