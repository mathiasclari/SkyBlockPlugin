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
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

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
            } /* else if(!tempFile.exists())
            {
                List<String> givenList = Arrays.asList("a", "2", "3", "4", "c", "6", "7", "8", "b");
                String isUUIDcreatror = "";

                for(int ia = 1; ia < 37; ia++)
                {
                    if(!((ia == 9) || (ia == 14) || (ia == 19) || (ia == 24)))
                    {
                        Random rand = new Random();
                        String a = givenList.get(rand.nextInt(givenList.size()));
                        isUUIDcreatror+=a;
                    }
                    else
                    {
                        isUUIDcreatror+="-";
                    }
                }

                UUID isUuidCreated = UUID.fromString(isUUIDcreatror);

                MainSB.IslandSaves.put(isUuidCreated, new IslandData(isUuidCreated, isUuidCreated.toString()+"island", event.getPlayer().getUniqueId());

                File dirWorld = new File(dir + "mainIslandsSores");
                File newWorld = new File(dir + islandName);
                File dataWorld = new File(dir + islandName+"/uid.dat");
            }
            */
        }
    }
}