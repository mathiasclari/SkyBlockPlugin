package xyz.aquacode.skyblock.data;

import java.util.UUID;

public class PlayerData
{
    private UUID IslandUUID;
    private String lastRequest;

    public PlayerData(UUID isUUID)
    {
        this.IslandUUID = isUUID;
    }

    public UUID getIsland()
    {
        return IslandUUID;
    }

    public String getLastRequest()
    {
        return lastRequest;
    }

    public void setIsland(UUID uuid)
    {
        this.IslandUUID = uuid;
    }

    public void setLatestRequest(String request)
    {
        this.lastRequest = request;
    }
}
