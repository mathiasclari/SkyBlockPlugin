package xyz.aquacode.skyblock.data;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import xyz.aquacode.skyblock.main.MainSB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PlayerLoader implements Listener
{
    @EventHandler
    public void playerLogin(PlayerLoginEvent event)
    {
        if(!MainSB.PlayerSaves.containsKey(event.getPlayer().getUniqueId())) {
            MainSB.PlayerSaves.put(event.getPlayer().getUniqueId(), new PlayerData());
            PlayerData pData = MainSB.PlayerSaves.get(event.getPlayer().getUniqueId());
            pData.getData(event.getPlayer().getUniqueId());
        }
    }
}
