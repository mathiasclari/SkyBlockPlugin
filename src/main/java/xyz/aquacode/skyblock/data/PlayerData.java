package xyz.aquacode.skyblock.data;

import xyz.aquacode.skyblock.main.MainSB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

public class PlayerData
{
    private UUID IslandUUID;
    private String lastRequest;

    public PlayerData()
    {}

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


    public void getData(UUID uuid)
    {
        try {
            Statement ps = MainSB.dataBase.GetConnection().createStatement();
            ResultSet result = ps.executeQuery("");
            if(result.next()) {
                this.IslandUUID = UUID.fromString(result.getString(""));
                this.lastRequest = null;
            } else {
                this.IslandUUID = null;
                this.lastRequest = null;
            }
        }

        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
