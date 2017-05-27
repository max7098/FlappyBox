import java.awt.*;
/**
 */
public class Obstacle
{
    private Rectangle top;
    private Rectangle bot;
    
    private final int SPACESIZE = 80;//space that the block can fit through
    private final int WIDTH = 20;//thickness of the obstacle  TODO make these vary
    
    public Obstacle(int Gameheight, int Gamewidth)
    {
        int randomSpace = (int)((Gameheight-SPACESIZE)*Math.random());//chooses a random point to draw polls
        
        top = new Rectangle(Gamewidth,0,WIDTH,randomSpace);//in two parts so that there is a space to fit through
        bot = new Rectangle(Gamewidth,randomSpace + SPACESIZE, WIDTH, Gameheight);
    }
    
    public void move()
    {
        top.setLocation((int)top.getX()-1,(int)top.getY());//moves the rectangles 1 pixel closer (and flappy block one pixel to the right)
        
        bot.setLocation((int)bot.getX()-1,(int)bot.getY());
    }
    
    public boolean notInRange()
    {
        return top.getX()<0;//this is used to calculate score and know when to stop keeping track of an obstacle
    }
    
    public boolean colides(int height)//if box loses
    {
        if (top.getX()<120 && top.getX()>80)
        {
            if(height<top.getHeight()||height+20>bot.getY())
            {
                return true;
            }
        }
        return false;
    }
    
    
    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(top.x, top.y, top.width, top.height);
        
        g.fillRect(bot.x, bot.y, bot.width, bot.height);
    }
}
