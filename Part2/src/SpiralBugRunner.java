/*
 * SpiralBugRunner
 * @author Linyiting
 */

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;
import info.gridworld.grid.UnboundedGrid;

import java.awt.Color;

/**
 * This class runs a world that contains Spiral bugs.
 */
public class SpiralBugRunner
{
    // The main function of SpiralBugRunner
    public static void main(String[] args)
    {
        // Make the grid to be a UnboundedGrid
        UnboundedGrid<Actor> ubg = new UnboundedGrid<Actor>();
        ActorWorld world = new ActorWorld(ubg);
        SpiralBug alice = new SpiralBug(1);
        alice.setColor(Color.ORANGE);
        world.add(new Location(7, 8), alice);
        world.show();
    }
}