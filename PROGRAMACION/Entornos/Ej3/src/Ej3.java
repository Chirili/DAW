
import javax.swing.JOptionPane;
import java.util.InputMismatchException;

public class Ej3 {

    public static void main(String[] args) {

        String texto=JOptionPane.showInputDialog(null,
                "Inserta una frase",
                "Insercion",
                JOptionPane.INFORMATION_MESSAGE);

        //usado para almacenar el texto final
        String texto_sin_espacios="";

        char caracterActual;

        //recorro el array
        try {
        for(int i=0;i<texto.length();i++){

            caracterActual=texto.charAt(i);

            //Cuando es un espacio no lo copia a la cadena
            if(caracterActual!=' '){
                texto_sin_espacios+=String.valueOf(caracterActual);
            }

        }
        } catch (StringIndexOutOfBoundsException e){
            System.out.println("Error bucle en el bucle for");
        }

        JOptionPane.showMessageDialog(null,
                "La frase tiene sin espacios es "+texto_sin_espacios,
                "Resultado",
                JOptionPane.INFORMATION_MESSAGE);

    }

}