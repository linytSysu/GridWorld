/**
 * SparseBoundedGrid2
 * @author Linyiting
 */
import info.gridworld.grid.Location;
import info.gridworld.grid.AbstractGrid;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
/**
 *  Consider using a HashMap to implement the SparseBoundedGrid.
 */
public class SparseBoundedGrid2<E> extends AbstractGrid<E> {
    private int rowNum;
    private int colNum;
    private Map<Location, E> occupantHMap;
    /**
     * Constructs an empty bounded grid with the given dimensions.
     * (Precondition: <code>rows > 0</code> and <code>cols > 0</code>.)
     * @param rows number of rows in BoundedGrid
     * @param cols number of columns in BoundedGrid
     */
    public SparseBoundedGrid2(int rows, int cols) {
        if (rows <= 0) {
            throw new IllegalArgumentException("rows <= 0");
        }
        if (cols <= 0) {
            throw new IllegalArgumentException("cols <= 0");
        }
        occupantHMap = new HashMap<Location, E>();
        this.rowNum = rows;
        this.colNum = cols;
    }

    public int getNumRows() {
        return rowNum;
    }
    public int getNumCols() {
        return colNum;
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
        for (Location loc : occupantHMap.keySet()) {
            theLocations.add(loc);
        }
        return theLocations;
    }
    /**
     * The get method
     */
    public E get(Location loc) {
        if (loc == null) {
            throw new IllegalArgumentException("loc == null");
        }
        if (!isValid(loc)) {
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
        }
        return occupantHMap.get(loc);
    }
    /**
     * The put method
     */
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
        return occupantHMap.put(loc, obj);
    }
    /**
     * The remove method
     */
    public E remove(Location loc) {
        if (loc == null) {
            throw new IllegalArgumentException("loc == null");
        }
        if (!isValid(loc)) {
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
        }
        return occupantHMap.remove(loc);
    }
}