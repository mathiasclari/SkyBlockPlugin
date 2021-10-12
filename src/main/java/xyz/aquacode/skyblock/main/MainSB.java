package xyz.aquacode.skyblock.main;

import org.bukkit.plugin.java.JavaPlugin;

public class MainSB extends JavaPlugin
{

    public static MainSB plugin;

    @Override
    public void onEnable()
    {
        plugin = this;
    }

    @Override
    public void onDisable()
    {
        // Disable
    }

    public static void ConsoleLog(Player player, String msg)
    {

    }
}

