package org.impulsemc.event.commands;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.impulsemc.event.player.PlayerManager;
import org.impulsemc.event.utils.CC;
import org.impulsemc.event.utils.framework.BaseCommand;
import org.impulsemc.event.utils.framework.Command;
import org.impulsemc.event.utils.framework.CommandArgs;

public class PlayerStateCommand extends BaseCommand {

    @Command(name = "playerstate", permission = "impulse.event.playerstate")
    public void onCommand(CommandArgs command) {
        String[] args = command.getArgs();

        Player player = command.getPlayer();
        if (args.length == 0) {
            sendMessage(player, player);
            return;
        }

        Player target = Bukkit.getPlayer(args[0]);
        if (args.length == 1) {
            sendMessage(player, target);
        }
    }

    private void sendMessage(Player player, Player target) {
        player.sendMessage(CC.translate("&7&m------------------------------------"));
        player.sendMessage(CC.translate("&b&lImpulseMC &7- &fPlayer State"));
        player.sendMessage(CC.translate("&7Player&f: &b" + target.getName()));
        player.sendMessage(CC.translate("&7State&f: &b" + PlayerManager.getState(target.getUniqueId())));
        player.sendMessage(CC.translate("&7&m------------------------------------"));
    }

}
