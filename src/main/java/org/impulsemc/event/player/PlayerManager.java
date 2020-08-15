package org.impulsemc.event.player;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class PlayerManager {

    public static HashMap<UUID, PlayerState> playerState = new HashMap<>();

    public static PlayerState SetState(UUID uuid, PlayerState state) {
        return playerState.put(uuid, state);
    }

    public static PlayerState getState(UUID uuid) {
        return PlayerManager.playerState.getOrDefault(uuid, PlayerState.ALIVE);
    }

    public static int getAlivePlayers() {
        int alivePlayers = 0;
        for (Player players : Bukkit.getOnlinePlayers()) {
            if (PlayerManager.getState(players.getUniqueId()).equals(PlayerState.ALIVE)) {
                alivePlayers++;
            }
        }

        return alivePlayers;
    }

}
