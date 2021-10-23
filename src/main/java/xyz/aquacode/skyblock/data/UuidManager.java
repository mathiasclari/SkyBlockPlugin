package xyz.aquacode.skyblock.data;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class UuidManager
{

    public static UUID createUUID()
    {
        List<String> givenList = Arrays.asList("a", "2", "3", "4", "c", "6", "7", "8", "b");
        String isUUIDcreatror = "";

        for(int ia = 1; ia < 37; ia++)
        {
            if(!((ia == 9) || (ia == 14) || (ia == 19) || (ia == 24)))
            {
                Random rand = new Random();
                String a = givenList.get(rand.nextInt(givenList.size()));
                isUUIDcreatror+=a;
            }
            else
            {
                isUUIDcreatror+="-";
            }
        }

        UUID isUuidCreated = UUID.fromString(isUUIDcreatror);

        return isUuidCreated;
    }
}
