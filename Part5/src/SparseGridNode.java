
public class SparseGridNode
{
    private Object occupant;
    private int col;
    private SparseGridNode next;

    public SparseGridNode(Object occupant, int col, SparseGridNode next) {
        this.occupant = occupant;
        this.col = col;
        this.next = next;
    }

    public void setOccupant(Object cp) {
        this.occupant = cp;
    }
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
    /**
     * set method of next
     */
    public void setNext(SparseGridNode next) {
        this.next = next;
    }
    /**
     * get method of next
     */
    public SparseGridNode getNext() {
        return next;
    }

}