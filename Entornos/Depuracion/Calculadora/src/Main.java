import java.util.Scanner;

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
                valor2 = 0;

        System.out.println("Introduzca el primer número: ");
        num1 = s.nextLine();
        System.out.println("Introduzca el segundo número: ");
        num2 = s.nextLine();

        if (num1.length() > num2.length()) {
            p1 = num1.length() - 1;
            p2 = num2.length() - 1;
        } else {
            p2 = num2.length() - 1;
            p1 = num1.length() - 1;
            aux = num1;
            num1 = num2;
            num2 = aux;
        }

        a = 0;
        for (i = p1; i >= 0; i--) {
            if (p2 >= 0) {
                valor1 = (int) num1.charAt(i);
                valor2 = (int) num2.charAt(p2);
                res = valor1 + valor2 + a;
                p2--;
                if (res >= 10) {
                    a = 1;
                    res = res % 10;
                } else a = 0;

            } else res = num1.charAt(i);

            String c = String.valueOf(res);
            suma.concat(suma);

        }

        System.out.println("La suma de " + num1 + " y " + num2 + " es " + suma);
    }
}
