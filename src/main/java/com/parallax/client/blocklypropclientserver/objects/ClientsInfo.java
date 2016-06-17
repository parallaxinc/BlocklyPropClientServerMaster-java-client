/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parallax.client.blocklypropclientserver.objects;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Michel
 */
public class ClientsInfo {

    private final List<Client> clients = new ArrayList<>();

    public ClientsInfo() {
    }

    public void addClient(Client client) {
        this.clients.add(client);
    }

    public List<Client> getClients() {
        return clients;
    }

}
