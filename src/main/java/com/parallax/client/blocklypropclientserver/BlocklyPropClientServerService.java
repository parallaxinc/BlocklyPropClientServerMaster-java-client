/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parallax.client.blocklypropclientserver;

import com.github.kevinsawicki.http.HttpRequest;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.parallax.client.blocklypropclientserver.exceptions.ServerException;
import com.parallax.client.blocklypropclientserver.objects.ClientsInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Michel
 */
public class BlocklyPropClientServerService {

    private final Logger LOG = LoggerFactory.getLogger(BlocklyPropClientServerService.class);
    private final String BASE_URL;

    public BlocklyPropClientServerService(String baseUrl) {
        this.BASE_URL = baseUrl;
    }

    private String getUrl(String actionUrl) {
        return BASE_URL + actionUrl;
    }

    public ClientsInfo getClientInfo(Long idUser) throws ServerException {
        try {
            HttpRequest request = HttpRequest.get(getUrl("/clientinfo/" + idUser));
//        int responseCode = request.code();
//        System.out.println("Response code: " + responseCode);
            String response = request.body();
//        System.out.println(response);
            JsonElement jelement = new JsonParser().parse(response);
            JsonObject responseObject = jelement.getAsJsonObject();
            if (responseObject.get("success").getAsBoolean()) {
                JsonArray clientsJson = responseObject.get("clients").getAsJsonArray();
                ClientsInfo clientInfo = new ClientsInfo();

                for (JsonElement clientElement : clientsJson) {
                    JsonObject client = clientElement.getAsJsonObject();
                }
                return clientInfo;
            } else {
                String message = responseObject.get("message").getAsString();
                switch (responseObject.get("code").getAsInt()) {
                }
                return null;
            }
        } catch (HttpRequest.HttpRequestException hre) {
            LOG.error("Inter service error", hre);
            throw new ServerException(hre);
        } catch (JsonSyntaxException jse) {
            LOG.error("Json syntace service error", jse);
            throw new ServerException(jse);
        }
    }

}
