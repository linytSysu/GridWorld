/*
 * DancingBugRunner
 * @author Linyiting
 */

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

import java.awt.Color;
/**
 * This class runs a world that contains dancing bugs.
 */
public class DancingBugRunner
{
    // The main function of dancingbugrunner
    public static void main(String[] args)
    {
        int turns[] = {1, 2, 3, 4, 5};
        ActorWorld world = new ActorWorld();
        DancingBug alice = new DancingBug(turns);
        alice.setColor(Color.ORANGE);
        world.add(new Location(2, 2), alice);
        world.show();
    }
}