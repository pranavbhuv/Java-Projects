import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*;

public class Main {
    public static void main(String... args) {
        JFrame j = new JFrame();
        MyPanel4 m = new MyPanel4();
        j.setSize(m.getSize());
        j.add(m); //adds the panel to the frame so that the picture will be drawn
        //use setContentPane() sometimes works better then just add b/c of greater efficiency.

        j.addKeyListener(m);
        j.addMouseListener(m);
        j.setVisible(true); //allows the frame to be shown.

        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //makes the dialog box exit when you click the "x" button.
    }

}

class MyPanel4 extends JPanel implements ActionListener, MouseListener, KeyListener {
    private Timer time;
    private int ox, oy, rx, ry;
    private int add;
    private int change;

    private String codeName;

    private int checkforR = 0;

    MyPanel4() {
        ox = oy = 10;
        rx = ry = 300;
        time = new Timer(15, this); //sets delay to 15 millis and calls the actionPerformed of this class.
        setSize(2000, 1500);
        setVisible(true); //it's like calling the repaint method.
        time.start();
        add = 1;
        change = 1;
    }


    public void paintComponent(Graphics g) {
        switch (change) {
            case 1 -> g.setColor(new Color(0, 150, 150));
            case 2 -> g.setColor(new Color(150, 150, 0));
            case 3 -> g.setColor(new Color(150, 0, 150));
            case 4 -> g.setColor(new Color(150, 150, 100));
            case 5 -> g.setColor(new Color(100, 20, 50));
            case 6 -> g.setColor(new Color(250, 20, 50));
            case 7 -> g.setColor(new Color(120, 50, 90));
            case 8 -> g.setColor(new Color(150, 20, 90));
            case 9 -> g.setColor(new Color(0, 200, 150));
        }

        // Background
        g.fillRect(0, 0, 2000, 1500);

        myRect(g, rx, ry);
        myOval(g, ox, oy);

        // Barrier
        g.setColor(Color.BLACK);
        g.drawRect(1050, 0, 10, 1000);
        g.fillRect(1050, 0, 10, 1000);

        // Info
        g.setFont(new Font("Arial", Font.BOLD, 25));
        g.drawString("- Right-click anywhere to move", 1100, 100);
        g.drawString("  the face.", 1100, 125);
        g.drawString("- Press 1 through 9 to change ", 1100, 175);
        g.drawString("  background color. [SPACEBAR], ", 1100, 200);
        g.drawString("  will reset your background.", 1100, 225);
        g.drawString("- [R or r] will move the face to a", 1100, 275);
        g.drawString("  random safe location.", 1100, 300);

        g.drawString("Key Tapped: " + codeName, 1100, 645);

        String x = Integer.toString(rx);
        String y = Integer.toString(ry);
        g.drawString("Current X: " + x, 1100, 670);
        g.drawString("Current Y: " + y, 1100, 695);
    }

    public void actionPerformed(ActionEvent e) {
        ox += add;
        oy += add;
        if (ox == 200 && oy == 200)
            add *= -1;
        if (ox == 10 && oy == 10)
            add *= -1;

        repaint();
    }

    public void myRect(Graphics g, int x, int y) {
        // Checks the barrier,
        if (x + 250 >= 1050) {
            g.setColor(Color.red);
            g.setFont(new Font("Arial", Font.BOLD, 25));
            g.drawString("You cannot draw there!", 1100, 450);
        } else {
            g.setColor(Color.DARK_GRAY);
            g.fillRect(x - 20, y - 20, 300, 250);
            g.setColor(Color.red);
            g.fillRect(x, y, 75, 75);
            g.fillRect(x + 190, y, 75, 75);
            g.fillRect(x, y + 180, 250, 25);
        }
    }

    public void myOval(Graphics g, int x, int y) {
        g.setColor(Color.DARK_GRAY);
        g.fillOval(x - 20, y - 20, 115, 115);
        g.setColor(Color.RED);
        g.fillOval(x, y, 75, 75);
    }

    public void mouseClicked(MouseEvent e) {
        codeName = "Mouse Click";
        rx = e.getX();
        ry = e.getY();
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == 82) {
            checkforR = 1;
        }
        if (e.getKeyCode() != 32) {
            codeName = Character.toString(e.getKeyChar());
        } else {
            codeName = "Spacebar";
        }

        // SPACE key changes back to original backrgound, SPACE returns 32.
        switch (code) {
            case '1' -> change = 1;
            case '2' -> change = 2;
            case '3' -> change = 3;
            case '4' -> change = 4;
            case '5' -> change = 5;
            case '6' -> change = 6;
            case '7' -> change = 7;
            case '8' -> change = 8;
            case '9' -> change = 9;
            case KeyEvent.VK_SPACE -> change = 1;
        }

        /**code == KeyEvent.VK_RIGHT for right arrow
         * code == KeyEvent.VK_LEFT for left arrow
         * code == KeyEvent.VK_SPACE
         **/

    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

}
