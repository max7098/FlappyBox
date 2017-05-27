import javax.swing.*;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * The main game
 */
public class Game extends JComponent
{
    private static Player p1 = new Player();

    private static ScoreKeeper s1 = new ScoreKeeper();

    private static ArrayList<Obstacle> Obastacles = new ArrayList<Obstacle>();

    public static void main(String[] args)
    {

        JFrame frame = new JFrame();
        frame.addKeyListener(new KeyAdapter()
            {
                public void keyPressed(KeyEvent e)
                {
                    if(e.getKeyCode() == KeyEvent.VK_SPACE)//controls go here
                    {
                        p1.jump();
                    }
                }
            });

        Game component = new Game();
        frame.add(component);
        frame.setSize(500,500);
        //frame.getContentPane().setBackground(Color.BLACK);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int counter = 0;

        p1.calcHeight();
        frame.repaint();
        JOptionPane.showMessageDialog(null, "Press space to start");

        outerloop:
        while(true)//time element
        {
            try
            {
                Thread.sleep(30);//tells computer to stall so it seems like object is moving

            }
            catch(Exception e)
            {

            }
            p1.calcHeight();
            frame.repaint();

            for(int i = 0; i< Obastacles.size();i++)//goes through each and every obstacle to see how affected
            {
                Obastacles.get(i).move();
                if(Obastacles.get(i).notInRange())
                {
                    Obastacles.remove(i);
                    s1.scored();
                }

                if((Obastacles.get(i).colides(60-p1.getHeight()))||60-p1.getHeight()<0||60-p1.getHeight()>480)
                {
                    JOptionPane.showMessageDialog(null, "You lose!");
                    break outerloop;
                }
            }
            if (counter%200 == 0)
            {
                Obastacles.add(new Obstacle(frame.getHeight(),frame.getWidth()));//gens new obstacle
            }

            counter++;
        }

    }

    public void paintComponent(Graphics g)//graphics
    {
        g.fillRect(100,60-p1.getHeight(),20,20);

        for(Obstacle o: Obastacles) {
            o.draw(g);
        }

        g.setColor(Color.BLACK);
        g.setFont(g.getFont().deriveFont(20f));
        g.drawString("Score: "+ s1.getScore(),0,20);

    }

}
