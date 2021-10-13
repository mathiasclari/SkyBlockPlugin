package xyz.aquacode.skyblock.IslandManamger;

import xyz.aquacode.skyblock.data.IslandData;
import xyz.aquacode.skyblock.main.MainSB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class IslandLoader
{

    public static void LoadIslandFromDataBase()
    {
        try
        {
            Statement ps = MainSB.dataBase.GetConnection().createStatement();
            ResultSet result = ps.executeQuery("");
            while(result.next())
            {
                String IslandUUID = result.getString("");
                MainSB.ConsoleLog("Loading {"+IslandUUID+"}");
                String IslandWorld = result.getString("");
                String adminUUID = result.getString("");
                List<UUID> IslandMembers = new ArrayList<>();
                int IslandSize = result.getInt("");

                ResultSet result2 = ps.executeQuery("");
                while (result2.next())
                {
                    IslandMembers.add(UUID.fromString(result2.getString("")));
                }

                MainSB.IslandSaves.put(UUID.fromString(IslandUUID), new IslandData(UUID.fromString(IslandUUID) ,IslandWorld, UUID.fromString(adminUUID), IslandMembers, IslandSize));
                MainSB.ConsoleLog("Done {"+IslandUUID+"}");
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
