import java.util.Scanner;

public class Perro {

    String color;
    int size;

    public Perro(){

    }

    public Perro (String color, int size){
        this.color = color;
        this.size = size;
    }

    public void animal1(){
        System.out.println("El perro hace Guau");
    }

    public void ladrar(){
        System.out.println("Guau Guau");
    }

    public void mostrarPerro(String str){
        System.out.println(str);
    }
}
