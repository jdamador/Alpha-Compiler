import org.antlr.v4.runtime.*;
import java.util.LinkedList;

/**
 * Created by oviquez on 19/9/2016.
 */
public class TablaSimbolos {
    private LinkedList<Object> tabla;
    public int levelActual;
    // New identifier element.
    class Ident{ 
        Token tok;
        String type;  //It saves three types of data (boolean, string and integer).
        int level;
        Object valor;
        public Ident(Token t, String tp){
            tok = t;
            type = tp;
            level = levelActual;
            valor = null;
        }

        public boolean setValue(Object data) {

            // Set value to exist variable.
            if ((data instanceof String && this.type.equals("String")) || (data instanceof Integer && this.type.equals("Integer")) || (data instanceof Boolean && this.type.equals("Boolean"))){
                valor = data;
                return  true;
            } else{
                return false;
            }
        }
        public void setValueConst(Object data) {
            this.valor = data;
        }
    }

    public TablaSimbolos()
    {
        tabla = new LinkedList<Object>();
        this.levelActual=-1;
    }

    public void insertar(Token id, String tipo)
    {
        Ident i = new Ident(id,tipo);
        tabla.add(i);
    }

    public Ident buscar(String nombre)
    {
        //System.out.println("Look for {" + nombre + "} | table size ("+tabla.size()+")");
        Ident temp=null;
        for (int i = tabla.size() -1; i >= 0; i--) {
            //Look for>
            //System.out.println("Element one: ["+((Ident) tabla.get(i)).tok.getText()+"] element two ["+nombre+"]");
            if (((Ident) tabla.get(i)).tok.getText().equals(nombre)) {
                temp = ((Ident) tabla.get(i));
                break;
            }
        }
        return temp;
    }

    public void openScope(){
        levelActual++;
    }

    public void closeScope(){
        for (int i = 0; i < tabla.size(); i++) {
            if(((Ident) tabla.get(i)).level == levelActual){
                tabla.remove(i);
            }
        };
        levelActual--;
    }

    public void imprimir() {
        for (int i = 0; i < tabla.size(); i++) {
            Token s = (Token) ((Ident) tabla.get(i)).tok;
            System.out.println("Nombre: " + s.getText() + "-" + ((Ident) tabla.get(i)).level+ "-" + ((Ident) tabla.get(i)).valor + "-" + ((Ident) tabla.get(i)).type); // Imprimir level y level actual
            /*if (s.getType() == 0) System.out.println("\tTipo: Indefinido");
            else if (s.getType() == 1) System.out.println("\tTipo: Integer\n");
            else if (s.getType() == 2) System.out.println("\tTipo: String\n");*/
        }
        System.out.println("-----------------------------------------------");
    }
}
