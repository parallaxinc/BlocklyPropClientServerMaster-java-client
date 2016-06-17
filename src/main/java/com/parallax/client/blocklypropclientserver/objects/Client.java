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
public class Client {

    private final List<Port> ports = new ArrayList<>();

    private final String identifier;

    public Client(String identifier) {
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void addPort(Port port) {
        this.ports.add(port);
    }

    public List<Port> getPorts() {
        return ports;
    }

}
