package com.company;

import java.util.Scanner;

public class Main {

    private static String sum;

    public static void main(String[] args) {

        sum = "";
        String num1;
        String num2;
        String aux;
        char c;

        int i;
        int p1;
        int p2;
        int a;
        int res = 0;
        int value1;
        int value2;

        System.out.println("Elige el primer numero a sumar");
        Scanner numero1 = extracted();
        num1 = numero1.nextLine();
        System.out.println("Elige el segundo numero a sumar");
        num2 = extracted().nextLine();

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
        for ( i = p1; i >= 0; i--){
            if (p2 >= 0) {
                value1 = (int) num1.charAt(i);
                value2 = (int) num2.charAt(p2);
                res = value1 + value2 + a;
                p1--;
            } else if (res >= 10) {
                a = 1;
                res = res - 10;
                res = num1.charAt(i);
            }
            else {
                c = (char) res;
                sum.concat(String.valueOf(c));
            }

        }
        System.out.println("La suma de "+num1+"y"+num2+"es"+sum);
    }

    private static Scanner extracted() {
        return new Scanner(System.in);
    }
}
