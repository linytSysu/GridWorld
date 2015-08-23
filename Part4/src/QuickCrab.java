/**
 * QuickCrab
 * @author Linyiting
 */

import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.util.ArrayList;

/**
 * A QuickCrab processes actors the same way a CrabCritter does. 
 * A QuickCrab moves to one of the two locations, randomly selected, 
 * that are two spaces to its right or left, if that location and 
 * the intervening location are both empty. Otherwise, a QuickCrab 
 * moves like a CrabCritter.
 */
public class QuickCrab extends CrabCritter {

    public void act()
    {
        if (getGrid() == null) {
            return;
        }
        ArrayList<Actor> actors = getActors();
        processActors(actors);
        ArrayList<Location> moveLocs = getDoubleMoveLocations();
        if (moveLocs.size() == 0) {
            moveLocs = getMoveLocations();
        }
        Location loc = selectMoveLocation(moveLocs);
        makeMove(loc);
    }

    public ArrayList<Location> getDoubleMoveLocations()
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        int[] dirs =
            { Location.LEFT, Location.RIGHT };
        for (Location loc : getDoubleLocationsInDirections(dirs)) {
            if (getGrid().get(loc) == null) {
                locs.add(loc);
            }
        }
        return locs;
    }
    /**
     * Find the locations that are two spaces to critter's right or left
     */
    public ArrayList<Location> getDoubleLocationsInDirections(int[] directions)
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        Grid gr = getGrid();
        Location loc = getLocation();
    
        for (int d : directions)
        {
            Location neighborLoc = loc.getAdjacentLocation(getDirection() + d);
            if (gr.isValid(neighborLoc)) {
                Location neighborLoc2 = neighborLoc.getAdjacentLocation(getDirection() + d);
                if (gr.get(neighborLoc) == null && gr.isValid(neighborLoc2)) {
                    if (gr.get(neighborLoc2) == null) {
                        locs.add(neighborLoc);
                        locs.add(neighborLoc2);
                    }
                } 
            }
        }
        return locs;
    }

}