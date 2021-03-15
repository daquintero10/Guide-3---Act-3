/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogot谩 - Colombia)
 * Departamento de Tecnolog铆as de la Informaci贸n y Comunicaciones
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Proyecto Evaluador de Expresiones Postfijas
 * Fecha: Febrero 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package universidadean.desarrollosw.postfijo;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Esta clase representa una clase que eval煤a expresiones en notaci贸n polaca o
 * postfija. Por ejemplo: 4 5 +
 */
public class EvaluadorPostfijo {

    /**
     * Realiza la evaluaci贸n de la expresi贸n postfijo utilizando una pila
     * @param expresion una lista de elementos con n煤meros u operadores
     * @return el resultado de la evaluaci贸n de la expresi贸n.
     */
    static int evaluarPostFija(List<String> expresion) {
        Stack<Integer> pila = new Stack<>();
        
        for (String elem: expresion) {
        	int a=0;
        	int b=0;
        	
        	//Caso para suma
        	if(elem.equalsIgnoreCase("+")) {
        	
        		a=pila.peek();
        		pila.pop();
        		b=pila.peek();
        		pila.pop();
        		
        		pila.push(b+a);
        		
        	}
        	//Caso para resta
        	else if(elem.equalsIgnoreCase("-")) {
        		
        		a=pila.peek();
        		pila.pop();
        		b=pila.peek();
        		pila.pop();
        		
        		pila.push(b-a);
        		
        	}
        	//Caso para multiplicaci髇
        	else if(elem.equalsIgnoreCase("*")) {
        		
        		a=pila.peek();
        		pila.pop();
        		b=pila.peek();
        		pila.pop();
        		
        		pila.push(b*a);
        		
        	}
        	//Caso para divisi髇
        	else if(elem.equalsIgnoreCase("/")) {
        		
        		a=pila.peek();
        		pila.pop();
        		b=pila.peek();
        		pila.pop();
        		
        		pila.push(b/a);
        		
        	}
        	//Caso para numero
        	else {
        		
        		pila.push(Integer.parseInt(elem));
        		
        	}
        	
        }

        // TODO: Realiza la evaluaci贸n de la expresi贸n en formato postfijo

        return pila.pop();
    }

    /**
     * Programa principal
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("> ");
        String linea = teclado.nextLine();

        try {
            List<String> expresion = Token.dividir(linea);
            System.out.println(evaluarPostFija(expresion));
        }
        catch (Exception e) {
            System.err.printf("Error grave en la expresi贸n: %s", e.getMessage());
        }

    }
}
