/*
 * Copyright 2014 Marc Sluiter
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.slintes.raspidroid;

import com.leapmotion.leap.Controller;

import java.io.IOException;

/**
 * Created by slintes on 10.02.14.
 */
public class RaspiLeapClient {

    static {
        new LibLoader();
    }

    public static void main(String[] args) {
        RaspiLeapClient raspiLeapClient = new RaspiLeapClient();
        raspiLeapClient.start();
    }

    public RaspiLeapClient() {
    }

    private void start() {

        // copy dlls to working directory
        new LibLoader();

        // create a leap motion listener and controller
        LeapListener listener = new LeapListener();
        Controller controller = new Controller();

        // have the listener receive events from the controller
        controller.addListener(listener);

        // keep this process running until enter is pressed
        System.out.println("Press Enter to quit...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // remove the listener when done
        controller.removeListener(listener);

    }

}
