import java.util.Scanner;

public class Ej8 {
    public static void main(String[] args) {
        int t[]=new int[10];
        int num,sitio_num,j;
        for (int i=0;i<=5;i++)
        {
            System.out.print("Introduzca numero (ordenado crecientemente): ");
            t[i]=Entrada();
        }
        System.out.println();
        System.out.print("Numero a insertar entre los anteriores: ");
        num=Entrada();
        sitio_num=0;
        j=1;
// buscaremos el sitio donde deberia ir num
        while(t[j]<num && j<=4){
            sitio_num ++;
            j++;
        }
// desplazaremos los elementos de
        for (int i=4; i>=sitio_num; i--)
            t[i]=t[i+1];
// por ultimo ponemos num en su sitio para que todo siga ordenado
        t[sitio_num]=num;
        System.out.println("La nueva serie ordenada queda: ");
        for (int i=0;i<5+1;i++)
            System.out.println(t[i]);
    }

    public static int Entrada(){
        Scanner Entrada = new Scanner(System.in);
        return Entrada.nextInt();
    }
}
