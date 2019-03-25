import javax.swing.JOptionPane;

public class Ej4 {

    public static void main(String[] args) {

        String texto = JOptionPane.showInputDialog(null,
                "Introduce un texto, cadena vacia para terminar",
                "Introducir texto",
                JOptionPane.INFORMATION_MESSAGE);

        String cadenaResultante = "";

        //Mientras no este vacio la cadena escrita continuo
        while (!texto.isEmpty()) {

            //Concatenamos el texto
            cadenaResultante += texto;

            //Reintroducimos de nuevo una cadena
            texto = JOptionPane.showInputDialog(null,
                    "Introduce un texto, cadena vacia para terminar",
                    "Introducir texto",
                    JOptionPane.INFORMATION_MESSAGE);

        }

        JOptionPane.showMessageDialog(null,
                cadenaResultante,
                "Resultado",
                JOptionPane.INFORMATION_MESSAGE);

    }
}
