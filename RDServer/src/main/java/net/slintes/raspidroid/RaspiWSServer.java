/*
 * Copyright 2013 Marc Sluiter
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package net.slintes.raspidroid;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

import java.net.InetSocketAddress;

/**
 * Created with IntelliJ IDEA.
 * User: slintes
 * Date: 29.12.12
 * Time: 21:56
 *
 * a Websocket server
 */
public class RaspiWSServer extends WebSocketServer {

    private final RaspiAmpel ampel;
    private RaspiLEDMatrix matrix;

    public RaspiWSServer(int port) {
        super(new InetSocketAddress(port));
        ampel = new RaspiAmpel();
        matrix = new RaspiLEDMatrix();
    }

    @Override
    public void onOpen(WebSocket conn, ClientHandshake handshake) {
        ampel.clientConnected();
    }

    @Override
    public void onClose(WebSocket conn, int code, String reason, boolean remote) {
        ampel.clientDisconnected();
    }

    @Override
    public void onMessage(WebSocket conn, String message) {
        matrix.handleMessage(message);
    }

    @Override
    public void onError(WebSocket conn, Exception ex) {
        ampel.error();
    }

    @Override
    public void start() {
        super.start();
        ampel.serverStarted();
    }
}
