package br.com.fiap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;

public final class main extends JavaPlugin implements Listener {

    TagManager tag;
    Scoreboard score;

    @Override
    public void onEnable() {
       // tag = new TagManager();
       // score = tag.setupTags();
       getLogger().info("Fiap Plugin its Rocking");
        Bukkit.getPluginManager().registerEvents(new MOTD(),this);
        Bukkit.getPluginManager().registerEvents(this,this);
       PluginCommand localizar =  getCommand("localizar");
        localizar.setExecutor(new LocalizarCMD());
       localizar.setTabCompleter(new LocalizarCMD());

    }

    @Override
    public void onDisable() {
        getLogger().info("Fiap Plugin isn't Rocking Anymore" );
    }


    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
      String msg = e.getMessage();
      Player p = e.getPlayer();
      for(Player a: Bukkit.getOnlinePlayers()) {
         if(p.isOp()) {
             a.sendMessage(ChatColor.RED + "" +  ChatColor.BOLD+"ADMIN " + ChatColor.WHITE + p.getDisplayName() + ChatColor.DARK_GRAY+": " + ChatColor.GRAY + msg);
             e.setCancelled(true);
             return;
         }


          a.sendMessage(ChatColor.WHITE + p.getDisplayName()+ ChatColor.DARK_GRAY +": " + ChatColor.GRAY + msg);
      }
      e.setCancelled(true);

    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.setJoinMessage(ChatColor.GRAY +"[" + ChatColor.GREEN + "+"+ChatColor.GRAY +"] " + e.getPlayer().getDisplayName());
        tag.addPlayerScoreboard(e.getPlayer(),score);
    }
    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        tag.removePlayerScoreboard(e.getPlayer(),score);
        e.setQuitMessage(null);
    }
}
