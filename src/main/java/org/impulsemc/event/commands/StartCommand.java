package org.impulsemc.event.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.impulsemc.event.player.PlayerManager;
import org.impulsemc.event.player.PlayerState;
import org.impulsemc.event.utils.CC;
import org.impulsemc.event.utils.framework.BaseCommand;
import org.impulsemc.event.utils.framework.Command;
import org.impulsemc.event.utils.framework.CommandArgs;

public class StartCommand extends BaseCommand {

    @Command(name = "start", permission = "impulse.event.start")
    public void onCommand(CommandArgs command) {
        Bukkit.broadcastMessage(CC.translate("&7&m------------------------------------"));
        Bukkit.broadcastMessage(CC.translate("&b&lImpulseMC &7- &f&nThe event has started&f!"));
        Bukkit.broadcastMessage(CC.translate("&7&m------------------------------------"));

        for (Player players : Bukkit.getOnlinePlayers()) {
            players.setGameMode(GameMode.SURVIVAL);
            PlayerManager.SetState(players.getUniqueId(), PlayerState.ALIVE);
        }

        Bukkit.broadcastMessage(CC.translate("&b&lImpulseMC &7- &fAll players were revived!"));
    }

}
