package xyz.aquacode.skyblock.main;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.aquacode.skyblock.data.IslandData;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.UUID;

public class MainSB extends JavaPlugin
{

    public static MainSB plugin;
    public static MySql dataBase;
    public static Map<UUID, IslandData> IslandSaves = new HashMap<>();

    @Override
    public void onEnable()
    {
        plugin = this;
        dataBase = new MySql("", "", "", "");
    }

    @Override
    public void onDisable()
    {
        // Disable
    }

    public static void ConsoleLog(Player player, String msg)
    {
        player.sendMessage(msg);
    }

}

