/**
 * SparseBoundedGrid2
 * @author Linyiting
 */

import info.gridworld.grid.Location;
import info.gridworld.grid.AbstractGrid;

import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;
/**
 *  Consider using a HashMap to implement the SparseBoundedGrid.
 */
public class SparseBoundedGrid3<E> extends AbstractGrid<E> {
    private int row;
    private int col;
    private Map<Location, E> occupantTMap;
    /**
     * Constructs an empty bounded grid with the given dimensions.
     * (Precondition: <code>rows > 0</code> and <code>cols > 0</code>.)
     * @param rows number of rows in BoundedGrid
     * @param cols number of columns in BoundedGrid
     */
    public SparseBoundedGrid3(int rows, int cols) {
        if (rows <= 0) {
            throw new IllegalArgumentException("rows <= 0");
        }
        if (cols <= 0) {
            throw new IllegalArgumentException("cols <= 0");
        }
        occupantTMap = new TreeMap<Location, E>();
        this.row = rows;
        this.col = cols;
    }

    public int getNumRows() {
        return row;
    }
    public int getNumCols() {
        return col;
    }
    public boolean isValid(Location loc) {
        return 0 <= loc.getRow() && loc.getRow() < getNumRows()
                && 0 <= loc.getCol() && loc.getCol() < getNumCols();
    }
    /**
     * Constructs an empty bounded grid with the given dimensions.
     * (Precondition: <code>rows > 0</code> and <code>cols > 0</code>.)
     * @param rows number of rows in BoundedGrid
     * @param cols number of columns in BoundedGrid
     */
    public ArrayList<Location> getOccupiedLocations() {
        ArrayList<Location> theLocations = new ArrayList<Location>();
        for (Location loc : occupantTMap.keySet()) {
            theLocations.add(loc);
        }
        return theLocations;
    }

    public E get(Location loc) {
        if (loc == null) {
            throw new IllegalArgumentException("loc == null");
        }
        if (!isValid(loc)) {
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
        }
        return occupantTMap.get(loc);
    }

    public E put(Location loc, E obj) {
        if (loc == null) {
            throw new IllegalArgumentException("loc == null");
        }
        if (!isValid(loc)) { 
            throw new IllegalArgumentException("Location " + loc
                                + " is not valid");
        }
        if (obj == null) {
            throw new NullPointerException("obj == null");
        }
        return occupantTMap.put(loc, obj);
    }

    public E remove(Location loc) {
        if (loc == null) {
            throw new IllegalArgumentException("loc == null");
        }
        if (!isValid(loc)) {
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
        }
        return occupantTMap.remove(loc);
    }
}