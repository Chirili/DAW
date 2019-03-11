import java.util.Scanner;

public class Gato {

    String color;
    int size;

    public Gato(){

    }

    public Gato (String color, int size){
        this.color = color;
        this.size = size;
    }

    public void maullar(){
        System.out.println("Miau Miau");
    }
    public void mostrarGato(String str){
        System.out.println(str);
    }
}
