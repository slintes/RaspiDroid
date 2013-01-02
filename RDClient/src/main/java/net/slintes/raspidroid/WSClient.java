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

    @Override
    public void send(String text) throws NotYetConnectedException {
        super.send(text);
    }

    private void log(String msg){
        Log.i(RaspiDroidClient.LOGTAG, msg);
    }
}
