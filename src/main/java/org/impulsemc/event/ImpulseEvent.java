package org.impulsemc.event;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.impulsemc.event.commands.*;
import org.impulsemc.event.layout.GameScoreboard;
import org.impulsemc.event.player.PlayerListener;
import org.impulsemc.event.utils.framework.CommandFramework;
import org.impulsemc.event.utils.scoreboard.Assemble;
import org.impulsemc.event.utils.scoreboard.AssembleStyle;

@Getter @Setter
public class ImpulseEvent extends JavaPlugin {

    public static ImpulseEvent instance;
    private CommandFramework framework;

    @Override
    public void onEnable() {
        instance = this;

        framework = new CommandFramework(this);

        Assemble assemble = new Assemble(this, new GameScoreboard());
        assemble.setTicks(2);
        assemble.setAssembleStyle(AssembleStyle.MODERN);

        new ImpulseCommand();
        new StartCommand();
        new FinishCommand();
        new ReviveCommand();
        new PlayerStateCommand();

        Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);
    }

}
