package com.ActuatorBoot.Impl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ActuatorParser {

    Logger logger = LoggerFactory.getLogger(ActuatorParser.class);

    public List<ActuatorModel> getActuatorDetails(String actuatorPath) {

        String output = new String();
        try {
            String httpURL = actuatorPath;
            URL myUrl = new URL(httpURL);
            HttpURLConnection conn = (HttpURLConnection) myUrl.openConnection();
            InputStream is = conn.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String inputLine;

            while ((inputLine = br.readLine()) != null) {
                output += inputLine;
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        JsonParser parser = new JsonParser();
        JsonObject jsonObj = new JsonObject();
        try {
            jsonObj = (JsonObject) parser.parse(output);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        JsonArray jsonArray = jsonObj.getAsJsonArray("traces");
        List<ActuatorModel> messageList = new ArrayList<>();
        try {
            for (Object o : jsonArray) {
                if (o == null) {
                    logger.info("Null object");
                } else {
                    JsonObject messageData = (JsonObject) o;

                    String principal;
                    String session;

                    try {
                        principal = messageData.get("principal") == null ? "null" : messageData.get("principal").getAsString();
                    } catch (UnsupportedOperationException e) {
                        principal = "null";
                    }

                    try {
                        session = messageData.get("session") == null ? "null" : messageData.get("session").getAsString();
                    } catch (UnsupportedOperationException e) {
                        session = "null";
                    }

                    messageList.add(new ActuatorModel(messageData.get("timestamp").getAsString(),
                            principal,
                            session,
                            messageData.get("request").getAsJsonObject(),
                            messageData.get("response").getAsJsonObject(),
                            messageData.get("timeTaken").getAsLong()
                    ));

                }
            }

        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return messageList;
    }
}
