/**
 * UnboundedGrid
 * @author Linyiting
 */
import info.gridworld.grid.Location;
import info.gridworld.grid.AbstractGrid;

import java.util.HashMap;
import java.util.ArrayList;

/**
 * Consider an implementation of an unbounded grid in which all valid 
 * locations have non-negative row and column values. The constructor 
 * allocates a 16 x 16 array. When a call is made to the put method 
 * with a row or column index that is outside the current array bounds, 
 * double both array bounds until they are large enough, construct a 
 * new square array with those bounds, and place the existing occupants 
 * into the new array.
 */
public class UnboundedGrid2<E> extends AbstractGrid<E> {

    private Object[][] occupantArray;
    private final static int defaultSize = 16;
    private int size;
    /**
     * Constructs an empty bounded grid with the given dimensions.
     * (Precondition: <code>rows > 0</code> and <code>cols > 0</code>.)
     * @param rows number of rows in BoundedGrid
     * @param cols number of columns in BoundedGrid
     */
    public UnboundedGrid2() {
        this.size = defaultSize;
        this.occupantArray = new Object[defaultSize][defaultSize];
    }

    public int getNumRows() {
        return -1;
    }

    public int getNumCols() {
        return -1;
    }
    /**
    * check whether the location is valid
    */
    public boolean isValid(Location loc) {
        return loc.getRow() >= 0 && loc.getCol() >= 0;
    }
    /**
     * getNewSize method
     */
    public int getNewSize(Location loc) {
        while (loc.getCol() >= size || loc.getRow() >= size) {
            size = size * 2;
        }
        return size;
    }

    public ArrayList<Location> getOccupiedLocations()
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                Location loc = new Location(r, c);
                if (get(loc) != null) {
                    locs.add(loc);
                }
            }
        }
        return locs;
    }
    /**
     * get method
     */
    public E get(Location loc)
    {
        if (loc == null) {
            throw new NullPointerException("loc == null");
        }
        if (loc.getCol() >= size || loc.getRow() >= size) {
            return null;
        }
        return (E) occupantArray[loc.getRow()][loc.getCol()];
    }
    /**
     * put method
     */
    public E put(Location loc, E obj)
    {
        if (loc == null) {
            throw new NullPointerException("loc == null");
        }
        if (obj == null) {
            throw new NullPointerException("obj == null");
        }
        // double the array if needed
        if (loc.getCol() >= size || loc.getRow() >= size) {
            int oldSize = size;
            int newSize = getNewSize(loc);
            Object[][] newArray = new Object[newSize][newSize];
            for (int i = 0; i < oldSize; i++) {
                for (int j = 0; j < oldSize; j++) {
                    newArray[i][j] = occupantArray[i][j];
                }
            }
            occupantArray = newArray;
        }

        E oldOccupant = get(loc);
        occupantArray[loc.getRow()][loc.getCol()] = obj;
        return oldOccupant;
    }
    /**
     * remove method
     */
    public E remove(Location loc)
    {
        if (loc == null) {
            throw new NullPointerException("loc == null");
        }
        if (loc.getCol() >= size || loc.getRow() >= size) {
            return null;
        }
        E r = get(loc);
        occupantArray[loc.getRow()][loc.getCol()] = null;
        return r;
    }
}
