package Snake;

import javax.swing.*;
import java.awt.*;

/**
 * Created by dmitri.kiriljuk on 03.12.2016.
 */
public class RenderPanel extends JPanel {

    public static Color Blue = new Color(0x0000FF);
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Blue);
        g.fillRect(0,0,800,600);
        Snake snake = Snake.snake;
        g.setColor(Color.GREEN);
        for (Point point : snake.snakeParts)
        {
            g.fillRect(point.x * snake.SCALE, point.y * snake.SCALE, snake.SCALE, snake.SCALE);
        }
        g.fillRect(snake.head.x * snake.SCALE, snake.head.y * snake.SCALE, snake.SCALE, snake.SCALE);

    }
}
