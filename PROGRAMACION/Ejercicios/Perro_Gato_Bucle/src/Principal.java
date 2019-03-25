import java.util.Scanner;

class Principal {
    public static void main(String[] args) {

        execute();
        /*
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
        } else{
        }

        int contadorGatos = 0;

        while (tipoAnimal == perro){

            System.out.println("Acabas de entrar en un bucle de creacion de gatos si quieres salir de él solo escribe 0 si quieres continuar pulsa 1");
            int Bucleg;
            Scanner scannerBucleg = new Scanner(System.in);
            Bucleg = scannerBucleg.nextInt();
            if (Bucleg > 1){
                System.out.println("Erro: Elige 1 para continuar o 0 para salir");
            } else if (Bucleg < 0){
                System.out.println("Erro: Elige 1 para continuar o 0 para salir");
            } else if (Bucleg == 1){
                animalCompañiaG.mostrarGato();
                animalCompañiaG.animal2();
                contadorGatos++;
            } else {
                System.out.println("Has creado este número de gatos: " + contadorGatos);
                break;
            }
        }
        int contadorPerros= 0;

        while (tipoAnimal < perro) {
            System.out.println("Acabas de entrar en un bucle de creacion de perros si quieres salir de él solo escribe 0 si quieres continuar pulsa 1");
            int Buclep;
            Scanner scannerBuclep = new Scanner(System.in);
            Buclep = scannerBuclep.nextInt();

            if (Buclep > 1){
                System.out.println("Erro: Elige 1 para continuar o 0 para salir");
            } else if (Buclep < 0){
                System.out.println("Erro: Elige 1 para continuar o 0 para salir");
            } else if (Buclep == 1){
                animalCompañiaP.mostrarPerro();
                animalCompañiaP.animal1();
                contadorPerros++;
            } else {
                System.out.println("Has creado este número de gatos: " + contadorPerros);
                break;
            }

        }
        */
    }
    public static void execute(){
        int option = 0;
        do{
            System.out.println("Elige si el animal es un perro o un gato recuerda 1=perro y 2=gato");
            option = getNumber();
            switch (option){
                case 1:
                    Perro dog = executeDog();
                    dog.ladrar();
                    dog.mostrarPerro("Color de mi perro: "+dog.color);

                    break;
                case 2:
                    Gato cat = executeCat();
                    break;
            }
        }while(option != 0);
    }
    public static Perro executeDog(){
        System.out.println("perro");
        /*
        String color = "";
        int size = 0;
        System.out.println("Dame color del perro:");
        size = getNumber();
        System.out.println("Dame tamaño del perro:");
        color = getString();
        Perro p = new Perro(color, size);
        */
        Perro p = new Perro();
        System.out.println("Dame  tamaño del perro:");
        p.size = getNumber();
        System.out.println("Dame color del perro:");
        p.color = getString();
        return p;
    }
    public static Gato executeCat(){
        Gato g = new Gato();
        System.out.println("gato");
        System.out.println("Dame  tamaño del gato:");
        g.size = getNumber();
        System.out.println("Dame color del perro:");
        g.color = getString();
        System.out.println("Dame color del perro:");
        return new Gato();
    }

    public static String getString(){
        return  "";
    }
    public static int getNumber(){
        Scanner op = new Scanner(System.in);
        return op.nextInt();
    }
}
