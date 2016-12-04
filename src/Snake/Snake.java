package Snake;

/**
 * Created by dmitri.kiriljuk on 03.12.2016.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Snake implements ActionListener, KeyListener {

    public JFrame jframe;
    public RenderPanel renderPanel;
    public static Snake snake;
    public Timer timer = new Timer(20, this);
    public ArrayList<Point> snakeParts = new ArrayList<Point>();
    public final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3, SCALE = 10;
    public int ticks = 0, direction = DOWN, score, tailLenght = 10;
    public boolean over;
    public Point head, cherry;

    public Snake() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        jframe = new JFrame("Snake");
        jframe.setTitle("Snake by Kiriljuk");
        jframe.setVisible(true);
        jframe.setSize(800, 600);
        int x = (int) ((dim.getWidth() - jframe.getWidth()) / 2);
        int y = (int) ((dim.getHeight() - jframe.getHeight()) / 2);
        jframe.setLocation(x, y);
        jframe.add(renderPanel = new RenderPanel());
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.addKeyListener(this);
        head = new Point(0, 0);
        cherry = new Point((int) dim.getWidth() / SCALE, (int) dim.getHeight() / SCALE);

        for (int i = 0;i < tailLenght  ;i++ )
        {
            snakeParts.add(new Point(head.x,head.y));
        }
        timer.start();
    }

    public static void main(String[] args) {
        snake = new Snake();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        renderPanel.repaint();
        ticks++;
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        if (ticks % 10 == 0 && head != null) {
            if (direction == UP)
                if()
                head =  new Point(head.x, head.y - 1);
            else
                over = true;
                //head = new Point(head.x, head.y - 1);
            if (direction == DOWN)
                head = new Point(head.x, head.y + 1);
            else
                over = true;
                //head = new Point(head.x, head.y + 1);
            if (direction == RIGHT)
                head = new Point(head.x + 1, head.y);
            else
                over = true;
                //head = new Point(head.x + 1, head.y);
            if (direction == LEFT)
                head = new Point(head.x - 1, head.y);
            else
                over = true;
                //head = new Point(head.x - 1, head.y);
            snakeParts.add(new Point(head.x,head.y));
            for (int i = 0; i < tailLenght; i++ )
               {
                  snakeParts.remove(i);
                }

            if (cherry != null) {
                if (head.equals(cherry)) {
                    score += 10;
                    tailLenght++;
                    cherry.setLocation((int) dim.getWidth() / SCALE, (int) dim.getHeight() / SCALE);
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int i = e.getKeyCode();
        if (i==KeyEvent.VK_A && direction != RIGHT)
            direction = LEFT;
        if (i==KeyEvent.VK_D && direction != LEFT)
            direction = RIGHT;
        if (i==KeyEvent.VK_W && direction != DOWN)
            direction = UP;
        if (i==KeyEvent.VK_S && direction != UP)
            direction = DOWN;
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

