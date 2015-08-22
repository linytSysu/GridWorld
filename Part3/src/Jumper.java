/**
 * Jumper Acotr
 * @author Linyiting  
 */

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import java.awt.Color;

/**
 * Jumper actor can move forward two cells in each move. 
 * It "jumps" over rocks and flowers. It does not leave 
 * anything behind it when it jumps
 */
public class Jumper extends Actor {
    /**
     * Constructs a green jumper.
     */
    public Jumper() {
        setColor(Color.GREEN);
    }
    /**
     * Constructs a jumper of a given color.
     * @param bugColor the color for this bug
     */
    public Jumper(Color jumperColor) {
        setColor(jumperColor);
    }
    /**
     * Turns the jumper 45 degrees to the right without changing its location.
     */
    public void turn() {
        setDirection(getDirection() + Location.HALF_RIGHT);
    }
    /**
     * Moves if it can move, turns otherwise.
     */
    public void act() {
        if (canJump()) {
            jump();
        } else {
            turn();
        }
    }
    /**
     * Jumps the bug forward
     */
    public void jump() {
        Grid<Actor> gr = getGrid();
        if (gr == null) {
            return;
        }
        if (canJump()) {
            Location loc = getLocation();
            Location next = loc.getAdjacentLocation(getDirection());
            Location next2 = next.getAdjacentLocation(getDirection());   
            moveTo(next2);
        } else {
            removeSelfFromGrid();
        }
    }
    /**
     * Tests whether this jumper can jumps forward
     * @return true if this jumper can jump.
     */
    public boolean canJump() {
        Grid<Actor> gr = getGrid();
        if (gr == null) {
            return false;
        }
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (!gr.isValid(next)) {
            return false;
        }
        Actor act = gr.get(next);
        if (act == null || act instanceof Flower || act instanceof Rock) {
            Location next2 = next.getAdjacentLocation(getDirection());
            if (!gr.isValid(next2)) {
                return false;
            }
            if (gr.get(next2) == null) {
                return true;
            }
        }
        return false;
    }
}
