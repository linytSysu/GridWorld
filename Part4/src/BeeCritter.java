/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 * @author Cay Horstmann
 */

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;

/**
 * A <code>CrabCritter</code> looks at a limited set of neighbors when it eats and moves.
 * <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class BeeCritter extends Critter
{
    public BeeCritter()
    {
        setColor(Color.YELLOW);
    }

    public void processActors(ArrayList<Actor> actors)
    {
        return;
    }

    /**
     * @return list of empty locations immediately to the right and to the left
     */
    public ArrayList<Location> getMoveLocations()
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        int[] dirs =
            { Location.AHEAD, Location.HALF_LEFT, Location.HALF_RIGHT, Location.RIGHT, Location.LEFT };
        for (Location loc : getLocationsInDirections(dirs)) {
            if (getGrid().get(loc) instanceof Flower) {
                locs.add(loc);
            }
        }
        if(locs.size() == 0)
        {
            int[] dir = {Location.AHEAD};
            ArrayList<Location> dirLoc = getLocationsInDirections(dir);
            if (dirLoc.size() != 0 && getGrid().get(dirLoc.get(0)) == null) {
                locs.add(dirLoc.get(0));
            } else {
                locs.add(getLocation());
            }
        }
        return locs;
    }

    /**
     * If the crab critter doesn't move, it randomly turns left or right.
     */
    public void makeMove(Location loc)
    {
        if (loc.equals(getLocation()))
        {
            setDirection(getDirection() + Location.HALF_RIGHT);
        }
        else
        {
            if (getGrid().get(loc) instanceof Flower)
            {
                setColor(getGrid().get(loc).getColor());
                setDirection(getLocation().getDirectionToward(loc));
            }

            super.makeMove(loc);
        }
    }
    
    /**
     * getLocationInDirection method
     * copy from CrabCritter
     */
    public ArrayList<Location> getLocationsInDirections(int[] directions)
    {
        ArrayList<Location> locations = new ArrayList<Location>();
        Grid gr = getGrid();
        Location loc = getLocation();
    
        for (int d : directions)
        {
            Location neighborLoc = loc.getAdjacentLocation(getDirection() + d);
            if (gr.isValid(neighborLoc)) {
                locations.add(neighborLoc);
            }
        }
        return locations;
    }
}
