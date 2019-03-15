import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Formulario {

    public JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Formulario window = new Formulario();
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
    public Formulario() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    public void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 389, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel pantalla = new JLabel("New label");
        pantalla.setBounds(10, 11, 414, 63);
        frame.getContentPane().add(pantalla);

        JLabel pError = new JLabel("New label");
        pError.setBounds(10, 85, 414, 21);
        frame.getContentPane().add(pError);

        JButton button0 = new JButton("0");
        button0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        button0.setBounds(10, 215, 89, 35);
        frame.getContentPane().add(button0);

        JButton button1 = new JButton("1");
        button1.setBounds(10, 182, 89, 35);
        frame.getContentPane().add(button1);

        JButton button2 = new JButton("2");
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        button2.setBounds(96, 182, 89, 35);
        frame.getContentPane().add(button2);

        JButton button3 = new JButton("3");
        button3.setBounds(183, 182, 89, 35);
        frame.getContentPane().add(button3);

        JButton button4 = new JButton("4");
        button4.setBounds(10, 149, 89, 35);
        frame.getContentPane().add(button4);

        JButton button5 = new JButton("5");
        button5.setBounds(96, 149, 89, 35);
        frame.getContentPane().add(button5);

        JButton button6 = new JButton("6");
        button6.setBounds(183, 149, 89, 35);
        frame.getContentPane().add(button6);

        JButton button7 = new JButton("7");
        button7.setBounds(10, 117, 89, 35);
        frame.getContentPane().add(button7);

        JButton button8 = new JButton("8");
        button8.setBounds(96, 117, 89, 35);
        frame.getContentPane().add(button8);

        JButton button9 = new JButton("9");
        button9.setBounds(183, 117, 89, 35);
        frame.getContentPane().add(button9);

        JButton button10 = new JButton("X");
        button10.setBounds(269, 117, 89, 35);
        frame.getContentPane().add(button10);

        JButton button11 = new JButton("-");
        button11.setBounds(269, 149, 89, 35);
        frame.getContentPane().add(button11);

        JButton button12 = new JButton("+");
        button12.setBounds(269, 182, 89, 35);
        frame.getContentPane().add(button12);

        JButton button13 = new JButton("=");
        button13.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        button13.setBounds(269, 215, 89, 35);
        frame.getContentPane().add(button13);

        JButton button14 = new JButton("/");
        button14.setBounds(183, 215, 89, 35);
        frame.getContentPane().add(button14);

        JButton button15 = new JButton("CE");
        button15.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        button15.setBounds(96, 215, 89, 35);
        frame.getContentPane().add(button15);
    }
}