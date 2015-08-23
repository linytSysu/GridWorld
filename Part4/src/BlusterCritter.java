/**
 * BlusterCritter
 * @author Linyiting
 */
import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.util.ArrayList;
import java.awt.Color;

/**
 * A BlusterCritter looks at all of the neighbors within two 
 * steps of its current location. (For a BlusterCritter not 
 * near an edge, this includes 24 locations). It counts the 
 * number of critters in those locations. If there are fewer 
 * than c critters, the BlusterCritter's color gets brighter (color 
 * values increase). If there are c or more critters, the 
 * BlusterCritter's color darkens (color values decrease). Here, c 
 * is a value that indicates the courage of the critter. It should 
 * be set in the constructor.
 */
public class BlusterCritter extends Critter {
    private int number;
    private static final double COLOR_FACTOR = 25;
    private static final int MAX_COLOR = 255;
    private static final int MIN_COLOR = 0;
    /**
     * constructor of BlusterCriter
     * @param n is the number of c
     */
    public BlusterCritter(int n) {
        this.number = n;
    }
    /**
     * Get the actors which are within 2 steps the critter
     */
    public ArrayList<Actor> getActors()
    {
        ArrayList<Actor> actors = new ArrayList<Actor>();
        int row = getLocation().getRow(), col = getLocation().getCol();
        int up = row-2;
        int down = row+2;
        int left = col-2;
        int right = col+2;
        Grid<Actor> grid = getGrid();
        if (grid == null) {
            return actors;
        }
        for (int i = left;  i <= right; i++) {
            for (int j = up; j <= down; j++) {
                if ( !(i == col && j == row) ) {
                    Location location = new Location(j, i);
                    if ( grid.isValid(location) ) {
                        Actor actor = grid.get(location);
                        if (actor != null) {
                            actors.add(actor);
                        }
                    }
                }
            }
        }
        return actors;
    }
    /**
     * Brighten or Darken the critter according the number of actors
     */
    public void processActors(ArrayList<Actor> actors)
    {
        int count = 0;
        for (Actor actor : actors) {
            if (actor instanceof Critter) {
                count++;
            }
        }
        if (count < number) {
            colorBrighten();
        } else {
            colorDarken();
        }
    }

    private void colorBrighten() {
        Color c = getColor();
        int red = (int)(c.getRed()+COLOR_FACTOR) < MAX_COLOR ? (int)(c.getRed()+COLOR_FACTOR) : MAX_COLOR;
        int green = (int)(c.getGreen()+COLOR_FACTOR) < MAX_COLOR ? (int)(c.getGreen()+COLOR_FACTOR) : MAX_COLOR;
        int blue = (int)(c.getBlue()+COLOR_FACTOR) < MAX_COLOR ? (int)(c.getBlue()+COLOR_FACTOR) : MAX_COLOR;
        setColor(new Color(red, green, blue));
    }

    private void colorDarken() {
        Color c = getColor();
        int red = (int)(c.getRed()-COLOR_FACTOR) > MIN_COLOR ? (int)(c.getRed()-COLOR_FACTOR) : MIN_COLOR;
        int green = (int)(c.getGreen()-COLOR_FACTOR) > MIN_COLOR ? (int)(c.getGreen()-COLOR_FACTOR) : MIN_COLOR;
        int blue = (int)(c.getBlue()-COLOR_FACTOR) > MIN_COLOR ? (int)(c.getBlue()-COLOR_FACTOR) : MIN_COLOR;
        setColor(new Color(red, green, blue));
    }
}
