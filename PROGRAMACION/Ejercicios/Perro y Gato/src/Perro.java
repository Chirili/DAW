import java.util.Scanner;

public class Perro {
    public void animal1(){
        System.out.println("El perro hace Guau");
    }
    public void mostrarPerro(){
        System.out.println("!Has elegido un perro!");
        String color;
        Scanner entradaColor = new Scanner(System.in);
        System.out.println("Elige el color del perro");
        color = entradaColor.nextLine();

        String tamaño;
        Scanner entradaTamaño = new Scanner(System.in);
        System.out.println("Elige el tamaño del perro");
        tamaño = entradaTamaño.nextLine();

        System.out.println("El color del perro es " + color);
        System.out.println("El tamaño del perro es " + tamaño);
    }
}
