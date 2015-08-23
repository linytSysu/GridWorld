/**
 * RockHound
 * @author Linyiting
 */

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;

import java.util.ArrayList;
/**
 * A RockHound gets the actors to be processed in the same way as 
 * a Critter. It removes any rocks in that list from the grid. A 
 * RockHound moves like a Critter.
 */
public class RockHound extends Critter {
    public void processActors(ArrayList<Actor> actors)
    {
        for (Actor a : actors)
        {
            if (a instanceof Rock) {
                a.removeSelfFromGrid();
            }
        }
    }
}
