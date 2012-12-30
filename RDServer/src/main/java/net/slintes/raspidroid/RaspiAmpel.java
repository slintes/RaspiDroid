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
