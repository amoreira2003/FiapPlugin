package br.com.fiap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

public class TagManager {



    Scoreboard setupTags() {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        final Scoreboard board = manager.getNewScoreboard();
        final Objective objective = board.registerNewObjective("test", "dummy");
            objective.setDisplaySlot(DisplaySlot.PLAYER_LIST);
            Team adminTeam = board.registerNewTeam("admin");
            Team plebeu = board.registerNewTeam("plebeu");
            adminTeam.setPrefix(ChatColor.RED + "" + ChatColor.BOLD+ "ADMIN" + ChatColor.WHITE+" ");
            plebeu.setPrefix(ChatColor.WHITE +"");
            return board;
    }


    void addPlayerScoreboard(Player player,Scoreboard scoreboard) {
        player.setScoreboard(scoreboard);
        if(player.isOp()) {
            scoreboard.getTeam("admin").addEntry(player.getDisplayName());
            return;
        }
        scoreboard.getTeam("plebeu").addEntry(player.getDisplayName());
    }


    void removePlayerScoreboard(Player player,Scoreboard scoreboard) {
        if(player.isOp()) {
            scoreboard.getTeam("admin").removeEntry(player.getDisplayName());
            return;
        }
        scoreboard.getTeam("plebeu").removeEntry(player.getDisplayName());
    }


}
