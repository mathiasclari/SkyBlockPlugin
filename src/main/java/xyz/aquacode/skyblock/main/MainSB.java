package xyz.aquacode.skyblock.main;

import net.milkbowl.vault.chat.Chat;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.aquacode.skyblock.IslandManamger.IslandLoader;
import xyz.aquacode.skyblock.data.IslandData;
import xyz.aquacode.skyblock.data.PlayerData;
import xyz.aquacode.skyblock.data.PlayerLoader;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.UUID;

public class MainSB extends JavaPlugin
{

    public static MainSB plugin;
    public static MySql dataBase;
    public static Map<UUID, IslandData> IslandSaves = new HashMap<>();
    public static Map<UUID, PlayerData> PlayerSaves = new HashMap<>();
    private static Chat chat = null;

    @Override
    public void onEnable()
    {
        plugin = this;
        dataBase = new MySql("", "", "", "");
        IslandLoader.LoadIslandFromDataBase();

        Bukkit.getPluginManager().registerEvents(new PlayerLoader(), this);

        setupChat();
    }

    @Override
    public void onDisable()
    {
        // Disable
    }

    private boolean setupChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
        return chat != null;
    }

    public static Chat getChat() {
        return chat;
    }

    public static void ConsoleLog(String msg)
    {
        Bukkit.getConsoleSender().sendMessage(msg);
    }

    public static void PlayerMessager(Player user, String msg)
    {
        user.sendMessage(msg);
    }
}


