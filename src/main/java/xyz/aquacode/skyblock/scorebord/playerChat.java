package xyz.aquacode.skyblock.scorebord;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import xyz.aquacode.skyblock.data.PlayerData;
import xyz.aquacode.skyblock.main.MainSB;

import java.util.ArrayList;
import java.util.List;

public class playerChat implements Listener
{
    @EventHandler
    public void onTalk(AsyncPlayerChatEvent event)
    {
        List<String> badWords = new ArrayList<>();

        badWords.add("fuck");

        if(badWords.contains(event.getMessage().toLowerCase()))
        {
            PlayerData pData = MainSB.PlayerSaves.get(event.getPlayer().getUniqueId());
            event.setFormat("[" + pData.getPlayerScore() + "] " + MainSB.getChat().getPlayerPrefix(event.getPlayer()) + " " + event.getPlayer().getName() + ": " + event.getMessage());
        }
        else
        {
            MainSB.PlayerMessager(event.getPlayer(), "Your message was blocked.");
        }
    }
}
