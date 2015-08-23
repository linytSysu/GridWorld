/**
 * Test the BeeCritter.java
 * @author Linyiting
 */
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;
import java.awt.Color;

import org.junit.Test;
import static org.junit.Assert.*;

public class BeeTest {
    /**
     * Test whether the bee can jump move forward. And test whether it turns.
     */
    @Test
    public void testMove() {
        ActorWorld world = new ActorWorld();
        BeeCritter bee = new BeeCritter();
        world.add(new Location(4, 4), bee);

        int dire = bee.getDirection();
        bee.act();
        int dire2 = bee.getDirection();
 
        assertEquals("The jumper jump over blank error", 3, bee.getLocation().getRow());
        assertEquals("The jumper jump over blank error", 4, bee.getLocation().getCol());
        assertTrue("The jumper doesn't turn error", dire == dire2);
    }
    /**
     * Move to a flower and eat the flower
     */
    @Test
    public void testMoveToFlower() {
        ActorWorld world = new ActorWorld();
        BeeCritter bee = new BeeCritter();
        Flower flower1 = new Flower();
        world.add(new Location(4, 4), bee);
        world.add(new Location(3, 4), flower1);

        Color fc = flower1.getColor();
        int dire = bee.getDirection();
        bee.act();
        int dire2 = bee.getDirection();
        Color bc = bee.getColor();
 
        assertEquals("The jumper jump over blank error", 3, bee.getLocation().getRow());
        assertEquals("The jumper jump over blank error", 4, bee.getLocation().getCol());
        assertTrue("The jumper doesn't turn error", dire == dire2);
        assertTrue("The bee get the color of the flower", fc == bc);
    }
    /**
     * Move to one of the flowers and eat the it
     */
    @Test
    public void testMoveToFlowers() {
        ActorWorld world = new ActorWorld();
        BeeCritter bee = new BeeCritter();
        Flower flower1 = new Flower();
        Flower flower2 = new Flower();
        world.add(new Location(4, 4), bee);
        world.add(new Location(3, 4), flower1);
        world.add(new Location(3, 3), flower2);
        bee.act();
        assertEquals("The jumper jump over blank error", 3, bee.getLocation().getRow());
        boolean is = ((bee.getLocation().getCol() == 4) || (bee.getLocation().getCol() == 3));
        assertTrue("The jumper jump over blank error", is == true);
    }
    /**
     * The bee trun when it face the edge
     */
    @Test
    public void testFaceEdge() {
        ActorWorld world = new ActorWorld();
        BeeCritter bee = new BeeCritter();
        world.add(new Location(0, 4), bee);
        int dir = bee.getDirection();
        bee.act();
        int dir2 = bee.getDirection();

        assertFalse("The bee should turn but it didn't", dir == dir2);

    }
}
