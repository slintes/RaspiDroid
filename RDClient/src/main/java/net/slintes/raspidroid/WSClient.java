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

import android.util.Log;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.nio.channels.NotYetConnectedException;

/**
 * Created with IntelliJ IDEA.
 * User: slintes
 * Date: 31.12.12
 * Time: 16:32
 *
 */
public class WSClient  extends WebSocketClient {

    public WSClient( URI serverURI ) {
        super( serverURI );
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        log("ws: onOpen");
    }

    @Override
    public void onMessage(String message) {
        log("ws: onMessage: " + message);
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        log("ws: onClose: code:" + code + ", reason: " + reason + ", remote: " + remote);
    }

    @Override
    public void onError(Exception ex) {
        log("ws: onError: " + ex.getMessage());
    }

    public void send(RDMessage msg) throws NotYetConnectedException {
        super.send(msg.toMessageString());
    }

    private void log(String msg){
        Log.i(RaspiDroidClient.LOGTAG, msg);
    }
}
