/**
 * Test the Jumper.java
 * @author Linyiting
 */
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Location;

import org.junit.Test;
import static org.junit.Assert.*;

public class JumperTest {
    /**
     * Test whether the jumper can jump forward when there are two
     * empty locations in front of it. And test whether it turns.
     */
    @Test
    public void testJump() {
        ActorWorld world = new ActorWorld();
        Jumper jumper = new Jumper();
        world.add(new Location(4, 4), jumper);

        int dire = jumper.getDirection();
        jumper.act();
        int dire2 = jumper.getDirection();
 
        assertEquals("The jumper jump over blank error", 2, jumper.getLocation().getRow());
        assertEquals("The jumper jump over blank error", 4, jumper.getLocation().getCol());
        assertTrue("The jumper doesn't turn error", dire == dire2);
    }
    /**
     * Test whether the jumper can jump forward when there are two
     * locations which are flower and empty in front of it. And test 
     * whether it turns.
     */
    @Test
    public void testJumpFlowerAndRock() {
        ActorWorld world = new ActorWorld();
        Flower flower = new Flower();
        Jumper jumper = new Jumper();
        world.add(new Location(3, 4), flower);
        world.add(new Location(4, 4), jumper);

        int olddire = jumper.getDirection();
        jumper.act();
        int newdire = jumper.getDirection();
 
        assertEquals("The jumper jump over flower error", 2, jumper.getLocation().getRow());
        assertEquals("The jumper jump over flower error", 4, jumper.getLocation().getCol());
        assertTrue("The jumper doesn't turn error", olddire == newdire);

        Rock rock = new Rock();
        Jumper jumper2 = new Jumper();
        world.add(new Location(3, 2), rock);
        world.add(new Location(4, 2), jumper2);
        
        int predire2 = jumper2.getDirection();
        jumper2.act();
        int aftdire2 = jumper2.getDirection();

        assertEquals("The jumper jump over rock error", 2, jumper2.getLocation().getRow());
        assertEquals("The jumper jump over rock error", 2, jumper2.getLocation().getCol());
        assertTrue("The jumper doesn't turn error", predire2 == aftdire2);
    }
    /**
     * Test whether the jumper can jump forward when there are two
     * locations which are empty and flower in front of it. And test 
     * whether it turns.
     */
    @Test
    public void testNoJumpFlowerAndRock() {
        ActorWorld world = new ActorWorld();
        Flower flower = new Flower();
        Jumper jumper = new Jumper();
        world.add(new Location(2, 4), flower);
        world.add(new Location(4, 4), jumper);
        
        int dire = jumper.getDirection();
        jumper.act();
        int dire2 = jumper.getDirection();
 
        assertEquals("The jumper don't jump over flower error", 4, jumper.getLocation().getRow());
        assertEquals("The jumper don't jump over flower error", 4, jumper.getLocation().getCol());
        assertFalse("The jumper doesn't turn error", dire == dire2);

        Rock rock = new Rock();
        Jumper jumper2 = new Jumper();
        world.add(new Location(2, 4), rock);
        world.add(new Location(4, 4), jumper2);
        
        int dd1 = jumper2.getDirection();
        jumper2.act();
        int dd2 = jumper2.getDirection();
 
        assertEquals("The jumper don't jump over rock error", 4, jumper2.getLocation().getRow());
        assertEquals("The jumper don't jump over rock error", 4, jumper2.getLocation().getCol());
        assertFalse("The jumper doesn't turn error", dd1 == dd2);
    }
    /**
     * Test whether the jumper can jump forward when two critter meet.
     *  And test whether it turns.
     */
    @Test
    public void testNoJumpActor() {
        ActorWorld world = new ActorWorld();
        Jumper jumper1 = new Jumper();
        Jumper jumper2 = new Jumper();
        world.add(new Location(3, 4), jumper1);
        world.add(new Location(4, 4), jumper2);
        jumper2.act();
        jumper1.act();

        assertEquals("The jumper don't jump over rock error", 1, jumper1.getLocation().getRow());
        assertEquals("The jumper don't jump over rock error", 4, jumper1.getLocation().getCol());
        assertEquals("The jumper don't jump over rock error", 4, jumper2.getLocation().getRow());
        assertEquals("The jumper don't jump over rock error", 4, jumper2.getLocation().getCol());
    }
    /**
     * Test whether the jumper can jump forward when it face the edge of the wall. 
     * And test whether it turns.
     */
    @Test
    public void testNoJumpEdge() {
        ActorWorld world = new ActorWorld();
        Jumper jumper = new Jumper();
        world.add(new Location(1, 4), jumper);

        int dire = jumper.getDirection();
        jumper.act();
        int dire2 = jumper.getDirection();
 
        assertEquals("The jumper don't jump over flower error", 1, jumper.getLocation().getRow());
        assertEquals("The jumper don't jump over flower error", 4, jumper.getLocation().getCol());
        assertFalse("The jumper doesn't turn error", dire == dire2);
    }
}
