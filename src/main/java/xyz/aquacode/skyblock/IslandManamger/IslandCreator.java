package xyz.aquacode.skyblock.IslandManamger;

import xyz.aquacode.skyblock.data.IslandData;
import xyz.aquacode.skyblock.data.UuidManager;
import xyz.aquacode.skyblock.main.MainSB;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class IslandCreator
{
    public static void IslandCreator(UUID ownerUUID)
    {
        UUID islandUUID = UuidManager.createUUID();
        setup(ownerUUID, islandUUID);
    }

    private static void setup(UUID ownerUUID, UUID isUUID)
    {
        if(MainSB.IslandSaves.containsKey(isUUID))
        {
            // IS create
            UUID islandUUID = isUUID;
            String islandWorld = isUUID.toString()+"world";
            UUID islandAdmin = ownerUUID;
            double islandScore = 0.0;
            List<UUID> islandMembers = new ArrayList<>();
            islandMembers.add(ownerUUID);
            int islandSize = 50;

            MainSB.IslandSaves.put(isUUID, new IslandData(islandUUID, islandWorld, islandAdmin, islandScore, islandMembers, islandSize));
            IslandData IslandD = MainSB.IslandSaves.get(islandUUID);
            IslandD.saveToDataBase();

        }
        else
        {
            IslandCreator(ownerUUID);
        }
    }
}
