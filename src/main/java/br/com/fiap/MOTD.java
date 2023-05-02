package br.com.fiap;

import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class MOTD implements Listener {

    @EventHandler
    public void onMotd(ServerListPingEvent e) {
        e.setMotd("                                 §d§lFIAP§r\n                §7Let's Craft The  Future");
        e.setMaxPlayers(e.getNumPlayers() + 1);
    }
}
