
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;



public class Calculadora extends JFrame {

    /** Muestra el numero tecleado tecleado */
    JTextField pantalla;

    /** Guarda el resultado de la operacion anterio o el numero tecleado*/
    double resultado;

    /** Variable encargada de guardar la operacion */
    String operacion;

    /** Paneles donde se colocaran los botones */
    JPanel panelNumeros, panelOperaciones;

    /** Indica si estamos iniciando o no una operación */
    boolean nuevaOperacion = true;

    /**
     * Constructor. Crea los botones y componentes de la calculadora
     */
    public Calculadora() {
        super();
        setSize(250, 300);
        setTitle("Calculadora Simple");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        // Vamos a dibujar sobre el panel
        JPanel panel = (JPanel) this.getContentPane();
        panel.setLayout(new BorderLayout());

        pantalla = new JTextField("0", 20);
        pantalla.setBorder(new EmptyBorder(4, 4, 4, 4));
        pantalla.setFont(new Font("Arial", Font.BOLD, 25));
        pantalla.setHorizontalAlignment(JTextField.RIGHT);
        pantalla.setEditable(false);
        pantalla.setBackground(Color.WHITE);
        panel.add("North", pantalla);

        panelNumeros = new JPanel();
        panelNumeros.setLayout(new GridLayout(4, 3));
        panelNumeros.setBorder(new EmptyBorder(4, 4, 4, 4));
        //Matríz de botones numéricos
        for (int n = 9; n >= 0; n--) {
            nuevoBotonNumerico("" + n);
        }

        nuevoBotonNumerico(".");
        //Se añaden los botones al panel central
        panel.add("Center", panelNumeros);

        panelOperaciones = new JPanel();
        panelOperaciones.setLayout(new GridLayout(6, 1));
        panelOperaciones.setBorder(new EmptyBorder(4, 4, 4, 4));

        nuevoBotonOperacion("+");
        nuevoBotonOperacion("-");
        nuevoBotonOperacion("*");
        nuevoBotonOperacion("/");
        nuevoBotonOperacion("=");
        nuevoBotonOperacion("CE");

        panel.add("East", panelOperaciones);

        validate();
    }

    /**
     * Crea los botones numericos y enlaza sus eventos con el listener que le corresponde
     *            boton a crear
     */
    private void nuevoBotonNumerico(String digito) {
        JButton btn = new JButton();
        btn.setText(digito);
        btn.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent evt) {
                JButton btn = (JButton) evt.getSource();
                numeroPulsado(btn.getText());
            }
        });

        panelNumeros.add(btn);
    }

    /**
     * Crea los botones de operacion y los enlaza con sus eventos
     */
    private void nuevoBotonOperacion(String operacion) {
        JButton btn = new JButton(operacion);
        btn.setForeground(Color.RED);

        btn.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent evt) {
                JButton btn = (JButton) evt.getSource();
                teclaOperacion(btn.getText());
            }
        });

        panelOperaciones.add(btn);
    }

    /**
     * Gestiona las pulsaciones de teclas numéricas
     *
     *            Tecla pulsada
     */
    private void numeroPulsado(String digito) {
        if (pantalla.getText().equals("0") || nuevaOperacion) {
            pantalla.setText(digito);
        } else {
            pantalla.setText(pantalla.getText() + digito);
        }
        nuevaOperacion = false;
    }

    /**
     * Gestiona el gestiona las pulsaciones de teclas de operación
     */
    private void teclaOperacion(String tecla) {
        if (tecla.equals("=")) {
            Operar();
        } else if (tecla.equals("CE")) {
            resultado = 0;
            pantalla.setText("");
            nuevaOperacion = true;
        } else {
            operacion = tecla;
            if ((resultado > 0) && !nuevaOperacion) {
                Operar();
            } else {
                resultado = new Double(pantalla.getText());
            }
        }

        nuevaOperacion = true;
    }

    /**
     * Calcula el resultado y lo muestra por pantalla
     */
    private void Operar() {
        if (operacion.equals("+")) {
            resultado += new Double(pantalla.getText());
        } else if (operacion.equals("-")) {
            resultado -= new Double(pantalla.getText());
        } else if (operacion.equals("/")) {
            resultado /= new Double(pantalla.getText());
        } else if (operacion.equals("*")) {
            resultado *= new Double(pantalla.getText());
        }

        pantalla.setText("" + resultado);
        operacion = "";
    }
}
