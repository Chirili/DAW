import java.util.Scanner;

public class Ej9 {
    public static void main(String[] args) {
        int t[] = new int[10];
        int num, j;

        for (int i = 0; i < 10; i++) {
            System.out.print("Introduzca numero (orden creciente): ");
            t[i] = Entrada();
        }
        System.out.println();
        System.out.println("Introduzca numero a buscar: ");
        num = Entrada();
        j = 1;
        while (j < 10 && t[j] < num) {
            j++;
        }
// cuando me salgo del mientras puede ser por dos motivos:
// - que j llegue a 10 �
// - que encuentre el donde ir�a num en la tabla
        if (j == 10) // hemos llegado al final y no hemos encontrado nada.
            System.out.println("No encontrado");
        else {
// si t[j] < num, hemos sobrepasado el lugar donde deber�a estar num, sin encontrarlo
            if (t[j] == num) // num est� en la posici�n i. Entonces si est� ah�
                System.out.println("Encontrado en la posici�n " + j);
            else
                System.out.println("No encontrado");
        }
    }
    public static int Entrada(){
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}