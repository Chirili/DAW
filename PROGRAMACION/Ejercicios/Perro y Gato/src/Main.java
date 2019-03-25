import java.util.Scanner;

class Principal {
    public static void main(String[] args) {

        Perro animalCompañiaP = new Perro();

        Gato animalCompañiaG = new Gato();

        System.out.println("Elige si el animal es un perro o un gato recuerda 1=perro y 2=gato");

        String tipoAnimal = "";
        Scanner entradaAnimal = new Scanner(System.in);
        tipoAnimal = entradaAnimal.nextLine();
        String perro = "2";

        if (!tipoAnimal.equals(perro)) {
            animalCompañiaP.mostrarPerro();
            animalCompañiaP.animal1();
        } else {
            animalCompañiaG.mostrarGato();
            animalCompañiaG.animal2();
        }
    }
}