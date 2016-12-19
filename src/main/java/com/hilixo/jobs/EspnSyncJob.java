package com.hilixo.jobs;

import com.hilixo.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author lstrihic
 */
@Component
public class EspnSyncJob {

    @Autowired
    private GameService gameService;

    @Scheduled(cron = "* * * * * *")
    public void espnSync() {

        gameService.syncGames();

    }

}
