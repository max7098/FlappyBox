public class ScoreKeeper
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * TODO add high score functionality
     */
    public ScoreKeeper()
    {
        // initialise instance variables
        x = 0;
    }

    public void scored()
    {
        x++;
    }
    
    public int getScore()
    {
        return x;
    }
}
