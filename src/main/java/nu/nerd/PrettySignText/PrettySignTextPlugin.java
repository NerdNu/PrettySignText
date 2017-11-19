package nu.nerd.PrettySignText;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class PrettySignTextPlugin extends JavaPlugin implements Listener {
    
    /**
     * onEnable
     * 
     * Setup callbacks
     */
    public void onEnable() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(this, this);
    }
    
    /**
     * onSignChangeevent
     * 
     * Pretty print all the sign text
     * 
     * @param signChangeEvent
     */
    @EventHandler
    public void onSignChangeEvent(SignChangeEvent signChangeEvent) {
        for (int i = 0; i < 4; i++) {
            String text;
            text = signChangeEvent.getLine(i);
            //text = text.replace("&&", "\0"); // Allow && to be a literal & with null trick
            text = ChatColor.translateAlternateColorCodes('&', text);
            //text = text.replaceAll("\0", "&");
            signChangeEvent.setLine(i,  text);
        }
    }
}
