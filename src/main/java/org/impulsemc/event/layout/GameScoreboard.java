package org.impulsemc.event.layout;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.impulsemc.event.player.PlayerManager;
import org.impulsemc.event.utils.scoreboard.AssembleAdapter;

import java.util.ArrayList;
import java.util.List;

public class GameScoreboard implements AssembleAdapter {

    @Override
    public String getTitle(Player player) {
        return ChatColor.AQUA.toString() + ChatColor.BOLD + "Event" + ChatColor.GRAY + " | " + ChatColor.GOLD.toString() + ChatColor.BOLD + "Orange";
    }

    @Override
    public List<String> getLines(Player player) {
        List<String> toReturn = new ArrayList<>();

        toReturn.add("&7&m----------------");
        toReturn.add("&fRemaining&7: &b" + PlayerManager.getAlivePlayers());
        toReturn.add("&7&m----------------");

        return toReturn;
    }

}
