package br.com.fiap;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

import java.util.Arrays;
import java.util.List;

public class LocalizarCMD implements TabExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("localizar")) {
            if(args.length == 1) {
                if(args[0].equalsIgnoreCase("paidoguilherme")) {
                    sender.sendMessage(ChatColor.GRAY + "Não foi possível" + ChatColor.RED + ChatColor.BOLD+ " ENCONTRAR" + ChatColor.GRAY + " o Pai Do Guilherme");
                }
            }
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        String[] complete = {"paidoguilherme"};
        return Arrays.asList(complete);
    }
}
