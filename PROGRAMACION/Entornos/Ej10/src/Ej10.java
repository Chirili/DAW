import java.util.Scanner;

public class Ej10 {
    /*
     * En esta versi�n nos fijaremos en los �ndices pares e impares
     * en par se incluir� t[2],t[4]...
     * en impar t[1], t[2],...
     */
    public static void main(String[] args) {
        int t[];
        int par[];
        int impar[];
        t = new int[10];
// Leemos los valores de la tabla
        for (int i=0;i<10;i++){
            System.out.print("Introduzca un n�mero: ");
            t[i]=Entrada();
        }
// creamos las tablas par e impar del tamano adecuado (5)
        par=new int[5];
        impar=new int[5];
// copiamos cada elemento en la tabla adecuada
        for (int i=0;i<10;i++)
            par[i/2] = t[i];
        for (int i=0;i<10;i+=2) // la division entera redondeada hacia el entero mas proximo por
            impar[i/2] = t[i]; // debajo: 1/2 =0, 3/2 =1, etc.
        System.out.println("\n\nTabla par:");
        for (int i=0;i<5;i++)
            System.out.println(par[i]);
        System.out.println("Tabla impar:");
        for (int i=0;i<5;i++)
            System.out.println(impar[i]);
    }
    public static int Entrada(){
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}
