package xyz.aquacode.skyblock.IslandManamger;

import org.bukkit.Bukkit;
import org.bukkit.WorldCreator;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import xyz.aquacode.skyblock.data.IslandData;
import xyz.aquacode.skyblock.data.PlayerData;
import xyz.aquacode.skyblock.main.MainSB;

import java.io.File;

public class IsWorldLoader implements Listener
{
    @EventHandler
    public void onJoin(PlayerJoinEvent event)
    {
        PlayerData pData = MainSB.PlayerSaves.get(event.getPlayer().getUniqueId());
        if(pData.getIsland() != null)
        {
            IslandData isData = MainSB.IslandSaves.get(pData.getIsland());
            String dir = MainSB.plugin.getServer().getWorldContainer().getAbsolutePath();
            if(dir.endsWith("."))
            {
                dir = dir.substring(0, dir.length() - 1);
            }
            File tempFile = new File(dir + isData.getIslandWord());
            if(tempFile.exists())
            {
                Bukkit.getScheduler().runTask(MainSB.plugin, new Runnable() {
                    @Override
                    public void run() {
                        Bukkit.createWorld(WorldCreator.name(isData.getIslandWord()));
                    }
                });
            }
        }
    }
}