/*
 * DancingBug
 * @author Linyiting
 */

import info.gridworld.actor.Bug;
/**
 * The class of dacing bug
 * A <code>DancingBug</code>
 */
public class DancingBug extends Bug
{
    private int steps;
    private int stages;
    private int turns[];

    /**
     * Constructs a circle bug that traces a square of a given side length
     * @param turnArr the turns array
     */
    public DancingBug(int[] turnArr)
    {
        steps = 0;
        stages = 0;
        turns = turnArr.clone();
    }
    /**
     * Turn and move to a new location
     */
    public void act()
    {
        stages = stages%turns.length;
        if (steps < turns[stages]) {
            turn();
            steps++;
        } else if (canMove()) {
            move();
            steps = 0;
            stages++;
        } else {
            steps = 0;
            stages++;
        }
    }
}
