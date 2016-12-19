package com.hilixo.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hilixo.service.GameService;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author lstrihic
 */
@Service
public class GameServiceImpl implements GameService {
    private static final Logger LOG = LoggerFactory.getLogger(GameServiceImpl.class);

    public static final String USER_AGENT = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Ubuntu Chromium/55.0.2883.44 Chrome/55.0.2883.44 Safari/537.36";
    public static final String ESPN_ENDPOINT = "http://api-app.espn.com/v1/sports/basketball/nba/events?tz=Europe%2FLondon&platform=android&profile=sportscenter_v1&locale=hr&version=4&device=handset&lang=en&region=us&disable=leagues,sports,season&dates=";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void syncGames() {
        LOG.info("Starting processing espn sync.");

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
            .url(ESPN_ENDPOINT + LocalDate.now().format(formatter))
            .addHeader("User-Agent", USER_AGENT)
            .build();

        try (Response response = client.newCall(request).execute()) {
            LOG.info("RES = {}", response.body().string());
            //res = objectMapper.readValue(response.body().string(), NbaGames.class);
        } catch (IOException ex) {

        }



    }

}
