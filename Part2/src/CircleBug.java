/**
 * CircleBug
 * @author Linyiting
 */

import info.gridworld.actor.Bug;

/**
 * The class of circle bug
 * A <code>CircleBug</code> traces out a circle of a given size. <br />
 */
public class CircleBug extends Bug {
    
    private int steps;
    private int sideLength;

    /**
     * Constructs a circle bug that traces a square of a given side length
     * @param length the side length
     */
    public CircleBug(int length)
    {
        steps = 0;
        sideLength = length;
    }

    /**
     * Move to a new location of the circle
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
            // just turn once
            turn();
            steps = 0;
        }
    }
}

