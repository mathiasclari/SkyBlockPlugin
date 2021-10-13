package xyz.aquacode.skyblock.data;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class IslandData
{
    // Island Data
    private String islandUUID;
    private String worldName;
    private UUID islandAdmin;
    private List<UUID> islandMembers = new ArrayList<>();
    private int islandSize;

    // Island Save Data
    public IslandData(String isUUID, String isWorld, UUID admin, List<UUID> isMembers, int isSize)
    {
        this.islandUUID = isUUID;
        this.worldName = isWorld;
        this.islandAdmin = admin;
        this.islandMembers = isMembers;
        this.islandSize = isSize;
    }

    // Island Get Data
    public String getIslandUUID()
    {
        return islandUUID;
    }

    public String getIslandWord()
    {
        return worldName;
    }

    public List<UUID> getIslandMembers()
    {
        return islandMembers;
    }

    public  int getIslandSize()
    {
        return islandSize;
    }

    // Set Island Data
    public void setIslandWorld(String wn)
    {
      this.worldName = wn;
    }

    public void setIslandSize(int iss)
    {
        this.islandSize = iss;
    }

    public void removeIslandMembers(UUID userUUID)
    {
        this.islandMembers.remove(userUUID);
    }

    public void addIslandMember(UUID userUUID)
    {
        this.islandMembers.add(userUUID);
    }
}
