/**
 * ZBug
 * @author Linyiting
 */
import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

/**
 * The class of z bug
 * A <code>ZBug</code> traces out a "z" of a given size. <br />
 */
public class ZBug extends Bug
{
    private int steps;
    private int sideLength;
    private int stages;
    
    /**
     * Constructs a z bug that traces a "z" of a given side length
     * @param length the z length
     */
    public ZBug(int length)
    {
        steps = 0;
        stages = 0;
        sideLength = length;
    }

    /**
     * Move to a new location of the z letter
     */
    public void act()
    {
        if (steps == 0) {
            if (stages == 0) {
                setDirection(Location.EAST);
            } else if (stages == 1) {
                setDirection(Location.SOUTHWEST);
            } else if (stages == 2) {
                setDirection(Location.EAST);
            } else {
                return;
            }
        }
        if (steps < sideLength && canMove()) {
            move();
            steps++;
        } else if (canMove()) {
            stages++;
            steps = 0;
        } else {
            return;
        }
    }
}
