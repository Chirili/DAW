import java.util.Scanner;

import static java.lang.String.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String suma = "",
                num1 = "",
                num2 = "",
                aux = "";

        int i = 0,
                p1 = 0,
                p2 = 0,
                a = 0,
                res = 0,
                valor1 = 0,
                valor2 = 0,
                inverso = 0;


        System.out.println("Introduzca el primer número: ");
        num1 = s.nextLine();
        System.out.println("Introduzca el segundo número: ");
        num2 = s.nextLine();
        //Bloque1
        if (num1.length() > num2.length()) {
            p1 = num1.length() - 1;
            p2 = num2.length() - 1;
        } else {
            p1 = num2.length() - 1;
            p2 = num1.length() - 1;

            aux = num1;
            num1 = num2;
            num2 = aux;
        }

        a = 0;
        //Bucle
        for (i = p1; i >= 0; i--) {
            if (p2 >= 0) {
                // codigo ascii ---> char c
                /*
                * Aqui el charAt se encarga de coger el String y sacar el numero de la tabla ASCII
                * que junto con el String.valueOf el codigo ASCII ese lo transforma en un String y despues
                * con el Integer.ValueOf o el parseInt se transforma en un entero para que pueda ser operado mas abajo
                */
                valor1 = Integer.valueOf(String.valueOf(num1.charAt(i)));
                valor2 =  Integer.valueOf(String.valueOf(num2.charAt(p2)));
                res = valor1 + valor2 + a;
                p2--;
                if (res >= 10) {
                    a = 1;
                    res = res % 10;
                } else {
                    a = 0;
                }/* while (res == 10){
                    res = 10;

                    inverso = (inverso * 10)+10;
                    res/=10;
                    inverso=res;
                }*/
            } else {
                /*
                * En esta linea la suma de a se hace porque si en la ultima iteraccion del bucle for es un numero mayor que 10
                * al no volver al bucle for no puede sumar ese +1 por lo tanto se suma aqui despues del bucle
                */

                res = Integer.valueOf(String.valueOf(num1.charAt(i))) + a;


                a=0;
            }

            String c = valueOf(res);
            suma = suma.concat(c);
        }
        //Bloque 2
        //Esta linea de codigo se encarga de lo que se ha concatenado en suma le invierta para que el numero resultante sea el correcto

        suma = new StringBuilder(suma).reverse().toString();
        System.out.println("La suma de " + num1 + " y " + num2 + " es " + suma);
    }
}
/*
* valor1 = Integer.parseInt(String.valueOf(num1.charAt(i)));
  valor2 = Integer.parseInt(String.valueOf(num2.charAt(p2)));
  valor1 = (int) num1.charAt(i);
  valor2 = (int) num2.charAt(p2);
* */