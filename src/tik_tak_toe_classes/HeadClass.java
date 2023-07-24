package tik_tak_toe_classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

public class HeadClass {
    protected static int counter = 9;
    protected static String[] templist = {"q", "w", "e", "r", "t", "y", "u", "i", "p"};
    protected static JButton a1 = new JButton();
    protected static JButton a2 = new JButton();
    protected static JButton a3 = new JButton();
    protected static JButton a4 = new JButton();
    protected static JButton a5 = new JButton();
    protected static JButton a6 = new JButton();
    protected static JButton a7 = new JButton();
    protected static JButton a8 = new JButton();
    protected static JButton a9 = new JButton();
    protected static JButton reset = new JButton("Сброс");

    public HeadClass(){
        createWindow();
        play_process();
    }

    private void createWindow(){
        JFrame jFrame = new JFrame("Крестики-нолики");
        jFrame.setSize(500, 500);

        GridLayout gridLayout = new GridLayout(4, 4);
        JPanel pole = new JPanel(gridLayout);

        pole.add(a1);
        pole.add(a2);
        pole.add(a3);
        pole.add(a4);
        pole.add(a5);
        pole.add(a6);
        pole.add(a7);
        pole.add(a8);
        pole.add(a9);
        pole.add(reset);
        jFrame.add(pole, BorderLayout.CENTER);

        jFrame.getContentPane().setBackground(Color.PINK);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }

    private void play_process() {
        Button_Handler h1 = new Button_Handler(a1);
        Button_Handler h2 = new Button_Handler(a2);
        Button_Handler h3 = new Button_Handler(a3);
        Button_Handler h4 = new Button_Handler(a4);
        Button_Handler h5 = new Button_Handler(a5);
        Button_Handler h6 = new Button_Handler(a6);
        Button_Handler h7 = new Button_Handler(a7);
        Button_Handler h8 = new Button_Handler(a8);
        Button_Handler h9 = new Button_Handler(a9);
        Button_Handler r = new Button_Handler(reset);

        a1.addMouseListener(h1);
        a2.addMouseListener(h2);
        a3.addMouseListener(h3);

        a4.addMouseListener(h4);
        a5.addMouseListener(h5);
        a6.addMouseListener(h6);

        a7.addMouseListener(h7);
        a8.addMouseListener(h8);
        a9.addMouseListener(h9);
        reset.addMouseListener(r);
    }

}

class Button_Handler extends Component implements MouseListener{
    JButton button = new JButton();
    private static final String X = "X";
    private static final String O = "0";

    public Button_Handler(JButton a) {
        button = a;
    }

    private void putToList(MouseEvent e) {
        if (e.getSource().equals(HeadClass.a1)) {
            HeadClass.templist[0] = HeadClass.a1.getText();
        }
        if (e.getSource().equals(HeadClass.a2)) {
            HeadClass.templist[1] = HeadClass.a2.getText();
        }
        if (e.getSource().equals(HeadClass.a3)) {
            HeadClass.templist[2] = HeadClass.a3.getText();
        }


        if (e.getSource().equals(HeadClass.a4)) {
            HeadClass.templist[3] = HeadClass.a4.getText();
        }
        if (e.getSource().equals(HeadClass.a5)) {
            HeadClass.templist[4] = HeadClass.a5.getText();
        }
        if (e.getSource().equals(HeadClass.a6)) {
            HeadClass.templist[5] = HeadClass.a6.getText();
        }

        if (e.getSource().equals(HeadClass.a7)) {
            HeadClass.templist[6] = HeadClass.a7.getText();
        }
        if (e.getSource().equals(HeadClass.a8)) {
            HeadClass.templist[7] = HeadClass.a8.getText();
        }
        if (e.getSource().equals(HeadClass.a9)) {
            HeadClass.templist[8] = HeadClass.a9.getText();
        }
    }

    private void checkConditions() {
        boolean condition = HeadClass.templist[0] == HeadClass.templist[1] && HeadClass.templist[1] == HeadClass.templist[2]    ||  // 0 1 2
                HeadClass.templist[3] == HeadClass.templist[4] && HeadClass.templist[4] == HeadClass.templist[5]  ||                // 3 4 5
                HeadClass.templist[6] == HeadClass.templist[7] && HeadClass.templist[7] == HeadClass.templist[8]  ||                // 6 7 8
                HeadClass.templist[0] == HeadClass.templist[3] && HeadClass.templist[3] == HeadClass.templist[6]  ||
                HeadClass.templist[1] == HeadClass.templist[4] && HeadClass.templist[4] == HeadClass.templist[7]  ||
                HeadClass.templist[2] == HeadClass.templist[5] && HeadClass.templist[5] == HeadClass.templist[8]  ||
                HeadClass.templist[0] == HeadClass.templist[4] && HeadClass.templist[4] == HeadClass.templist[8]  ||
                HeadClass.templist[2] == HeadClass.templist[4] && HeadClass.templist[4] == HeadClass.templist[6];
        if (condition) {
            JOptionPane.showConfirmDialog(this, "Новая игра?", "GameOver!", JOptionPane.INFORMATION_MESSAGE);
            reset();
        } else {
            if (HeadClass.counter == 1) {
                JOptionPane.showConfirmDialog(this, "Ничья\nНовая игра?", "GameOver!", JOptionPane.INFORMATION_MESSAGE);
                reset();
            }
        }
    }

    private void reset() {
        HeadClass.templist = Arrays.copyOf(new String[]{"q", "w", "e", "r", "t", "y", "u", "i", "p"}, 9);
        HeadClass.counter = 9;
        System.out.println(Arrays.toString(HeadClass.templist));
        System.out.println(HeadClass.counter);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(button != HeadClass.reset){
            if (HeadClass.counter % 2 != 0 && HeadClass.counter != 1) {
                button.setText(X);
                putToList(e);
                checkConditions();
                System.out.println(Arrays.toString(HeadClass.templist));
            } else
            {
                if (HeadClass.counter % 2 == 0) {
                    button.setText(O);
                    putToList(e);
                    checkConditions();
                    System.out.println(Arrays.toString(HeadClass.templist));
                }
                if (HeadClass.counter == 1) {
                    checkConditions();
                    System.out.println("Игра закончена");
                }
            }
            HeadClass.counter--;
        }
        else {
            HeadClass.a1.setText("");
            HeadClass.a2.setText("");
            HeadClass.a3.setText("");
            HeadClass.a4.setText("");
            HeadClass.a5.setText("");
            HeadClass.a6.setText("");
            HeadClass.a7.setText("");
            HeadClass.a8.setText("");
            HeadClass.a9.setText("");
            reset();
        }

    }


    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}