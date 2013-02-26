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

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: slintes
 * Date: 29.12.12
 * Time: 21:18
 *
 * A Websocket server running on a Raspberry Pi
 * Control LEDs and a LED matrix by sending messages to it
 *
 */
public class RaspiDroidServer {

    public static void main(String[] args) throws IOException {

        RaspiDroidServer rdServer = new RaspiDroidServer();

        int port = RDConstants.DEFAULT_PORT;
        if(args != null && args.length > 0){
            String portTmp = args[0];
            try{
                port = Integer.parseInt(portTmp);
            } catch (Exception e){}
        }
        rdServer.start(port);
    }

    private void start(int port) {
        RaspiWSServer server = new RaspiWSServer(port);
        server.start();
        //System.out.println("server started");
    }
}
