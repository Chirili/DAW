import java.util.Scanner;

public class Ej2 {

    public static void main(String[] args) {

        //Pedimos el numero
        System.out.println("Introduce un numero");
        Scanner sn=new Scanner(System.in);
        int num=sn.nextInt();

        int contador=0;

        //Hasta que no se introduzca -1 no se sale
        while(num != -1){
            System.out.println("Introduce de nuevo el numero");
            num=sn.nextInt(); //Pedimos de nuevo el n�mero
            contador++;

        }

        System.out.println("Fin, se ha introducido "+contador+" numeros");

    }

}