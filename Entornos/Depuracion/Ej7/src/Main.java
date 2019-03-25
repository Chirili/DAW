import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int nota;

        Scanner Entrada = new Scanner(System.in);
        System.out.print("Introduzca una nota: ");
        nota= Entrada.nextInt();

// tanto los if's como los else's encierran a una sola instrucci�n
// y no es necesario utilizar llaves { }
        if(nota>=0 && nota<5)
            System.out.println("INSUFICIENTE");
        else
        if(nota==5)
            System.out.println("SUFICIENTE");
        else
        if(nota==6)
            System.out.println("BIEN");
        else
        if(nota==7 || nota==8)
            System.out.println("NOTABLE");
        else
            if (nota==9 || nota==10)
        System.out.println("SOBRESALIENTE");
        else
        System.out.println("ERROR");
    }
}


