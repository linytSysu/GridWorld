/*
 * SpiralleBug
 * @author Linyiting
 */
import info.gridworld.actor.Bug;

/**
 * The class of spiral bug
 * A <code>SpiralBug</code> traces out a spiral.
 */

public class SpiralBug extends Bug {
    private int steps;
    private int sideLength;
    
    /**
     * The constructor of SpiralBug
     */
    public SpiralBug(int length)
    {
        steps = 0;
        sideLength = length;
    }

    /**
     * Moves to the next location of the spiral.
     */
    public void act()
    {
        if (steps < sideLength && canMove())
        {
            move();
            steps++;
        }
        else
        {
            turn();
            turn();
            sideLength++;
            steps = 0;
        }
    }
}

