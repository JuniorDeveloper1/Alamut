package region;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class playerMoveTest implements Listener {
    vierkant vier;
    @EventHandler
    public void onMove(PlayerMoveEvent e){
        Player p = e.getPlayer();

        if(!p.isFlying() && vier.containsLocation(e.getTo())) {
            p.setFlying(true);
        }else if(p.isFlying() && !vier.containsLocation(e.getTo())) {
            p.setFlying(false);
        }

    }
}
