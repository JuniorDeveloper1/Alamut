package me.JuniorDeveloper;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;
import region.playerMoveTest;
import region.vierkant;

public class main extends JavaPlugin {
    vierkant vier;
    public static main instance;
    public static main getInstance() {return instance;}
    boolean vierkantAan = getInstance().getConfig().getBoolean("vierkantAan.off");
    boolean driehoekAan = getInstance().getConfig().getBoolean("driehoekAan.off");
    int grondX = getInstance().getConfig().getInt("Vierkantgrond.x");
    int grondY = getInstance().getConfig().getInt("Vierkantgrond.y");
    int grondZ = getInstance().getConfig().getInt("Vierkantgrond.z");

    int topX = getInstance().getConfig().getInt("Vierkanttop.x");
    int topY = getInstance().getConfig().getInt("Vierkanttop.y");
    int topZ = getInstance().getConfig().getInt("Vierkanttop.z");
    @Override
    public void onEnable() {
        instance = this;
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();
        this.reloadConfig();
        Listeners();
        vierkantRegion();
        driehoekRegion();
        getServer().getConsoleSender().sendMessage("The plugin has been enabled.");
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
    public void Listeners() {
        getServer().getPluginManager().registerEvents(new playerMoveTest(), this);
    }
    public void vierkantRegion() {
        if(vierkantAan == true) {
            vier = new vierkant(

                    new Location(Bukkit.getWorld("world"), grondX, grondY, grondZ),
                    new Location(Bukkit.getWorld("world"), topX, topY, topZ));
        }


    }
    public void driehoekRegion() {
        if(driehoekAan == true) {}
    }
}
