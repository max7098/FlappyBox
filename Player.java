
/**
 */
public class Player
{
    private int height;
    private int velocity;
    public Player()
    {
        height = 10;//sets default initial height and downward velocity
        velocity = 0;
    }

    public int getHeight()
    {
        return height;
    }
    
    public void calcHeight()
    {
        velocity = Gravity.newVelocity(velocity);
        height = Gravity.newHeight(height,velocity);
    }
    
    public void jump()
    {
        velocity+=10;
    }
}
