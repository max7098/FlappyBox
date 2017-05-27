
public class Gravity
{
    private final static int GRAVITY = 1; //represents the acceleration of pixels per second per second

    public static int newVelocity(int curVel)
    {
        return curVel - GRAVITY;
    }
    
    public static int newHeight(int curHeight, int vel)
    {
        return curHeight + vel;
    }
    
}
