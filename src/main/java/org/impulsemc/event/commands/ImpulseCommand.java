package org.impulsemc.event.commands;

import org.bukkit.entity.Player;
import org.impulsemc.event.ImpulseEvent;
import org.impulsemc.event.utils.CC;
import org.impulsemc.event.utils.framework.BaseCommand;
import org.impulsemc.event.utils.framework.Command;
import org.impulsemc.event.utils.framework.CommandArgs;

public class ImpulseCommand extends BaseCommand {

    @Command(name = "impulse", aliases = {"impulsemc", "impulsemcevent"})
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        player.sendMessage(CC.translate("&7&m------------------------------------"));
        player.sendMessage(CC.translate("&b&lImpulseMC"));
        player.sendMessage(CC.translate("&7Author&f: &b" + ImpulseEvent.instance.getDescription().getAuthors()));
        player.sendMessage(CC.translate("&7Version&f: &b" + ImpulseEvent.instance.getDescription().getVersion()));
        player.sendMessage(CC.translate("&7&m------------------------------------"));
    }

}
