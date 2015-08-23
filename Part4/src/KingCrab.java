/**
 * KingCrab
 * @author Linyiting
 */

import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * A KingCrab gets the actors to be processed in the same way a CrabCritter does. 
 * A KingCrab causes each actor that it processes to move one location further 
 * away from the KingCrab. If the actor cannot move away, the KingCrab removes it 
 * from the grid. When the KingCrab has completed processing the actors, it moves 
 * like a CrabCritter.
 */
public class KingCrab extends CrabCritter {
    /**
     * actorCanBeMoveTo method can find the locations that the actor can be moved to. 
     */
    private ArrayList<Location> actorCanMovedTo(Actor act) {
        Location loc = act.getLocation();
        ArrayList<Location> locs = getGrid().getEmptyAdjacentLocations(loc);
        Location crabLoc = getLocation();
        ArrayList<Location> crabLocs = getGrid().getEmptyAdjacentLocations(crabLoc);
        for (Iterator<Location> iterator = locs.iterator(); iterator.hasNext();) {
            Location l = iterator.next();
            if (getGrid().get(l) == null || !(l .equals(crabLoc))) {
                for(Location cl : crabLocs) {
                    if ( l.equals(cl) ) {
                        iterator.remove();
                    }
                }
            }
        }
        for (Location l : locs) {
            if (getGrid().get(l) == null || !(l .equals(crabLoc))) {
                for(Location cl : crabLocs) {
                    if ( l.equals(cl) ) {
                        locs.remove(l);
                    }
                }
            }
        }
        return locs;
    }
    /**
     * Override the processActors
     */
    public void processActors(ArrayList<Actor> actors)
    {
        for (Actor a : actors) {
            if ((a instanceof Rock) || (a instanceof Flower)) {
                a.removeSelfFromGrid();
            } else {
                for (Location loc : actorCanMovedTo(a)) {
                    int mayDir = a.getLocation().getDirectionToward(loc);
                    int dir = a.getDirection();
                    if (mayDir == dir) {
                        a.moveTo(loc);
                        return;
                    }
                }
                a.removeSelfFromGrid();
            }
        }
    }
}
