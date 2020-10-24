import me.JuniorDeveloper.main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import region.vierkant;

public class commands implements Listener, CommandExecutor {
    String cmd1 = "startVierkant";
    vierkant vier;
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            //Vierkant
            if(cmd.getName().equalsIgnoreCase(cmd1)) {
                int distance = 6;
                int maxDistance = 100;
               String play = "@a";
               Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), String.format("spreadplayers %d %d %d %d %b %s", minCords(), maxCords(), distance, maxDistance, true, play));

            }
            //Driehoek
            return true;
        }
        return false;
    }
    public Location minCords() {
        int grondX = main.getInstance().getConfig().getInt("Vierkantgrond.x");
        int grondY = main.getInstance().getConfig().getInt("Vierkantgrond.y");
        int grondZ = main.getInstance().getConfig().getInt("Vierkantgrond.z");

        return new Location(Bukkit.getWorld("world"), grondX, grondY, grondZ);
    }
    public Location maxCords() {
        int topX = main.getInstance().getConfig().getInt("Vierkanttop.x");
        int topY = main.getInstance().getConfig().getInt("Vierkanttop.y");
        int topZ = main.getInstance().getConfig().getInt("Vierkanttop.z");

        return new Location(Bukkit.getServer().getWorld("world"), topX, topY,topZ);
    }
}
