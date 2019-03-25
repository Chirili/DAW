import java.util.Scanner;

class Principal {
    public static void main(String[] args) {


        Perro animalCompañiaP = new Perro();

        Gato animalCompañiaG = new Gato();

        System.out.println("Elige si el animal es un perro o un gato recuerda 1=perro y 2=gato");

        Scanner entradaAnimal = new Scanner(System.in);
        int tipoAnimal;
        tipoAnimal = entradaAnimal.nextInt();

        int perro = Integer.parseInt(("2"));

        if ( tipoAnimal < --perro) {
            System.out.println("Error el numero no es 1 o 2");
        } else if (tipoAnimal > ++perro){
            System.out.println(" Error el numero no es 1 o 2");
        } else if (tipoAnimal == perro){
            animalCompañiaG.mostrarGato();
            animalCompañiaG.animal2();
        } else {
            animalCompañiaP.mostrarPerro();
            animalCompañiaP.animal1();
        }

    }
}