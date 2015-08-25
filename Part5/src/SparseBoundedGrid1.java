/**
 * SparseBoundedGrid2
 * @author Linyiting
 */
import info.gridworld.grid.Location;
import info.gridworld.grid.AbstractGrid;
import java.util.ArrayList;
import java.util.LinkedList;

public class SparseBoundedGrid1<E> extends AbstractGrid<E>
{
    /**
     * Constructs an empty bounded grid with the given dimensions.
     * (Precondition: <code>rows > 0</code> and <code>cols > 0</code>.)
     * @param rows number of rows in BoundedGrid
     * @param cols number of columns in BoundedGrid
     */
    private ArrayList< LinkedList<OccupantInCol> > linkedArray;
    private int colValue;
    private int rowValue;

    public SparseBoundedGrid1(int rows, int cols) {
        if (rows <= 0) {
            throw new IllegalArgumentException("rows <= 0");
        }
        if (cols <= 0) {
            throw new IllegalArgumentException("cols <= 0");
        }
        linkedArray = new ArrayList< LinkedList<OccupantInCol> >();

        for (int i = 0; i < rows; i++) {
            LinkedList<OccupantInCol> ll = new LinkedList<OccupantInCol>();
            linkedArray.add(ll);
        }
        this.rowValue = rows;
        this.colValue = cols;
    }

    public int getNumRows() {
        return rowValue;
    }
    public int getNumCols() {
        return colValue;
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
        LinkedList<OccupantInCol> ll;
        for (int r = 0; r < getNumRows(); r++) {
            ll = linkedArray.get(r);
            for (OccupantInCol oic : ll) {
                Location loc = new Location(r, oic.getCol());
                theLocations.add(loc);
            }
        }
        return theLocations;
    }
    /**
     * get method
     */
    public E get(Location loc) {
        if (loc == null) {
            throw new IllegalArgumentException("loc is null");
        }
        if (!isValid(loc)) {
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
        }
        LinkedList<OccupantInCol> ll = linkedArray.get(loc.getRow());
        for (OccupantInCol oic : ll) {
            if (oic.getCol() == loc.getCol()) {
                return (E) oic.getOccupant();
            }
        }
        return null;
    }
    /**
     * put method
     */
    public E put(Location loc, E obj) {
        if (loc == null) {
            throw new IllegalArgumentException("loc is null");
        }
        if (!isValid(loc)) { 
            throw new IllegalArgumentException("Location " + loc
                                + " is not valid");
        }
        if (obj == null) {
            throw new NullPointerException("obj == null");
        }
        E oldOccupant = get(loc);
        LinkedList<OccupantInCol> ll = linkedArray.get(loc.getRow());
        OccupantInCol newOic = new OccupantInCol(obj, loc.getCol());
        ll.add(newOic);
        return  oldOccupant;
    }
    /**
     * remove method
     */
    public E remove(Location loc) {
        if (loc == null) {
            throw new IllegalArgumentException("loc is null");
        }
        if (!isValid(loc)) {
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
        }
        E r = get(loc);
        LinkedList<OccupantInCol> ll = linkedArray.get(loc.getRow());
        int pos = 0;
        for (OccupantInCol oic : ll) {
            if (oic.getCol() == loc.getCol()) {
                ll.remove(pos);
                break;
            }
            pos++;
        }
        return r;
    }
}
