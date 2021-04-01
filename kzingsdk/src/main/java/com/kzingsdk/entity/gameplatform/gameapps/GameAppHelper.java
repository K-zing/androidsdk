package com.kzingsdk.entity.gameplatform.gameapps;

import com.kzingsdk.core.BaseAppGame;
import com.kzingsdk.entity.gameplatform.GamePlatform;

public final class GameAppHelper {

    /**
     * To check a gameplatform if it has a APP to call with. return <b>null</b> if there is none.
     * @param gamePlatform GamePlatform to check.
     **/
    public static BaseAppGame getInstance(GamePlatform gamePlatform) {
        if (gamePlatform.getGpid().equals(LdGaming.GPID)) {
            return new LdGaming(gamePlatform);
        }
        if (gamePlatform.getGpid().equals(Ebet.GPID)) {
            return new Ebet(gamePlatform);
        }
        if (gamePlatform.getGpid().equals(AgLive.GPID)) {
            return new AgLive(gamePlatform);
        }
//        if (gamePlatform.getGpid().equals(AllBet.GPID)) {
//            return new AllBet(gamePlatform);
//        }
        return null;
    }

}
