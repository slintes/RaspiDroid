package net.slintes.raspidroid;

import net.slintes.raspi.Ampel;

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
        try {
            ampel = new Ampel(GPIO_PIN_RED, GPIO_PIN_YELLOW, GPIO_PIN_GREEN);
            ampel.setState(Ampel.State.RED);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public void serverStarted(){
        if(ampel == null) return;
        ampel.setState(Ampel.State.RED_YELLOW);
    }

    public void clientConnected(){
        if(ampel == null) return;
        ampel.setState(Ampel.State.GREEN);
    }

    public void clientDisconnected(){
        if(ampel == null) return;
        ampel.setState(Ampel.State.RED_YELLOW);
    }

    public void error(){
        if(ampel == null) return;
        ampel.setState(Ampel.State.RED);
    }
}
