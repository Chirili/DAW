import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;


public class Interfaz {

    public JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Interfaz window = new Interfaz();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public Interfaz() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 384, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel pantalla = new JLabel("New label");
        pantalla.setBounds(10, 11, 414, 63);
        frame.getContentPane().add(pantalla);

        JLabel pError = new JLabel("New label");
        pError.setBounds(10, 74, 414, 30);
        frame.getContentPane().add(pError);

        JButton button0 = new JButton("0");
        button0.setBounds(10, 213, 89, 37);
        frame.getContentPane().add(button0);

        JButton button1 = new JButton("1");
        button1.setBounds(10, 178, 89, 37);
        frame.getContentPane().add(button1);

        JButton button2 = new JButton("2");
        button2.setBounds(96, 178, 89, 37);
        frame.getContentPane().add(button2);

        JButton button3 = new JButton("3");
        button3.setBounds(183, 178, 89, 37);
        frame.getContentPane().add(button3);

        JButton button4 = new JButton("4");
        button4.setBounds(10, 143, 89, 37);
        frame.getContentPane().add(button4);

        JButton button5 = new JButton("5");
        button5.setBounds(96, 143, 89, 37);
        frame.getContentPane().add(button5);

        JButton button6 = new JButton("6");
        button6.setBounds(183, 143, 89, 37);
        frame.getContentPane().add(button6);

        JButton button7 = new JButton("7");
        button7.setBounds(10, 108, 89, 37);
        frame.getContentPane().add(button7);

        JButton button8 = new JButton("8");
        button8.setBounds(96, 108, 89, 37);
        frame.getContentPane().add(button8);

        JButton button9 = new JButton("9");
        button9.setBounds(183, 108, 89, 37);
        frame.getContentPane().add(button9);

        JButton button10 = new JButton("X");
        button10.setBounds(269, 108, 89, 37);
        frame.getContentPane().add(button10);

        JButton button11 = new JButton("-");
        button11.setBounds(269, 143, 89, 37);
        frame.getContentPane().add(button11);

        JButton button12 = new JButton("+");
        button12.setBounds(269, 178, 89, 37);
        frame.getContentPane().add(button12);

        JButton button13 = new JButton("=");
        button13.setBounds(269, 213, 89, 37);
        frame.getContentPane().add(button13);

        JButton button14 = new JButton("/");
        button14.setBounds(183, 213, 89, 37);
        frame.getContentPane().add(button14);

        JButton button15 = new JButton("CE");
        button15.setBounds(96, 213, 89, 37);
        frame.getContentPane().add(button15);
    }
}