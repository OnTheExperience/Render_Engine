import javax.swing.*;
import java.awt.*;

public class RendWindow extends JFrame
{
    public MyPanel panel;

    public RendWindow(Dimension size, String title, Color background)
    {
        setSize(size.width+16,size.height+39);
        setTitle(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new MyPanel(size,background);
        add(panel);

        setVisible(true);
    }

    public class MyPanel extends JPanel
    {
        private Color[][] buffer;

        public MyPanel(Dimension size, Color background)
        {
            buffer = new Color[size.width][size.height];
            for(int x = 0; x < buffer.length-1; x++)
                for(int y = 0; y < buffer[0].length; y++)
                    buffer[x][y] = background;
        }

        public void SetPixel(Color c, int x, int y)
        {
            buffer[x][y]=c;
            this.repaint();
        }

        public void SwapBuffer(Color[][] buf)
        {
            buffer = buf;
            this.repaint();
        }

        public void paintComponent(Graphics g)
        {
            for(int x = 0; x < buffer.length-1; x++)
                for(int y = 0; y < buffer[0].length; y++)
                {
                    g.setColor(buffer[x][y]);
                    g.drawRect(x, y, 1, 1);
                }
        }
    }
}
