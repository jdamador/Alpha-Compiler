import org.antlr.v4.runtime.*;
import java.util.LinkedList;

/**
 * Created by oviquez on 19/9/2016.
 */
public class TablaSimbolos {
    private LinkedList<Object> tabla;
    private int nivelActual;
    class Ident{ // Indentificadores
        Token tok;
        String type; // Esto problemente cambie a un tipo más estructurado
        int nivel;
        Object valor;
        public Ident(Token t, String tp){
            tok = t;
            type = tp;
            nivel = nivelActual;
            valor = new Object();
        }

        public void setValue(Object v){
            valor = v;
            if( v instanceof String){
                this.type = "String";
            }else{
                this.type = "Integer";
            }
        }

    }

    public TablaSimbolos()
    {
        tabla = new LinkedList<Object>();
        this.nivelActual=-1;
    }

    public void insertar(Token id, String tipo)
    {
        Ident i = new Ident(id,tipo);
        tabla.add(i);
    }

    // Buscar esta mal, hay que recorrer la lista alrevez
    public Ident buscar(String nombre)
    {
        Ident temp=null;
        for (int i = tabla.size()-1; i >= 0; i--) {
            if (((Ident) tabla.get(i)).tok.getText().equals(nombre))
                temp = ((Ident) tabla.get(i));
                break;
        }
        return temp;
    }

    public void openScope(){
        nivelActual++;
    }

    public void closeScope(){
        // Hay que sacar todos los identificadores del nivel que se esta cerrando
        for (int i = 0; i < tabla.size(); i++) {
            if(((Ident) tabla.get(i)).nivel == nivelActual){
                tabla.remove(i);
            }
        };
        nivelActual--;
    }
    // Falta openScope()

    // Falta closeScope()

    public void imprimir() {
        for (int i = 0; i < tabla.size(); i++) {
            Token s = (Token) ((Ident) tabla.get(i)).tok;
            System.out.println("Nombre: " + s.getText() + "-" + ((Ident) tabla.get(i)).nivel+ "-" + ((Ident) tabla.get(i)).valor + "-" + ((Ident) tabla.get(i)).type); // Imprimir nivel y nivel actual
            /*if (s.getType() == 0) System.out.println("\tTipo: Indefinido");
            else if (s.getType() == 1) System.out.println("\tTipo: Integer\n");
            else if (s.getType() == 2) System.out.println("\tTipo: String\n");*/
        }
        System.out.println("-----------------------------------------------");
    }
}
