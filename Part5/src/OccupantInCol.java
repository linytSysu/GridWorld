/**
 * OccupantIncol
 * @author Linyiting
 */
public class OccupantInCol
{
    private Object occupant;
    private int col;
    // constructor
    public OccupantInCol(Object occupant, int col) {
        this.occupant = occupant;
        this.col = col;
    }
    /**
     * set method of occupant
     */
    public void setOccupant(Object cp) {
        this.occupant = cp;
    }
    /**
     * get method of occupant
     */
    public Object getOccupant() {
        return occupant;
    }
    /**
     * set method of col
     */
    public void setCol(int col) {
        this.col = col;
    }
    /**
     * get method of col
     */
    public int getCol() {
        return col;
    }
}