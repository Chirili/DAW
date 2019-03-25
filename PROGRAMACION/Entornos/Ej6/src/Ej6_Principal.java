import java.util.Scanner;

public class Ej6_Principal {

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);

        Mes[] meses = Mes.values();

        System.out.println("Escribe un numero de dias");
        int dias = sn.nextInt();

        for (int i = 0; i < meses.length; i++) {

            if (meses[i].getNumDias() == dias) {
                System.out.println(meses[i].toString());
            }

        }

    }
}