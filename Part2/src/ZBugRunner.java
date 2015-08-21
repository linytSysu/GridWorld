/**
 * ZBugRunner
 * @author Linyiting
 */

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

import java.awt.Color;


/**
 * This class runs a world that contains spiral z bugs.
 */
public class ZBugRunner
{
    // The main fuction of the ZBugRunner
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        // construct a new zbug named alice
        ZBug alice = new ZBug(4);
        alice.setColor(Color.ORANGE);
        world.add(new Location(3, 3), alice);
        world.show();
    }
}