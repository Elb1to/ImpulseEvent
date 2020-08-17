package org.impulsemc.event.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.impulsemc.event.player.PlayerListener;
import org.impulsemc.event.player.PlayerManager;
import org.impulsemc.event.player.PlayerState;
import org.impulsemc.event.utils.CC;
import org.impulsemc.event.utils.framework.BaseCommand;
import org.impulsemc.event.utils.framework.Command;
import org.impulsemc.event.utils.framework.CommandArgs;

public class ReviveCommand extends BaseCommand {

    @Command(name = "revive", aliases = {"event revive", "impulsemcevent"}, permission = "impulse.event.revive")
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();
        Player target = Bukkit.getPlayer(args[0]);

        if (PlayerManager.getState(target.getUniqueId()) != PlayerState.DEAD) {
            player.sendMessage(CC.translate("&c" + target.getName() + " is not dead!"));
        } else {
            target.setGameMode(GameMode.SURVIVAL);
            target.teleport(PlayerListener.deathLocation.get(target));
            PlayerManager.setState(target.getUniqueId(), PlayerState.ALIVE);

            player.sendMessage(CC.translate("&aSuccessfully revived " + target.getName()));

            target.sendMessage(CC.translate(" "));
            target.sendMessage(CC.translate("&7&m------------------------------------"));
            target.sendMessage(CC.translate("&b&lImpulseMC &7- &fYou have been revived!"));
            target.sendMessage(CC.translate("&7Revived by&f: &b" + player.getName()));
            target.sendMessage(CC.translate(" "));
            target.sendMessage(CC.translate("&7&oYou were teleported to your death location"));
            target.sendMessage(CC.translate("&7&m------------------------------------"));
            target.sendMessage(CC.translate(" "));

            Bukkit.broadcastMessage(CC.translate("&7&m------------------------------------"));
            Bukkit.broadcastMessage(CC.translate("&b" + target.getName() + " &7has been revived."));
            Bukkit.broadcastMessage(CC.translate("&7&m------------------------------------"));
        }
    }

}
