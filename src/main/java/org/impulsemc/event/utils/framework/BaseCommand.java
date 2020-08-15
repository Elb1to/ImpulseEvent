package org.impulsemc.event.utils.framework;

import org.impulsemc.event.ImpulseEvent;

public abstract class BaseCommand {

    public ImpulseEvent main = ImpulseEvent.instance;

    public BaseCommand() {
        main.getFramework().registerCommands(this);
    }

    public abstract void onCommand(CommandArgs command);

}
