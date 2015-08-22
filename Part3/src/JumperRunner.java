
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Location;

public class JumperRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        Flower flower = new Flower();
        Jumper jumper = new Jumper();
        Rock rock = new Rock();
        world.add(new Location(1, 4), rock);
        world.add(new Location(3, 4), flower);
        world.add(new Location(4, 4), jumper);
        world.show();
    }
}
