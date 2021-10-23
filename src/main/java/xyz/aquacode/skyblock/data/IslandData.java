package xyz.aquacode.skyblock.data;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import xyz.aquacode.skyblock.main.MainSB;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class IslandData
{
    // Island Data
    private UUID islandUUID;
    private String worldName;
    private UUID islandAdmin;
    private double islandScore;
    private List<UUID> islandMembers = new ArrayList<>();
    private int islandSize;

    // Island Save Data
    public IslandData(UUID isUUID, String isWorld, UUID admin, double score,List<UUID> isMembers, int isSize)
    {
        this.islandUUID = isUUID;
        this.worldName = isWorld;
        this.islandAdmin = admin;
        this.islandScore = score;
        this.islandMembers = isMembers;
        this.islandSize = isSize;
    }

    // Island Get Data
    public UUID getIslandUUID()
    {
        return islandUUID;
    }

    public String getIslandWord()
    {
        return worldName;
    }

    public UUID getIslandAdmin()
    {
        return islandAdmin;
    }

    public List<UUID> getIslandMembers()
    {
        return islandMembers;
    }

    public  int getIslandSize()
    {
        return islandSize;
    }

    public double getIslandScore()
    {
        return islandScore;
    }

    // Set Island Data
    public void setIslandWorld(String wn)
    {
      this.worldName = wn;
    }

    public void setIslandAdmin(UUID uuid)
    {
        this.islandAdmin = uuid;
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

    public void setIslandScore(double score)
    {
        this.islandScore = score;
    }

    public void addIslandScore(double score)
    {
        this.islandScore = islandScore+score;
    }

    public void saveToDataBase()
    {
        UUID isID = this.islandUUID;
        String WorldName = this.worldName;
        UUID admin = islandAdmin;
        double score = this.islandScore;
        int size = this.islandSize;

        Thread thread = new Thread(this.islandUUID.toString()) {
            public void run(){
                try
                {
                    Statement ps = MainSB.dataBase.GetConnection().createStatement();
                    ps.executeUpdate("INSERT INTO `islandData` (`islandUUID`, `islandWorldName`, `islandAdminUUID`, `islandScore`,`islandSize`) VALUES ('"+isID.toString()+"', '"+WorldName+"', '"+admin.toString()+"', "+score+", "+size+");");
                    ps.close();
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }
        };
    }
}
