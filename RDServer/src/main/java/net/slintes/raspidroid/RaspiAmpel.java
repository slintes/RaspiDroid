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

import net.slintes.raspiAmpel.Ampel;
import net.slintes.raspiAmpel.AmpelFactory;

/**
 * Created with IntelliJ IDEA.
 * User: slintes
 * Date: 29.12.12
 * Time: 22:01
 *
 * wrapper for the ampel LEDs
 */
public class RaspiAmpel {

    // see http://pi4j.com/usage.html#Pin_Numbering
    private static final int GPIO_PIN_RED = 4;
    private static final int GPIO_PIN_YELLOW = 5;
    private static final int GPIO_PIN_GREEN = 6;

    private Ampel ampel;

    public RaspiAmpel(){
        ampel = AmpelFactory.createAmpel(GPIO_PIN_RED, GPIO_PIN_YELLOW, GPIO_PIN_GREEN);
        ampel.setState(Ampel.State.RED);
    }

    public void serverStarted(){
        ampel.setState(Ampel.State.RED_YELLOW);
    }

    public void clientConnected(){
        ampel.setState(Ampel.State.GREEN);
    }

    public void clientDisconnected(){
        ampel.setState(Ampel.State.RED_YELLOW);
    }

    public void error(){
        ampel.setState(Ampel.State.RED);
    }
}
