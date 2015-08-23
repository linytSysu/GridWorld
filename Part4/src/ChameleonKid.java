/**
 * ChameleonKid
 * @author Linyiting
 */
import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;

import java.util.ArrayList;

/**
 * A ChameleonKid changes its color to the color of 
 * one of the actors immediately in front or behind.
 * If there is no actor in either of these locations,
 * then the ChameleonKid darkens like the modified ChameleonCritter.
 */
public class ChameleonKid extends ChameleonCritter {
    /**
     * Override the getActors method
     * Get the actors that be in front of or behind
     */
    public ArrayList<Actor> getActors()
    {
        ArrayList<Actor> actors = new ArrayList<Actor>();
        int[] dirs = { Location.AHEAD, Location.HALF_CIRCLE };
        for (Location loc : getLocationsInDirections(dirs))
        {
            Actor a = getGrid().get(loc);
            if (a != null) {
                actors.add(a);
            }
        }
        return actors;
    }
    /**
     * The function is from CrabCritter.java
     */
    public ArrayList<Location> getLocationsInDirections(int[] directions)
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        Grid gr = getGrid();
        Location loc = getLocation();
    
        for (int d : directions)
        {
            Location neighborLoc = loc.getAdjacentLocation(getDirection() + d);
            if (gr.isValid(neighborLoc)) {
                locs.add(neighborLoc);
            }
        }
        return locs;
    }    
}
