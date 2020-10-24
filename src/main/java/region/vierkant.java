package region;

import org.bukkit.Location;
import org.bukkit.util.Vector;

import java.util.concurrent.ThreadLocalRandom;

public  class vierkant {

    private String world;
    private Vector minV, maxV;

    public vierkant(Location min, Location max) {
        world = min.getWorld().getName();
        double xPos1 = Math.min(min.getX(), max.getX());
        double yPos1 = Math.min(min.getY(), max.getY());
        double zPos1 = Math.min(min.getZ(), max.getZ());
        double xPos2 = Math.min(min.getX(), max.getX());
        double yPos2 = Math.min(min.getY(), max.getY());
        double zPos2 = Math.min(min.getZ(), max.getZ());

         minV = new Vector(xPos1, yPos1, zPos1);
         maxV = new Vector(xPos2,yPos2,zPos2);

         new Location(min.getWorld(), randomDouble(xPos1, xPos2), randomDouble(yPos1, yPos2), randomDouble(zPos1, zPos2));

    }

    public boolean containsLocation(Location loc) {
        return loc.toVector().isInAABB(minV, maxV);
    }
    public double randomDouble(double min, double max) {
        return min + ThreadLocalRandom.current().nextDouble(Math.abs(max - min + 1));
    }
}
