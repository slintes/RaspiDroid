package net.slintes.raspidroid;

import net.slintes.raspi.Adafruit8x8LEDMatrix;

/**
 * Created with IntelliJ IDEA.
 * User: slintes
 * Date: 29.12.12
 * Time: 22:14
 *
 * wrapper for the LED matrix
 */
public class RaspiLEDMatrix {

    private Adafruit8x8LEDMatrix matrix;

    public RaspiLEDMatrix() {
        try {
            matrix = new Adafruit8x8LEDMatrix(1, 0x70);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public void handleMessage(String message) {

        //System.out.println("message received: " + message);

        if(matrix == null) return;

        try {
            RDMessage rdMessage = RDMessage.fromMessageString(message);
            matrix.clear(true);
            matrix.setPixel(rdMessage.getX(), rdMessage.getY(), Adafruit8x8LEDMatrix.LedColor.GREEN);
            matrix.writeDisplay();
        } catch (Exception e) {}

    }
}
