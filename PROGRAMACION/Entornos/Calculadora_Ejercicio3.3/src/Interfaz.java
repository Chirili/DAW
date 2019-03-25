import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;


public class Interfaz{

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
    Calculadora a = new Calculadora();
    /**
     * Create the application.
     */
    public Interfaz() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    public void initialize(){



        frame = new JFrame();
        frame.setBounds(100, 100, 384, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel screen = new JLabel("New label");
        screen.setBounds(10, 11, 414, 63);
        frame.getContentPane().add(screen);

        JLabel pError = new JLabel("New label");
        pError.setBounds(10, 74, 414, 30);
        frame.getContentPane().add(pError);

        JButton button0 = new JButton("0");
        button0.setBounds(10, 213, 89, 37);
        frame.getContentPane().add(button0);
        button0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent addValue) {
                Calculadora Calculadora = new Calculadora();

            }
        });

        JButton button1 = new JButton("1");
        button1.setBounds(10, 178, 89, 37);
        frame.getContentPane().add(button1);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent addValue) {

                try{
                    if (a.valor==0){
                        screen.setText("1");
                        a.valor=1;
                    }else {
                        screen.setText(screen.getText() + "1");
                        a.valor=a.valor*10+1;
                    }
                }catch (Exception err){}
            }
        });

        JButton button2 = new JButton("2");
        button2.setBounds(96, 178, 89, 37);
        frame.getContentPane().add(button2);
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent button2) {
                screen.setText("2");
            }
        });

        JButton button3 = new JButton("3");
        button3.setBounds(183, 178, 89, 37);
        frame.getContentPane().add(button3);
        

        JButton button4 = new JButton("4");
        button4.setBounds(10, 143, 89, 37);
        frame.getContentPane().add(button4);
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent button4) {
                screen.setText("4");
            }
        });

        JButton button5 = new JButton("5");
        button5.setBounds(96, 143, 89, 37);
        frame.getContentPane().add(button5);
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent button5) {
                screen.setText("5");
            }
        });

        JButton button6 = new JButton("6");
        button6.setBounds(183, 143, 89, 37);
        frame.getContentPane().add(button6);
        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent button6) {
                screen.setText("6");
            }
        });

        JButton button7 = new JButton("7");
        button7.setBounds(10, 108, 89, 37);
        frame.getContentPane().add(button7);
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent button7) {
                screen.setText("7");
            }
        });

        JButton button8 = new JButton("8");
        button8.setBounds(96, 108, 89, 37);
        frame.getContentPane().add(button8);
        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent button8) {
                screen.setText("8");
            }
        });

        JButton button9 = new JButton("9");
        button9.setBounds(183, 108, 89, 37);
        frame.getContentPane().add(button9);
        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent button9) {
                screen.setText("9");
            }
        });

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