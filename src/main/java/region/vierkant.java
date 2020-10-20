package region;

import org.bukkit.Location;

import org.bukkit.util.Vector;

public class vierkant {

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
    }

    public boolean containsLocation(Location loc) {
        return loc.toVector().isInAABB(minV, maxV);
    }
}
