import java.util.Scanner;

public class Gato {
    public void animal2(){
        System.out.println("Miau");
    }
    public void mostrarGato(){
        System.out.println("!Has elegido un gato!");
        String color;
        Scanner entradaColor = new Scanner(System.in);
        System.out.println("Elige el color del gato");
        color = entradaColor.nextLine();

        String tamaño;
        Scanner entradaTamaño = new Scanner(System.in);
        System.out.println("Elige el tamaño del gato");
        tamaño = entradaTamaño.nextLine();

        System.out.println("El color del gato es " + color);
        System.out.println("El tamaño del gato es " + tamaño);
    }
}