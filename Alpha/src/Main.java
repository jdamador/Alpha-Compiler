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
        Scanner inst = null;
        Parser2 parser = null;
        ParseTree tree=null;

        //ANTLRInputStream input=null;
        CharStream input=null;
        CommonTokenStream tokens = null;
        MyErrorListener errorListener = null;
        try {
            //input = new ANTLRInputStream(new FileReader("test.txt"));
            input = CharStreams.fromFileName("test2.txt");
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
                MiVisitor mv = new MiVisitor();
                //mv.visit(tree); // Visita el árbol
                GenCode mv2 = new GenCode();
                mv2.visit(tree);
            }
            catch(RecognitionException e){
                System.out.println("Error!!!");
                e.printStackTrace();
            }
            if (errorListener.hasErrors() == false) {
                System.out.println("Compilación Exitosa!!\n");
                java.util.concurrent.Future<JFrame> treeGUI = org.antlr.v4.gui.Trees.inspect(tree, parser);
                treeGUI.get().setVisible(true);
            }
            else {
                System.out.println("Compilación Fallida!!\n");
                System.out.println(errorListener.toString());
            }

        }
        catch(Exception e){System.out.println("No hay archivo");e.printStackTrace();}
        /*List<Token> lista = (List<Token>) inst.getAllTokens();

        for (Token t : lista)

            System.out.println(t.getType() + ":" + t.getText() + "\n");

        inst = new Scanner(input);
        //inst.reset();*/

        //Cambiar los listeners de errores sintácticos
    }

}
